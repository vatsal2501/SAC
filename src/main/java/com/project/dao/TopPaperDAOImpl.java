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

import com.project.model.ReelVO;
import com.project.model.TopPaperVO;

@Repository
public class TopPaperDAOImpl implements TopPaperDAO{
	
  @Autowired
  private  SessionFactory sessionFactory;
  
  @Override
  public void insertTopPaper(TopPaperVO toppaperVO) {
    try {
      Session session = sessionFactory.getCurrentSession();
      session.saveOrUpdate(toppaperVO);
      System.out.println("hello");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @SuppressWarnings("unchecked")
@Override
  public List<TopPaperVO> searchTopPaper(){
    List<TopPaperVO> toppaperList = new ArrayList<TopPaperVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(":: before query ");
        Query query = session.createQuery("from TopPaperVO where status = true" );
        System.out.println(":: after query ");
        toppaperList = (List<TopPaperVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return toppaperList;
  }
  
  @SuppressWarnings("unchecked")
@Override
  public List<TopPaperVO> findById(int id){
    List<TopPaperVO> toppaperList = new ArrayList<TopPaperVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from TopPaperVO where status = true and id = " +id );
        toppaperList = (List<TopPaperVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return toppaperList;
  }

	@SuppressWarnings("unchecked")
	@Override
	public List<TopPaperVO> sortTopPaper() {
		List<TopPaperVO> toppaperList = new ArrayList<TopPaperVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from TopPaperVO  ");
			query.setMaxResults(5);
			toppaperList = (List<TopPaperVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toppaperList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Long calculatePercent() {
		List<Long> toppaperPiecesList = new ArrayList<Long>();
		try {
			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("SELECT SUM(CAST(topPaperPieces AS integer )) FROM TopPaperVO where status=true");
			toppaperPiecesList = (List<Long>) query.list();
			System.out.println("sum of toppaper :::::" + toppaperPiecesList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Long pieces =toppaperPiecesList.get(0);
		
		return pieces;
	}
 
}