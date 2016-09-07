package xxland.com.domain.mapper;

import org.apache.ibatis.annotations.Param;

import xxland.com.common.mapper.IMapper;
import xxland.com.domain.model.Operater;
public interface OperaterMapper extends IMapper<Operater> {

	/**
	 * 根据名称或账号获取操作者
	 * 
	 * @author songkun
	 * @create 2014年4月25日 下午6:49:59
	 * @since
	 * @param operater
	 * @throws Exception
	 */
	public Operater getOneByNameOrCode(@Param("object") Operater operater) throws Exception;
}