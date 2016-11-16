package com.ptl.rbac.mapper;

import com.ptl.rbac.vo.User;

public interface ShiroMapper {
	User login(String username);
}
