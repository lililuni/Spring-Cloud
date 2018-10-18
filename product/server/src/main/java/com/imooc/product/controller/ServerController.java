package com.imooc.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.service.ProductService;

/**
* @Description 服务调用时的测试控制器，用于订单服务--〉商品服务
* @since  2018年10月8日 上午9:42:23
* @author LiuLiBin
*/
@RestController
public class ServerController {
	
	
	
	@GetMapping("/msg")
	public String msg() {
		return "this is product msg";
	}
	
	/*
	 * 根据id list 返回商品列表（专门给 order 服务提供）
	 * 
	 */

}
