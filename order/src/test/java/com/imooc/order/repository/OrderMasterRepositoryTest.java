package com.imooc.order.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;

/**
* 测试类
* @since  2018年10月5日 上午10:46:46
* @author llb 
*/
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests{

	@Autowired
	private OrderMasterRepository orderMasterRepository;
	
	@Test
	public void test() {
		 OrderMaster orderMaster = new OrderMaster();
	        orderMaster.setOrderId("123444");
	        orderMaster.setBuyerName("师");
	        orderMaster.setBuyerPhone("1886131241241");
	        orderMaster.setBuyerAddress("慕课网总部");
	        orderMaster.setBuyerOpenid("1101110");
	        orderMaster.setOrderAmount(new BigDecimal(2.5));
	        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
	        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
	        
	        OrderMaster result = orderMasterRepository.save(orderMaster);
	        Assert.assertTrue(result != null);
	}

}
