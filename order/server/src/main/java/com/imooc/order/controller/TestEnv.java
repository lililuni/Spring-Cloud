package com.imooc.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
* @Description 
* @since  2018年10月30日 下午8:32:49
* @author LiuLiBin
*/
@RestController
@RequestMapping("/env")
public class TestEnv {

	@Value("${env}")
	private String envString;
	
	@GetMapping("/test")
	public String getEv() {
		return envString;
	}
}
