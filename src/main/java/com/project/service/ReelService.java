package com.project.service;

import java.util.*;

import com.project.model.ReelVO;

public interface ReelService {
	
	void insertReel (ReelVO reelVO);
	List<ReelVO> searchReel();
	List<ReelVO> sortReel();
	List<ReelVO> findById(int id);
	Long calculatePercent();
	long getNextSequence();
}
