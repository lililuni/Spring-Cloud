package com.imooc.order.controller;
/**
* order 控制类  
* @since  2018年10月5日 下午5:33:37
* @author llb 
*/

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.order.VO.ResultVO;

import com.imooc.order.converter.OrderForm2OrderDTOConverter;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.ResultEnum;
import com.imooc.order.exception.OrderException;
import com.imooc.order.form.OrderForm;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.ResultVOUtil;


import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
	

	
	/**
	 * 1：参数检验
	 * 2：查询商品信息
	 * 3：计算总价
	 * 4：扣库存（调用商品服务）
	 * 5：订单入库
	 *  
	 */
	@Autowired
    private OrderService orderService;
    
	
	
	@PostMapping("/create") 
	public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
		
		//1：参数校验
		/*
		*新建form类规定输入参数的格式,以及作为检验方法的参数  items 实际上是orderDetail对象的集合
		*新建 resultVO 类指定返回格式，ResultVOUtil类修饰返回状态
		*新建 OrderException 类指定参数异常信息,在里面用到了 枚举类 ResultEnum 
		* 异常信息分为两种，一是参数不准确和购物车信息为空，里面用到了 json转化为java对象的Gson方式
		*/
		if (bindingResult.hasErrors()) {
			log.error("【创建订单】参数不正确, orderForm={}", orderForm);
			throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
					bindingResult.getFieldError().getDefaultMessage());
		}
		// orderForm -> orderDTO
		OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
		if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
			log.error("【创建订单】购物车信息为空");
			throw new OrderException(ResultEnum.CART_EMPTY);
		}
		
		
		//查询商品信息，计算总价，以及扣库存
		/**
		 * 1：从 orderDTO 获取 orderDetail 的list集合
		 * 2：对于每一个orderdetail对象，根据 orderDetail 的 productid 调用商品服务完善orderDetail，同时，扣库存
		 * 3：计算总价
		 * 4：将orderDetail重新注入到 orderDTO中
		 */
		
		//5：订单入库
		OrderDTO result = orderService.create(orderDTO);

		Map<String, String> map = new HashMap<>();
		
		map.put("orderId", result.getOrderId());
		
		return ResultVOUtil.success(map);
		
	}
	
	
	
	

}
