package com.yudi.tutor.HibernateCore.common;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="stock", catalog="test")
public class Stock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer stockId;
	private String stockCode;
	private String stockName;
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public Stock(Integer stockId, String stockCode, String stockName) {		
		this.stockId = stockId;
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	

}
