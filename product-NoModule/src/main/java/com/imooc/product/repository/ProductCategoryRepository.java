package com.imooc.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imooc.product.dataobject.ProductCategory;

/**
* 
* @since  2018年9月29日 下午4:10:48
* @author llb 
* 商品通过类目类型查询所有类目
*/
public interface ProductCategoryRepository  extends JpaRepository<ProductCategory,Integer>{

	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
