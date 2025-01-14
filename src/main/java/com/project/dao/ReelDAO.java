package com.project.dao;

import java.util.*;

import com.project.model.ReelVO;

public interface ReelDAO {
	void insertReel(ReelVO reelVO);
	List<ReelVO> searchReel();
	List<ReelVO> findById(int id);
	List<ReelVO> sortReel();
	Long calculatePercent();
	long getNextSequence();
	
}
