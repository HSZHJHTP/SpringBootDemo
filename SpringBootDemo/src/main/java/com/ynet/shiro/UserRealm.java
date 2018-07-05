package com.ynet.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.ynet.entity.User;
import com.ynet.service.UserService;

/**
 * @author hansz
 * @version 2018年7月2日 下午10:01:57
 * @Description TODO
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	UserService userService;
	
	/*
	 * @author hansz
	 * 
	 * @version 2018年7月2日 下午10:02:48
	 * 
	 * @Description TODO 执行授权逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
	    
		//给资源进行授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		//添加资源的授权字符串
//		info.addStringPermission("user:add");//字符串要与perms[user:add]中的字符串完全相同
		
		//到数据库查询当前登录用户的授权字符串
		//获取当前登录用户
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		User doUser = userService.findById(user.getId());
		
		info.addStringPermission(doUser.getPerms());
		return info;
	}

	/*
	 * @author hansz
	 * 
	 * @version 2018年7月2日 下午10:03:03
	 * 
	 * @Description TODO 执行认证逻辑
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		
		//编写Shiro判断逻辑，判断用户名和密码
		//1.判断用户名
		UsernamePasswordToken token =  (UsernamePasswordToken)arg0;
		
		User user = userService.findByName(token.getUsername());
		
		if (null == user) {
			return null;//Shiro底层会抛出UnknownAccountException
		}
		
		//2.判断密码,第一个参数为需要返回给subject.login()方法的一些数据，即为principal；第二个参数为数据库中的密码；第三个参数为Shiro的名字，可以为空
		return new SimpleAuthenticationInfo(user, user.getPassword(), "");
	}

}
