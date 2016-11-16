package com.ptl.rbac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ptl.rbac.service.PermissionService;
import com.ptl.rbac.vo.DataGridBean;
import com.ptl.rbac.vo.Role;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private PermissionService permissionService;
	
    @RequestMapping(value="list")
	public String toList(){
		return "roles";
	}
    @RequestMapping(value="roleList",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DataGridBean<Role> getRoles(int rows,int page){
    	System.out.println("RoleController.getRoles()");
    	DataGridBean<Role> dataGridBean=permissionService.getPaginatedRoles(page, rows);
    	System.out.println(dataGridBean);
    	return dataGridBean;
    }
}
