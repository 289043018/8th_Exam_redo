package com.hand.Dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Iterator;  
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;  
import org.hibernate.Session;  
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.hand.POJO.Address;
import com.hand.POJO.Customer;
import com.hand.POJO.Payment;
import com.hand.POJO.Rental;
import com.hand.util.HibernateUtil;
import com.opensymphony.xwork2.Result;  
public class CustomerDao {
	private Session session;  
	private Transaction tx;  

	public CustomerDao(){
		session = HibernateUtil.getSession();  
	}


	/*  
	 * 将User对象插入到数据库中  
	 * @param user  
	 */  
	public void create(Customer customer) {  
		try {  
			tx = session.beginTransaction();  
			session.save(customer);
			System.out.println("插入了一个用户");
			tx.commit();  
		} catch (HibernateException e) { 
			System.out.println("插入事务回滚了");
			HibernateUtil.rollback(tx);  
		} finally {  
			HibernateUtil.closeSession();  
		}  
	}  

	public void delete(int customer_id) {  
		try {  
			tx = session.beginTransaction();
			Customer customer = 
					(Customer)session.get(Customer.class, customer_id);
			session.delete(customer);
			System.out.println("删除了一个用户");
			tx.commit();  
		} catch (HibernateException e) {  
			HibernateUtil.rollback(tx);
			System.out.println("删除事务回滚了");
		} finally {  
			HibernateUtil.closeSession();  
		}  
	}  

	public Customer find(int id) {  
		Customer customer = null; 
		try {  
			tx = session.beginTransaction();  
			customer = (Customer) session.get(Customer.class, id); 
			System.out.println("查找到了："+customer.getFirst_name());
			tx.commit();
		} catch (HibernateException e) {  
			HibernateUtil.rollback(tx);
			System.out.println("查找id事务回滚了");
		} finally {  
			HibernateUtil.closeSession();  
		}
		return customer;
	}

	public List<Customer> select(int pagesize,int pagenum){
		tx = session.beginTransaction();
		List<Customer> customer = session.createQuery("FROM Customer").
				setFirstResult((pagenum-1)*pagesize).setMaxResults(pagesize).list();
		tx.commit();
		HibernateUtil.closeSession();  
		return customer;
	}


	public void update(int id,String first_name,String last_name,String email,Address address) {  
		try {  
			tx = session.beginTransaction(); 
			Customer customer = (Customer) session.get(Customer.class, id);
			customer.setFirst_name(first_name);
			customer.setLast_name(last_name);
			customer.setEmail(email);
			customer.setAddress(address);
			session.update(customer); 
			System.out.println("更新了用户："+customer.getFirst_name());
			tx.commit();  
		} catch (HibernateException e) {  
			HibernateUtil.rollback(tx);
			System.out.println("更新事务回滚了");
		} finally {  
			HibernateUtil.closeSession();  
		}
	}  

	public boolean check(Customer customer) {  
		tx = session.beginTransaction();  
		String sql = "select last_name from Customer where first_name='"+customer.getFirst_name()+"'";  
		List list = session.createQuery(sql).list();  
		if(!list.isEmpty()) {  
			Iterator it = list.iterator();  
			while(it.hasNext()) {  
				String get = (String) it.next();  
				System.out.println(get);  
				if(get.equals(customer.getLast_name())) {  
					HibernateUtil.closeSession();  
					return true;  
				}  
			}  
		}  
		HibernateUtil.closeSession();  
		return false;     
	}  
}
