package win.dengyuanke.dao;

import java.util.List;
import java.util.Map;

import win.dengyuanke.entity.Blog;

/**
 * ����Dao�ӿ�
 * 
 * @author Administrator
 *
 */
public interface BlogDao {
	/**
	 * ���������·ݷ����ѯ
	 * @return
	 */
	public List<Blog> countList();
	/**
	 * ��ҳ��ѯ����
	 * @param map
	 * @return
	 */
	public List<Blog> list(Map<String, Object> map);
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
}
