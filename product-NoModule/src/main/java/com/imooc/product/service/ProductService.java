package com.imooc.product.service;
/**
* 
* @since  2018年9月30日 上午11:05:14
* @author llb 
*/
/*
 * 查询所有在架商品列表
 * 
 */

import java.util.List;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.dto.CartDTO;

public interface ProductService {
	//查询所有在架商品
	List <ProductInfo> findUpAll();
	
	//查询所有商品
	List<ProductInfo> findAll();
	
	//根据idList 查商品列表
	List<ProductInfo> findList(List<String> productIdList);
	
	/*
	 * 扣库存
	 */
	void decreaseStock(List<CartDTO> cartDTOList);
}
