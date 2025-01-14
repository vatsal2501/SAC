package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.LoginVO;
import com.project.model.UserVO;

@Repository
public class RegistrationDAOImpl implements RegistrationDAO{
  @Autowired
  private  SessionFactory sessionFactory;
  @Override
  public void save(UserVO registerVO) {
    try {
      Session session = sessionFactory.getCurrentSession();
      session.saveOrUpdate(registerVO);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public List<UserVO> search(){
    List<UserVO> userList = new ArrayList<UserVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from UserVO where status = true" );
        userList = (List<UserVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return userList;
  }
  
  @Override
  public List<UserVO> findById(int id){
    List<UserVO> userList = new ArrayList<UserVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from UserVO where status = true and id = " +id );
        userList = (List<UserVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return userList;
  }
  
}
