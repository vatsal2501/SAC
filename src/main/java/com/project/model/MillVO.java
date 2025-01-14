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
@Table(name = "mill_table")
public class MillVO extends Auditable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mill_id")
	private int millId;

	@Column(name = "mill_name")
	private String millName;

	@Column(name = "mill_address")
	private String millAddress;

	@Column(name = "mill_mobile_number")
	private String millMobileNumber;

	@Column(name = "gst_number")
	private String millGSTNumber;

	@ManyToOne
	@JoinColumn(name = "login_id")
	private LoginVO loginVO;

	@Column(name = "status")
	private boolean status = true;

	public int getMillId() {
		return millId;
	}

	public void setMillId(int millId) {
		this.millId = millId;
	}

	public String getMillName() {
		return millName;
	}

	public void setMillName(String millName) {
		this.millName = millName;
	}

	public String getMillAddress() {
		return millAddress;
	}

	public void setMillAddress(String millAddress) {
		this.millAddress = millAddress;
	}

	public String getMillMobileNumber() {
		return millMobileNumber;
	}

	public void setMillMobileNumber(String millMobileNumber) {
		this.millMobileNumber = millMobileNumber;
	}

	public String getMillGSTNumber() {
		return millGSTNumber;
	}

	public void setMillGSTNumber(String millGSTNumber) {
		this.millGSTNumber = millGSTNumber;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
