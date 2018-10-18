package com.imooc.order.utils;

import java.util.Random;

/**
* 生成唯一的主键 id
* @since  2018年10月6日 上午9:47:15
* @author llb 
*/
public class KeyUtil {
	
	//加上 synchronized 避免多个进程同时生成随机数,但是这种方式并不适合大工程
	public static synchronized String getUniqueKey() {
		Random random = new Random();
		Integer number = random.nextInt(900000)+100000;
		
		return System.currentTimeMillis()+String.valueOf(number);
		
	}
}
