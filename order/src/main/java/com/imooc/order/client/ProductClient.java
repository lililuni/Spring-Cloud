package com.imooc.order.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;



/**
* @Description 
* @since  2018年10月11日 下午8:45:17
* @author LiuLiBin
*/
@FeignClient(name = "product") //name 写调用的服务名称
public interface ProductClient {

	@GetMapping("/msg")  //msg 对应对应相应的路径  GetMapping 对应服务的GetMapping
	String productMsg(); //名称可随意，不过返回类型要和服务端一致
	
	/*
	 * 根据id集合  返回 productInfo对象
	 */
	@PostMapping("/product/listProductForOrder")
	public List<ProductInfo> listProductForOrder(@RequestBody List<String> productIdList) ;
	
	/*
	 * 扣库存，根据CartDTO集合更新商品库存
	 */
	@PostMapping("/product/decreaseStock")
	public void  decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
