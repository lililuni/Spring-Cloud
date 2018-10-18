package com.imooc.order.service;

import com.imooc.order.dto.OrderDTO;

/**
* 
* @since  2018年10月5日 下午7:23:26
* @author llb 
*/
public interface OrderService {

	/*
	 * 创建订单
	 */
	OrderDTO create(OrderDTO orderDTO);
	
}
