package com.imooc.product.VO;

import java.util.List;

import lombok.Data;

/**
* http请求返回的最外层对象
* @since  2018年9月30日 下午4:08:04
* @author llb 
*/
@Data
public class ResultVO<T> {
	
	/**
	 ** 错误码 正常返回 0
	 */
	private Integer code;
	
	/*
	 * 提示信息 成功
	 */
	private String msg;
	
	/*
	 * 具体内容
	 */
	private List<T> data;
}
