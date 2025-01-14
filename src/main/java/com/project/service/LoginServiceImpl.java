package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.LoginDAO;
import com.project.model.LoginVO;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDAO loginDAO;

	@Override
	public void save(LoginVO loginVO) {
		// TODO Auto-generated method stub
		this.loginDAO.save(loginVO);
	}

	@Override
	public List<LoginVO> findById(int loginId) {
		return this.loginDAO.findById(loginId);
	}
	
	public List<LoginVO> searchByUserName(String userName){
		return this.loginDAO.searchByUserName(userName);
	}

}
