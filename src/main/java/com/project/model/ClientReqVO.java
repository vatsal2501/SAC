package com.project.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "clientreq_table")
public class ClientReqVO extends Auditable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "clientreq_id")
	private int clientreqId;

	@Column(name = "clientitems")
	private String clientItems;

	@Column(name = "length")
	private String length;

	@Column(name = "width")
	private String width;

	@Column(name = "height")
	private String height;

	@Column(name = "printing")
	private String printing;

	@Column(name = "ply")
	private String ply;
	
	@Column(name="decal")
	private String decal;

	@Column(name="cutting")
	private String cutting;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private ClientVO clientVO;

	@ManyToOne
	@JoinColumn(name = "papertype_id")
	private PaperTypeVO papertypeVO;

	@ManyToOne
	@JoinColumn(name = "login_id")
	private LoginVO LoginVO;

	@Column(name = "entry_date")
	private Date entryDate;

	@Column(name = "status")
	private boolean status = true;

	@Transient
	private List<PlyDetailsVO> plyDetailsList;

	public int getClientreqId() {
		return clientreqId;
	}

	public void setClientreqId(int clientreqId) {
		this.clientreqId = clientreqId;
	}

	public String getClientItems() {
		return clientItems;
	}

	public void setClientItems(String clientItems) {
		this.clientItems = clientItems;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getPrinting() {
		return printing;
	}

	public void setPrinting(String printing) {
		this.printing = printing;
	}

	public String getPly() {
		return ply;
	}

	public void setPly(String ply) {
		this.ply = ply;
	}

	public ClientVO getClientVO() {
		return clientVO;
	}

	public void setClientVO(ClientVO clientVO) {
		this.clientVO = clientVO;
	}

	public LoginVO getLoginVO() {
		return LoginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		LoginVO = loginVO;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public PaperTypeVO getPapertypeVO() {
		return papertypeVO;
	}

	public void setPapertypeVO(PaperTypeVO papertypeVO) {
		this.papertypeVO = papertypeVO;
	}

	public List<PlyDetailsVO> getPlyDetailsList() {
		return plyDetailsList;
	}

	public void setPlyDetailsList(List<PlyDetailsVO> plyDetailsList) {
		this.plyDetailsList = plyDetailsList;
	}

	public String getDecal() {
		return decal;
	}

	public void setDecal(String decal) {
		this.decal = decal;
	}

	public String getCutting() {
		return cutting;
	}

	public void setCutting(String cutting) {
		this.cutting = cutting;
	}


}
