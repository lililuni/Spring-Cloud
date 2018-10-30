package com.imooc.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
* @Description  RestTemplate的第3种方法，注意添加的三个注解
* @since  2018年10月8日 上午10:50:18
* @author LiuLiBin
*/
@Component
public class RestTemplateConfig {
	
	@Bean
	@LoadBalanced
	
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
