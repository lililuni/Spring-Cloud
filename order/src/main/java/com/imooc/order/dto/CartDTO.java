package com.imooc.order.dto;

import lombok.Data;

/**
* @Description  从 order 服务中传过来的参数信息组成的类
* @since  2018年10月14日 下午8:27:18
* @author LiuLiBin
*/
@Data
public class CartDTO {
	private String ProductId;
	
	private Integer ProductQuantity ;

	public CartDTO(String productId, Integer productQuantity) {
	
		ProductId = productId;
		ProductQuantity = productQuantity;
	}

	public CartDTO() {
	
	}
	
	
	
	
}
