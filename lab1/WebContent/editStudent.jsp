<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>修改学生信息</h1>
   <form action="addStudent" method="post">
    <table>
    	<tr><td>学号</td><td><input type="text" name="id" readonly value="${student.id }"/></td></tr>
    	<tr><td>姓名</td><td><input type="text" name="name" value="${student.name }"/></td></tr>
    	<tr><td>年龄</td><td><input type="text" name="age" value="${student.age }"/></td></tr>
    	<tr><td>QQ</td><td><input type="text" name="qq" value="${student.qq }"/>
    	<tr><td><input type="submit" value="确定"></td>
    	<td><input type="reset" value="取消"></td></tr>
    </table>
   <a href="showStudent">返回</a>
   </form>
</body>
</html>