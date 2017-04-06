<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎 ${user.name} !</title>
</head>
<body>
	<h3 style='color:#00f'>亲爱的${user.name}，欢迎您！</h3>
    <p>现在的时间是：<% out.println(new java.util.Date()); %></p>
       查看<a href='session1.jsp' >session1</a><br>
       查看<a href='session1.jsp' >session1</a><br>
</body>
</html>