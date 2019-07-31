
CREATE TABLE `order_detail` (
  
   `detail_id` varchar(32) NOT NULL,
  `order_id` varchar(32) NOT NULL,
  
   `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) DEFAULT NULL COMMENT '��Ʒ����',
  
   `product_price` decimal(8,2) NOT NULL COMMENT '��ǰ�۸񣬵�λ��',
  
   `product_quantity` int(20) DEFAULT NULL COMMENT '����',
  
   `product_icon` varchar(512) DEFAULT NULL COMMENT 'Сͼ',
  
   `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  
   `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  
   KEY `idx_order_id` (`order_id`) USING BTREE
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='������Ʒ';

CREATE TABLE `order_master` (
 
    `order_id` varchar(32) NOT NULL,
 
    `buyer_name` varchar(32) NOT NULL COMMENT '�������',

    `buyer_phone` varchar(32) NOT NULL COMMENT '��ҵ绰\r\n',
 
    `buyer_address` varchar(128) NOT NULL COMMENT '��ҵ�ַ',
 
    `buyer_openid` varchar(64) NOT NULL COMMENT '���΢��openid\r\n',
 
    `order_amount` decimal(8,2) NOT NULL COMMENT '�����ܽ��\r\n',
  
    `order_status` tinyint(3) DEFAULT '0' COMMENT '����״̬��Ĭ��Ϊ���µ�''\r\n',
 
    `pay_status` tinyint(3) DEFAULT '0' COMMENT '֧��״̬��Ĭ��δ֧��''\r\n',
  
    `create_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '����ʱ��',
  
    `update_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '����ʱ��',
  
    PRIMARY KEY (`order_id`) USING BTREE,
  KEY `idx_buyer_openid` (`buyer_openid`) USING BTREE COMMENT '���΢��openid'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='������';

CREATE TABLE `product_category` (
  
   `category_id` int(11) NOT NULL,
  
   `category_name` varchar(64) DEFAULT NULL,
  
   `category_type` int(11) DEFAULT NULL COMMENT '��Ŀ���',
  
   `update_time` datetime(6) DEFAULT NULL,
  
   `create_time` datetime(6) DEFAULT NULL
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='����';

CREATE TABLE `product_info` (
  
   `product_id` varchar(32) NOT NULL,
  
   `product_name` varchar(64) NOT NULL,
  
   `product_price` decimal(8,2) NOT NULL COMMENT '����',
  
   `product_stock` tinyint(10) NOT NULL COMMENT '���',
  
   `product_description` varchar(64) DEFAULT NULL,
  
   `product_icon` varchar(512) DEFAULT NULL,
  
   `product_status` tinyint(3) DEFAULT '0' COMMENT '��Ʒ״̬ 0����1�¼�',
  
   `category_type` tinyint(11) DEFAULT '0' COMMENT '���ͱ��',
  
   `create_time` datetime(6) DEFAULT NULL,
  
   `update_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='��Ʒ��';

CREATE TABLE `user_info` (
  
   `id` varchar(32) NOT NULL,
  
   `username` varchar(32) DEFAULT '',
  
   `password` varchar(32) DEFAULT '',
  
   `openid` varchar(64) DEFAULT '' COMMENT '΢��openid',
  
   `role` tinyint(1) NOT NULL COMMENT '1���2����',
  
   `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  
   `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='�û���';