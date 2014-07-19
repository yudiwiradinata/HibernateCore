package com.yudi.tutor.HibernateCore.common;

import java.awt.Window.Type;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "STOCK_DAILY_RECORD", catalog = "test", uniqueConstraints = @UniqueConstraint(columnNames = "DATE"))
public class StockDailyRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RECORD_ID", unique = true, nullable = false)
	private Integer recordId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="STOCK_ID", nullable=false)	
	private Stock stock;

	@Column(name = "PRICE_OPEN", precision = 6)
	private Float priceOpen;

	@Column(name = "PRICE_CLOSE", precision = 6)
	private Float priceClose;
	
	@Column(name="PRICE_CHANGE", precision= 6)
	private Float priceChange;
	
	@Column(name="VOLUME")
	private Long volume;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE", unique=true, length=10, nullable=false)
	private Date date;

	public StockDailyRecord() {
		// TODO Auto-generated constructor stub
	}		
	
	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Float getPriceOpen() {
		return priceOpen;
	}

	public void setPriceOpen(Float priceOpen) {
		this.priceOpen = priceOpen;
	}

	public Float getPriceClose() {
		return priceClose;
	}

	public void setPriceClose(Float priceClose) {
		this.priceClose = priceClose;
	}

	public Float getPriceChange() {
		return priceChange;
	}

	public void setPriceChange(Float priceChange) {
		this.priceChange = priceChange;
	}

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
