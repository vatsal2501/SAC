package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ClientReqDAO;
import com.project.model.ClientReqVO;
import com.project.model.PlyDetailsVO;

@Service
@Transactional
public class ClientReqServiceImpl implements ClientReqService {

	@Autowired
	private ClientReqDAO clientreqDAO;

	@Override
	public void insertClientReq(ClientReqVO clientreqVO) {
		this.clientreqDAO.insertClientReq(clientreqVO);
	}
	@Override
	public List<ClientReqVO> searchClientReq() {
		return this.clientreqDAO.searchClientReq();
	}

	@Override
	public List<ClientReqVO> findById(int id) {
		return this.clientreqDAO.findById(id);
	}
	
	@Override
	public void savePlyDetails(PlyDetailsVO plyDetailsVO){
		this.clientreqDAO.savePlyDetails(plyDetailsVO);
	}
	
	@Override
	public List<PlyDetailsVO> findPlyDetailsByClientReqId(int clientReqId){
		return this.clientreqDAO.findPlyDetailsByClientReqId(clientReqId);
	}
	
	@Override
	public void deletePlyDetailsByClientReqId(int clientReqId){
		this.clientreqDAO.deletePlyDetailsByClientReqId(clientReqId);

	}


}