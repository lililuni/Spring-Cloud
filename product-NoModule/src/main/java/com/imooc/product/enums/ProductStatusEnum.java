package com.imooc.product.enums;

import lombok.Getter;

/**
* 
* @since  2018年9月30日 上午11:25:07
* @author llb 
* ProductStatus 商品上下架枚举类  
*/
@Getter
public enum ProductStatusEnum {
	UP(0,"在架"),
	DOWN(1,"下架"),
	;
	
	private Integer code;
	private String message;
	private ProductStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
	
}
