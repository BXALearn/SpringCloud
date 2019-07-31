package com.bxa.order.service.impl;

import com.bxa.order.dataobject.OrderDetail;
import com.bxa.order.dataobject.OrderMaster;
import com.bxa.order.enums.ResultEnum;
import com.bxa.order.exception.OrderException;
import com.bxa.order.repository.OrderDetailRepository;
import com.bxa.order.repository.OrderMasterRepository;
import com.bxa.order.dto.OrderDTO;
import com.bxa.order.enums.OrderStatusEnum;
import com.bxa.order.enums.PayStatusEnum;
import com.bxa.order.service.OrderService;
import com.bxa.order.utils.KeyUtil;
import com.bxa.product.client.ProductClient;
import com.bxa.product.common.DecreaseStockInput;
import com.bxa.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Create by 摆欣安
 * 2019/7/18 16:19
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired // 订单商品对象
    private OrderDetailRepository orderDetailRepository;

    @Autowired // 订单信息对象
    private OrderMasterRepository orderMasterRepository;

    @Autowired // 商品服务对象
    private ProductClient productClient;

    @Override
    @Transactional
    /**
     *  创建订单
     *  Param: OrderDTO - 订单信息
     */
    public OrderDTO create(OrderDTO orderDTO) {
        // 雪花算法生成唯一Id
        String orderId = KeyUtil.genUniqueKey();

        // 从订单获取商品Id列表
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        //根据商品Id查询商品信息(调用商品服务)
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);


        //计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        // 循环订单中的商品对象
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()) {
            for (ProductInfoOutput productInfo: productInfoList) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    //单价*数量
                    orderAmout = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        //扣库存(调用商品服务)
        List<DecreaseStockInput> decreaseStockInputList = orderDTO.getOrderDetailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInputList);

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
//        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMaster.setOrderId(KeyUtil.genUniqueKey());
        orderMasterRepository.save(orderMaster);
//      设置订单Id
        orderDTO.setOrderId(orderMaster.getOrderId());
        return orderDTO;
    }

    @Override
    @Transactional  // 完成订单
    public OrderDTO finish(String orderId) {

        //1. 先查询订单
        Optional<OrderMaster> orderMasterOptional = orderMasterRepository.findById(orderId);
        if (!orderMasterOptional.isPresent()) {
            throw new OrderException(ResultEnum.ORDER_NOT_EXIST);
        }

        //2. 判断订单状态
        OrderMaster orderMaster = orderMasterOptional.get();
        if (OrderStatusEnum.NEW.getCode() != orderMaster.getOrderStatus()) {
            throw new OrderException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //3. 修改订单状态为完结
        orderMaster.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        orderMasterRepository.save(orderMaster);

        //查询订单详情
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new OrderException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
