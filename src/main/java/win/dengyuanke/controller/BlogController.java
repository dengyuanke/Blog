package win.dengyuanke.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.bcel.internal.generic.RETURN;

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
		
		String keyWords=blog.getKeyWord();
		if(StringUtils.isNotEmpty(keyWords)){
			String kw[]=keyWords.split(" ");
			mav.addObject("keyWords",kw);
		}else{
			mav.addObject("keyWords",null);
		}
		
		mav.addObject("blog",blog);
		
		mav.addObject("pageCode",getUpAndDownPageCode(blogService.getLastBlog(id),blogService.getNextBlog(id),request.getServletContext().getContextPath()));
		mav.addObject("pageTitle",blog.getTitle()+"Java开源博客");
		mav.addObject("mainPage","foreground/blog/view.jsp");
		mav.setViewName("mainTemp");
		
		blog.setClickHit(blog.getClickHit()+1);
		blogService.update(blog);
		return mav;
	}
	/**
	 * 获取上一篇博客和获取下一篇博客
	 * @param lastBlog
	 * @param nextBlog
	 * @param projectContext
	 * @return
	 */
	private String getUpAndDownPageCode(Blog lastBlog,Blog nextBlog,String projectContext){
		StringBuffer pageCode=new StringBuffer();
		if(lastBlog==null||lastBlog.getId()==null){
			pageCode.append("<p>上一篇：没有了</p>");
		}else {
			pageCode.append("<p>上一篇：<a href='"+projectContext+"/blog/articles/"+lastBlog.getId()+".html'>"+lastBlog.getTitle()+"</a></p>");
		}
		if(nextBlog==null||nextBlog.getId()==null){
			pageCode.append("<p>下一篇：没有了</p>");
		}else {
			pageCode.append("<p>下一篇：<a href='"+projectContext+"/blog/articles/"+nextBlog.getId()+".html'>"+nextBlog.getTitle()+"</a></p>");
		}
		return pageCode.toString(); 
	}
	
}
