package win.dengyuanke.dao;

import java.util.List;
import java.util.Map;

import win.dengyuanke.entity.Link;

/**
 * 友情链接Dao接口
 * @author Administrator
 *
 */
public interface LinkDao {
	public List<Link> list(Map<String, Object> map);
}
