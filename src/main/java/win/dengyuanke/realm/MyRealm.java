package win.dengyuanke.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import win.dengyuanke.entity.Blogger;
import win.dengyuanke.service.BloggerService;

public class MyRealm extends AuthorizingRealm {
	
	@Resource
	private BloggerService bloggerService;

	/**
	 * 当前登录的用户角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 验证当前登陆用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName=(String) token.getPrincipal();
		Blogger blogger=bloggerService.getByUserName(userName);
		if(blogger!=null){
			//把当前用户信息存入session中
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", blogger);
			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(blogger.getUserName(),blogger.getPassword(),"login");
			return authcInfo;
		}else{
			return null;
		}
		
	}

}
