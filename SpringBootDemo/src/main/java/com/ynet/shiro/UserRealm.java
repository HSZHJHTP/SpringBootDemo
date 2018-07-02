package com.ynet.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author hansz
 * @version 2018年7月2日 下午10:01:57
 * @Description TODO 
 */
public class UserRealm extends AuthorizingRealm{

	/*
	 * @author hansz
	 * @version 2018年7月2日 下午10:02:48
	 * @Description TODO 执行授权逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @author hansz
	 * @version 2018年7月2日 下午10:03:03
	 * @Description TODO 执行认证逻辑
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

}
