package win.dengyuanke.dao;

import java.util.List;
import java.util.Map;

import win.dengyuanke.entity.Link;

/**
 * ��������Dao�ӿ�
 * @author Administrator
 *
 */
public interface LinkDao {
	public List<Link> list(Map<String, Object> map);
}
