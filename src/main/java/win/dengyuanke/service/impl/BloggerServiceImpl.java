package win.dengyuanke.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import win.dengyuanke.dao.BloggerDao;
import win.dengyuanke.entity.Blog;
import win.dengyuanke.entity.Blogger;
import win.dengyuanke.service.BloggerService;

@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService{

	@Resource
	private BloggerDao bloggerDao;
	
	public Blogger getByUserName(String userName) {
		return bloggerDao.getByUserName(userName);
	}
	public Blogger find() {
		// TODO Auto-generated method stub
		return bloggerDao.find();
	}
	

}
