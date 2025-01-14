package com.project.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.OrderDAO;
import com.project.model.OrderVO;
import com.project.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	public void insertOrder(OrderVO orderVO) {
		this.orderDAO.insertOrder(orderVO);
	}
	@Override
	public List<OrderVO> searchOrder() {
		return this.orderDAO.searchOrder();
	}

	@Override
	public List<OrderVO> findById(int id) {
		return this.orderDAO.findById(id);
	}

}