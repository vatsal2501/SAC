package com.project.dao;

import java.util.List;

import com.project.model.UserVO;

public interface RegistrationDAO {
  
  void save(UserVO registerVO);
  
  List<UserVO> search();
  
  List<UserVO> findById(int id);

}
