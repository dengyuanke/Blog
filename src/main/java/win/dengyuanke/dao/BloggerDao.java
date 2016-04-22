package win.dengyuanke.dao;

import win.dengyuanke.entity.Blogger;

public interface BloggerDao {
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
