package com.imooc.order.dataobject;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
* 订单商品-实体类
* @since  2018年10月5日 上午10:26:18
* @author llb 
*/
@Table(name="order_detail")
@Entity
@Data
public class OrderDetail {
	 @Id
    private String detailId;

    /** 订单id. */
    private String orderId;

    /** 商品id. */
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 商品单价. */
    private BigDecimal productPrice;

    /** 商品数量. */
    private Integer productQuantity;

    /** 商品小图. */
    private String productIcon;
}
