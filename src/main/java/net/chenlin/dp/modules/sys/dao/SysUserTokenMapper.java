package net.chenlin.dp.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import net.chenlin.dp.modules.sys.entity.SysUserTokenEntity;

/**
 * 用户token
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年9月3日 上午3:29:17
 */
@Mapper
public interface SysUserTokenMapper extends BaseMapper<SysUserTokenEntity> {

	SysUserTokenEntity getByToken(String token);
	
	SysUserTokenEntity getByUserId(Long userId);
	
}
