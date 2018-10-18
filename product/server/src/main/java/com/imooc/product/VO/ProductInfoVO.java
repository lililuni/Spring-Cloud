package com.imooc.product.VO;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
* http请求中的foods对象
* @since  2018年9月30日 下午4:29:42
* @author llb 
*/
@Data
public class ProductInfoVO {
	
	@JsonProperty("id")
	private String productId;
	
	@JsonProperty("name")
	private String productName;
	
	@JsonProperty("price")
	private BigDecimal productPrice;
	
	@JsonProperty("description")
	private String productDescription;
	
	@JsonProperty("icon")
	private String productIcon;
	
}
