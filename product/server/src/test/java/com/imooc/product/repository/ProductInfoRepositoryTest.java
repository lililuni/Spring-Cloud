package com.imooc.product.repository;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.product.dataobject.ProductInfo;


/**
* 
* @since  2018年9月28日 下午9:02:05
* @author llb 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

	
	@Autowired
	private ProductInfoRepository productInfoRespository;

	@Test
	public void findAll() throws Exception {
		List<ProductInfo> list=productInfoRespository.findAll();
		Assert.assertTrue(list.size()>0);
		
	}
	
	@Test
	public void findByProductIdIn() throws Exception{
		List <ProductInfo> productInfoLists =
				productInfoRespository.findByProductIdIn(
						Arrays.asList("157875196366160022","157875227953464068"));
		Assert.assertTrue(productInfoLists.size()>0);
	}

}
