package com.imooc.order.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.dataobject.OrderDetail;

/**
* 
* @since  2018年10月5日 下午5:19:41
* @author llb 
*/
@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Test
	public void test() {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setDetailId("12367");
		orderDetail.setOrderId("123456");
		orderDetail.setProductIcon("http://xxx.com");
		orderDetail.setProductId("157875196366160022");
		orderDetail.setProductName("皮蛋粥");
		orderDetail.setProductPrice(new BigDecimal(0.01));
		orderDetail.setProductQuantity(2);

		OrderDetail result = orderDetailRepository.save(orderDetail);
		Assert.assertTrue(result != null);
	}

}
