package com.hand.action;

import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hand.Dao.CustomerDao;
import com.hand.Dao.PageDao;
import com.hand.POJO.Customer;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String uname;
	private String pword;
	private int pagecount;
	@Override
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(); 
/*		
		if(uname.equals("admin")){
			ServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			System.out.println("{\"uname\":\"" + uname  + "}");  
			out.print("{\"uname\":\"" + uname  + "}");  
	          
	        out.flush();  
	        out.close();  
		}
		*/
		
		
		
			 if (uname == null || uname.trim().equals("")||pword == null || pword.trim().equals(""))
		      {
		        	session.setAttribute("login_message", "用户名或者密码不能为空！");
		        	return "input";
		      }else{
		    	  CustomerDao customerDao = new CustomerDao();  
		 		 Customer customer = new Customer(); 
		 		 customer.setFirst_name(uname);
		 		 customer.setLast_name(pword);
		 	        if(customerDao.check(customer)) {
		 	        	session.removeAttribute("login_message");
		 	        	PageDao pageDao = new PageDao();
		 	        	int pagecount = pageDao.getPageCount(50);
		 	        	System.out.println("获得的总页数："+pagecount);
		 	        	session.setAttribute("pagecount", pagecount);
		 	        	return SUCCESS;  
		 	        }
		 	        session.setAttribute("login_message", "用户名或者密码错误！");
		 	        return "input";
		      }
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
	
	/*public void validate()
	   {
	      if (uname == null || uname.trim().equals(""))
	      {
//	         addFieldError("uname","The name is required");
	    	  HttpSession session = ServletActionContext.getRequest().getSession();  
	        	session.setAttribute("login_message", "error");  
	      }
	      if (pword == null || pword.trim().equals(""))
	      {
	         addFieldError("pword","The pword is required");
	      }
	   }
*/
}
