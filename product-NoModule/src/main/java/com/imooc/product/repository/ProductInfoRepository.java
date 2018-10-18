package com.imooc.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imooc.product.dataobject.ProductInfo;



/**
* 
* @since  2018年9月28日 下午8:31:16
* @author llb 
* Dao类，继承JpaRepository可以方便查询数据库
*/
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>{
	
	List <ProductInfo> findByProductStatus(Integer productStatus);
	
	List <ProductInfo> findAll();
	
	List <ProductInfo> findByProductIdIn(List<String> productIdList);
}
