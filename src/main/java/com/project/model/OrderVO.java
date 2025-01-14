package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "order_table")
public class OrderVO extends Auditable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int orderId;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private ClientVO clientVO;

	@ManyToOne
	@JoinColumn(name = "client_requirement_id")
	private ClientReqVO clientReqVO;

	@Column(name = "orderquantity")
	private String orderQuantity;

	@Column(name = "status")
	private boolean status = true;

	@Column(name = "process_status")
	private String processStatus;

	@Column(name = "two_ply")
	private Integer twoPly;
	
	@ManyToOne
	@JoinColumn(name = "login_id")
	private LoginVO loginVO;

	@Column(name = "availability")
	private boolean available = true;

	
	public ClientVO getClientVO() {
		return clientVO;
	}

	public void setClientVO(ClientVO clientVO) {
		this.clientVO = clientVO;
	}

	public ClientReqVO getClientReqVO() {
		return clientReqVO;
	}

	public void setClientReqVO(ClientReqVO clientReqVO) {
		this.clientReqVO = clientReqVO;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public Integer getTwoPly() {
		return twoPly;
	}

	public void setTwoPly(Integer twoPly) {
		this.twoPly = twoPly;
	}

}
