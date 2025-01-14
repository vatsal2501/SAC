package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ProgressOrderDAO;
import com.project.model.OrderPlyDetailsVO;
import com.project.model.ProgressOrderVO;

@Service
@Transactional
public class ProgressOrderServiceImpl implements ProgressOrderService {

	@Autowired
	private ProgressOrderDAO progressOrderDAO;

	@Override
	public void insertProgressOrder(ProgressOrderVO progressOrderVO) {
		this.progressOrderDAO.insertProgressOrder(progressOrderVO);
	}
	@Override
	public List<ProgressOrderVO> searchProgressOrder() {
		return this.progressOrderDAO.searchProgressOrder();
	}

	@Override
	public List<ProgressOrderVO> findById(int id) {
		return this.progressOrderDAO.findById(id);
	}
	
	
	@Override
	public void saveOrderPlyDetails(OrderPlyDetailsVO orderPlyDetailsVO){
		this.progressOrderDAO.saveOrderPlyDetails(orderPlyDetailsVO);
	}

}