package com.hand.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hand.Dao.AddressDao;
import com.hand.Dao.CustomerDao;
import com.hand.Dao.PageDao;
import com.hand.POJO.Address;
import com.hand.POJO.Customer;
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
	
	public String add() throws Exception {
		CustomerDao customerDao = new CustomerDao();
		Date date = new Date();
		AddressDao addressDao = new AddressDao();
		 address = addressDao.findById(address_id);
		Timestamp time=new Timestamp (date.getTime());
		 Customer customer = new Customer();
		 customer.setFirst_name(first_name);
		 customer.setLast_name(last_name);
		 customer.setAddress(address);
		 customer.setEmail(email);
		 customer.setStore_id(1);
		 customer.setCreate_date(time);
		 customerDao.create(customer);
		 
		return SUCCESS;
	}
	
	public String delet() throws Exception {
		CustomerDao customerDao = new CustomerDao();
		customerDao.delete(delet_id);
		return SUCCESS;
	}
	public String update() throws Exception{
		CustomerDao customerDao = new CustomerDao();
		Customer customer = new Customer();
		AddressDao addressDao = new AddressDao();
		 address = addressDao.findById(address_id);
		customerDao.update(delet_id,first_name,last_name,email,address);
		return SUCCESS;
	}
	
	public String list() throws Exception {
//		int pagesize = 50;
		CustomerDao customerDao = new CustomerDao();
		List<Customer> customerList = customerDao.select(50,pagenum);
		ActionContext.getContext().put("customerList", customerList);
		/* 获取address列表 */
		AddressDao addressDao = new AddressDao();
		 List<Address> addressList = addressDao.select();
		ActionContext.getContext().put("addressList", addressList);
		PageDao pageDao = new PageDao();
		int pagecount = pageDao.getPageCount(50);
		System.out.println("获得的总页数："+pagecount);
		return SUCCESS;
	}
	
	public String toupdate(){
		AddressDao addressDao = new AddressDao();
		 List<Address> addressList = addressDao.select();
//		 Iterator<Address> address_it = addressList.iterator();
		ActionContext.getContext().put("addressList", addressList);
		CustomerDao customerDao = new CustomerDao();
		Customer customer = customerDao.find(delet_id);
//		List<Customer> clist ;
//		clist.add(customer);
//		ActionContext.getContext().put("clist", clist);
		ActionContext.getContext().put("customer", customer);
//		System.out.println(customer);
		return "toupdate";
	}
	
	public int getDelet_id() {
		/* 获取address列表 */
		AddressDao addressDao = new AddressDao();
		 List<Address> addressList = addressDao.select();
//		 Iterator<Address> address_it = addressList.iterator();
		ActionContext.getContext().put("addressList", addressList);
		return delet_id;
	}

	public String toadd(){
		/* 获取address列表 */
		AddressDao addressDao = new AddressDao();
		 List<Address> addressList = addressDao.select();
//		 Iterator<Address> address_it = addressList.iterator();
		ActionContext.getContext().put("addressList", addressList);
		return "toadd";
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
