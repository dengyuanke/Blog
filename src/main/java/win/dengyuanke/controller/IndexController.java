package win.dengyuanke.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
import win.dengyuanke.util.PageUtil;

@Controller
@RequestMapping("/")
public class IndexController {
	@Resource
	private BlogService blogService;
	
	/**
	 * 请求主页
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(value="page",required=false)String page,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		if(StringUtils.isEmpty(page)){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 10);
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Blog> blogList=blogService.list(map);
		
		for(Blog blog:blogList){
			List<String> imageList=blog.getImageList();
			String blogInfo=blog.getContent();
			Document doc=Jsoup.parse(blogInfo);
			Elements jpgs=doc.select("img[src$=.jpg]");
			for(int i=0;i<jpgs.size();i++){
				Element jpg=jpgs.get(i);
				imageList.add(jpg.toString());
				if(i==2){
					break;
				}
			}
		}
		
		mav.addObject("blogList",blogList);
		
		StringBuffer param=new StringBuffer();
		
		mav.addObject("pageCode",PageUtil.genPagination(request.getContextPath()+"/index.html", blogService.getTotal(map), Integer.parseInt(page), 10, param.toString()));
		mav.addObject("pageTitle","Java开源博客");
		mav.addObject("mainPage","foreground/blog/list.jsp");
		mav.setViewName("mainTemp");
		return mav;
	}
}
