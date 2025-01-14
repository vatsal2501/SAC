package com.project.service;

import java.util.List;

import com.project.model.UserVO;

public interface RegistrationService {
  
  void save(UserVO userVO);
  
  List<UserVO> search();
  
  List<UserVO> findById(int id);

}
