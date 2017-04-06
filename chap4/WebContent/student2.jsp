<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,cn.edu.lsu.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>student2</title>
</head>
<body>
<table>
	<tr>
		<th>学号</th>
		<th>姓名</th>
		<th>年龄</th>
		<th>成绩</th>
	</tr>
<%
    ArrayList<Student> students = (ArrayList)session.getAttribute("students");
	for(int i=0; i<students.size(); i++){
		Student s = students.get(i);
		out.println("<tr><td>"+s.getId()+"</td>");
		out.println("<td>"+s.getName()+"</td>");
		out.println("<td>"+s.getAge()+"</td>");
		out.println("<td>"+s.getScore()+"</td></tr>");
	}
%>
</table>
${applicationScope.name }

</body>
</html>