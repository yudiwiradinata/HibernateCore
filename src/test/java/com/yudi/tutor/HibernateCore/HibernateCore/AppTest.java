package com.yudi.tutor.HibernateCore.HibernateCore;

import java.util.Date;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.yudi.tutor.HibernateCore.common.Stock;
import com.yudi.tutor.HibernateCore.common.StockDetail;
import com.yudi.tutor.HibernateCore.persistence.HibernateUtil;


/**
 * Unit test for simple App.
 */
public class AppTest{
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */

	Session session = null;
	
	@Before
	public void init() {
		System.out.println("Maven + Hibernate 4 + MySQL");
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	@Test	
	public void testInsertOneToOne(){
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("K29");
		stock.setStockName("YudiWiran2");		
		
		StockDetail stockDetail = new StockDetail();				
		stockDetail.setCompDesc("Tes Desc");
		stockDetail.setCompName("Praweda");
		stockDetail.setRemark("Y");
		stockDetail.setListedDate(new Date());
		
		stockDetail.setStock(stock);
		stock.setStockDetail(stockDetail);
		
		session.save(stock);
		session.getTransaction().commit();
		session.close();
	}
	
	public void testInsert(){
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("K26");
		stock.setStockName("YudiWiran");		
		
		session.save(stock);
		session.getTransaction().commit();
		session.close();
	}

}
