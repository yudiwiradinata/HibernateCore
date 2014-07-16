package com.yudi.tutor.HibernateCore.common;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="stock")
public class Stock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer stockId;
	private String stockCode;
	private String stockName;
	private StockDetail stockDetail;
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public Stock(Integer stockId, String stockCode, String stockName) {		
		this.stockId = stockId;
		this.stockCode = stockCode;
		this.stockName = stockName;
	}
	
	public Stock(Integer stockId, String stockCode, String stockName, StockDetail stockDetail) {		
		this.stockId = stockId;
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockDetail = stockDetail;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="STOCK_ID", unique=true, nullable=false, precision=11, scale=0)
	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	@Column(name="STOCK_CODE", length=10, nullable=false)
	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	@Column(name="STOCK_NAME", length=10, nullable=false)
	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="stock", cascade = CascadeType.ALL)
	public StockDetail getStockDetail() {
		return stockDetail;
	}
	
	public void setStockDetail(StockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}
	
	
	

}
