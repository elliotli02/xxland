package xxland.com.domain.mapper;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;

import xxland.com.common.exception.ServiceException;
import xxland.com.common.mapper.IMapper;
import xxland.com.domain.model.OperaterBindRole;
public interface OperaterBindRoleMapper extends IMapper<OperaterBindRole> {

	/**
	 * 删除操作者对应的角色
	 *
	 * @author songkun
	 * @create 2014年4月25日 下午10:15:25
	 * @param key
	 * @throws ServiceException
	 */
	public void deleteByOperater(@Param("key") Serializable key) throws ServiceException;
}