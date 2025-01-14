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

import com.project.model.ClientReqVO;
import com.project.model.ClientVO;

@Repository
public class ClientDAOImpl implements ClientDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertClient(ClientVO clientVO) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(clientVO);
			System.out.println("hello");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClientVO> searchClient() {
		List<ClientVO> clientList = new ArrayList<ClientVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			System.out.println(":: before query ");
			Query query = session.createQuery("from ClientVO where status = true");
			System.out.println(":: after query ");
			clientList = (List<ClientVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClientVO> findById(int id) {
		List<ClientVO> clientList = new ArrayList<ClientVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ClientVO where status = true and id = " + id);
			clientList = (List<ClientVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClientReqVO> findByClientId(int clientId) {
		List<ClientReqVO> clientReqList = new ArrayList<ClientReqVO>();
		try {
			System.out.println("from ClientReqVO where status = true and ClientVO = " + clientId);
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ClientReqVO where status = true and clientVO = " + clientId);
			clientReqList = (List<ClientReqVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientReqList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ClientReqVO> getItemsDetailsByClientItem(int clientreqId) {
		List<ClientReqVO> clientReqList = new ArrayList<ClientReqVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ClientReqVO where status = true and clientreqId = " + clientreqId);
			clientReqList = (List<ClientReqVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientReqList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ClientReqVO> getverifyOrderDetailsByOrderId(int clientreqId) {
		List<ClientReqVO> clientReqList = new ArrayList<ClientReqVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ClientReqVO where status = true and clientreqId = " + clientreqId);
			clientReqList = (List<ClientReqVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientReqList;
	}
	
}