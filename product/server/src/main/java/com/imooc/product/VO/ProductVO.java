package com.imooc.product.VO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
* http请求中的data对象
* @since  2018年9月30日 下午4:18:53
* @author llb 
*/
@Data
public class ProductVO {
	
	@JsonProperty("name") //为了避免变量直接命名为name产生歧义，所以命名为categoryName，但是在api中为name，所以用这种方式
	private String categoryName;
	
	@JsonProperty("type")
	private Integer categoryTypeInteger;

	@JsonProperty("foods")
	private List<ProductInfoVO> productInfoVOList;
}
