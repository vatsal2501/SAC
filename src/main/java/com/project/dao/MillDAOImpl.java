package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.MillVO;

@Repository
public class MillDAOImpl implements MillDAO{
	
  @Autowired
  private  SessionFactory sessionFactory;
  
  @Override
  public void insertMill(MillVO millVO) {
    try {
      Session session = sessionFactory.getCurrentSession();
      session.saveOrUpdate(millVO);
      System.out.println("hello");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @SuppressWarnings("unchecked")
@Override
  public List<MillVO> searchMill(){
    List<MillVO> millList = new ArrayList<MillVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(":: before query ");
        Query query = session.createQuery("from MillVO where status = true" );
        System.out.println(":: after query ");
        millList = (List<MillVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return millList;
  }
  
  @SuppressWarnings("unchecked")
@Override
  public List<MillVO> findById(int id){
    List<MillVO> millList = new ArrayList<MillVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from MillVO where status = true and id = " +id );
        millList = (List<MillVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return millList;
  }
 
}