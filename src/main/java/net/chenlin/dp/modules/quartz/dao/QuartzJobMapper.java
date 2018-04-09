package net.chenlin.dp.modules.quartz.dao;

import org.apache.ibatis.annotations.Mapper;
import net.chenlin.dp.modules.quartz.entity.QuartzJobEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;


/**
 * 定时任务
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月20日 下午11:19:55
 */
@Mapper
public interface QuartzJobMapper extends BaseMapper<QuartzJobEntity> {

}
