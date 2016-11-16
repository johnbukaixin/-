package com.ptl.rbac.service;

import com.ptl.rbac.vo.User;

public interface ShiroService {
	User login(String username);
}
