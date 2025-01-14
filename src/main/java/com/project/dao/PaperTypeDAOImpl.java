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

import com.project.model.PaperTypeVO;

@Repository
public class PaperTypeDAOImpl implements PaperTypeDAO{
	
  @Autowired
  private  SessionFactory sessionFactory;
  
  @Override
  public void insertPaperType(PaperTypeVO paperTypeVO) {
    try {
      Session session = sessionFactory.getCurrentSession();
      session.saveOrUpdate(paperTypeVO);
      System.out.println("hello");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @SuppressWarnings("unchecked")
@Override
  public List<PaperTypeVO> searchPaperType(){
    List<PaperTypeVO> PaperTypeList = new ArrayList<PaperTypeVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(":: before query ");
        Query query = session.createQuery("from PaperTypeVO where status = true" );
        System.out.println(":: after query ");
        PaperTypeList = (List<PaperTypeVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return PaperTypeList;
  }
  
  @SuppressWarnings("unchecked")
@Override
  public List<PaperTypeVO> findById(int id){
    List<PaperTypeVO> PaperTypeList = new ArrayList<PaperTypeVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from PaperTypeVO where status = true and id = " +id );
        PaperTypeList = (List<PaperTypeVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return PaperTypeList;
  }
 
}