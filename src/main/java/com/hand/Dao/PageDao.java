package com.hand.Dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.hand.POJO.Customer;
import com.hand.util.HibernateUtil;
@Repository
public class PageDao {
	private Session session;  
    private Transaction tx;  
    
    public PageDao(){
    	session = HibernateUtil.getSession();  
    }
	public int  getPageCount(){
		int rows = 0; 
   	 tx = session.beginTransaction();
//   	 List<Customer> customer = session.createQuery("FROM Customer").setFirstResult((pagenum-1)*pagesize).setMaxResults(pagesize).list();
//   	 List list = session.createQuery("select count(*) FROM Customer").list();
////   	 Iterator it = list.iterator(); 
//   	 Iterator iterator = 
//				  list.iterator();
//   	 for (; iterator.hasNext();iterator.next()){
//   		 pagecount = pagecount+1;;
//   	 }
   	Criteria cr = session.createCriteria(Customer.class);
   	Number num = (Number) cr.setProjection(Projections.rowCount()).uniqueResult();
   	
//   	rows = (Integer) cr.setProjection(Projections.rowCount()).uniqueResult();
   	
   	rows = num.intValue();
   	
   	System.out.println("计算出来的总数据条数："+rows);
   	 tx.commit();
	        HibernateUtil.closeSession();  
	        if (rows % 50 == 0) {  
	            return rows / 50;  
	        } else {  
	            return rows / 50 + 1;  
	        }  
   }
}
