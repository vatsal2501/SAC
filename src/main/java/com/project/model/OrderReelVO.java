package com.project.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "order_reel_table")
public class OrderReelVO extends Auditable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int Id;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private OrderVO orderVO;
	
	@Column(name = "reel_number")
	private String reelNumber;
	
	@Column(name = "is_part_reel")
	private boolean partReel;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public OrderVO getOrderVO() {
		return orderVO;
	}

	public void setOrderVO(OrderVO orderVO) {
		this.orderVO = orderVO;
	}

	public String getReelNumber() {
		return reelNumber;
	}

	public void setReelNumber(String reelNumber) {
		this.reelNumber = reelNumber;
	}

	public boolean isPartReel() {
		return partReel;
	}

	public void setPartReel(boolean partReel) {
		this.partReel = partReel;
	}

}
