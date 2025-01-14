package com.project.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.TopPaperDAO;
import com.project.model.TopPaperVO;
import com.project.service.TopPaperService;

@Service
@Transactional
public class TopPaperServiceImpl implements TopPaperService {

	@Autowired
	private TopPaperDAO toppaperDAO;

	@Override
	public void insertTopPaper(TopPaperVO toppaperVO) {
		this.toppaperDAO.insertTopPaper(toppaperVO);
	}
	@Override
	public List<TopPaperVO> searchTopPaper() {
		return this.toppaperDAO.searchTopPaper();
	}
	@Override
	public List<TopPaperVO> sortTopPaper() {
		return this.toppaperDAO.sortTopPaper();
	}

	@Override
	public List<TopPaperVO> findById(int id) {
		return this.toppaperDAO.findById(id);
	}
	@Override
	public Long calculatePercent() {
		return this.toppaperDAO.calculatePercent();
	}

}