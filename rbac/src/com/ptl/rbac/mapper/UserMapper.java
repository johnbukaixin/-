package com.ptl.rbac.mapper;

import java.util.List;

import com.ptl.rbac.vo.User;

public interface UserMapper {
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public User login(User user);
//	public User login(String username);
	public List<User> list();
}
