package com.imooc.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imooc.order.dataobject.OrderMaster;

/**
* OrderMaster 对应的 dao
* @since  2018年10月5日 上午10:36:46
* @author llb 
*/
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
	//不用写方法，直接用 jpa 私有的方法就好
}
