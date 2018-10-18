package com.imooc.product.utils;
/**
* ResultVO 的修饰类
* @since  2018年10月3日 上午11:30:14
* @author llb 
*/

import java.util.List;

import com.imooc.product.VO.ProductVO;
import com.imooc.product.VO.ResultVO;

public class ResultVOUtil {
	
	public static ResultVO<ProductVO> success(List<ProductVO> object){
		ResultVO<ProductVO> resultVO=new ResultVO<>();
		resultVO.setData(object);
		resultVO.setCode(0);
		resultVO.setMsg("成功");
		return resultVO;
	}
}
