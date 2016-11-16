package com.ptl.rbac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ptl.rbac.mapper.PermissionMapper;
import com.ptl.rbac.mapper.RoleMapper;
import com.ptl.rbac.service.PermissionService;
import com.ptl.rbac.util.MenuUtil;
import com.ptl.rbac.vo.DataGridBean;
import com.ptl.rbac.vo.Permission;
import com.ptl.rbac.vo.Role;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
    private RoleMapper roleMapper;
	@Override
	public List<Permission> findMenuByUser(int userId) {
		List<Permission> list= permissionMapper.findMenuByUser(userId);
		List<Permission> menu=MenuUtil.listToMenu(list);
		return menu;
	}
	@Override
	public List<Permission> findPermissionByUser(int userId) {
		return permissionMapper.findPermissionByUser(userId);
	}
	@Override
	public DataGridBean<Role> getPaginatedRoles(int num,int size) {
		PageHelper.startPage(num, size);
		List<Role> roles=roleMapper.getRoles();
		System.out.println(roles);
		PageInfo<Role> info=new PageInfo<>(roles);
		int total=(int) info.getTotal();
		DataGridBean<Role> aBean=new DataGridBean<>();
		aBean.setTotal(total);
		aBean.setRows(roles);
		return aBean;
	}
	@Override
	public List<DataGridBean> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
