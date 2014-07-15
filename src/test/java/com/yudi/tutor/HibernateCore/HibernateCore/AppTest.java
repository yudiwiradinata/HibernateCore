package com.yudi.tutor.HibernateCore.HibernateCore;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.yudi.tutor.HibernateCore.common.Stock;
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
		System.out.println("Maven + Hibernate + MySQL");
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	@Test
	public void testInsert(){
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("K21");
		stock.setStockName("Yudi");		
		
		session.save(stock);
		session.getTransaction().commit();
		session.close();
	}

}
