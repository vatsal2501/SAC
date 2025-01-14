package com.project.dao;

import java.util.List;

import com.project.model.UserVO;

public interface UserDAO {
	void save (UserVO registerVO);
	
	List<UserVO> searchUser();

	List<UserVO> findById(int id);

}
