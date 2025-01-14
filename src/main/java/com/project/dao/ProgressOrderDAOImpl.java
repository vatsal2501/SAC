package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.OrderPlyDetailsVO;
import com.project.model.ProgressOrderVO;

@Repository
public class ProgressOrderDAOImpl implements ProgressOrderDAO{
	
  @Autowired
  private  SessionFactory sessionFactory;
  
  @Override
  public void insertProgressOrder(ProgressOrderVO progressOrderVO) {
    try {
      Session session = sessionFactory.getCurrentSession();
      session.saveOrUpdate(progressOrderVO);
      System.out.println("hello");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @SuppressWarnings("unchecked")
@Override
  public List<ProgressOrderVO> searchProgressOrder(){
    List<ProgressOrderVO> progressOrderVOList = new ArrayList<ProgressOrderVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(":: before query ");
        Query query = session.createQuery("from ProgressOrderVO where status = true" );
        System.out.println(":: after query ");
        progressOrderVOList = (List<ProgressOrderVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return progressOrderVOList;
  }
  
  @SuppressWarnings("unchecked")
@Override
  public List<ProgressOrderVO> findById(int id){
    List<ProgressOrderVO> progressOrderVOList = new ArrayList<ProgressOrderVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ProgressOrderVO where status = true and progressOrderId = " +id );
        progressOrderVOList = (List<ProgressOrderVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return progressOrderVOList;
  }
  
  @Override
	public void saveOrderPlyDetails(OrderPlyDetailsVO orderPlyDetailsVO){
	  try {
	      Session session = sessionFactory.getCurrentSession();
	      session.saveOrUpdate(orderPlyDetailsVO);
	      System.out.println("hello");
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}