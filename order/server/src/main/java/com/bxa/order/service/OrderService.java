package com.bxa.order.service;

import com.bxa.order.dto.OrderDTO;

/**
 * Create by 摆欣安
 * 2019/7/18 16:13
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    public OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单(只能卖家操作)
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);

}
