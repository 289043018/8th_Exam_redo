<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <link rel="stylesheet" href="<%=path %>/css/style1.css"> 
</head>
<body>
	<div class="container">
		<div class="head">
			<a class="btn btn-primary"
				href="<%= request.getContextPath() %>/logout.action">退出</a>
		</div>
		<div class="body">
			<div class="menu">
				<ul id="mytab" class="nav nav-tabs nav-stacked" role="tablist">
					<li role="presentation" class=""><a href="#">Customer管理<span
							class="glyphicon glyphicon-chevron-right"></span></a></li>
					<li role="presentation"><a href="#">Film设置<span
							class="glyphicon glyphicon-chevron-right"></span></a></li>
				</ul>
			</div>
			<div class="kehuguanli">
				<div class="cust">
					<h3>客户管理</h3>
				</div>


<div class="panel panel-info">
					<div class="panel-heading">
						<div>新建用户</div>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<form class="form-horizontal" role="form" action="<%=request.getContextPath()%>/doCustomer_update!update.action?" Method="post" name="loginForm">
                    
                     <s:iterator id="customer" value="customer">
										<tr class="success">
							<td>
								<div class="form-group">
									<label class="col-md-4 control-label">ID：</label>
									<div class="col-md-4">
										<input type="text" name="delet_id" readonly="readonly" value="${id}" class="form-control">
									</div>
								</div>
								<div class="form-group">
                        <label class="col-md-4 control-label">Frist Name：</label>
                        <div class="col-md-4">
                            <input type="text" name="first_name" value="${first_name}"
											class="form-control" placeholder="Frist Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Last Name：</label>
                        <div class="col-md-4">
                            <input type="text" name="last_name" value="${last_name}"
											class="form-control" placeholder="Last Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Email：</label>
                        <div class="col-md-4">
                            <input type="text" name="email" value="${email}"
											class="form-control" placeholder="Email">
                        </div>
                    </div>
								

										
                    <div class="form-group">
                        <label class="col-md-4 control-label">Address：</label>
                        <div class="dropdown">
                         <s:select name="address_id" list="addressList"
											listKey="address_id" listValue="address" headerKey=""
											headerValue="==请选择==" />   
							</div>
                    </div>
                    </tr>
                    </s:iterator> 
                    <div class="form-group">
                        <div class="col-sm-offset-4 col-md-4">
                            <button type="submit"
											class="btn btn-default">更改</button>
                            <button type="submit"
											class="btn btn-default">取消</button>
                        </div>
                    </div>
                
							</form>

						</div>
					</div>
				</div>








			</div>
		</div>
	</div>
	
	<script src="../js/jquery-2.1.4.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="AJAX.js"></script>
</body>
</html>