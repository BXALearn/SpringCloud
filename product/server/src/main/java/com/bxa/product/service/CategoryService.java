package com.bxa.product.service;

import com.bxa.product.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Create by 摆欣安
 * 2019/7/17 16:33
 */
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
