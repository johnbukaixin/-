package com.ptl.rbac.shiro.realm;

import java.util.HashSet;
import java.util.Set;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.ptl.rbac.service.PermissionService;
import com.ptl.rbac.service.ShiroService;
import com.ptl.rbac.vo.Permission;
import com.ptl.rbac.vo.User;


public class UserRealm extends AuthorizingRealm{
	@Autowired
    private PermissionService permissionService;
	@Autowired
    private ShiroService shiroService;
	//用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//获取用户
		User user=(User) principalCollection.getPrimaryPrincipal();
		 SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		 Set<String> permissions=new HashSet<>();
		 for (Permission permission : user.getPermissions()) {
			permissions.add(permission.getPercode());
		}
		info.addStringPermissions(permissions);
		return info;
	}
    //用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		 
		String username=token.getPrincipal().toString();
		System.out.println(username);
		User user=shiroService.login(username);
		
		if(user!=null){
			user.setMenus(permissionService.findMenuByUser(user.getId()));
			user.setPermissions(permissionService.findPermissionByUser(user.getId()));
		}
		if(user==null){
		    return null;
		}
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user, user.getPwd(),ByteSource.Util.bytes(user.getSalt()), "UserRealm");
	    return info;
	}

	

}
