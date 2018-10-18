package com.imooc.product.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.dto.CartDTO;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.enums.ResultEnum;
import com.imooc.product.exception.ProductException;
import com.imooc.product.repository.ProductInfoRepository;
import com.imooc.product.service.ProductService;

/**
* 
* @since  2018年9月30日 上午11:18:32
* @author llb 
*/
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Override
	public List<ProductInfo> findUpAll() {
		// TODO Auto-generated method stub
		return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

	@Override
	public List<ProductInfo> findAll() {
		// TODO Auto-generated method stub
		return productInfoRepository.findAll();
	}

	@Override
	public List<ProductInfo> findList(List<String> productIdList) {
		// TODO Auto-generated method stub
		return productInfoRepository.findByProductIdIn(productIdList);
	}

	@Override
	@Transactional
	public void decreaseStock(List<CartDTO> cartDTOList) {
		// TODO Auto-generated method stub
		for(CartDTO cartDTO:cartDTOList) {
			//根据 id 查询商品
			ProductInfo productInfo = productInfoRepository.findOne(cartDTO.getProductId());
			
			//判断商品是否存在
			if(productInfo==null) {
				//自定义异常
				throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			//判断库存是否足够
			Integer resultStock = productInfo.getProductStock()-cartDTO.getProductQuantity();
			if(resultStock<0) {
				throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
			}
			
			//扣库存后商品入库
			productInfo.setProductStock(resultStock);
			productInfoRepository.save(productInfo);
		}
		
	}
	
	

}
