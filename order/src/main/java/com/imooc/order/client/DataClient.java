package com.imooc.order.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.imooc.order.VO.HourdbParmVO;
import com.imooc.order.VO.HourdbResultVO;



/**
* @Description 
* @since  2018年10月15日 下午4:49:45
* @author LiuLiBin
*/
@FeignClient(name = "data")
public interface DataClient {
	
	@PostMapping("/database/hourdb/listBySenidAndTime")
    public HourdbResultVO listBySenidAndTime(@RequestBody List<HourdbParmVO> hourdbParmVOs); 
}
