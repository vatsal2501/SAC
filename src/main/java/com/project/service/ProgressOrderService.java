package com.project.service;

import java.util.List;

import com.project.model.OrderPlyDetailsVO;
import com.project.model.ProgressOrderVO;
import com.project.model.VerifyPlyDetailsVO;

public interface ProgressOrderService {
	
	void insertProgressOrder(ProgressOrderVO progressOrderVO);
	
	List<ProgressOrderVO> searchProgressOrder();
	
	List<ProgressOrderVO> findById(int id);
	
	void saveOrderPlyDetails(OrderPlyDetailsVO orderPlyDetailsVO);
	
}
