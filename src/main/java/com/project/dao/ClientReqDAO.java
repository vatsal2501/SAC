package com.project.dao;

import java.util.List;

import com.project.model.ClientReqVO;
import com.project.model.OrderVO;
import com.project.model.PlyDetailsVO;

public interface ClientReqDAO {
	void insertClientReq(ClientReqVO clientreqVO);
	List<ClientReqVO> searchClientReq();
	List<ClientReqVO> findById(int id);
	
	void savePlyDetails(PlyDetailsVO plyDetailsVO);
	
	List<PlyDetailsVO> findPlyDetailsByClientReqId(int clientReqId);

	void deletePlyDetailsByClientReqId(int clientReqId);
	
/*	List<OrderVO> getOrderDetials(int orderId);
*/

}
