package net.chenlin.dp.modules.quartz.dao;

import org.apache.ibatis.annotations.Mapper;
import net.chenlin.dp.modules.quartz.entity.QuartzJobLogEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;

/**
 * 定时任务日志
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月20日 下午11:04:51
 */
@Mapper
public interface QuartzJobLogMapper extends BaseMapper<QuartzJobLogEntity> {

	int batchRemoveAll();
	
}
