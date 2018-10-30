package com.imooc.order.exception;

import com.imooc.order.enums.ResultEnum;

/**
* 
* @since  2018年10月6日 上午10:36:22
* @author llb 
*/
public class OrderException extends RuntimeException {
    
	private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
