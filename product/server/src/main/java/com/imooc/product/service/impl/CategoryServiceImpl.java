package com.imooc.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.repository.ProductCategoryRepository;
import com.imooc.product.service.CategoryService;

/**
* 
* @since  2018年9月30日 下午12:09:09
* @author llb 
* 商品类目接口，方法返回制定类目类型的商品
*/
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private  ProductCategoryRepository  productCategoryRepository;
	
	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
		// TODO Auto-generated method stub
		return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
	}

}
