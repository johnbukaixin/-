package com.ptl.rbac.interceptor;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ptl.rbac.util.ResourceUtil;
import com.ptl.rbac.vo.Permission;
import com.ptl.rbac.vo.User;

public class UrlInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session =request.getSession();
		User user = (User)session.getAttribute("currentUser");
		//正在登录
		if(user==null){
			return true;
		}
		List<Permission> permissions = user.getPermissions();
		String uri=request.getRequestURI();
		//是否是公共的url
		Set<String> commonUrl=ResourceUtil.getPropertis("common.properties");
		for(String url:commonUrl){
			if(uri.indexOf(url)>0){
				return true;
			}
		}
		//是否具有权限访问该url
		for(Permission p:permissions){
			if(uri.indexOf(p.getUrl())>0){
				return true;
			}
		}
		response.sendRedirect(request.getContextPath()+"/refuse.do");
		return false;
	}
}
