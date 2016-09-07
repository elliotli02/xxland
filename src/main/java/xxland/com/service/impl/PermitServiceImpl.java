/**
 * Program  : PermitServiceImpl.java
 * Author   : songkun
 * Create   : 2014年4月25日 下午2:01:44
 *
 */

package xxland.com.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xxland.com.common.exception.ServiceException;
import xxland.com.common.mapper.IMapper;
import xxland.com.common.service.impl.AbstractServiceImpl;
import xxland.com.domain.mapper.PermitMapper;
import xxland.com.domain.model.Permit;
import xxland.com.service.IPermitService;

/**
 * 权限业务处理实现类
 * 
 * @author songkun
 * @version 1.0.0
 * @2014年4月25日 下午2:01:44
 */
@Service("permitService")
public class PermitServiceImpl extends AbstractServiceImpl<Permit> implements IPermitService {

	@Resource(name = "permitMapper")
	private PermitMapper permitMapper;

	@Override
	public List<Permit> listPermitsByRole(Serializable key) throws ServiceException {
		try {
			return this.permitMapper.listPermitsByRole(key);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	@Override
	public List<Permit> listUnbindPermitsByRole(Serializable key) throws ServiceException {
		try {
			return this.permitMapper.listUnbindPermitsByRole(key);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Permit> listPermitByOperater(Serializable key) throws ServiceException {
		try {
			return this.permitMapper.listPermitsByOperater(key);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	@Override
	public IMapper<Permit> getMapper() {
		// TODO Auto-generated method stub
		return this.permitMapper;
	}

}
