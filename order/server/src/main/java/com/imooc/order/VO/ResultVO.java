package com.imooc.order.VO;

import lombok.Data;

/**
* 
* @since  2018年10月6日 上午10:25:55
* @author llb 
*/
@Data
public class ResultVO <T>{
    private Integer code;

    private String msg;

    private T data;
}
