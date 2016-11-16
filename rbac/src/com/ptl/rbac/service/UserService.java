package com.ptl.rbac.service;

import java.util.List;

import com.ptl.rbac.vo.User;

public interface UserService {
	public User login(User user) throws Exception;
	public List<User> list();
}
