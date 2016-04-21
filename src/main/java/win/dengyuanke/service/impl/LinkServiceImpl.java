package win.dengyuanke.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import win.dengyuanke.dao.LinkDao;
import win.dengyuanke.entity.Link;
import win.dengyuanke.service.LinkService;

@Service("linkService")
public class LinkServiceImpl implements LinkService{
	@Resource
	private LinkDao linkDao;

	public List<Link> list(Map<String, Object> map) {
		return linkDao.list(map);
	}

}
