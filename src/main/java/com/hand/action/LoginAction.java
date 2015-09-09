package com.hand.action;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hand.Dao.CustomerDao;
import com.hand.POJO.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String uname;
	private String pword;
	@Override
	public String execute() throws Exception {
		 CustomerDao customerDao = new CustomerDao();  
		 Customer customer = new Customer(); 
		 customer.setFirst_name(uname);
		 customer.setLast_name(pword);
//		 CustomerDao customerDao2 = new CustomerDao();
//		 List<Customer> customerList = customerDao2.select();
	        if(customerDao.check(customer)) {  
//	    		ActionContext.getContext().put("customerList", customerList);
	            return SUCCESS;  
	        } 
	        return "fail";
	}
	

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}

}
