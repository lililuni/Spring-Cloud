package com.imooc.order.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
* @Description 
* @since  2018年10月8日 上午10:00:29
* @author LiuLiBin
*/
@RestController
@Slf4j
public class ClientControllerTemplate {
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired 
//	private LoadBalancerClient loadBalancerClient; //第2种
	
	@GetMapping("/getProductMsg")
	public String getProductMsg() {
		//1.第一种方式，需要知道服务端ip，url写死
		/*RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject("http://localhost:9000/msg", String.class);*/
		
		//第二种方式  利用loadBalancerClient
		/*ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");//参数为Eureka中的对象
		//拿到选定服务的url
		String url = String.format("http://%s:%s", serviceInstance.getHost(),serviceInstance.getPort())+"/msg";
		
		RestTemplate restTemplate = new RestTemplate();
		
		String response = restTemplate.getForObject(url, String.class);*/
		
		//第3种方式 利用注解@LoadBalanced
		String response=restTemplate.getForObject("http://PRODUCT/msg", String.class);
		
		log.info("response={}",response);
		
		return response;
	}
}
