<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,cn.edu.lsu.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>student1</title>
<style>
table {
    text-align: center;
    margin: auto;
    border-spacing: 0;
}
table th {
    font-weight: bold;
    padding: 5px 10px;
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
	Student s1 = new Student(1,"张飞",21,65);
	Student s2 = new Student(2,"关羽",22,77);
	Student s3 = new Student(3,"赵云",20,90);
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
	</tr>
<%
	for(int i=0; i<students.size(); i++){
		Student s = students.get(i);
		out.println("<tr><td>"+s.getId()+"</td>");
		out.println("<td>"+s.getName()+"</td>");
		out.println("<td>"+s.getAge()+"</td>");
		out.println("<td>"+s.getScore()+"</td></tr>");
	}
%>
</table>
<%application.setAttribute("name", "李斯"); %>

</body>
</html>