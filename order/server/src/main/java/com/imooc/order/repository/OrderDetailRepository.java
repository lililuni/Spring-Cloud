package com.imooc.order.repository;

import org.hibernate.boot.spi.JpaOrmXmlPersistenceUnitDefaultAware;
import org.springframework.data.jpa.repository.JpaRepository;

import com.imooc.order.dataobject.OrderDetail;

/**
* OrderDetail 的dao 类
* @since  2018年10月5日 上午10:43:30
* @author llb 
*/
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

}
