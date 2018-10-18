package com.imooc.product.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import com.imooc.product.dataobject.ProductInfo;
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
	public List<ProductInfoOutput> findList(List<String> productIdList) {
		// TODO Auto-generated method stub
		return productInfoRepository.findByProductIdIn(productIdList).stream()
				.map(e -> {
					ProductInfoOutput output = new ProductInfoOutput();
					BeanUtils.copyProperties(e, output);
					return output;
				})
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
		// TODO Auto-generated method stub
		for(DecreaseStockInput decreaseStockInput:decreaseStockInputList) {
			//根据 id 查询商品
			ProductInfo productInfo = productInfoRepository.findOne(decreaseStockInput.getProductId());
			
			//判断商品是否存在
			if(productInfo==null) {
				//自定义异常
				throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			//判断库存是否足够
			Integer resultStock = productInfo.getProductStock()-decreaseStockInput.getProductQuantity();
			if(resultStock<0) {
				throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
			}
			
			//扣库存后商品入库
			productInfo.setProductStock(resultStock);
			productInfoRepository.save(productInfo);
		}
		
	}
	
	

}
