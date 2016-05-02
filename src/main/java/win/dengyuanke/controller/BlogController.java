package win.dengyuanke.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import win.dengyuanke.entity.Blog;
import win.dengyuanke.service.BlogService;

/**
 * 博客Controller层
 * @author dengyuanke
 *
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

	@Resource
	private BlogService blogService;
	
	/**
	 * 请求博客详细信息
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/articles/{id}")
	public ModelAndView details(@PathVariable("id") Integer id,HttpServletRequest request) throws Exception{
		ModelAndView mav=new ModelAndView();
		Blog blog=blogService.findById(id);
		mav.addObject("blog",blog);
		
		mav.addObject("pageTitle",blog.getTitle()+"Java开源博客");
		mav.addObject("mainPage","foreground/blog/view.jsp");
		mav.setViewName("mainTemp");
		
		blog.setClickHit(blog.getClickHit()+1);
		blogService.update(blog);
		return mav;
	}
}
