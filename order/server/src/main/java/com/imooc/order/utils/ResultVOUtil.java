package com.imooc.order.utils;

import java.util.Map;

import com.imooc.order.VO.ResultVO;

/**
* 返回对象格式化  其中 data即为map对象
* @since  2018年10月6日 上午11:07:37
* @author llb 
*/
public class ResultVOUtil {
	 
	public static ResultVO< Map<String,String>> success(Map<String,String> object) {
	       
		ResultVO< Map<String,String>>  resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        
        return resultVO;
	}
}
