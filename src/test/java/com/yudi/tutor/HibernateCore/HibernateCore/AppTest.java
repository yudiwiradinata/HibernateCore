package com.yudi.tutor.HibernateCore.HibernateCore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Array;
import com.yudi.tutor.HibernateCore.common.Category;
import com.yudi.tutor.HibernateCore.common.Stock;
import com.yudi.tutor.HibernateCore.common.StockDailyRecord;
import com.yudi.tutor.HibernateCore.common.StockDetail;
import com.yudi.tutor.HibernateCore.persistence.HibernateUtil;

/**
 * Unit test for simple App.
 */
public class AppTest {
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
	public void testSelect(){
		session.beginTransaction();
		//List<Stock> stocks = session.createQuery("from Stock").list();	
		Stock stock = (Stock) session.get(Stock.class, 23);
		
		List list = stock.getStockDailyRecord();
		StockDetail sd = stock.getStockDetail();
		
		System.out.println("  "+stock.getStockName()+"  "+sd.getCompName());
		
	
		 
		for(Iterator iter = list.iterator();iter.hasNext();){
			StockDailyRecord sdr = (StockDailyRecord) iter.next();
			 System.out.println(stock.getStockName()+"  "+sd.getCompName()+"  "+sdr.getRecordId());
		     System.out.println(stock.getStockName()+"  "+sd.getCompName()+"  "+sdr.getDate());
			
		}
		/*
		for(Stock stock : stocks){
		
			if(stock.getStockDailyRecord() != null){
				List<StockDailyRecord> stockDailyRecord = stock.getStockDailyRecord();
				for (int i = 0; i < stockDailyRecord.size(); i++) {
					System.out.println("   "+stock.getStockId()+"  "+stockDailyRecord.get(i).getPriceOpen());
				}
			}
			
			
		}*/
		
		
	}
	public void testManyToMany() {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Stock stock = new Stock();
			stock.setStockCode("K34");
			stock.setStockName("YudiWiran4");

			Stock stock2 = new Stock();
			stock2.setStockCode("2K34");
			stock2.setStockName("2YudiWira");

			Category category1 = new Category();
			category1.setName("CATGORY 1");
			category1.setDesc("CATGORY 1 DESC");

			Category category2 = new Category();
			category2.setName("CATGORY 2");
			category2.setDesc("CATGORY 2 DESC");

			Category category3 = new Category();
			category3.setName("CATGORY 3");
			category3.setDesc("CATGORY 3 DESC");

			List<Category> categories = new ArrayList<Category>();
			categories.add(category3);
			categories.add(category2);

			stock.setCategories(categories);
			stock2.setCategories(categories);

			session.save(stock2);
			session.save(stock);

			tx.commit();

		} catch (RuntimeException e) {
			// TODO: handle exception
			try {
				tx.rollback();
			} catch (RuntimeException e2) {
				// TODO: handle exception
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public void testInsertOneToMany() throws ParseException {
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("K34");
		stock.setStockName("YudiWiran4");

		StockDailyRecord stockDailyRecords = new StockDailyRecord();
		stockDailyRecords.setPriceOpen(new Float("1.2"));
		stockDailyRecords.setPriceClose(new Float("1.1"));
		stockDailyRecords.setPriceChange(new Float("10.0"));
		stockDailyRecords.setVolume(3000000L);
		stockDailyRecords.setDate(new Date());

		StockDailyRecord stockDailyRecords2 = new StockDailyRecord();
		stockDailyRecords2.setPriceOpen(new Float("1.2"));
		stockDailyRecords2.setPriceClose(new Float("1.1"));
		stockDailyRecords2.setPriceChange(new Float("10.0"));
		stockDailyRecords2.setVolume(3000000L);
		stockDailyRecords2.setDate(new SimpleDateFormat("yyyy-MM-dd")
				.parse("2010-05-20"));

		stockDailyRecords.setStock(stock);
		stockDailyRecords2.setStock(stock);
		stock.getStockDailyRecord().add(stockDailyRecords);
		stock.getStockDailyRecord().add(stockDailyRecords2);

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompDesc("Tes Desc 4");
		stockDetail.setCompName("Praweda 4");
		stockDetail.setRemark("Y");
		stockDetail.setListedDate(new Date());

		stockDetail.setStock(stock);
		stock.setStockDetail(stockDetail);

		session.save(stock);
		session.save(stockDailyRecords);
		session.save(stockDailyRecords2);

		session.getTransaction().commit();
		session.close();
		System.out.println("Done");

	}

	public void testNativeQuery() {

		String sql = "select * from STOCK s where s.stock_code = :stockCode";
		Query query = session.createSQLQuery(sql).addEntity(Stock.class);
		query.setParameter("stockCode", "K34");

		List<Stock> result = query.list();

		for (Stock s : result) {
			System.out.println("Test " + s.getStockName());
		}

		Query query2 = session
				.createSQLQuery(
						"select s.stock_code from STOCK s where s.stock_code = :stockCode")
				.setParameter("stockCode", "K34");

		List result2 = query2.list();

		for (int i = 0; i < result2.size(); i++) {
			System.out.println(result2.get(i));
		}

	}
		
	public void testInsertOneToOne() {
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("T@2");
		stock.setStockName("YudiT");

		StockDetail stockDetail = new StockDetail();
		//stockDetail.setCompDesc("Tes Desc");
		//stockDetail.setCompName("Praweda");
		stockDetail.setRemark("Y");
		stockDetail.setListedDate(new Date());

		stockDetail.setStock(stock);
		stock.setStockDetail(stockDetail);

		session.save(stock);
		session.getTransaction().commit();
		session.close();
	}

		
	public void testInsert() {
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("K30");
		stock.setStockName("YudiWiran");

		session.save(stock);
		session.getTransaction().commit();
		session.close();
	}

}
