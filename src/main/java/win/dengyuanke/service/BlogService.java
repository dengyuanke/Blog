package win.dengyuanke.service;

import java.util.List;
import java.util.Map;

import win.dengyuanke.entity.Blog;

/**
 * ����Service�ӿ�
 * @author Administrator
 *
 */
public interface BlogService {
	
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
