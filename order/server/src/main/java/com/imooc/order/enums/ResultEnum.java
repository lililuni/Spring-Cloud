package com.imooc.order.enums;

import lombok.Getter;

/**
* 
* @since  2018年10月6日 上午10:44:22
* @author llb 
*/
@Getter
public enum ResultEnum {
	 PARAM_ERROR(1, "参数错误"),
	    CART_EMPTY(2, "购物车为空")

	    ;

	    private Integer code;

	    private String message;

	    ResultEnum(Integer code, String message) {
	        this.code = code;
	        this.message = message;
	    }
}
