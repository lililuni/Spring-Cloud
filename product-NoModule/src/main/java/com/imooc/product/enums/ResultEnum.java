package com.imooc.product.enums;

import lombok.Getter;

/**
* @Description  查询商品后的 状态类 是否存在
* @since  2018年10月15日 上午9:38:10
* @author LiuLiBin
*/
@Getter
public enum ResultEnum {
	PRODUCT_NOT_EXIST(1,"商品不存在"),
	
	PRODUCT_STOCK_ERROR(2,"库存不够")
	
	;
	
	
	private Integer code;
	
	private String  message;

	private ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
}
