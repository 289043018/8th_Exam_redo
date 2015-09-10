package com.hand.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.Dao.CustomerDao;
import com.hand.Dao.PageDao;
import com.hand.POJO.Customer;
import com.hand.util.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String uname;
	private String pword;
	private int pagecount;
//	@Resource(name="customerDao")
	@Autowired 
//	private CustomerDao customerDao ;
//	=new CustomerDao();
	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	CustomerDao customerDao =(CustomerDao) ac.getBean("customerDao");
	
	 Customer customer = new Customer(); 
	 private PageDao pageDao= new PageDao();
	 
	public String Login() throws Exception {
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
		        	return "tologin";
		      }else{
		    	  
		 		 customer.setFirst_name(uname);
		 		 customer.setLast_name(pword);
		 	        if(customerDao.check(customer)) {
		 	        	session.removeAttribute("login_message");
		 	        	int pagecount = pageDao.getPageCount();
		 	        	System.out.println("获得的总页数："+pagecount);
		 	        	session.setAttribute("pagecount", pagecount);
		 	        	HibernateUtil.closeSession();
		 	        	return SUCCESS;  
		 	        }
		 	        session.setAttribute("login_message", "用户名或者密码错误！");
		 	        return "tologin";
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
}
