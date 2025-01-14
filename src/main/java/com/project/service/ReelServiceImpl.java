package com.project.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ReelDAO;
import com.project.model.ReelVO;
import com.project.service.ReelService;

@Service
@Transactional
public class ReelServiceImpl implements ReelService {

	@Autowired
	private ReelDAO reelDAO;

	@Override
	public void insertReel(ReelVO reelVO) {
		this.reelDAO.insertReel(reelVO);
	}

	@Override
	public List<ReelVO> searchReel() {
		return this.reelDAO.searchReel();
	}

	@Override
	public List<ReelVO> sortReel() {
		return this.reelDAO.sortReel();
	}

	@Override
	public List<ReelVO> findById(int id) {
		return this.reelDAO.findById(id);
	}

	@Override
	public Long calculatePercent() {
		return this.reelDAO.calculatePercent();
	}

	public long getNextSequence() {
		return this.reelDAO.getNextSequence();
	}

}