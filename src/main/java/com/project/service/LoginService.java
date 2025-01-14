package com.project.service;

import java.util.List;

import com.project.model.LoginVO;

public interface LoginService {

	void save(LoginVO loginVO);
	
	List<LoginVO> findById(int loginId);
	
	List<LoginVO> searchByUserName(String userName);

}
