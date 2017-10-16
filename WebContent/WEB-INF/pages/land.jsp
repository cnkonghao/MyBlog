<!-- 用户登陆页面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
    <title>用户登录界面</title>
    <link rel="stylesheet" href="/css/loginstyle.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Simple Login Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
	</script>
</head>
<body>
     <h1>欢迎来到用户登录界面</h1>
     <div class="container w3">
         <h2>现在登录</h2>
         <form action="dolands" method="post">
             <div class="username">
                 <span class="username" style="height:19px">用户：</span>
                 <input type="text" name="username" class="name" placeholder="" required="required">
                 <div class="clear"></div>
             </div>
             <div class="password-agileits">
				<span class="username"style="height:19px">密码:</span>
				<input type="password" name="passwordHash" class="password" placeholder="" required="required">
				<div class="clear"></div>
			</div>
			<div class="rem-for-agile">
			     <input type="checkbox" name="remember" class="remember">记住我<br>
			     <a href="#">忘记密码</a><br>
			</div>
			<div class="login-w3">
			
				 <input type="submit" class="login" value="登录">
			     <a href="/enrolls"><input type="button" class="login" value="注册"></a> 
			
			    
			</div>
			<div class="clear"></div>
         </form>
     </div>
     <div class="footer-w3l">
          <p>用户登录界面</p>
     </div>
</body>
</html>