package net.chenlin.dp.modules.visit.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.visit.entity.VisitEntity;

/**
 * 来访登记
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年4月09日 下午7:23:40
 */
public interface VisitService {

	Page<VisitEntity> listVisit(Map<String, Object> params);
	
	R saveVisit(VisitEntity visit);
	
	R getVisitById(Long id);
	
	R updateVisit(VisitEntity visit);
	
	R batchRemove(Long[] id);
	
}
