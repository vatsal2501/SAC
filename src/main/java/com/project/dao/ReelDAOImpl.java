package com.project.dao;

import java.math.BigInteger;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.ReelVO;

@Repository
public class ReelDAOImpl implements ReelDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertReel(ReelVO reelVO) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(reelVO);
			System.out.println("hello");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReelVO> searchReel() {
		List<ReelVO> reelList = new ArrayList<ReelVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			System.out.println(":: before query ");
			Query query = session.createQuery("from ReelVO where status = true");
			System.out.println(":: after query ");
			reelList = (List<ReelVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reelList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReelVO> findById(int id) {
		List<ReelVO> reelList = new ArrayList<ReelVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ReelVO where status = true and id = " + id);
			reelList = (List<ReelVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reelList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReelVO> sortReel() {
		List<ReelVO> reelList = new ArrayList<ReelVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ReelVO ORDER BY createdDate DESC");
			query.setMaxResults(5);
			reelList = (List<ReelVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reelList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Long calculatePercent() {
		List<Long> reelWeightList = new ArrayList<Long>();
		try {
			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("SELECT SUM(CAST(reelWeight AS integer )) FROM ReelVO where status=true");
			reelWeightList = (List<Long>) query.list();
			System.out.println("sum of reels :::::" + reelWeightList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Long weight =reelWeightList.get(0);
		
		return weight;
	}
	public long getNextSequence() {
		long reelNumber = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery("select hibernate_sequence('ReelVO')");
			Long key = ((BigInteger) query.uniqueResult()).longValue();
			reelNumber = key.longValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reelNumber;
	}

}