package  com.imooc.order.VO;
/**
* @Description 
* @since  2018��10��10�� ����8:35:20
* @author LiuLiBin
*/

import java.util.List;

import com.imooc.order.dataobject.HourdbEntity;

import lombok.Data;

/**
 * @Describe Hourdb�Ľ��������
 * @author LiuLiBin
 * @email 970985518@qq.com
 * @date 2018-10-15 10:17:48
 */

@Data
public class HourdbResultVO {
	
	List<HourdbEntity> hourdbEntities;

}
