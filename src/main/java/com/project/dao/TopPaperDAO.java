package com.project.dao;

import java.util.*;

import com.project.model.TopPaperVO;

public interface TopPaperDAO {
	void insertTopPaper(TopPaperVO toppaperVO);
	List<TopPaperVO> searchTopPaper();
	List<TopPaperVO> sortTopPaper();
	List<TopPaperVO> findById(int id);
	Long calculatePercent();
}
