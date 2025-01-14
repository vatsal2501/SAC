package com.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "client_table")
public class ClientVO extends Auditable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_id")
	private int clientId;

	@Column(name = "client_name")
	private String clientName;

	@Column(name = "clientaddress")
	private String clientAddress;

	@Column(name = "pincode")
	private String pinCode;

	@Column(name = "client_mobile_number")
	private String clientMobileNumber;

	@Column(name = "gst_number")
	private String clientGSTNumber;

	@ManyToOne
	@JoinColumn(name = "login_id")
	private LoginVO LoginVO;

	@Column(name = "status")
	private boolean status = true;

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getClientMobileNumber() {
		return clientMobileNumber;
	}

	public void setClientMobileNumber(String clientMobileNumber) {
		this.clientMobileNumber = clientMobileNumber;
	}

	public String getClientGSTNumber() {
		return clientGSTNumber;
	}

	public void setClientGSTNumber(String clientGSTNumber) {
		this.clientGSTNumber = clientGSTNumber;
	}

	public LoginVO getLoginVO() {
		return LoginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		LoginVO = loginVO;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
