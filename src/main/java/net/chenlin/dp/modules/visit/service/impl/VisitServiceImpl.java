package net.chenlin.dp.modules.visit.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.visit.entity.VisitEntity;
import net.chenlin.dp.modules.visit.manager.VisitManager;
import net.chenlin.dp.modules.visit.service.VisitService;

/**
 * 来访登记
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年4月09日 下午7:23:40
 */
@Service("visitService")
public class VisitServiceImpl implements VisitService {

	@Autowired
	private VisitManager visitManager;

	@Override
	public Page<VisitEntity> listVisit(Map<String, Object> params) {
		Query query = new Query(params);
		Page<VisitEntity> page = new Page<>(query);
		visitManager.listVisit(page, query);
		return page;
	}

	@Override
	public R saveVisit(VisitEntity role) {
		int count = visitManager.saveVisit(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getVisitById(Long id) {
		VisitEntity visit = visitManager.getVisitById(id);
		return CommonUtils.msg(visit);
	}

	@Override
	public R updateVisit(VisitEntity visit) {
		int count = visitManager.updateVisit(visit);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = visitManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
