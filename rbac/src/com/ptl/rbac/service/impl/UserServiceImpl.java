package com.ptl.rbac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptl.rbac.mapper.UserMapper;
import com.ptl.rbac.service.UserService;
import com.ptl.rbac.vo.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return userMapper.list();
	}

	

	@Override
	public User login(User user) throws Exception {
		
		return userMapper.login(user);
	}
}
