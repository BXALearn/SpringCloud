
CREATE TABLE `order_detail` (
  
   `detail_id` varchar(32) NOT NULL,
  `order_id` varchar(32) NOT NULL,
  
   `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) DEFAULT NULL COMMENT '商品名字',
  
   `product_price` decimal(8,2) NOT NULL COMMENT '当前价格，单位分',
  
   `product_quantity` int(20) DEFAULT NULL COMMENT '数量',
  
   `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
  
   `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  
   `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  
   KEY `idx_order_id` (`order_id`) USING BTREE
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单商品';

CREATE TABLE `order_master` (
 
    `order_id` varchar(32) NOT NULL,
 
    `buyer_name` varchar(32) NOT NULL COMMENT '买家名字',

    `buyer_phone` varchar(32) NOT NULL COMMENT '买家电话',
 
    `buyer_address` varchar(128) NOT NULL COMMENT '买家地址',
 
    `buyer_openid` varchar(64) NOT NULL COMMENT '买家微信openid',
 
    `order_amount` decimal(8,2) NOT NULL COMMENT '订单总金额',
  
    `order_status` tinyint(3) DEFAULT '0' COMMENT '订单状态，默认为新下单''',
 
    `pay_status` tinyint(3) DEFAULT '0' COMMENT '支付状态，默认未支付''',
  
    `create_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
  
    `update_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
  
    PRIMARY KEY (`order_id`) USING BTREE,
  KEY `idx_buyer_openid` (`buyer_openid`) USING BTREE COMMENT '买家微信openid'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单表';

CREATE TABLE `product_category` (
  
   `category_id` int(11) NOT NULL,
  
   `category_name` varchar(64) DEFAULT NULL,
  
   `category_type` int(11) DEFAULT NULL COMMENT '类目编号',
  
   `update_time` datetime(6) DEFAULT NULL,
  
   `create_time` datetime(6) DEFAULT NULL
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='类别表';

CREATE TABLE `product_info` (
  
   `product_id` varchar(32) NOT NULL,
  
   `product_name` varchar(64) NOT NULL,
  
   `product_price` decimal(8,2) NOT NULL COMMENT '单价',
  
   `product_stock` tinyint(10) NOT NULL COMMENT '库存',
  
   `product_description` varchar(64) DEFAULT NULL,
  
   `product_icon` varchar(512) DEFAULT NULL,
  
   `product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态 0正常1下架',
  
   `category_type` tinyint(11) DEFAULT '0' COMMENT '类型编号',
  
   `create_time` datetime(6) DEFAULT NULL,
  
   `update_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品表';

CREATE TABLE `user_info` (
  
   `id` varchar(32) NOT NULL,
  
   `username` varchar(32) DEFAULT '',
  
   `password` varchar(32) DEFAULT '',
  
   `openid` varchar(64) DEFAULT '' COMMENT '微信openid',
  
   `role` tinyint(1) NOT NULL COMMENT '1买家2卖家',
  
   `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  
   `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';
