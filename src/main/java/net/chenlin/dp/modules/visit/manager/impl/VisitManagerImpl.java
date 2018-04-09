package net.chenlin.dp.modules.visit.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.visit.dao.VisitMapper;
import net.chenlin.dp.modules.visit.entity.VisitEntity;
import net.chenlin.dp.modules.visit.manager.VisitManager;

/**
 * 来访登记
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年4月09日 下午7:23:40
 */
@Component("visitManager")
public class VisitManagerImpl implements VisitManager {

	@Autowired
	private VisitMapper visitMapper;
	

	@Override
	public List<VisitEntity> listVisit(Page<VisitEntity> page, Query search) {
		return visitMapper.listForPage(page, search);
	}

	@Override
	public int saveVisit(VisitEntity visit) {

		return visitMapper.save(visit);
	}

	@Override
	public VisitEntity getVisitById(Long id) {
		VisitEntity visit = visitMapper.getObjectById(id);
		return visit;
	}

	@Override
	public int updateVisit(VisitEntity visit) {
		return visitMapper.update(visit);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = visitMapper.batchRemove(id);
		return count;
	}
	
}
