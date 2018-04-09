package net.chenlin.dp.modules.sys.dao;

import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.sys.entity.SysUserEntity;
import net.chenlin.dp.modules.sys.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Set;

/**
 * 系统用户dao
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月8日 下午3:26:05
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

	SysUserEntity getByUserName(String username);

	List<Long> listAllMenuId(Long userId);

	List<Long> listAllOrgId(Long userId);

	int updatePswdByUser(Query query);

	int updateUserStatus(Query query);

	int updatePswd(SysUserEntity user);

	
}
