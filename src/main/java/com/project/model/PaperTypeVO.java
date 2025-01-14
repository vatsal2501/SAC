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
@Table(name = "paper_type_table")
public class PaperTypeVO extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "paper_type_id")
	private int paperTypeId;

	@Column(name = "paper_type")
	private String paperType;

	@ManyToOne
	@JoinColumn(name = "mill_id")
	private MillVO millVO;

	@Column(name = "status")
	private boolean status = true;

	@ManyToOne
	@JoinColumn(name = "login_id")
	private LoginVO loginVO;

	public int getPaperTypeId() {
		return paperTypeId;
	}

	public void setPaperTypeId(int paperTypeId) {
		this.paperTypeId = paperTypeId;
	}

	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public MillVO getMillVO() {
		return millVO;
	}

	public void setMillVO(MillVO millVO) {
		this.millVO = millVO;
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

}
