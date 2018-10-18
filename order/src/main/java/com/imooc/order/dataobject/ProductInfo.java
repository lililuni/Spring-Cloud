package com.imooc.order.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
* 
* @since  2018年9月28日 上午11:31:53
* @author llb 
*/
@Data    //需要使用lombok插件，直接生成了get（） set（）方法

@Table(name="product_info")  //对应数据库中的表名

@Entity 		//表明是一个实体类
//类名和表的名字对应，可以直接注入，否则需要用Table注解
public class ProductInfo {
	@Id
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. 类型*/
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

	
	
}
