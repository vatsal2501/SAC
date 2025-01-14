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
@Table(name = "progess_order_ply_details")
public class OrderPlyDetailsVO extends Auditable {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private OrderVO orderVO;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderVO getOrderVO() {
		return orderVO;
	}

	public void setOrderVO(OrderVO orderVO) {
		this.orderVO = orderVO;
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
