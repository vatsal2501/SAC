package com.project.service;

import java.util.*;

import com.project.model.OrderVO;

public interface OrderService {
	
	void insertOrder (OrderVO orderVO);
	
	List<OrderVO> searchOrder();
	
	List<OrderVO> findById(int id);
}
