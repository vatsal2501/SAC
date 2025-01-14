package com.project.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.MillDAO;
import com.project.model.MillVO;
import com.project.service.MillService;

@Service
@Transactional
public class MillServiceImpl implements MillService {

	@Autowired
	private MillDAO millDAO;

	@Override
	public void insertMill(MillVO millVO) {
		this.millDAO.insertMill(millVO);
	}

	@Override
	public List<MillVO> searchMill() {
		return this.millDAO.searchMill();
	}

	@Override
	public List<MillVO> findById(int id) {
		return this.millDAO.findById(id);
	}
}