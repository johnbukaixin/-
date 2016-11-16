package com.ptl.rbac.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ptl.rbac.service.PermissionService;
import com.ptl.rbac.service.ShiroService;
import com.ptl.rbac.vo.Node;
import com.ptl.rbac.vo.Permission;
import com.ptl.rbac.vo.User;

@Controller
@RequestMapping("/shiro")
public class ShiroController {
    @Autowired
	private ShiroService shiroService;
    @Autowired
    private PermissionService permissionService;
    
    @RequestMapping("login")
    public String login(Model model,HttpServletRequest request){
    	System.out.println("ShiroController.login()");
    	Subject subject=SecurityUtils.getSubject();
    	String message=null;
    	try{
    		subject.login(new UsernamePasswordToken(request.getParameter("username"), request.getParameter("password")));
    	}catch(Exception e){
    		if(e.getClass().getName().equals(IllegalAccessException.class.getName())){
    			message="密码错误";
    			System.out.println("密码错误");
    		}
    		if(e.getClass().getName().equals(UnknownAccountException.class.getName())){
    			message="用户名不存在";
    			System.out.println("用户名不存在");
    		}
    		model.addAttribute("message", message);
    		return "login";
    	}
//    	return "redirect:/index.jsp";
    	return "redirect:/shiro/index.do";
    	
    }
    @RequestMapping("index")
    public String toIndex(){
    	Subject subject=SecurityUtils.getSubject();
    	
    	if(subject.isPermitted("role:add")){
    		return "test";
    	}
    	return "refuse";
    }
    
    @RequestMapping(value="menu",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Node> getMenu(HttpSession session){
    	Subject subject=SecurityUtils.getSubject();
    	User user=(User) subject.getPrincipal();
		//获得所有权限
		List<Permission> permissions=permissionService.findMenuByUser(user.getId());
		List<Node> nodes=permissionToNode(permissions);
		return nodes;
	}
	
	
	private List<Node> permissionToNode(List<Permission> permissions){
		List<Node> nodes=new ArrayList<>();
		Node node=null;
		for (Permission permission : permissions) {
			node=new Node();
			node.setId(permission.getId());
			node.setText(permission.getName());
			if(permission.getChildren()!=null&&permission.getChildren().size()>0){
				node.setState("closed");
				node.setChildren(permissionToNode(permission.getChildren()));
			}else{
				node.setState("open");
			}
			node.setUrl(permission.getUrl());
			nodes.add(node);
		}
		return nodes;
	}
	
}
