<!-- 用户注册页面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>用户注册界面</title>
<link rel="stylesheet" href="/css/loginstyle.css">

<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Simple Login Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
	

</script>
</head>
<body>
	<h1>欢迎来到用户注册界面</h1>
	<div class="container w3">
		<form action="/doenroll" method="post">
			<div class="username">
				<span class="username" style="height: 19px">用户名：</span> <input
					type="text" name="username" class="name" placeholder="请输入用户名"
					required="required">
				<div class="clear"></div>
			</div>
			<div class="password-agileits">
				<span class="username" style="height: 19px">密码:</span> <input
					type="password" name="passwordHash" class="password"
					placeholder="请输入密码" required="required">
				<div class="clear"></div>
			</div>
			<div class="username">
				<span class="username" style="height: 19px">邮箱:</span> <input
					type="text" name="email" class="name" placeholder="请输入邮箱"
					required="required">
				<div class="clear"></div>
			</div>

			<div class="username">
				<span class="username" style="height: 19px">密保问题：</span> <input
					type="text" name="question" class="name" placeholder="请输入密保问题"
					required="required">
				<div class="clear"></div>
			</div>
			<div class="username">
				<span class="username" style="height: 19px">密保回答:</span> <input
					type="text" name="answer" class="password" placeholder="请输入密保答案"
					required="required">
				<div class="clear"></div>
			</div>

			<div class="login-w3">
				<input type="submit" class="login" value="保存">
			</div>
			<div class="clear"></div>
		</form>
	</div>
	<div class="footer-w3l">
		<p>用户注册界面</p>
	</div>
</body>
</html>