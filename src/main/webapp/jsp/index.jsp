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
				href="<%= request.getContextPath() %>/Logout_Logout!Logout.do">退出</a>
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
						<div>客户列表</div>
						<a class="btn btn-primary btn-md" name="add"
												href="<%= request.getContextPath() %>/doCustomer_toadd!toadd.do">新建</a>

					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table
								class="table table-striped table-bordered table-hover table-condensed">
								<thead>
									<tr class="active">
										<th>操作</th>
										<th>Frist Name</th>
										<th>Last Name</th>
										<th>Address</th>
										<th>Email</th>
										<th>Customer_ID</th>
										<th>LastUpdate</th>
									</tr>
								</thead>
								<tbody>

									<s:iterator id="customer" value="customerList">
										<tr class="success">
											<td>
											<a class="btn btn-primary btn-sm" name="delet_id"
											href="<%= request.getContextPath() %>/doCustomer_toupdate!toupdate.do?delet_id=${id}">编辑</a>
											<a class="btn btn-primary btn-sm" name="delet_id"
											href="<%= request.getContextPath() %>/doCustomer_delet!delet.do?delet_id=${id}">删除</a>
											<td align="center" name="first_name">${first_name}</td>
											<td align="center" name="last_name">${last_name}</td>
											<td align="center" name="address">${address.address}</td>
											<td align="center" name="email">${email}</td>
											<td width="20px" align="center" name="customer_id">${id}</td>
											<td align="center" name="last_update">${lastupdate}</td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</div>
					</div>
					<div class="panel-footer">
						<div class="fenpage">
							<nav class="bottom_nav">
							<ul class="pagination">
								<li><a href="<%= request.getContextPath() %>/listCustomer!list.do?pagenum=1">&laquo;</a></li>
								<%
								/* String str =(String) session.getAttribute("pagecount");
								int pagecount = Integer.parseInt(str); */
								
								int pagecount = Integer.parseInt(String.valueOf(session.getAttribute("pagecount")  != null ? session.getAttribute("pagecount"): "0").trim());
								%>
								<%
									for (int curpage = 1; curpage <= pagecount; curpage++) {
								%>
								<li><a href="<%= request.getContextPath() %>/listCustomer!list.do?pagenum=<%=curpage%>"><%=curpage%></a></li>
								<%
									} 
								%>
								<li><a href="<%= request.getContextPath() %>/listCustomer!list.do?pagenum=<%=pagecount %>">&raquo;</a></li>
							</ul>
							</nav>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLable">New Massage</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" action="#" Method="post"
						name="loginForm">
						<div class="form-group">
							<label class="col-md-4 control-label">Frist Name：</label>
							<div class="col-md-4">
								<input type="text" name="uname" class="form-control"
									placeholder="Frist Name">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Last Name：</label>
							<div class="col-md-4">
								<input type="password" name="pword" class="form-control"
									placeholder="Last Name">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Email：</label>
							<div class="col-md-4">
								<input type="password" name="pword" class="form-control"
									placeholder="Email">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Address：</label>
							<div class="dropdown">
								<button class="btn btn-default" id="dlabel" type="button"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
									Address <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
									<li><a class="active">1</a></li>
									<li><a>2</a></li>
									<li><a>3</a></li>
									<li><a>4</a></li>
									<li><a>5</a></li>
								</ul>
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-4 col-md-4">
								<button type="submit" class="btn btn-default">新建</button>
								<button type="submit" class="btn btn-default">取消</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
 	<script src="../js/jquery-2.1.4.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="AJAX.js"></script> 
</body>
</html>