package com.ynet.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author hansz
 * @version 2018年7月2日 下午10:01:57
 * @Description TODO
 */
public class UserRealm extends AuthorizingRealm {

	/*
	 * @author hansz
	 * 
	 * @version 2018年7月2日 下午10:02:48
	 * 
	 * @Description TODO 执行授权逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
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
		//数据库中的用户名和密码
		String name = "root";
		String password = "root";
		
		//编写Shiro判断逻辑，判断用户名和密码
		//1.判断用户名
		UsernamePasswordToken token =  (UsernamePasswordToken)arg0;
		if (!token.getUsername().equals(name)) {
			return null;//Shiro底层会抛出UnknownAccountException
		}
		
		//2.判断密码,第一个参数为需要返回给subject.login()方法的一些数据，可以为空；第二个参数为数据库中的密码；第三个参数为Shiro的名字，可以为空
		return new SimpleAuthenticationInfo("", password, "");
	}

}
