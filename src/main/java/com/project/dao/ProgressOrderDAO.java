package com.project.dao;

import java.util.List;

import com.project.model.OrderPlyDetailsVO;
import com.project.model.ProgressOrderVO;
import com.project.model.VerifyPlyDetailsVO;

public interface ProgressOrderDAO {
	void insertProgressOrder(ProgressOrderVO progressOrderVO);
	List<ProgressOrderVO> searchProgressOrder();
	List<ProgressOrderVO> findById(int id);
	
	 void saveOrderPlyDetails(OrderPlyDetailsVO orderPlyDetailsVO);
}
