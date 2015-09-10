package com.hand.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.Dao.AddressDao;
import com.hand.Dao.CustomerDao;
import com.hand.Dao.PageDao;
import com.hand.POJO.Address;
import com.hand.POJO.Customer;
import com.hand.util.HibernateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class doCustomerAction extends ActionSupport {
	private String first_name;
	private String last_name;
	private String email;
	private Address address;
	private int address_id;
	private int delet_id;
	private int pagenum = 1;
	
//	CustomerDao customerDao;
//	= new CustomerDao();
	Customer customer = new Customer();
	AddressDao addressDao = new AddressDao();
	
	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	CustomerDao customerDao =(CustomerDao) ac.getBean("customerDao");
    
	//添加用户
	public String add() throws Exception {
		Date date = new Date();
		 address = addressDao.findById(address_id);
		Timestamp time=new Timestamp (date.getTime());
		 customer.setFirst_name(first_name);
		 customer.setLast_name(last_name);
		 customer.setAddress(address);
		 customer.setEmail(email);
		 customer.setStore_id(1);
		 customer.setCreate_date(time);
		 customerDao.create(customer);
		 HibernateUtil.closeSession();
		return SUCCESS;
	}
	
	//删除用户
	public String delet() throws Exception {
		customerDao.delete(delet_id);
		HibernateUtil.closeSession();
		return SUCCESS;
	}
	//更新用户
	public String update() throws Exception{
		 address = addressDao.findById(address_id);
		customerDao.update(delet_id,first_name,last_name,email,address);
		HibernateUtil.closeSession();
		return SUCCESS;
	}
	
	//查询用户列表
	public String list() throws Exception {
		List<Customer> customerList = customerDao.select(50,pagenum);
		ActionContext.getContext().put("customerList", customerList);
		/* 获取address列表 */
		 List<Address> addressList = addressDao.select();
		ActionContext.getContext().put("addressList", addressList);
		HibernateUtil.closeSession();
		return SUCCESS;
	}
	
	//跳转到更新用户页面之前，将用户信息和地址表加载出来
	public String toupdate(){
		 List<Address> addressList = addressDao.select();
		ActionContext.getContext().put("addressList", addressList);
		Customer customer = customerDao.find(delet_id);
		ActionContext.getContext().put("customer", customer);
		HibernateUtil.closeSession();
		return "toupdate";
	}
	
	//跳转到新增用户页面之前，先加载地址列表
	public String toadd(){
		/* 获取address列表 */
		 List<Address> addressList = addressDao.select();
		ActionContext.getContext().put("addressList", addressList);
		HibernateUtil.closeSession();
		return "toadd";
	}
	
	
	public int getDelet_id() {
		return delet_id;
	}
	
	public void setDelet_id(int delet_id) {
		this.delet_id = delet_id;
	}

	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	
}
