<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<style>
	form{ width:99%; margin: auto; margin-top: 20%; text-align: center;}
	form>div{ display: inline-block; width: 50px; height: 21px; text-align:right; margin-top: 10px;}
	input{ width: 150px}
</style>
</head>
<body>
	<form action="login" method="post">
		<input type="text" name="username" value="" placeholder="用户名">
		<br>
		<input type="password" name="password" placeholder="密码"><br>
		
		<input type="submit" value="登录" >
		${error}
	</form>
</body>
</html>