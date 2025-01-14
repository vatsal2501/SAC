package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.LoginVO;
import com.project.model.MillVO;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(LoginVO loginVO) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(loginVO);

	}
	
	@Override
	  public List<LoginVO> findById(int id){
	    List<LoginVO> loginVOList = new ArrayList<LoginVO>();
	    try {
	        Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("from LoginVO where status = true and id = " +id );
	        loginVOList = (List<LoginVO>) query.list();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return loginVOList;
	  }

	@Override
	public List<LoginVO> searchByUserName(String userName) {
		 List<LoginVO> loginVOList = new ArrayList<LoginVO>();
		    try {
		        Session session = sessionFactory.getCurrentSession();
		        System.out.println(":: before query ");
		        Query query = session.createQuery("from LoginVO where status = true AND userName = '"+userName+"'");
		        System.out.println(":: after query ");
		        loginVOList = (List<LoginVO>) query.list();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return loginVOList;
	}

}
