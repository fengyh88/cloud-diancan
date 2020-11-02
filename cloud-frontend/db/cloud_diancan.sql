/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.19 : Database - cloud_diancan
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cloud_diancan` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

/*Table structure for table `cloud_call` */

DROP TABLE IF EXISTS `cloud_call`;

CREATE TABLE `cloud_call` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `shop_id` bigint DEFAULT NULL COMMENT '店铺Id 0表示全局公告',
  `user_id` bigint DEFAULT NULL COMMENT '用户Id',
  `res_id` bigint DEFAULT NULL COMMENT '桌号Id',
  `title` varchar(36) DEFAULT NULL COMMENT '公告标题',
  `content` varchar(50) DEFAULT NULL COMMENT '公告内容',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态(1:呼叫 2:已读)',
  `emp_id` bigint DEFAULT NULL COMMENT '已读员工Id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='呼叫表';

/*Data for the table `cloud_call` */

/*Table structure for table `cloud_cart` */

DROP TABLE IF EXISTS `cloud_cart`;

CREATE TABLE `cloud_cart` (
  `cart_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `shop_id` bigint NOT NULL COMMENT '店铺Id',
  `user_id` varchar(50) NOT NULL COMMENT '用户Id',
  `prod_id` bigint unsigned NOT NULL DEFAULT '0' COMMENT '商品Id',
  `sku_id` bigint unsigned NOT NULL DEFAULT '0' COMMENT 'skuId',
  `prod_prop` varchar(200) NOT NULL DEFAULT '' COMMENT '商品属性JSON',
  `num` int NOT NULL DEFAULT '0' COMMENT '购物车商品个数',
  `cart_time` datetime NOT NULL COMMENT '购物时间',
  PRIMARY KEY (`cart_id`),
  KEY `shop_id` (`shop_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';

/*Data for the table `cloud_cart` */

/*Table structure for table `cloud_coupon` */

DROP TABLE IF EXISTS `cloud_coupon`;

CREATE TABLE `cloud_coupon` (
  `coupon_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '优惠券Id',
  `shop_id` bigint DEFAULT NULL COMMENT '店铺Id',
  `coupon_name` varchar(255) NOT NULL COMMENT '优惠券名称',
  `intro` varchar(200) DEFAULT NULL COMMENT '简介',
  `img` varchar(500) DEFAULT NULL COMMENT '图片',
  `discount_type` tinyint NOT NULL DEFAULT '1' COMMENT '优惠券类型：1=折扣，2=满减',
  `min_amount` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '最低消费金额',
  `sub_amount` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '优惠金额',
  `discount` decimal(3,1) NOT NULL DEFAULT '10.0' COMMENT '折扣率',
  `expire_type` tinyint NOT NULL DEFAULT '1' COMMENT '到期类型：1=领取后N天过期，2=指定有效期',
  `expire_day` int NOT NULL DEFAULT '0' COMMENT '有效天数，expire_type=1时',
  `begin_time` datetime DEFAULT NULL COMMENT '有效期开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '有效期结束时间',
  `total_num` int NOT NULL DEFAULT '-1' COMMENT '发放总数量',
  `prod_cate_list` varchar(255) DEFAULT NULL COMMENT '适用商品分类列',
  `prod_list` varchar(255) DEFAULT NULL COMMENT '适用商品列',
  `price` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '售价',
  `seq` int DEFAULT NULL COMMENT '排序',
  `status` tinyint DEFAULT '1' COMMENT '0 禁用 1 启用 -1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`coupon_id`),
  KEY `shop_id` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠券';

/*Data for the table `cloud_coupon` */

/*Table structure for table `cloud_dept` */

DROP TABLE IF EXISTS `cloud_dept`;

CREATE TABLE `cloud_dept` (
  `dept_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'dept_Id',
  `dept_name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `p_id` varchar(255) DEFAULT NULL COMMENT '父级部门',
  `shop_id` bigint DEFAULT NULL COMMENT '店铺Id',
  `create_time` datetime NOT NULL COMMENT '建立时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门';

/*Data for the table `cloud_dept` */

/*Table structure for table `cloud_duty` */

DROP TABLE IF EXISTS `cloud_duty`;

CREATE TABLE `cloud_duty` (
  `duty_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `duty_name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `shop_id` bigint DEFAULT NULL COMMENT '店铺Id',
  `create_time` datetime NOT NULL COMMENT '建立时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`duty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位';

/*Data for the table `cloud_duty` */

/*Table structure for table `cloud_emp` */

DROP TABLE IF EXISTS `cloud_emp`;

CREATE TABLE `cloud_emp` (
  `emp_id` bigint NOT NULL AUTO_INCREMENT,
  `emp_number` varchar(50) DEFAULT NULL COMMENT '工号',
  `emp_name` varchar(50) NOT NULL COMMENT '姓名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `gender` char(1) DEFAULT 'M' COMMENT 'M(男) or F(女)',
  `birth_date` datetime DEFAULT NULL COMMENT '例如：2009-11-27',
  `pic` varchar(255) DEFAULT NULL COMMENT '头像图片路径',
  `shop_id` bigint DEFAULT NULL COMMENT '用户所在的商城Id',
  `dept_id` bigint DEFAULT NULL COMMENT '所属部门Id',
  `duty_id` bigint DEFAULT NULL COMMENT '岗位Id',
  `status` tinyint DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `emp_number_unique_ind` (`emp_number`),
  UNIQUE KEY `mobile_unique_ind` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工';

/*Data for the table `cloud_emp` */

/*Table structure for table `cloud_order` */

DROP TABLE IF EXISTS `cloud_order`;

CREATE TABLE `cloud_order` (
  `order_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '订单Id',
  `shop_id` bigint DEFAULT '0' COMMENT '店铺Id',
  `prod_name` varchar(1000) NOT NULL DEFAULT '' COMMENT '商品名称,多个商品将会以逗号隔开',
  `user_id` varchar(36) NOT NULL COMMENT '用户Id',
  `order_number` varchar(50) NOT NULL COMMENT '订单流水号',
  `order_type` tinyint DEFAULT NULL COMMENT '订单类型',
  `total_amount` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '总值',
  `user_coupon_id` bigint DEFAULT NULL COMMENT '用户优惠券Id',
  `reduce_amount` decimal(18,2) DEFAULT NULL COMMENT '优惠总额',
  `actual_amount` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '实际总值',
  `pay_type` int DEFAULT NULL COMMENT '支付方式 1 微信支付 2 支付宝 3 现金支付',
  `is_payed` tinyint(1) DEFAULT NULL COMMENT '是否支付，1：已经支付过，0：没有支付过',
  `remark` varchar(1024) DEFAULT NULL COMMENT '订单备注',
  `status` int NOT NULL DEFAULT '0' COMMENT '订单状态 1：已提交 5：未支付 9:已支付 13:关闭，失败，17:完成，成功',
  `prod_num` int DEFAULT NULL COMMENT '订单商品总数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_number_unique_ind` (`order_number`),
  UNIQUE KEY `order_number_userid_unique_ind` (`user_id`,`order_number`),
  KEY `shop_id` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单';

/*Data for the table `cloud_order` */

/*Table structure for table `cloud_order_item` */

DROP TABLE IF EXISTS `cloud_order_item`;

CREATE TABLE `cloud_order_item` (
  `order_item_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '订单项Id',
  `order_id` bigint unsigned NOT NULL COMMENT '订单Id',
  `user_id` varchar(36) NOT NULL DEFAULT '' COMMENT '用户Id',
  `table_id` bigint unsigned NOT NULL COMMENT '台桌Id',
  `prod_id` bigint unsigned NOT NULL COMMENT '商品Id',
  `prod_name` varchar(120) NOT NULL DEFAULT '' COMMENT '商品名称',
  `prod_img` varchar(255) NOT NULL DEFAULT '' COMMENT '商品主图片路径',
  `prod_prop` varchar(200) NOT NULL DEFAULT '' COMMENT '商品属性JSON',
  `sku_id` bigint unsigned NOT NULL COMMENT '商品SkuId',
  `sku_name` varchar(120) DEFAULT NULL COMMENT 'sku名称',
  `sku_img` varchar(255) NOT NULL DEFAULT '' COMMENT 'sku主图片路径',
  `sku_prop` varchar(200) DEFAULT '' COMMENT '销售属性组合JSON 格式是p1:v1;p2:v2',
  `num` int NOT NULL DEFAULT '0' COMMENT '商品个数',
  `price` decimal(18,2) NOT NULL COMMENT '商品价格',
  `total_amount` decimal(18,2) NOT NULL COMMENT '商品总金额',
  `remark` varchar(120) NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`order_item_id`),
  KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单项';

/*Data for the table `cloud_order_item` */

/*Table structure for table `cloud_order_settlement` */

DROP TABLE IF EXISTS `cloud_order_settlement`;

CREATE TABLE `cloud_order_settlement` (
  `settlement_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '结算单号Id',
  `order_id` bigint unsigned NOT NULL COMMENT '订单Id',
  `order_number` varchar(36) DEFAULT NULL COMMENT '订单流水号',
  `shop_id` bigint NOT NULL COMMENT '店铺Id',
  `user_id` varchar(36) DEFAULT NULL COMMENT '用户Id',
  `pay_type` int DEFAULT NULL COMMENT '支付方式 1 微信支付 2 支付宝 3 现金支付',
  `pay_amount` decimal(18,2) DEFAULT NULL COMMENT '支付金额',
  `pay_number` varchar(36) DEFAULT NULL COMMENT '支付单号',
  `pay_status` int DEFAULT NULL COMMENT '支付状态 1 已支付',
  `biz_pay_number` varchar(255) DEFAULT NULL COMMENT '外部订单流水号',
  `is_clear` int DEFAULT NULL COMMENT '是否清算 0:否 1:是',
  `clear_time` datetime DEFAULT NULL COMMENT '清算时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`settlement_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='结算';

/*Data for the table `cloud_order_settlement` */

/*Table structure for table `cloud_perm` */

DROP TABLE IF EXISTS `cloud_perm`;

CREATE TABLE `cloud_perm` (
  `perm_code` varchar(20) NOT NULL DEFAULT '' COMMENT '权限编码',
  `perm_name` varchar(50) NOT NULL DEFAULT '' COMMENT '权限名称',
  `shop_id` bigint DEFAULT NULL COMMENT '店铺Id',
  `status` tinyint DEFAULT NULL COMMENT '状态  0 禁用  1 启用 -1 删除',
  `create_time` datetime NOT NULL COMMENT '建立时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`perm_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限';

/*Data for the table `cloud_perm` */

/*Table structure for table `cloud_prod` */

DROP TABLE IF EXISTS `cloud_prod`;

CREATE TABLE `cloud_prod` (
  `prod_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '商品Id',
  `prod_code` varchar(300) NOT NULL DEFAULT '' COMMENT '商品编码',
  `prod_name` varchar(300) NOT NULL DEFAULT '' COMMENT '商品名称',
  `pinyin` varchar(100) DEFAULT '' COMMENT '拼音简码',
  `shop_id` bigint DEFAULT NULL COMMENT '店铺Id',
  `cate_id` bigint unsigned DEFAULT NULL COMMENT '商品分类',
  `brand_id` bigint DEFAULT NULL COMMENT '品牌Id',
  `ori_price` decimal(18,2) DEFAULT '0.00' COMMENT '原价',
  `price` decimal(18,2) DEFAULT NULL COMMENT '现价',
  `mem_price` decimal(18,2) DEFAULT '0.00' COMMENT '会员价',
  `unit` varchar(20) DEFAULT NULL COMMENT '单位',
  `brief` varchar(500) DEFAULT '' COMMENT '简要描述,卖点等',
  `content` varchar(500) DEFAULT '' COMMENT '详细描述',
  `sold` int DEFAULT NULL COMMENT '销量',
  `stock` int DEFAULT '0' COMMENT '库存',
  `status` int DEFAULT '0' COMMENT '默认是1 上架, -1表示删除, 0下架',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `puton_time` datetime DEFAULT NULL COMMENT '上架时间',
  `version` int DEFAULT NULL COMMENT '版本 乐观锁',
  PRIMARY KEY (`prod_id`),
  KEY `shop_id` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品';

/*Data for the table `cloud_prod` */

/*Table structure for table `cloud_prod_cate` */

DROP TABLE IF EXISTS `cloud_prod_cate`;

CREATE TABLE `cloud_prod_cate` (
  `cate_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '类目Id',
  `shop_id` bigint NOT NULL COMMENT '店铺Id',
  `cate_name` varchar(50) NOT NULL DEFAULT '' COMMENT '类目名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '类目图标',
  `img` varchar(300) DEFAULT NULL COMMENT '类目的显示图片',
  `p_id` bigint unsigned NOT NULL COMMENT '父节点',
  `grade` int NOT NULL COMMENT '分类层级',
  `seq` int NOT NULL COMMENT '排序',
  `status` int NOT NULL DEFAULT '1' COMMENT '默认是1 正常状态,0 禁用状态 -1 删除状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`cate_id`),
  KEY `p_id` (`p_id`),
  KEY `shop_id` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类目';

/*Data for the table `cloud_prod_cate` */

/*Table structure for table `cloud_prod_img` */

DROP TABLE IF EXISTS `cloud_prod_img`;

CREATE TABLE `cloud_prod_img` (
  `img_id` bigint NOT NULL AUTO_INCREMENT,
  `img_url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `img_type` varchar(20) DEFAULT NULL COMMENT '图片类型',
  `img_size` int DEFAULT NULL COMMENT '图片大小',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `link_type` tinyint DEFAULT NULL COMMENT '图片关联表类型：1 商品表 2 商品规格',
  `link_id` bigint DEFAULT NULL COMMENT '图片关联的表主键Id',
  `link_cate` tinyint DEFAULT NULL COMMENT '1 商品表(1 主图 2 轮播图 3 详情图 ) 2 商品规格表(1 主图，2 详情图)',
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图';

/*Data for the table `cloud_prod_img` */

/*Table structure for table `cloud_prod_prop` */

DROP TABLE IF EXISTS `cloud_prod_prop`;

CREATE TABLE `cloud_prod_prop` (
  `prop_id` bigint NOT NULL AUTO_INCREMENT COMMENT '属性Id',
  `shop_id` bigint DEFAULT NULL COMMENT '店铺Id',
  `cate_id` bigint unsigned DEFAULT NULL COMMENT '商品分类 0表示所有分类通用',
  `rule` tinyint DEFAULT NULL COMMENT '1:销售属性(规格); 2:参数属性',
  `prop_name` varchar(20) DEFAULT NULL COMMENT '属性名称',
  PRIMARY KEY (`prop_id`),
  KEY `shop_id` (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品属性';

/*Data for the table `cloud_prod_prop` */

insert  into `cloud_prod_prop`(`prop_id`,`shop_id`,`cate_id`,`rule`,`prop_name`) values (80,1,NULL,1,'内存'),(81,1,NULL,1,'颜色');

/*Table structure for table `cloud_prod_prop_value` */

DROP TABLE IF EXISTS `cloud_prod_prop_value`;

CREATE TABLE `cloud_prod_prop_value` (
  `value_id` bigint NOT NULL AUTO_INCREMENT COMMENT '属性值Id',
  `value_name` varchar(20) DEFAULT NULL COMMENT '属性值名称',
  `prop_id` bigint DEFAULT NULL COMMENT '属性Id',
  PRIMARY KEY (`value_id`),
  KEY `prop_id` (`prop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品属性值';

/*Data for the table `cloud_prod_prop_value` */

/*Table structure for table `cloud_prod_sku` */

DROP TABLE IF EXISTS `cloud_prod_sku`;

CREATE TABLE `cloud_prod_sku` (
  `sku_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '单品Id',
  `prod_id` bigint unsigned NOT NULL COMMENT '商品Id',
  `shop_id` bigint DEFAULT NULL COMMENT '店铺Id',
  `barcode` varchar(100) DEFAULT NULL COMMENT '商品条码',
  `sku_prop` varchar(200) DEFAULT '' COMMENT '销售属性组合JSON 格式是p1:v1;p2:v2',
  `sku_name` varchar(120) DEFAULT NULL COMMENT 'sku名称',
  `prod_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `ori_price` decimal(18,2) DEFAULT NULL COMMENT '原价',
  `price` decimal(18,2) DEFAULT NULL COMMENT '价格',
  `unit` varchar(20) DEFAULT NULL COMMENT '单位',
  `v_stock` int NOT NULL COMMENT '商品在付款减库存的状态下，该sku上未付款的订单数量',
  `stock` int DEFAULT NULL COMMENT '实际库存',
  `status` tinyint DEFAULT '1' COMMENT '0 禁用 1 启用 -1 已删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`sku_id`),
  KEY `prod_id` (`prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单品SKU';

/*Data for the table `cloud_prod_sku` */

/*Table structure for table `cloud_role` */

DROP TABLE IF EXISTS `cloud_role`;

CREATE TABLE `cloud_role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `shop_id` bigint DEFAULT NULL COMMENT '店铺Id',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_by` bigint DEFAULT NULL COMMENT '创建者Id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `cloud_role` */

insert  into `cloud_role`(`role_id`,`role_name`,`shop_id`,`remark`,`create_by`,`create_time`) values (1,'管理员',NULL,'测试',NULL,'2019-07-03 08:39:49');

/*Table structure for table `cloud_role_menu` */

DROP TABLE IF EXISTS `cloud_role_menu`;

CREATE TABLE `cloud_role_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint DEFAULT NULL COMMENT '角色Id',
  `menu_id` bigint DEFAULT NULL COMMENT '菜单Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

/*Data for the table `cloud_role_menu` */

/*Table structure for table `cloud_role_perm` */

DROP TABLE IF EXISTS `cloud_role_perm`;

CREATE TABLE `cloud_role_perm` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint DEFAULT NULL COMMENT '角色Id',
  `perm_id` bigint DEFAULT NULL COMMENT '权限Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与权限对应关系';

/*Data for the table `cloud_role_perm` */

/*Table structure for table `cloud_search_hot` */

DROP TABLE IF EXISTS `cloud_search_hot`;

CREATE TABLE `cloud_search_hot` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `shop_id` bigint DEFAULT NULL COMMENT '店铺ID',
  `content` varchar(255) NOT NULL COMMENT '内容',
  `times` int DEFAULT NULL COMMENT '点击次数',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态 0删除 1在用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `shop_id` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='热搜';

/*Data for the table `cloud_search_hot` */

/*Table structure for table `cloud_search_record` */

DROP TABLE IF EXISTS `cloud_search_record`;

CREATE TABLE `cloud_search_record` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` varchar(50) NOT NULL COMMENT '用户Id',
  `shop_id` bigint DEFAULT NULL COMMENT '店铺ID',
  `content` varchar(255) NOT NULL COMMENT '内容',
  `times` int DEFAULT NULL COMMENT '搜索次数',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态 0删除 1在用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='搜索记录';

/*Data for the table `cloud_search_record` */

/*Table structure for table `cloud_shop` */

DROP TABLE IF EXISTS `cloud_shop`;

CREATE TABLE `cloud_shop` (
  `shop_id` bigint NOT NULL AUTO_INCREMENT COMMENT '店铺Id',
  `shop_name` varchar(50) DEFAULT NULL COMMENT '店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一',
  `shop_type` tinyint DEFAULT NULL COMMENT '店铺类型',
  `industry` tinyint DEFAULT NULL COMMENT '店铺行业(餐饮、生鲜果蔬、鲜花等)',
  `brief` varchar(200) DEFAULT NULL COMMENT '店铺简介(可修改)',
  `notice` varchar(50) DEFAULT NULL COMMENT '店铺公告(可修改)',
  `owner` varchar(50) DEFAULT NULL COMMENT '店长',
  `mobile` varchar(20) DEFAULT NULL COMMENT '店铺绑定的手机(登录账号：唯一)',
  `tel` varchar(20) DEFAULT NULL COMMENT '店铺联系电话',
  `lat` varchar(20) DEFAULT NULL COMMENT '店铺所在纬度(可修改)',
  `lng` varchar(20) DEFAULT NULL COMMENT '店铺所在经度(可修改)',
  `pca_code` varchar(20) DEFAULT NULL COMMENT '店铺省市区代码，用于回显',
  `pca_name` varchar(10) DEFAULT NULL COMMENT '店铺所在省市区（描述）',
  `address` varchar(100) DEFAULT NULL COMMENT '详细地址',
  `open_time` varchar(100) DEFAULT NULL COMMENT '每天营业时间段(可修改)',
  `close_time` varchar(100) DEFAULT NULL COMMENT '每天关闭时间段(可修改)',
  `status` tinyint DEFAULT NULL COMMENT '店铺状态(-1:未开通 0: 停业中 1:营业中)，可修改',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`shop_id`),
  UNIQUE KEY `mobile` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺';

/*Data for the table `cloud_shop` */

/*Table structure for table `cloud_sys_config` */

DROP TABLE IF EXISTS `cloud_sys_config`;

CREATE TABLE `cloud_sys_config` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `param_key` varchar(50) DEFAULT NULL COMMENT 'key',
  `param_value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `status` int NOT NULL DEFAULT '1' COMMENT '状态  1:启用  0：禁用 -1:删除',
  `shop_id` bigint DEFAULT NULL COMMENT '店铺Id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`param_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置信息';

/*Data for the table `cloud_sys_config` */

/*Table structure for table `cloud_sys_dic` */

DROP TABLE IF EXISTS `cloud_sys_dic`;

CREATE TABLE `cloud_sys_dic` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dic_code` varchar(50) DEFAULT NULL COMMENT '编码',
  `dic_name` varchar(500) DEFAULT NULL COMMENT '名称',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `shop_id` bigint DEFAULT NULL COMMENT '店铺Id 0表示全局配置',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典';

/*Data for the table `cloud_sys_dic` */

/*Table structure for table `cloud_sys_dic_kv` */

DROP TABLE IF EXISTS `cloud_sys_dic_kv`;

CREATE TABLE `cloud_sys_dic_kv` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dic_code` varchar(50) DEFAULT NULL COMMENT '字典编码',
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(500) DEFAULT NULL COMMENT 'value',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `shop_id` bigint DEFAULT NULL COMMENT '店铺Id 0表示全局配置',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典kv';

/*Data for the table `cloud_sys_dic_kv` */

/*Table structure for table `cloud_sys_menu` */

DROP TABLE IF EXISTS `cloud_sys_menu`;

CREATE TABLE `cloud_sys_menu` (
  `menu_id` bigint NOT NULL AUTO_INCREMENT,
  `p_id` bigint DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `menu_type` int DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `menu_name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `seq` int DEFAULT NULL COMMENT '排序',
  `shop_id` bigint DEFAULT NULL COMMENT '店铺Id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单';

/*Data for the table `cloud_sys_menu` */

/*Table structure for table `cloud_table` */

DROP TABLE IF EXISTS `cloud_table`;

CREATE TABLE `cloud_table` (
  `table_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `table_code` varchar(20) NOT NULL COMMENT '台桌编码',
  `table_name` varchar(100) NOT NULL COMMENT '台桌名称',
  `location` varchar(20) DEFAULT NULL COMMENT '台桌位置',
  `people` int DEFAULT '1' COMMENT '人数',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `status` int DEFAULT '1' COMMENT '默认是1，表示正常状态,0为禁用状态 -1 删除状态 10 空桌 11 就餐 12结清',
  `seq` int DEFAULT '1' COMMENT '顺序',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` datetime DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='台桌';

/*Data for the table `cloud_table` */

/*Table structure for table `cloud_user` */

DROP TABLE IF EXISTS `cloud_user`;

CREATE TABLE `cloud_user` (
  `user_id` varchar(36) NOT NULL DEFAULT '' COMMENT '用户Id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登录密码',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `mail` varchar(100) DEFAULT NULL COMMENT '用户邮箱',
  `gender` char(1) DEFAULT 'M' COMMENT 'M(男) or F(女)',
  `birth_date` char(10) DEFAULT NULL COMMENT '例如：2009-11-27',
  `reg_time` datetime NOT NULL COMMENT '注册时间',
  `reg_ip` varchar(50) DEFAULT NULL COMMENT '注册IP',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(50) DEFAULT NULL COMMENT '最后登录IP',
  `img` varchar(255) DEFAULT NULL COMMENT '头像图片',
  `grade_id` bigint DEFAULT NULL COMMENT '会员等级',
  `current_integral` int NOT NULL COMMENT '当前积分',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态 1 正常 0 无效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `ud_mail` (`mail`),
  UNIQUE KEY `ud_user_unique_mobile` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `cloud_user` */

/*Table structure for table `cloud_user_coupon` */

DROP TABLE IF EXISTS `cloud_user_coupon`;

CREATE TABLE `cloud_user_coupon` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `user_id` varchar(36) NOT NULL COMMENT '用户Id',
  `coupon_id` bigint NOT NULL COMMENT '优惠券Id',
  `begin_time` datetime DEFAULT NULL COMMENT '有效期开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '有效期结束时间',
  `create_time` datetime DEFAULT NULL COMMENT '领取时间',
  `use_time` datetime DEFAULT NULL COMMENT '使用时间',
  `status` tinyint DEFAULT '0' COMMENT '1 已使用 0 未使用 -1已过期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='用户优惠券';

/*Data for the table `cloud_user_coupon` */

/*Table structure for table `cloud_user_tp` */

DROP TABLE IF EXISTS `cloud_user_tp`;

CREATE TABLE `cloud_user_tp` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `user_id` varchar(36) NOT NULL COMMENT '本系统userId',
  `third_id` tinyint DEFAULT NULL COMMENT '第三方系统id 1：微信小程序',
  `third_user_id` varchar(255) DEFAULT NULL COMMENT '第三方系统userId',
  `third_union_id` varchar(255) DEFAULT NULL COMMENT '第三方系统unionId',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '第三方系统昵称',
  `img` varchar(500) DEFAULT NULL COMMENT '第三方系统头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户第三方信息';

/*Data for the table `cloud_user_tp` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
