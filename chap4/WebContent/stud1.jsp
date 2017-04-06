<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,cn.edu.lsu.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>stud1--{jstl}</title>
<style>
table {
    text-align: center;
    margin: auto;
    border-spacing: 0;
}
table th {
    font-weight: bold;
    padding: 5px 15px;
    border-bottom: 2px solid #909ba2;
}
table tr:nth-child(2n) {
    background: #f7f8f8;
}
</style>
</head>
<body>
<%
	List<Student> students = new ArrayList<Student>();
	Student s1 = new Student(1,"张飞",21,55);
	Student s2 = new Student(2,"关羽",22,77);
	Student s3 = new Student(3,"赵云",20,59);
	Student s4 = new Student(4,"刘备",23,86);
	students.add(s1);
	students.add(s2);
	students.add(s3);
	students.add(s4);
	session.setAttribute("students", students);
%>
<table>
	<tr>
		<th>学号</th>
		<th>姓名</th>
		<th>年龄</th>
		<th>成绩</th>
		<th>评价</th>
	</tr>
	<c:forEach items="${students}" var="s">
	<tr><td>${s.id}</td>
		<td>${s.name}</td>
		<td>${s.age}</td>
		<td>${s.score}</td>
		<c:if test="${s.score>=60}"><td>合格</td></c:if>
		<c:if test="${s.score<60}"><td>不合格</td></c:if>
	</tr>
	</c:forEach>
</table>
<%application.setAttribute("name", "李斯"); %>

</body>
</html>