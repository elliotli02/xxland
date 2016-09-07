/**
 * Program  : IOperaterService.java
 * Author   : songkun
 * Create   : 2014年4月24日 下午11:35:59
 *
 */

package xxland.com.service;

import xxland.com.common.exception.ServiceException;
import xxland.com.common.service.IService;
import xxland.com.domain.model.Operater;

/**
 * ログイン処理インタフェース
 *
 * @author songkun
 * @version 1.0.0
 * @2014年4月24日 午後11:35:59
 */
public interface IOperaterService extends IService<Operater> {

	/**
	 * ユーザー検証
	 *
	 * @author songkun
	 * @create 2014年4月24日 午後11:47:04
	 * @since
	 * @param operater
	 * @return
	 * @throws ServiceException
	 */
	public Operater validate(Operater operater) throws ServiceException;

	/**
	 * ユーザー名とパスワードの存在チェック
	 *
	 * @author songkun
	 * @create 2014年4月24日 午後11:47:11
	 * @since
	 * @param operater
	 * @return
	 * @throws ServiceException
	 */
	public boolean isExist(Operater operater) throws ServiceException;

}
