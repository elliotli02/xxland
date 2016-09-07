package xxland.com.common.service;

import java.io.Serializable;
import java.util.List;

import com.kun.common.bean.Pagination;

import xxland.com.common.exception.ServiceException;

/**
 * service インタフェース
 *
 * @author songkun
 * @version 1.0.0
 * @2014年4月23日 下午2:34:55
 */
public interface IService<T> {

	/**
	 * 保存
	 *
	 * @param object
	 */
	public void save(T object) throws ServiceException;

	/**
	 * 更新
	 *
	 * @param object
	 */
	public void update(T object) throws ServiceException;

	/**
	 * 取得（キー）
	 *
	 * @param key
	 * @return
	 */
	public T getByKey(Serializable key) throws ServiceException;

	/**
	 * 削除
	 *
	 * @param object
	 */
	public void delete(T object) throws ServiceException;

	/**
	 * 全レコード削除
	 *
	 */
	public void deleteAll() throws ServiceException;

	/**
	 * 削除（キー）
	 *
	 * @param key
	 */
	public void deleteByKey(Serializable key) throws ServiceException;

	/**
	 * 検索（オブジェクト）
	 *
	 * @param object
	 */
	public List<T> findByExample(T object) throws ServiceException;

	/**
	 * 根据实例,分页获得对象集,不支持like查找,只能精确查找
	 *
	 * @author songkun
	 * @create 2014年5月3日 下午10:27:12
	 * @param object
	 * @param page
	 * @return
	 * @throws ServiceException
	 */
	public List<T> findOnePageByExample(T object, Pagination page) throws ServiceException;

	/**
	 * 根据实例,获得对象
	 *
	 * @author songkun
	 * @create 2014年5月3日 下午10:27:23
	 * @since
	 * @param object
	 * @return
	 * @throws ServiceException
	 */
	public T findOneByExample(T object) throws ServiceException;

	/**
	 * 加载所有对象
	 *
	 * @author songkun
	 * @create 2014年5月3日 下午10:27:36
	 * @since
	 * @return
	 * @throws ServiceException
	 */
	public List<T> loadAll() throws ServiceException;

	/**
	 * 获得当前页的对象(没有设置查询条件)
	 *
	 * @author songkun
	 * @create 2014年5月3日 下午10:27:43
	 * @since
	 * @param page
	 * @return
	 * @throws ServiceException
	 */
	public List<T> loadOnePage(Pagination page) throws ServiceException;

	/**
	 * 根据实例,分页获得对象集,如果字段是字符串,则使用模糊查找
	 *
	 * @author songkun
	 * @create 2014年5月3日 下午10:25:52
	 * @since
	 * @param object
	 * @param page
	 * @return
	 * @throws ServiceException
	 */
	public List<T> search(T object, Pagination page) throws ServiceException;

}
