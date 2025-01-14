package com.project.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ClientDAO;
import com.project.model.ClientReqVO;
import com.project.model.ClientVO;
import com.project.service.ClientService;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDAO;

	@Override
	public void insertClient(ClientVO clientVO) {
		this.clientDAO.insertClient(clientVO);
	}

	@Override
	public List<ClientVO> searchClient() {
		return this.clientDAO.searchClient();
	}

	@Override
	public List<ClientVO> findById(int id) {
		return this.clientDAO.findById(id);
	}
	
	@Override
	public List<ClientReqVO> findByClientId(int clientId){
		return this.clientDAO.findByClientId(clientId);
	}

	@Override
	public List<ClientReqVO> getItemsDetailsByClientItem(int clientItem) {
		return this.clientDAO.getItemsDetailsByClientItem(clientItem);
	}
	
	@Override
	public List<ClientReqVO> getverifyOrderDetailsByOrderId(int clientItem) {
		return this.clientDAO.getverifyOrderDetailsByOrderId(clientItem);
	}
}