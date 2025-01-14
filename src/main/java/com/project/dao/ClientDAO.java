package com.project.dao;

import java.util.List;

import com.project.model.ClientReqVO;
import com.project.model.ClientVO;

public interface ClientDAO {

	void insertClient(ClientVO clientVO);

	List<ClientVO> searchClient();

	List<ClientVO> findById(int id);

	List<ClientReqVO> findByClientId(int clientId);

	List<ClientReqVO> getItemsDetailsByClientItem(int clientreqId);

	List<ClientReqVO> getverifyOrderDetailsByOrderId(int clientItem);

}