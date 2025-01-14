package com.project.service;

import java.util.*;

import com.project.model.PaperTypeVO;

public interface PaperTypeService {
	
	void insertPaperType (PaperTypeVO paperTypeVO);
	
	List<PaperTypeVO> searchPaperType();
	
	List<PaperTypeVO> findById(int id);
}
