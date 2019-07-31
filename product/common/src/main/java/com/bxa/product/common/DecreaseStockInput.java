package com.bxa.product.common;

import lombok.Data;

/**
 * 减库存入参
 * Created by 摆欣安
 * 2019年7月24日21:49:37
 */
@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}