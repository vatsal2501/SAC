package com.project.service;

import java.util.List;

import com.project.model.ClientReqVO;
import com.project.model.PlyDetailsVO;

public interface ClientReqService {
	
	void insertClientReq (ClientReqVO clientreqVO);
	
	List<ClientReqVO> searchClientReq();
	
	List<ClientReqVO> findById(int id);
	
	void savePlyDetails(PlyDetailsVO plyDetailsVO);

	List<PlyDetailsVO> findPlyDetailsByClientReqId(int id);
	
	void deletePlyDetailsByClientReqId(int clientReqId);
}
