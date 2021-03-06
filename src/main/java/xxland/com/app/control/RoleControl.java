/**
 * Program  : RoleAction.java
 * Author   : songkun
 * Create   : 2014年4月26日 上午9:52:17
 *
 */

package xxland.com.app.control;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kun.common.bean.Pagination;
import com.kun.common.web.control.BaseControl;
import com.kun.common.web.response.DataOut;
import com.kun.common.web.response.MessageOut;
import com.kun.common.web.response.Out;

import xxland.com.common.exception.ServiceException;
import xxland.com.domain.model.Role;
import xxland.com.service.IRoleService;

/**
 * 角色处理
 * 
 * @author songkun
 * @version 1.0.0
 * @2014年4月26日 上午9:52:17
 */
@Controller("roleControl")
@RequestMapping("/role")
public class RoleControl extends BaseControl<Role> {

	@Resource(name = "roleService")
	private IRoleService roleService;

	/**
	 * 获取角色列表
	 * 
	 * @author songkun
	 * @return
	 * @return String
	 * @date 2011-6-17 下午05:32:08
	 * @since 2.0.0
	 */
	@RequestMapping("/list.do")
	@ResponseBody
	public Out<Role> list(Pagination pagination) {
		try {
			return new DataOut<Role>(this.roleService.loadOnePage(pagination), pagination);
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 新增角色
	 * 
	 * @author songkun
	 * @return Out
	 * @date 2011-6-17 下午05:32:33
	 * @since 2.0.0
	 */
	@RequestMapping("/add.do")
	@ResponseBody
	public Out<Object> add(Role role) {
		this.getLogger().info("新增用户: " + role.getName());
		try {
			if (this.roleService.isExist(role)) {// 如果后台用户已经存在
				return MessageOut.NAME_EXIST_MESSAGE;
			} else {
				Date date = new Date();
				role.setCreateTime(date);
				role.setUpdateTime(date);
				role.setOperaterId(this.getCurrentOperater().getId());
				role.setOperaterCode(this.getCurrentOperater().getCode());
				role.setStatus(1);
				this.roleService.save(role);
			}
			return MessageOut.ADD_OK_MESSAGE;
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return MessageOut.ADD_FAIL_MESSAGE;
	}

	/**
	 * 修改角色
	 * 
	 * @author songkun
	 * @return
	 * @return String
	 * @date 2011-6-19 上午11:51:48
	 * @since 2.0.0
	 */
	@RequestMapping("/update.do")
	@ResponseBody
	public Out<Object> update(Role role) {
		try {
			Role dbRole = (Role) this.roleService.getByKey(role.getId());
			if (dbRole == null) {
				return MessageOut.RECORD_UN_EXIST_MESSAGE;
			} else {
				if (this.roleService.isExist(role)) {
					return MessageOut.NAME_EXIST_MESSAGE;
				} else {
					dbRole.setName(role.getName());
					dbRole.setUpdateTime(new Date());
					dbRole.setRemark(role.getRemark());
					dbRole.setOperaterId(this.getCurrentOperater().getId());
					dbRole.setOperaterCode(this.getCurrentOperater().getCode());
					this.roleService.update(dbRole);
				}
			}
			return MessageOut.UPDATE_OK_MESSAGE;
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MessageOut.UPDATE_FAIL_MESSAGE;
	}

	/**
	 * 删除后台用户
	 * 
	 * @author songkun
	 * @return String
	 * @date 2011-6-17 下午05:32:25
	 * @since 2.0.0
	 */
	@RequestMapping("/delete.do")
	@ResponseBody
	public Out<Object> delete(String ids) {
		try {
			if (ids != null && ids.length() > 0) {
				String[] idsArr = ids.split(",");
				for (int i = 0; i < idsArr.length; i++) {
					this.roleService.deleteByKey(Long.parseLong(idsArr[i]));
				}
			}
			return MessageOut.DELETE_OK_MESSAGE;
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MessageOut.DELETE_FAIL_MESSAGE;
	}

	/**
	 * 查询
	 * 
	 * @author songkun
	 * @return String
	 * @date 2011-6-19 下午05:44:22
	 * @since 2.0.0
	 */
	@RequestMapping("/search.do")
	@ResponseBody
	public Out<Role> search(Role role, Pagination pagination) {
		try {
			return new DataOut<Role>(this.roleService.search(role, pagination), pagination);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
