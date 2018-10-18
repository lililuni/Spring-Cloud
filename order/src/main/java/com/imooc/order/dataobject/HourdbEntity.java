package com.imooc.order.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @Describe Hourdb的实体类
 * @author LiuLiBin
 * @email 970985518@qq.com
 * @date 2018-10-15 10:17:48
 */
@Data  
@Entity
@Table(name="HOURDB")
public class HourdbEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@Id
	
	private double senid;
	/**
	 * $column.comments
	 */
	private Date time;
	/**
	 * $column.comments
	 */
	private double v;
	/**
	 * $column.comments
	 */
	private double avgv;
	/**
	 * $column.comments
	 */
	private double maxv;
	/**
	 * $column.comments
	 */
	private Date maxt;
	/**
	 * $column.comments
	 */
	private double minv;
	/**
	 * $column.comments
	 */
	private Date mint;
	/**
	 * $column.comments
	 */
	private double s;
	/**
	 * $column.comments
	 */
	private double avgs;
	/**
	 * $column.comments
	 */
	private double maxs;
	/**
	 * $column.comments
	 */
	private double mins;
	/**
	 * $column.comments
	 */
	private double span;


}
