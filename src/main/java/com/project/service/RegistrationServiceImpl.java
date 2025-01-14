package com.project.service;

import java.util.List;

import javax.imageio.spi.RegisterableService;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.RegistrationDAO;
import com.project.model.UserVO;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService{
  
  @Autowired
  private RegistrationDAO registrationDAO;
  
  @Override
  public void save(UserVO userVO) {
    this.registrationDAO.save(userVO);
  }
  
  @Override
  public List<UserVO> search(){
    return this.registrationDAO.search();
  }
  
  @Override
  public List<UserVO> findById(int id){
    return this.registrationDAO.findById(id);
  }

}
