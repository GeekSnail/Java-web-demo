<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<style>
	/*form{ width:175px; margin: auto; margin-top: 20%; text-align: center;}*/
	form{width: 175px; position: absolute; text-align: center; top: 50%; margin-top: -95px;
    left: 50%; margin-left: -87.5px;}
	form>div{ position: relative; }
	input{ width: 175px; height: 30px; display: block; box-sizing: border-box; padding: 0 6px; border-radius: 3px;
    border: 1px #ccc solid; margin-bottom: 3px; color: #666;}
    .info{ color: red; position: absolute; top: 0; left: 180px; line-height: 30px; margin: 0; width: 130px; text-align: left;}
</style>
</head>
<body>
	<form action="login" method="POST">
		<div><input type="text" name="username" id="userId" placeholder="用户名"><span class="info"></span></div>
		<div><input type="password" name="password" id="passwd" placeholder="密码"><span class="info"></span></div>
		<input type="submit" value="登   录" >
		${error}
	</form>
<script type="text/javascript">
var xmlHttp;
var userId = document.getElementById("userId");
var passwd = document.getElementById("passwd");
var info = document.getElementsByClassName("info");
userId.onblur = checkUser;
passwd.onblur = checkPwd;
function createXMLHttpRequest() {
    //检查是否支持 ActiveXObject 控件（IE浏览器）
    if(window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else if(window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest(); 
    }
}

function checkUser() {
	createXMLHttpRequest();
	var url = "login?username="+userId.value;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
	xmlHttp.onreadystatechange = function() {
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			info[0].innerHTML = xmlHttp.responseText;
		}
	};
}
function checkPwd() {
	createXMLHttpRequest();
	var url = "login?password="+passwd.value;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
	xmlHttp.onreadystatechange = function() {
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			info[1].innerHTML = xmlHttp.responseText;
		}
	};
}


</script>
</body>
</html>