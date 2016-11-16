package com.ptl.rbac.mapper;

import java.util.List;

import com.ptl.rbac.vo.Permission;
import com.ptl.rbac.vo.Role;

public interface PermissionMapper {
	public List<Permission> findMenuByUser(int userId);
	public List<Permission> findPermissionByUser(int userId);

}
