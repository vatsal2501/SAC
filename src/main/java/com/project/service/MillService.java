package com.project.service;

import java.util.*;

import com.project.model.MillVO;

public interface MillService {
	
	void insertMill (MillVO millVO);
	
	List<MillVO> searchMill();
	
	List<MillVO> findById(int id);
}
