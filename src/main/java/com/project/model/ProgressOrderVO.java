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
@Table(name = "order_transaction_table")
public class ProgressOrderVO extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "progress_order_id")
	private int progressOrderId;

	// will contain the paperType for top paper
	@ManyToOne
	@JoinColumn(name = "papertype_id")
	private PaperTypeVO papertypeVO;

	// to save new client items, length, width, height, decal, cutting,
	@ManyToOne
	@JoinColumn(name = "clientreq_id")
	private ClientReqVO clientReqVO;

	// will contain order Details orderId , quantity, 2ply
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderVO orderVO;
	
	@Column(name = "order_quantity")
	private String orderQuantity;

	@Column(name = "flute")
	private String flute;

	// will contain client info : clientName
	@ManyToOne
	@JoinColumn(name = "client_id")
	private ClientVO clientVO;

	@ManyToOne
	@JoinColumn(name = "login_id")
	private LoginVO LoginVO;

	@Column(name = "entry_date")
	private Date entryDate;
	
	//to terminate the process
	@Column(name = "status")
	private boolean status = true;

	
	@Column(name = "process_status") 
	private String processStatus;
		
	
	/*this feilds will be included
	// to track down the status of the process
	// which user has done the work
	@ManyToOne
	@JoinColumn(name = "corrugation")
	private LoginVO corrugationSupervisor;
	
	@ManyToOne
	@JoinColumn(name = "pasting")
	private LoginVO pastingSupervisor;
	
	@ManyToOne
	@JoinColumn(name = "rotary")
	private LoginVO rotarySupervisor;
	
	@ManyToOne
	@JoinColumn(name = "rs4")
	private LoginVO rs4Supervisor;
	
	@ManyToOne
	@JoinColumn(name = "stiching")
	private LoginVO stichingWSupervisor;
	
	@ManyToOne
	@JoinColumn(name = "bundle")
	private LoginVO bundleSupervisor;
	
	@ManyToOne
	@JoinColumn(name = "dispatch")
	private LoginVO dispatchSupervisor;
	
	*/
	
	@Transient
	private List<OrderPlyDetailsVO> OrderPlyDetailsList;

	public ClientReqVO getClientReqVO() {
		return clientReqVO;
	}

	public void setClientReqVO(ClientReqVO clientReqVO) {
		this.clientReqVO = clientReqVO;
	}

	public OrderVO getOrderVO() {
		return orderVO;
	}

	public void setOrderVO(OrderVO orderVO) {
		this.orderVO = orderVO;
	}

	public String getFlute() {
		return flute;
	}

	public void setFlute(String flute) {
		this.flute = flute;
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

	public String getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public int getProgressOrderId() {
		return progressOrderId;
	}

	public void setProgressOrderId(int progressOrderId) {
		this.progressOrderId = progressOrderId;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public List<OrderPlyDetailsVO> getOrderPlyDetailsList() {
		return OrderPlyDetailsList;
	}

	public void setOrderPlyDetailsList(List<OrderPlyDetailsVO> orderPlyDetailsList) {
		OrderPlyDetailsList = orderPlyDetailsList;
	}
	
	
	
}
