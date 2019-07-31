package com.bxa.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 摆欣安
 * 2019年7月17日11:38:56
 */
//@Table(name = "T_xxx")
@Data
@Entity
public class ProductInfo {
    @Id
    private String productId;

    // 名字
    private String productName;

    // 单价
    private BigDecimal productPrice;

    // 库存
    private Integer productStock;

    // 描述
    private String productDescription;

    // 状态,0正常1下架
    private Integer productStatus;

    // 类目编号
    private Integer categoryType;

//    private Date createTime;
//    private Date updateTime;

}
