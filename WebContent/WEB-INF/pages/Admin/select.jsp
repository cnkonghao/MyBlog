<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Insert title here</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css" /> 
    <link rel="stylesheet" type="text/css" href="/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery.sorted.js"></script>
    <script type="text/javascript" src="/js/bootstrap.js"></script>
    <script type="text/javascript" src="/js/ckform.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>

<style type="text/css">
    body {
        padding-bottom:40px; 
    }
    .sidebar-nav {
        padding: 9px 0;
    }
    
    @media (max-width: 980px){
        .navbar-text.pull-right{
            float: none;
            padding-left: 5px;
            padding-right: 5px;
        }
    }
</style>
</head>
<body>
<form action="./update" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10"> 
<input type="hidden" name="id" value="${admin.id}"/>
    <tr>
        <td width="10%" class="tableleft">用户名</td>
        <td><input type="text" name="username" value="${admin.username}"/></td>
    </tr>
    <tr>
        <td class="tableleft">密码</td>
        <td><input type="password" name="passwordHash" value="${admin.passwordHash}"/></td>
    </tr>
    <tr>
        <td class="tableleft">邮箱</td>
        <td><input type="text" name="email" value="${admin.email}"/></td>
    </tr>
    <tr>
        <td class="tableleft">状态</td>
        <td>
            <c:if test="${admin.status==1}">
            <input type="radio" name="status" value="1" checked="true"/> 启用
            <input type="radio" name="status" value="0"/> 禁用
            </c:if>
            <c:if test="${admin.status==0}">
            <input type="radio" name="status" value="1" /> 启用
            <input type="radio" name="status" value="0" checked="true"/> 禁用
            </c:if>
        </td>
    </tr>
     <tr>
        <td class="tableleft">角色</td>
        <td>
            <c:if test="${admin.role==10}">
            <input type="radio" name="role" value="10" checked="true"/> 审核
            <input type="radio" name="role" value="20" /> 编辑
            </c:if>
            <c:if test="${admin.role==20}">
            <input type="radio" name="role" value="10" /> 审核
            <input type="radio" name="role" value="20" checked="true"/> 编辑
            </c:if>
        </td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>   
</table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="./index";
		 });
    });
</script>