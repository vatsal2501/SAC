package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.ClientReqVO;
import com.project.model.OrderVO;
import com.project.model.PlyDetailsVO;

@Repository
public class ClientReqDAOImpl implements ClientReqDAO{
	
  @Autowired
  private  SessionFactory sessionFactory;
  
  @Override
  public void insertClientReq(ClientReqVO clientreqVO) {
    try {
      Session session = sessionFactory.getCurrentSession();
      session.saveOrUpdate(clientreqVO);
      System.out.println("hello");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @SuppressWarnings("unchecked")
@Override
  public List<ClientReqVO> searchClientReq(){
    List<ClientReqVO> ClientReqList = new ArrayList<ClientReqVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(":: before query ");
        Query query = session.createQuery("from ClientReqVO where status = true" );
        System.out.println(":: after query ");
        ClientReqList = (List<ClientReqVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ClientReqList;
  }
  
  @SuppressWarnings("unchecked")
@Override
  public List<ClientReqVO> findById(int id){
    List<ClientReqVO> ClientReqList = new ArrayList<ClientReqVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ClientReqVO where status = true and id = " +id );
        ClientReqList = (List<ClientReqVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ClientReqList;
  }
  
  @Override
  public void savePlyDetails(PlyDetailsVO plyDetailsVO) {
    try {
      Session session = sessionFactory.getCurrentSession();
      session.saveOrUpdate(plyDetailsVO);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public List<PlyDetailsVO> findPlyDetailsByClientReqId(int clientReqId){
	  List<PlyDetailsVO> plyDetailsVOList = new ArrayList<PlyDetailsVO>();
	    try {
	        Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("from PlyDetailsVO where clientReqVO = " +clientReqId);
	        plyDetailsVOList = (List<PlyDetailsVO>) query.list();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return plyDetailsVOList;  
  }
  
  	@Override
	public void deletePlyDetailsByClientReqId(int clientReqId){
  		try {
	        Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("DELETE FROM PlyDetailsVO WHERE clientReqVO = " + clientReqId);
	        query.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

  	}
    /*@SuppressWarnings("unchecked")
  	@Override
  	public List<OrderVO> getOrderDetials(int orderId) {
  		List<OrderVO> orderList = new ArrayList<OrderVO>();
  		try {
  			Session session = sessionFactory.getCurrentSession();
  			Query query = session.createQuery("from OrderVO where status = true and orderId = " + orderId);
  			System.out.println("in getorederdetailsdaoimpl"+orderList);
  			orderList = (List<OrderVO>) query.list();
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		return orderList;
  	}
   */

  
}