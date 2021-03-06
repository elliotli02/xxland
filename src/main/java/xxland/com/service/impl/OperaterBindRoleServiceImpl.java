/**
 * Program  : OperaterBindRoleServiceImpl.java
 * Author   : songkun
 * Create   : 2014年4月25日 下午9:34:58
 *
 */

package xxland.com.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xxland.com.common.exception.ServiceException;
import xxland.com.common.mapper.IMapper;
import xxland.com.common.service.impl.AbstractServiceImpl;
import xxland.com.domain.mapper.OperaterBindRoleMapper;
import xxland.com.domain.model.Operater;
import xxland.com.domain.model.OperaterBindRole;
import xxland.com.service.IOperaterBindRoleService;

/**
 * 操作者与角色关联service
 * 
 * @author songkun
 * @version 1.0.0
 * @2014年4月25日 下午9:34:58
 */
@Service("operaterBindRoleService")
public class OperaterBindRoleServiceImpl extends AbstractServiceImpl<OperaterBindRole>
		implements
			IOperaterBindRoleService {

	@Resource(name = "operaterBindRoleMapper")
	private OperaterBindRoleMapper operaterBindRoleMapper;

	@Override
	public void updateBindsByOperater(Long userId, String ids, Operater operater) throws ServiceException {
		// 删除所有已经绑定到该后台用户的记录
		this.operaterBindRoleMapper.deleteByOperater(userId);
		// 新增新的绑定信息
		if (ids != null && ids.length() > 0) {
			String[] idsStr = ids.split(",");
			OperaterBindRole obr;
			Date date = new Date();
			for (int i = 0; i < idsStr.length; i++) {
				obr = new OperaterBindRole();
				obr.setOperaterCode(operater.getOperaterCode());
				obr.setOperaterId(operater.getId());
				obr.setUserId(userId);
				obr.setRoleId(Long.parseLong(idsStr[i]));
				obr.setCreateTime(date);
				obr.setUpdateTime(date);
				obr.setStatus(1);
				this.save(obr);
			}
		}
	}

	@Override
	public IMapper<OperaterBindRole> getMapper() {
		// TODO Auto-generated method stub
		return this.operaterBindRoleMapper;
	}

}
