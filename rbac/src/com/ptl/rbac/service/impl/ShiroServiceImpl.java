package com.ptl.rbac.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptl.rbac.mapper.ShiroMapper;
import com.ptl.rbac.service.ShiroService;
import com.ptl.rbac.vo.User;
@Service
public class ShiroServiceImpl implements ShiroService{
    @Autowired
	private ShiroMapper shiroMapper;
	@Override
	public User login(String username) {
		System.out.println("ShiroServiceImpl.login()");
		return shiroMapper.login(username);
	}

}
