package com.project.dao;

import java.util.*;

import com.project.model.PaperTypeVO;

public interface PaperTypeDAO {
	void insertPaperType(PaperTypeVO paperTypeVO);
	List<PaperTypeVO> searchPaperType();
	List<PaperTypeVO> findById(int id);
}
