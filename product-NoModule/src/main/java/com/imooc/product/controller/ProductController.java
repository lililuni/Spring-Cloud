package com.imooc.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.product.VO.ProductInfoVO;
import com.imooc.product.VO.ProductVO;
import com.imooc.product.VO.ResultVO;
import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.dto.CartDTO;
import com.imooc.product.service.CategoryService;
import com.imooc.product.service.ProductService;
import com.imooc.product.utils.ResultVOUtil;

/**
* 
* @since  2018年9月28日 上午9:38:17
* @author llb 
*/
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

	/*
	 * 1: 查询所有在架的商品
	 * 2：获取类目type列表
	 * 3：查询类目
	 * 4：构造数据
	 * 
	 * 查询方式：Spring Data JPA
	 */
	@GetMapping("/list")
	public ResultVO<ProductVO> list() {

		
		//查询所有在架商品
		List<ProductInfo> productInfoList=productService.findUpAll();
		
		//获取类目type列表 stream为java8的特性，map方法产生1：；1映射，对于每个ProductInfo，都转换为一个Type
		List<Integer> categoryTypeList = productInfoList.stream()
				.map(ProductInfo::getCategoryType)
				.collect(Collectors.toList());
		
		
		//从数据库查询类目
		List<ProductCategory> categoryList =categoryService.findByCategoryTypeIn(categoryTypeList);
		
		//构造数据
		List<ProductVO> productVOList =new ArrayList<>();

		for (ProductCategory productCategory : categoryList) {
			ProductVO productVO = new ProductVO();
			productVO.setCategoryName(productCategory.getCategoryName());
			productVO.setCategoryTypeInteger(productCategory.getCategoryType());

			List<ProductInfoVO> productInfoVOList = new ArrayList<>(); // 商品集合

			for (ProductInfo productInfo : productInfoList) {

				if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {

					ProductInfoVO productInfoVO = new ProductInfoVO();

					BeanUtils.copyProperties(productInfo, productInfoVO); // 复制对象的简单方式

					productInfoVOList.add(productInfoVO);
				}

			}

			productVO.setProductInfoVOList(productInfoVOList);

			productVOList.add(productVO);
		}
		return ResultVOUtil.success(productVOList);

	}

	/*
	 * 根据id集合  返回 productInfo对象
	 */
	@PostMapping("/listProductForOrder")
	public List<ProductInfo> listProductForOrder(@RequestBody List<String> productIdList) {
		return  productService.findList(productIdList);
	}
	
	/*
	 * 扣库存，根据CartDTO集合更新商品库存
	 */
	@PostMapping("/decreaseStock")
	public void  decreaseStock(@RequestBody List<CartDTO> cartDTOList) {
		productService.decreaseStock(cartDTOList);
	}
	
	
	
	
	
}
