package com.imooc.product.exception;

import com.imooc.product.enums.ResultEnum;

/**
* @Description 
* @since  2018年10月15日 上午9:24:00
* @author LiuLiBin
*/
public class ProductException extends RuntimeException{

	private Integer code;
	
	public ProductException(Integer code,String message) {
		super(message);
		
		this.code = code;
		
	}
	
	//再定义一个构造方法 用到枚举类
	public ProductException(ResultEnum resultEnum) {
		
		super(resultEnum.getMessage());
		
		this.code = resultEnum.getCode();
	}
	
	
}
