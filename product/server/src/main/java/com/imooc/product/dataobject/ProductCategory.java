package com.imooc.product.dataobject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
* 
* @since  2018年9月29日 下午3:53:45
* @author llb 
*/
@Data
@Entity
public class ProductCategory {
	@Id
	@GeneratedValue //自增
	private Integer categoryId;

	/** 类目名字. */
	private String categoryName;

	/** 类目编号. */
	private Integer categoryType;

	private Date createTime;

	private Date updateTime;
}
