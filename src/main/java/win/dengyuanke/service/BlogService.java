package win.dengyuanke.service;

import java.util.List;
import java.util.Map;

import win.dengyuanke.entity.Blog;

/**
 * 博客Service接口
 * @author Administrator
 *
 */
public interface BlogService {
	
	public List<Blog> countList();
	
	/**
	 * 分页查询博客
	 * @param map
	 * @return
	 */
	public List<Blog> list(Map<String, Object> map);
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 根据Id查找博客
	 * @param id
	 * @return
	 */
	public Blog findById(Integer id);
	/**
	 * 更新博客信息
	 * @return
	 */
	public Integer update(Blog blog);
	
}
