package com.project.service;

import java.util.List;

import com.project.model.ClientReqVO;
import com.project.model.ClientVO;

public interface ClientService {
	
	void insertClient (ClientVO clientVO);
	
	List<ClientVO> searchClient();
	
	List<ClientVO> findById(int id);
	List<ClientReqVO> findByClientId(int clientId);
	List<ClientReqVO> getItemsDetailsByClientItem(int clientItem);
	List<ClientReqVO> getverifyOrderDetailsByOrderId(int clientItem);

}