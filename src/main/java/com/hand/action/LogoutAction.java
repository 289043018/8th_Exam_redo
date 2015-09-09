package com.hand.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.utility.Execute;

public class LogoutAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
	    HttpServletRequest request = ServletActionContext.getRequest();
	    HttpSession session = request.getSession();
	    session.invalidate();
		return SUCCESS;
	}
}
