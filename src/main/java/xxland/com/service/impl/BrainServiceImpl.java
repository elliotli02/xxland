/**
 * Program  : OperaterServiceImpl.java
 * Author   : songkun
 * Create   : 2014年4月24日 下午11:37:01
 *
 */

package xxland.com.service.impl;

import org.springframework.stereotype.Service;

import xxland.com.common.exception.ServiceException;
import xxland.com.common.mapper.IMapper;
import xxland.com.common.service.impl.AbstractServiceImpl;
import xxland.com.domain.model.KnowLedge;
import xxland.com.service.IBrainService;

/**
 * 操作员业务处理实现类
 *
 * @author songkun
 * @version 1.0.0
 * @2014年4月24日 下午11:37:01
 */
@Service("brainService")
public class BrainServiceImpl extends AbstractServiceImpl<KnowLedge> implements IBrainService {

//	@Resource(name = "brainMapper")
//	private OperaterMapper brainMapper;
//
//	@Resource(name = "operaterBindRoleMapper")
//	private OperaterBindRoleMapper operaterBindRoleMapper;

	@Override
	public KnowLedge validate(KnowLedge operater) throws ServiceException {
//		try {
			KnowLedge temp = new KnowLedge();
//			temp.setCode(operater.getCode());
//			temp.setStatus(1);
//			temp = (Operater) findOneByExample(temp);
//			if (temp == null || !temp.getPassword().equals(MD5Util.getMD5String(operater.getPassword())))
//				return null;
			return temp;
//		} catch (ServiceException e) {
//			throw new ServiceException(e);
//		}
	}

	@Override
	public boolean isExist(KnowLedge knowLedge) throws ServiceException {
		return false;
//		try {
//			knowLedge tmp = this.operaterMapper.getOneByNameOrCode(operater);
//			return (tmp != null) && !(tmp.getId().equals(operater.getId()));
//		} catch (Exception e) {
//			throw new ServiceException(e);
//		}
	}

	@Override
	public void delete(KnowLedge knowLedge) throws ServiceException {
		try {
			// 级联删除.这种方式有点别扭，不如hibernate来得美观。没有找到仅仅通过配置xml来达到级联删除的方式
			// 别扭，只是从代码美化、简化角度来说。级联删除的效果是实现了，因为，service方法处于一个事务中
//			this.operaterBindRoleMapper.deleteByOperater(operater.getId());
//			super.delete(operater);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public IMapper<KnowLedge> getMapper() {
		// TODO Auto-generated method stub
		return this.getMapper();
	}
}
