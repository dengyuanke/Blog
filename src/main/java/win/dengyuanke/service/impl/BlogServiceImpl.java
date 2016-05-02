package win.dengyuanke.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import win.dengyuanke.dao.BlogDao;
import win.dengyuanke.entity.Blog;
import win.dengyuanke.service.BlogService;
/**
 * 博客Service实现类
 * @author Administrator
 *
 */
@Service("blogService")
public class BlogServiceImpl implements  BlogService{

	@Resource
	private BlogDao blogDao;
	
	public List<Blog> countList() {
		return blogDao.countList();
	}

	public List<Blog> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return blogDao.list(map);
	}

	public Long getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return blogDao.getTotal(map);
	}

	public Blog findById(Integer id) {
		// TODO Auto-generated method stub
		return blogDao.findById(id);
	}

	public Integer update(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.update(blog);
	}

}
