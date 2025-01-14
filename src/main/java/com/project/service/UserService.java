package com.project.service;

import java.util.*;

import com.project.model.UserVO;

public interface UserService {
	void save (UserVO registerVO);
	
	List<UserVO> searchUser();

	List<UserVO> findById(int id);

}
