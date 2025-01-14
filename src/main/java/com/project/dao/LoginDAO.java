package com.project.dao;

import java.util.List;

import com.project.model.LoginVO;
import com.project.model.UserVO;

public interface LoginDAO {

	void save(LoginVO loginVO);
	
	List<LoginVO> findById(int loginId);
	
	List<LoginVO> searchByUserName(String userName);

}
