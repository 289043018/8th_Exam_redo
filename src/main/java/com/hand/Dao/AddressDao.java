package com.hand.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hand.POJO.Address;
import com.hand.util.HibernateUtil;

public class AddressDao {
	 private Session session;  
	    private Transaction tx;  
	    
	    public AddressDao(){
	    	session = HibernateUtil.getSession();  
	    }
	    
	    public List<Address> select(){
	    	 tx = session.beginTransaction();  
	    	 List<Address> address = session.createQuery("FROM Address").list(); 	   
	    	 tx.commit();
		        HibernateUtil.closeSession();  
	    	return address;
	    }
	    
	    public Address findById(int addressId) {
			return (Address) session.get(Address.class, addressId);
		}
  
}
