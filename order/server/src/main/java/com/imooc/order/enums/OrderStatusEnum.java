package com.imooc.order.enums;

import lombok.Getter;

/**
* 
* @since  2018年10月5日 上午10:55:20
* @author llb 
*/
@Getter
public enum OrderStatusEnum {
	NEW(0,"新订单"),
	FINISHED(1,"完结"),
	CACCEL(2,"取消"),
	;
	
	private Integer code;
	
	private String  message;

	private OrderStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
}
