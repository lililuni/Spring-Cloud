package com.imooc.product.service;

import java.util.List;

import com.imooc.product.dataobject.ProductCategory;

/**
* 
* @since  2018年9月30日 下午12:07:13
* @author llb 
*/
public interface CategoryService {
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
