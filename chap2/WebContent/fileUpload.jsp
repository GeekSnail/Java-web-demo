<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>fileUpload</title>
<style type="text/css">
table{
	margin: auto;
}
</style>
</head>
<body>

<form action="fileUpload.do" enctype="multipart/form-data" method="post"><!-- 不对字符编码 -->
	<table>
	<% request.setCharacterEncoding("utf-8"); %>
		<tr><td colspan="2" align="center" >文件上传</td></tr>
		<tr><td>会员号 </td>
			<td><input type="text" name="number" size="21" ></td>
		</tr>
		<tr><td>文件名 </td>
			<td><input type="file" name="fileName" size="10" ></input></td>
		</tr>
		<tr><td></td><td align="left"><input type="submit" value="提交"></input>
			<input type="reset" value="重置"></input></td>${message}<br>
		</tr>
	</table>	
</form>
</body>
</html>