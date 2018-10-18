package com.imooc.order.VO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
* @Description 
* @since  2018年10月15日 下午2:50:52
* @author LiuLiBin
*/


@Data
public class HourdbParmVO {
	
	private double senid;
	
	//"yyyy-MM-dd HH:mm:ss"
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date 	time;

	public HourdbParmVO(double senid, Date time) {
		
		this.senid = senid;
		this.time = time;
	}

	public HourdbParmVO() {
		
	}
	
	
	
	
}
