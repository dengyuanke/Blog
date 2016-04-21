package win.dengyuanke.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import win.dengyuanke.service.BloggerService;

@Controller
@RequestMapping("admin/blogger")
public class BloggerAdminController {
	@Resource
	private BloggerService bloggerService;
}
