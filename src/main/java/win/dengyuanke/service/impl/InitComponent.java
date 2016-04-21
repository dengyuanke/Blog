package win.dengyuanke.service.impl;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import win.dengyuanke.entity.BlogType;
import win.dengyuanke.entity.Blogger;
import win.dengyuanke.entity.Link;
import win.dengyuanke.service.BlogService;
import win.dengyuanke.service.BlogTypeService;
import win.dengyuanke.service.BloggerService;
import win.dengyuanke.service.LinkService;

@Component
public class InitComponent implements ServletContextListener,ApplicationContextAware{

	private static ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext=applicationContext;
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext application =sce.getServletContext();
		BloggerService bloggerService =(BloggerService) applicationContext.getBean("bloggerService");
		LinkService linkService =(LinkService) applicationContext.getBean("linkService");
		BlogTypeService blogTypeService =(BlogTypeService) applicationContext.getBean("blogTypeService");
		BlogService blogService =(BlogService) applicationContext.getBean("blogService");
		
		List<BlogType> blogTypecounts=blogTypeService.countList();//查询博客类别以及博客数量
		Blogger blogger=bloggerService.find();
		List<Link> linkList=linkService.list(null);//查询所有友情链接
		blogger.setPassword(null);
		application.setAttribute("blogger", blogger);
		application.setAttribute("linkList", linkList);
		application.setAttribute("blogTypes", blogTypecounts);
		application.setAttribute("blogs", blogService.countList());
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
