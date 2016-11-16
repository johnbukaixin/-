package com.ptl.rbac.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ptl.rbac.service.PermissionService;
import com.ptl.rbac.service.UserService;
import com.ptl.rbac.vo.Node;
import com.ptl.rbac.vo.Permission;
import com.ptl.rbac.vo.User;
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;
	@RequestMapping("/toLogin")
	public ModelAndView toLogin(){
		return new ModelAndView("login");
	}
	@RequestMapping("/login")
	public ModelAndView login(HttpSession session,User user) throws Exception{
		user = userService.login(user);
		List<Permission> menus=permissionService.findMenuByUser(user.getId());
		user.setMenus(menus);
		List<Permission> permissions=permissionService.findPermissionByUser(user.getId());
		user.setPermissions(permissions);
		session.setAttribute("currentUser", user);
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="menu",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Node> getMenu(HttpSession session){
		User user=(User) session.getAttribute("currentUser");
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
			System.out.println(node);
			nodes.add(node);
		}
		return nodes;
	}
	
	@RequestMapping("/refuse.do")
	public ModelAndView refuse(){
		return new ModelAndView("refuse");
	}
	@RequestMapping("/user/list.do")
	public ModelAndView users(){
		ModelAndView mv=new ModelAndView("users");
		mv.addObject("list", userService.list());
		return mv;
	}
//	@RequestMapping("/role/list.do")
//	public String list(){
//		permissionService.getRoles();
//		return "";
//	}
}
