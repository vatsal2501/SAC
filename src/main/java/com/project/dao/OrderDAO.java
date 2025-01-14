package com.project.dao;

import java.util.*;

import com.project.model.OrderVO;

public interface OrderDAO {
	void insertOrder(OrderVO orderVO);
	List<OrderVO> searchOrder();
	List<OrderVO> findById(int id);
}
