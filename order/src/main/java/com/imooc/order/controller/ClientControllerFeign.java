package com.imooc.order.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.order.client.ProductClient;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;

import lombok.extern.slf4j.Slf4j;

/**
* @Description 
* @since  2018年10月8日 上午10:00:29
* @author LiuLiBin
*/
@RestController
@Slf4j
public class ClientControllerFeign {
	
	@Autowired
	private ProductClient productClient;
	
	@GetMapping("/getProductFeginMsg")
	public String getProductMsg() {
	
		String response = productClient.productMsg();
		
		log.info("response={}",response);
		
		return response;
	}
	
	/*
	 * 依据商品 id 查询商品信息
	 * 
	 */
	@GetMapping("/getProductByIdList")
	public String getProductByIdList() {
		List<ProductInfo> infos=
				productClient.listProductForOrder(Arrays.asList("157875196366160022","157875227953464068"));
		
		log.info("response={}",infos);
		
		return "查询商品";
	}
	
	/*
	 * 测试 扣库存
	 */
	@GetMapping("/decreaseProductStock")
	public String decreaseProductStock() {
		CartDTO cartDTO = new CartDTO("157875196366160022",2);
		productClient.decreaseStock(Arrays.asList(cartDTO));
		
		return "扣库存成功";
	}
	
	
}
