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

import com.imooc.product.dataobject.ProductCategory;



/**
* 
* @since  2018年9月29日 下午4:54:25
* @author llb 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Autowired
	private  ProductCategoryRepository  productCategoryRepository;

	@Test
	public void testFindByCategoryTypeIn() throws Exception {
		List<ProductCategory> list=productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11,22));
		Assert.assertTrue(list.size()>0);
	}

}
