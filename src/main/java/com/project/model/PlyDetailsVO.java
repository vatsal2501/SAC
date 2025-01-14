package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_ply_details")
public class PlyDetailsVO extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ply_details_id")
	private int plyDetailsId;

	@Column(name = "paper_gsm")
	private String paperGsm;

	@Column(name = "paper_bf")
	private String paperBf;

	@Column(name = "flute_gsm")
	private String fluteGsm;

	@Column(name = "flute_bf")
	private String fluteBf;

	@ManyToOne
	@JoinColumn(name = "client_requirement_id")
	private ClientReqVO clientReqVO;

	public int getPlyDetailsId() {
		return plyDetailsId;
	}

	public void setPlyDetailsId(int plyDetailsId) {
		this.plyDetailsId = plyDetailsId;
	}

	public String getPaperGsm() {
		return paperGsm;
	}

	public void setPaperGsm(String paperGsm) {
		this.paperGsm = paperGsm;
	}

	public String getPaperBf() {
		return paperBf;
	}

	public void setPaperBf(String paperBf) {
		this.paperBf = paperBf;
	}

	public String getFluteGsm() {
		return fluteGsm;
	}

	public void setFluteGsm(String fluteGsm) {
		this.fluteGsm = fluteGsm;
	}

	public String getFluteBf() {
		return fluteBf;
	}

	public void setFluteBf(String fluteBf) {
		this.fluteBf = fluteBf;
	}

	public ClientReqVO getClientReqVO() {
		return clientReqVO;
	}

	public void setClientReqVO(ClientReqVO clientReqVO) {
		this.clientReqVO = clientReqVO;
	}

}
