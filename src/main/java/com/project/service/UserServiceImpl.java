package com.project.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserDAO;
import com.project.model.UserVO;
import com.project.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO registerDAO;

	@Override
	public void save(UserVO registerVO) {
		this.registerDAO.save(registerVO);
	}

	@Override
	public List<UserVO> searchUser() {
		return this.registerDAO.searchUser();
	}

	@Override
	public List<UserVO> findById(int id) {
		return this.registerDAO.findById(id);
	}
}