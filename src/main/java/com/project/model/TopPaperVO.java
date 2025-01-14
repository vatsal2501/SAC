package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "toppaper_table")
public class TopPaperVO extends Auditable {

	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)   
	  @Column(name = "top_paper_id")
	  private int topPaperId;
	  
	  @ManyToOne
	  @JoinColumn(name = "mill_id")
	  private MillVO millVO;
	  
	  @ManyToOne
	  @JoinColumn(name = "paperType_id")
	  private PaperTypeVO paperTypeVO;
	 
	  @Column(name = "top_paper_bundle_number")
	  private String topPaperBundleNumber;
	  
	  @Column(name = "top_paper_pieces_old")
	  private String topPaperPiecesOld;
	  
	  @Column(name = "top_paper_pieces")
	  private String topPaperPieces;
	  
	  @Column(name = "gsm_old")
	  private String topPaperGSMOld;
	  
	  @Column(name = "gsm")
	  private String topPaperGSM;
	  
	  @Column(name = "bf_old")
	  private String topPaperBFOld;

	  @Column(name = "bf")
	  private String topPaperBF;
	  
	  @Column(name = "decal_old")
	  private String topPaperDecalOld;
	  
	  @Column(name = "decal")
	  private String topPaperDecal;

	  @Column(name = "remark")
	  private String topPaperRemark;
	  
	  @ManyToOne
	  @JoinColumn(name = "login_id")
	  private LoginVO loginVO;
	  //this loginVO will save the loginVO of the current logged in user
	  
	  @Column(name = "available_pieces")
	  private int availablePieces=0; 
	  
	  @Column(name = "availability")
	  private boolean available=true;
	  
	  @Column(name = "status")
	  private boolean status=true;

	public int getTopPaperId() {
		return topPaperId;
	}

	public void setTopPaperId(int topPaperId) {
		this.topPaperId = topPaperId;
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

	public String getTopPaperBundleNumber() {
		return topPaperBundleNumber;
	}

	public void setTopPaperBundleNumber(String topPaperBundleNumber) {
		this.topPaperBundleNumber = topPaperBundleNumber;
	}


	public String getTopPaperPiecesOld() {
		return topPaperPiecesOld;
	}

	public void setTopPaperPiecesOld(String topPaperPiecesOld) {
		this.topPaperPiecesOld = topPaperPiecesOld;
	}

	public String getTopPaperPieces() {
		return topPaperPieces;
	}

	public void setTopPaperPieces(String topPaperPieces) {
		this.topPaperPieces = topPaperPieces;
	}



	public String getTopPaperGSMOld() {
		return topPaperGSMOld;
	}

	public void setTopPaperGSMOld(String topPaperGSMOld) {
		this.topPaperGSMOld = topPaperGSMOld;
	}

	public String getTopPaperGSM() {
		return topPaperGSM;
	}

	public void setTopPaperGSM(String topPaperGSM) {
		this.topPaperGSM = topPaperGSM;
	}



	public String getTopPaperBFOld() {
		return topPaperBFOld;
	}

	public void setTopPaperBFOld(String topPaperBFOld) {
		this.topPaperBFOld = topPaperBFOld;
	}

	public String getTopPaperBF() {
		return topPaperBF;
	}

	public void setTopPaperBF(String topPaperBF) {
		this.topPaperBF = topPaperBF;
	}

	public String getTopPaperDecalOld() {
		return topPaperDecalOld;
	}

	public void setTopPaperDecalOld(String topPaperDecalOld) {
		this.topPaperDecalOld = topPaperDecalOld;
	}

	public String getTopPaperDecal() {
		return topPaperDecal;
	}

	public void setTopPaperDecal(String topPaperDecal) {
		this.topPaperDecal = topPaperDecal;
	}

	public String getTopPaperRemark() {
		return topPaperRemark;
	}

	public void setTopPaperRemark(String topPaperRemark) {
		this.topPaperRemark = topPaperRemark;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public int getAvailablePieces() {
		return availablePieces;
	}

	public void setAvailablePieces(int availablePieces) {
		this.availablePieces = availablePieces;
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
