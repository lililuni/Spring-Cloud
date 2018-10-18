package com.imooc.order.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.order.VO.HourdbParmVO;
import com.imooc.order.VO.HourdbResultVO;
import com.imooc.order.client.DataClient;

import lombok.extern.slf4j.Slf4j;

/**
* @Description  测试数据库服务
* @since  2018年10月15日 下午4:54:48
* @author LiuLiBin
*/
@RestController
@Slf4j
public class DataClientController {
	
	@Autowired
	private DataClient dataClient;
	
	/**
	 * 
	 * @return 返回 hourdb 对象
	 * @throws ParseException
	 */
	@GetMapping("/listHourdb")
	public HourdbResultVO listHourdb() throws ParseException {
		
		List<HourdbParmVO>  hourdbDTOList = new ArrayList<>();
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = dateFormat2.parse("2012-12-26 16:00:00");
		HourdbParmVO hourdbDTO = new HourdbParmVO((double)531200114,date);
		hourdbDTOList.add(hourdbDTO);
		
		HourdbResultVO hourdbResultVO = dataClient.listBySenidAndTime(hourdbDTOList);
		
		return hourdbResultVO ;
	}
	
}
