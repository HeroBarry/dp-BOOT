package net.chenlin.dp.modules.visit.dao;

import org.apache.ibatis.annotations.Mapper;

import net.chenlin.dp.modules.visit.entity.VisitEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;

/**
 * 来访登记
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年4月09日 下午7:23:40
 */
@Mapper
public interface VisitMapper extends BaseMapper<VisitEntity> {
	
}
