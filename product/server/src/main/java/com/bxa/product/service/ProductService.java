package com.bxa.product.service;

import com.bxa.product.common.DecreaseStockInput;
import com.bxa.product.common.ProductInfoOutput;
import com.bxa.product.dataobject.ProductInfo;

import java.util.List;

/**
 * Create by 摆欣安
 * 2019年7月17日16:06:57
 */
public interface ProductService {
    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
     List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
     void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
