package net.chenlin.dp.modules.visit.controller;

import java.util.Date;
import java.util.Map;

import net.chenlin.dp.common.annotation.DataPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.visit.entity.VisitEntity;
import net.chenlin.dp.modules.visit.service.VisitService;

/**
 * 来访登记
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年4月09日 下午7:23:40
 */
@RestController
@RequestMapping("/visit/visit")
public class VisitController extends AbstractController {
	
	@Autowired
	private VisitService visitService;
	
	/**
	 * 列表
	 * @param params
	 * @DataPermission(alias = "u", user = false, sub = true)
	 * alias 数据查询表的别名，无别名为空
	 * user  无数据权限时，是否可查询自己新增的数据，默认可以
	 * sub   是否查询下级架构的数据，默认不查询下级结构数据
	 * @return
	 */
	@RequestMapping("/list")
	@DataPermission
	public Page<VisitEntity> list(@RequestBody Map<String, Object> params) {
		return visitService.listVisit(params);
	}
		
	/**
	 * 新增
	 * @param visit
	 * @return
	 */
	@SysLog("新增来访登记")
	@RequestMapping("/save")
	public R save(@RequestBody VisitEntity visit) {
		visit.setUserIdCreate(getUserId());
		visit.setOrgId(getUser().getOrgId());
		visit.setOperator(getUser().getUsername());
		visit.setCreateTime(new Date());
		return visitService.saveVisit(visit);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return visitService.getVisitById(id);
	}
	
	/**
	 * 修改
	 * @param visit
	 * @return
	 */
	@SysLog("修改来访登记")
	@RequestMapping("/update")
	public R update(@RequestBody VisitEntity visit) {
		visit.setUpdateTime(new Date());
		return visitService.updateVisit(visit);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除来访登记")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return visitService.batchRemove(id);
	}
	
}
