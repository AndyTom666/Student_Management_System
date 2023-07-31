<%@page import="com.yanzhuang.po.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login success</title>
</head>
<body background="1.jpeg" 
	style=" background-repeat:no-repeat;background-size:110% 260%;attachment: fixed;">
<h1 align="center">欢迎进入学生管理系统</h1>
<% Student stu=(Student)session.getAttribute("stu"); %>
<h2 align="center" style="color:blue">Welcome <%=stu.getStuname() %> to the Student Manager System</h2>
<br><br><br>
<h1 align="left"><a href="register.jsp"><button  onclick="alert('welecome to njupt')" style="height:50px;width
	=200px">新生注册</button></a></h1>
<h1 align="center"><a href="manager.jsp"><button  onclick="alert('welecome to student manager system')" style="height:50px;width
	=200px">学生管理</button></a></h1>
	
<h1 align="right"><a href="grade.jsp"><button  onclick="alert('welecome to grade manager system')" style="height:50px;width
	=200px">学生成绩管理</button></a></h1>

</body>
</html>