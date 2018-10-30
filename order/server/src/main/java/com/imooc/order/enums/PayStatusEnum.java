package com.imooc.order.enums;

import lombok.Getter;

/**
* 
* @since  2018年10月5日 上午10:56:02
* @author llb 
*/
@Getter
public enum PayStatusEnum {
	WAIT(0,"等待支付"),
	SUCCESS(1,"已支付"),
	
	;
	
	private Integer code;
	
	private String  message;

	private  PayStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
