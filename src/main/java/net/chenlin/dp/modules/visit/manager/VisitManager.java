package net.chenlin.dp.modules.visit.manager;

import java.util.List;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.visit.entity.VisitEntity;

/**
 * 来访登记
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年4月09日 下午7:23:40
 */
public interface VisitManager {

	List<VisitEntity> listVisit(Page<VisitEntity> page, Query search);
	
	int saveVisit(VisitEntity visit);
	
	VisitEntity getVisitById(Long id);
	
	int updateVisit(VisitEntity visit);
	
	int batchRemove(Long[] id);
	
}
