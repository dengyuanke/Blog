package win.dengyuanke.service;

import win.dengyuanke.entity.Blog;
import win.dengyuanke.entity.Blogger;

public interface BloggerService {
	/**
	 * 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	public Blogger getByUserName(String userName);

	/**
	 * 查询博主信息
	 * @return
	 */
	public Blogger find();
	
}
