package com.project.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.PaperTypeDAO;
import com.project.model.PaperTypeVO;
import com.project.service.PaperTypeService;

@Service
@Transactional
public class PaperTypeServiceImpl implements PaperTypeService {

	@Autowired
	private PaperTypeDAO paperTypeDAO;

	@Override
	public void insertPaperType(PaperTypeVO paperTypeVO) {
		this.paperTypeDAO.insertPaperType(paperTypeVO);
	}
	@Override
	public List<PaperTypeVO> searchPaperType() {
		return this.paperTypeDAO.searchPaperType();
	}

	@Override
	public List<PaperTypeVO> findById(int id) {
		return this.paperTypeDAO.findById(id);
	}

}