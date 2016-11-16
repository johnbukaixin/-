package com.ptl.rbac.service;

import java.util.List;

import com.ptl.rbac.vo.DataGridBean;
import com.ptl.rbac.vo.Permission;
import com.ptl.rbac.vo.Role;

public interface PermissionService {

	List<Permission> findMenuByUser(int userId);
	public List<Permission> findPermissionByUser(int userId);
	List<DataGridBean> getRoles();
	DataGridBean<Role> getPaginatedRoles(int num, int size);
}
