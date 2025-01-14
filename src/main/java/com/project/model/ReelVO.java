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
@Table(name = "reel_table")
public class ReelVO extends Auditable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reel_id")
	private int reelId;

	@ManyToOne
	@JoinColumn(name = "mill_id")
	private MillVO millVO;

	@ManyToOne
	@JoinColumn(name = "paperType_id")
	private PaperTypeVO paperTypeVO;

	@Column(name = "reel_number_old")
	private String reelNumberOld;

	@Column(name = "reel_number")
	private String reelNumber;

	@Column(name = "weight_old")
	private String reelWeightOld;

	@Column(name = "reelweight")
	private String reelWeight;

	@Column(name = "gsm_old")
	private String reelGSMOld;

	@Column(name = "gsm")
	private String reelGSM;

	@Column(name = "bf_old")
	private String reelBFOld;

	@Column(name = "bf")
	private String reelBF;

	@Column(name = "decal_old")
	private String reelDecalOld;

	@Column(name = "decal")
	private String reelDecal;

	@Column(name = "remark")
	private String reelRemark;

	@ManyToOne
	@JoinColumn(name = "login_id")
	private LoginVO loginVO;

	@Column(name = "used_reel_quantity")
	private float usedReelQuantity = 0;
	// (in -kg)

	@Column(name = "is_partreel")
	private boolean partReel = false;
	// (boolean : true if the reel is used before)

	@Column(name = "part_reel_quantity")
	private int partReelQuantity = 0;
	/*
	 * (kg-int shows how much part reel is used 0 if the reel is not used )
	 */

	@Column(name = "availability")
	private boolean available = true;

	@Column(name = "status")
	private boolean status = true;
	



	public int getReelId() {
		return reelId;
	}

	public void setReelId(int reelId) {
		this.reelId = reelId;
	}

	public MillVO getMillVO() {
		return millVO;
	}

	public void setMillVO(MillVO millVO) {
		this.millVO = millVO;
	}

	public PaperTypeVO getPaperTypeVO() {
		return paperTypeVO;
	}

	public void setPaperTypeVO(PaperTypeVO paperTypeVO) {
		this.paperTypeVO = paperTypeVO;
	}

	public String getReelNumberOld() {
		return reelNumberOld;
	}

	public void setReelNumberOld(String reelNumberOld) {
		this.reelNumberOld = reelNumberOld;
	}

	public String getReelNumber() {
		return reelNumber;
	}

	public void setReelNumber(String reelNumber) {
		this.reelNumber = reelNumber;
	}


	public String getReelWeightOld() {
		return reelWeightOld;
	}

	public void setReelWeightOld(String reelWeightOld) {
		this.reelWeightOld = reelWeightOld;
	}



	public String getReelWeight() {
		return reelWeight;
	}

	public void setReelWeight(String reelWeight) {
		this.reelWeight = reelWeight;
	}


	public String getReelGSMOld() {
		return reelGSMOld;
	}

	public void setReelGSMOld(String reelGSMOld) {
		this.reelGSMOld = reelGSMOld;
	}

	public String getReelGSM() {
		return reelGSM;
	}

	public void setReelGSM(String reelGSM) {
		this.reelGSM = reelGSM;
	}

	public String getReelBFOld() {
		return reelBFOld;
	}

	public void setReelBFOld(String reelBFOld) {
		this.reelBFOld = reelBFOld;
	}

	public String getReelBF() {
		return reelBF;
	}

	public void setReelBF(String reelBF) {
		this.reelBF = reelBF;
	}

	public String getReelDecalOld() {
		return reelDecalOld;
	}

	public void setReelDecalOld(String reelDecalOld) {
		this.reelDecalOld = reelDecalOld;
	}

	public String getReelDecal() {
		return reelDecal;
	}

	public void setReelDecal(String reelDecal) {
		this.reelDecal = reelDecal;
	}

	public String getReelRemark() {
		return reelRemark;
	}

	public void setReelRemark(String reelRemark) {
		this.reelRemark = reelRemark;
	}


	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public float getUsedReelQuantity() {
		return usedReelQuantity;
	}

	public void setUsedReelQuantity(float usedReelQuantity) {
		this.usedReelQuantity = usedReelQuantity;
	}

	public boolean isPartReel() {
		return partReel;
	}

	public void setPartReel(boolean partReel) {
		this.partReel = partReel;
	}

	public int getPartReelQuantity() {
		return partReelQuantity;
	}

	public void setPartReelQuantity(int partReelQuantity) {
		this.partReelQuantity = partReelQuantity;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
