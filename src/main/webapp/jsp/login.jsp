<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false"%>
    <%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link href="../css/bootstrap.min.css" type="text/css" rel="stylesheet">
 <link rel="stylesheet" href="<%=path %>/css/style.css"> 
<script type="text/javascript">
	function check(form) {
		if(document.forms.loginForm.uname.value==""||document.forms.loginForm.pword.value==""){
			alert("请输入用户名或密码！");
			document.forms.loginForm.userName.focus();
			return false;
		};
	};
	function chakan(){
		$.post("<%=path%>/login.action",{uname:"admin"},function(data){
			$("#result").text(data);
		});
	};
	
	
</script>
</head>
<body>

    <div class="head">
        <h1>黄子良</h1>
    </div>

            <div class="panel panel-info loginform">
                <div class="panel-heading">
                 		   销售管理系统
                </div>
                 
                <div class="panel-body">
                   <form class="form-horizontal" role="form" action="<%= request.getContextPath()%>/Login_Login!Login.do" Method="post" name="loginForm">
                    <div class="form-group">
                        <label class="col-md-4 control-label">用户名：</label>
                        <div class="col-md-4">
                           <input type="text" name="uname" class="form-control" placeholder="用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">密码：</label>
                        <div class="col-md-4">
                             <input type="password" name="pword" class="form-control" placeholder="密码"> 
                        </div>
                    </div>

                         <h5 align="center">${login_message}</h5>

                    <div class="form-group">
                        <div class="col-sm-offset-4 col-md-4">
                       
                          <button type="submit" class="btn btn-default">登录</button>
                       <!--    <button type="submit" class="btn btn-default" onclick="chakan()">查看</button>
                          <span id="result"></span> -->
                        </div>
                    </div>
                </form>
                </div>
                
            </div>
</body>
</html>