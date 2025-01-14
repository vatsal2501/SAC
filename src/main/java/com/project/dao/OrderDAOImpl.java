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

import com.project.model.OrderVO;

@Repository
public class OrderDAOImpl implements OrderDAO{
	
  @Autowired
  private  SessionFactory sessionFactory;
  
  @Override
  public void insertOrder(OrderVO orderVO) {
    try {
      Session session = sessionFactory.getCurrentSession();
      session.saveOrUpdate(orderVO);
      System.out.println("hello");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @SuppressWarnings("unchecked")
@Override
  public List<OrderVO> searchOrder(){
    List<OrderVO> orderList = new ArrayList<OrderVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(":: before query ");
        Query query = session.createQuery("from OrderVO where status = true" );
        System.out.println(":: after query ");
        orderList = (List<OrderVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return orderList;
  }
  
  @SuppressWarnings("unchecked")
@Override
  public List<OrderVO> findById(int id){
    List<OrderVO> orderList = new ArrayList<OrderVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderVO where status = true and id = " +id );
        orderList = (List<OrderVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return orderList;
  }
 
}