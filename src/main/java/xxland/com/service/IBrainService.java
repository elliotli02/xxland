/**
 * Program  : IOperaterService.java
 * Author   : songkun
 * Create   : 2014年4月24日 下午11:35:59
 *
 */

package xxland.com.service;

import xxland.com.common.exception.ServiceException;
import xxland.com.common.service.IService;
import xxland.com.domain.model.KnowLedge;

/**
 * ログイン処理インタフェース
 *
 * @author songkun
 * @version 1.0.0
 * @2014年4月24日 午後11:35:59
 */
public interface IBrainService extends IService<KnowLedge> {

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
	public KnowLedge validate(KnowLedge knowLedge) throws ServiceException;

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
	public boolean isExist(KnowLedge knowLedge) throws ServiceException;

}
