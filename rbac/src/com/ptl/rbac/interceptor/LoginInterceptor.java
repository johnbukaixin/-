package com.ptl.rbac.interceptor;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ptl.rbac.util.ResourceUtil;

public class LoginInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object obj) throws Exception {
		/*
		 * ���session
		 * ���url
		 * */
		HttpSession session = req.getSession();
		Object currentUser=session.getAttribute("currentUser");
		if(currentUser!=null){
			return true;
		}
		//���url�Ƿ��ǹ�����
		String uri=req.getRequestURI();
		System.out.println(uri);
		Set<String> commonUrl=ResourceUtil.getPropertis("common.properties");
		for(String url:commonUrl){
			if(uri.indexOf(url)>0){
				return true;
			}
		}
		resp.sendRedirect(req.getContextPath()+"/toLogin.do");
		return false;
	}
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	

}
