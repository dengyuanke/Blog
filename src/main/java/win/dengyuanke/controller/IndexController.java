package win.dengyuanke.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * ��ҳContrller
 * @author Administrator
 *
 */
import org.springframework.web.servlet.ModelAndView;

import sun.launcher.resources.launcher;
import win.dengyuanke.entity.Blog;
import win.dengyuanke.entity.PageBean;
import win.dengyuanke.service.BlogService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Resource
	private BlogService blogService;
	
	/**
	 * ������ҳ
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(value="page",required=false)String page) {
		ModelAndView mav=new ModelAndView();
		if(StringUtils.isEmpty(page)){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 10);
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Blog> blogList=blogService.list(map);
		mav.addObject("blogList",blogList);
		mav.addObject("pageTitle","Java开源博客");
		mav.addObject("mainPage","foreground/blog/list.jsp");
		mav.setViewName("mainTemp");
		return mav;
	}
}
