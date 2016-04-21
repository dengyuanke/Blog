package win.dengyuanke.service;

import java.util.List;
import java.util.Map;

import win.dengyuanke.entity.Link;

public interface LinkService {
	/**
	 * 查询所有链接
	 * @param userName
	 * @return
	 */
	public List<Link> list(Map<String, Object> map);

}
