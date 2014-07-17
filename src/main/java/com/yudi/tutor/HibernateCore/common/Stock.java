package com.yudi.tutor.HibernateCore.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK")
public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false, precision = 11, scale = 0)
	private Integer stockId;

	@Column(name = "STOCK_CODE", length = 10, nullable = false)
	private String stockCode;

	@Column(name = "STOCK_NAME", length = 10, nullable = false)
	private String stockName;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.ALL)
	private StockDetail stockDetail;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.ALL)
	private List<StockDailyRecord> stockDailyRecord = new ArrayList<StockDailyRecord>();

	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public Stock(Integer stockId, String stockCode, String stockName) {
		this.stockId = stockId;
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public Stock(Integer stockId, String stockCode, String stockName,
			StockDetail stockDetail) {
		this.stockId = stockId;
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockDetail = stockDetail;
	}

	public List<StockDailyRecord> getStockDailyRecord() {
		return stockDailyRecord;
	}

	public void setStockDailyRecord(List<StockDailyRecord> stockDailyRecord) {
		this.stockDailyRecord = stockDailyRecord;
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

	public StockDetail getStockDetail() {
		return stockDetail;
	}

	public void setStockDetail(StockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}

}
