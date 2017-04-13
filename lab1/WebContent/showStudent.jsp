<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
<title>😎  ${sessionScope.user.name}！</title>
<style>
#admin{ color: #999;}
h2 { text-align: center; }
a { text-decoration: none; color: #555; font-size: 14px;}
table { text-align: center; margin: auto; border-spacing: 0; position: relative; padding-bottom: 1.5px;}
table th { font-weight: bold; padding: 5px 15px; border-bottom: 1px solid #909ba2; }
table tr:nth-child(2n) { background: #f7f8f8; }
tbody tr:nth-last-child(2) td { border-bottom: 1px solid #909ba2; }
table tr td {padding: 5px 10px; height: 32px; min-width: 80px; max-width: 115px; box-sizing: border-box;}
table tr:nth-last-child(1) { background: none; }
td#addBtn {    
	border-bottom: 1px solid #909ba2;
    border-left: 1px solid #909ba2;
    border-right: 1px solid #909ba2;
    /*border-radius: 0 0 6px 6px;*/ }
.saveInfo,.reset { display: none; margin: 0 7px;}
.modify,.delInfo { margin: 0 7px;}
a:hover{ border-bottom:1px #555 solid; }
td input{ width: 57px; vertical-align: middle;}
.addIn { display: none;}
.qq {width:80px;}
.qqWid {margin-left:10px;}
.btn { padding:0; width: 37px; height: 23px; line-height: 23px;
 border-radius:3px; border: 1px solid #ccc; }
.userId,.prompt { display: none; position: absolute; top: 30px; left: 0px; width: 75px; height: 20px; padding: 2px 4px;
    font-size: 13px; border: 1px solid #edc27a; color: #ad7415; box-shadow: 0 0 1px 1.5px #d9e217;
    background: rgb(254, 254, 164);}
a.btn{display:inline-block;}
table tr td:nth-child(2), table tr td:nth-child(3), table tr td:nth-child(4),
#addInfo td:nth-of-type(3), #addInfo td:nth-of-type(4), #addInfo td:nth-of-type(5) { position: relative; }
@media screen and (max-width: 400px) {
    table tr td { min-width: 60px; padding: 5px 5px; }
    .oldInfo{margin: 0 4px;}
    td input { width: 50px;  }
    a.btn { margin-top: 4px; }
}
</style>
</head>
<body>
<div id="admin">夜深了，亲爱的 😎  ${sessionScope.user.name}！</div>
<div>	
	<table>
	<thead><th colspan="5">学生信息表</th></thead>
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>QQ</td>
			<td>操作</td>
		</tr>
	<c:forEach var="stu" items="${ requestScope.students }">
		<tr>
			<td>${ stu.id }<input type="text" name="id" value="${ stu.id }" class="addIn oldInfo"/></td>
			<td>${ stu.name }<input type="text" name="name" value="${ stu.name }" autofocus="autofocus" class="addIn oldInfo name"/><div class="prompt">姓名不合法.</div></td>
			<td>${ stu.age }<input type="text" name="age" value="${ stu.age }" class="addIn oldInfo age"/><div class="prompt">年龄不合法.</div></td>
			<td>${ stu.qq }<input type="text" name="qq" value="${ stu.qq }" class="addIn oldInfo qq"/><div class="prompt qqWid">QQ不合法.</div></td></td>
			<td>
				<a href="editStudent?id=${ stu.id }" class="saveInfo oldInfo">保存</a><a class="reset oldInfo">取消</a>
				<a  class="oldInfo modify">修改</a><a href="delStudent?id=${ stu.id }" class="oldInfo delInfo">删除</a>			
			</td>
		</tr>
	</c:forEach>
	<tr id="addInfo">	
		<td id="addBtn"><a>添加</a></td>
		<form action="addStudent" method="post">
			<td><input type="text" name="id" placeholder="学号" required="required" autofocus="autofocus" class="addIn newInfo" id="userId"/><div class="userId">学号已存在!</div></td>
			<td><input type="text" name="name" placeholder="姓名" required="required" class="addIn newInfo name"/><div class="prompt">姓名不合法.</div></td>
			<td><input type="text" name="age" placeholder="年龄" required="required" class="addIn newInfo age"/><div class="prompt">年龄不合法.</div></td></td>
			<td><input type="text" name="qq" placeholder="QQ" class="addIn newInfo qq"/><div class="prompt qqWid">QQ不合法.</div></td></td>
			<td  class="addIn newInfo">
				<input type="submit" value="添加" id="submit" class="btn">
				<a id="cancel" class="btn">取消</a>
			</td>
		</form>
	</tr>
	</table>
</div>
<script type="text/javascript">
window.onload = function() {
	var xmlHttp;
	var boolName, boolAge, boolQq;
	var table = document.getElementsByTagName("table")[0];
	var oldInfo = document.getElementsByClassName("oldInfo");
	var addInfo = document.getElementById("addInfo");
	var addBtn = document.getElementById("addBtn");
	var newInfo = document.getElementsByClassName("newInfo");
	var submit = document.getElementById("submit");
	var cancel = document.getElementById("cancel");
	var modify = document.getElementsByClassName("modify");
	var delInfo = document.getElementsByClassName("delInfo");
	var saveInfo = document.getElementsByClassName("saveInfo");
	var reset = document.getElementsByClassName("reset");
	var userId = document.getElementById("userId");
	var name = document.getElementsByClassName("name");
	var age = document.getElementsByClassName("age");
	var qq = document.getElementsByClassName("qq");
	var prompt = document.getElementsByClassName("prompt");
	addBtn.onclick = function(){
		this.style.display = "none";
		for(var i=0; i<newInfo.length; i++){
			newInfo[i].style.display = "inline-block";
		}
	}

	cancel.onclick = function(){
		for(var i=0; i<newInfo.length; i++){
			newInfo[i].style.display = "none";
		}
		prompt[prompt.length-1].style.display = "none";
		addBtn.style.display = "inline-block";
	}

	for(var i=0; i<modify.length; i++) {
		(function(i){
			//触发修改显示输入框
			modify[i].onclick = function() {
				//修改当前记录前，先检查其他行，是否已点击过修改，若其他行已点击过则先恢复
				for(var j=(i+1)%modify.length; j>i&&j<modify.length||j<i; j=(j+1)%modify.length){
					if(oldInfo[j*8+1].style.display == "inline-block"){
						showTr(j);
					}
				}
				for(var j=i*8+1; j<i*8+6; j++){
					oldInfo[j].value = oldInfo[j].defaultValue;
					oldInfo[j].style.display = "inline-block"; //显示输入框
					if(oldInfo[j].previousSibling){
						oldInfo[j].previousSibling.data = "";
					}
				}
				oldInfo[j].style.display = "none";
				oldInfo[j+1].style.display = "none";
							
			}
			//取消修改
			reset[i].onclick = function(){
				showTr(i);
			}
			//保存前先检查所填写的字段是否合法，若合法则更新uri参数
			saveInfo[i].onclick = function() {
				if(checkName(i) && checkAge(i) && checkQq(i)){
					var j = i*8+1;
					this.href += "&name=" + encodeURI(oldInfo[j].value) + "&age=" + oldInfo[j+1].value + "&qq=" + oldInfo[j+2].value;
				} else {
					return false;
				}
			}
			//删除提示
			delInfo[i].onclick = function() {
				if (confirm('确定删除学生【id='+oldInfo[i*8].value+'】的所有信息？')) { 
					return true;
				} else {
					return false;
				}
			}
			
		})(i);
	}
	userId.onblur =  checkId; 
	//检查姓名、年龄、QQ 是否合法
	
	for(var i=0; i<name.length; i++) {
		(function(i){
			name[i].onblur = function(){
				boolName = checkName(i);
			}
			age[i].onblur = function(){
				boolAge = checkAge(i);
			}
			qq[i].onkeyup = function(){
				boolQq = checkQq(i);
			}
		})(i);
	}
	submit.onclick = function() {
		var a = checkQq(name.length-1);
		if(boolName && boolAge && a){
			alert("😉"+" 添加成功！"); //emoji from : http://www.fhdq.net/emoji.html
		} else {
			alert("😪"+" 亲, 注意规范哦！");
			return false;  //a=undefined or a=false
		}
				
	}
	function showTr(i){
		for(var j=i*8+1; j<i*8+6; j++){
			oldInfo[j].style.display = "none";
			if(!oldInfo[j].nextSibling || oldInfo[j].nextSibling.tagName!="A"){  //过滤掉后面两个a标签
				if(oldInfo[j].previousSibling){
					oldInfo[j].previousSibling.data = oldInfo[j].defaultValue;
				}
			}
		}
		oldInfo[j].style.display = "inline-block";
		oldInfo[j+1].style.display = "inline-block";	
	}
	//Ajax 查询id是否已存在
	function checkId(){
		var regex = new RegExp("^[0-9]+$"); 
		var res = regex.test(userId.value);
		if(res!=true){
			userId.nextSibling.innerHTML = "学号不合法."
			userId.nextSibling.style.display = "block";
			userId.focus(); 
			setTimeout(function(){
				userId.nextSibling.style.display = "none";
			}, 1000);
		}
		createXMLHttpRequest();
		var url = "checkId?id="+userId.value;
		console.log(userId.value);
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
		xmlHttp.onreadystatechange = function() {
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				if(xmlHttp.responseText){
					userId.nextSibling.innerHTML = "学号已存在."
					userId.nextSibling.style.display = "block";
					userId.focus(); 
					setTimeout(function(){
						userId.nextSibling.style.display = "none";
					}, 1000);
				} 
			}
		}
	}
	function checkName(i){
		if(name[i].value!=""){  //避免第一次学号失去焦点进入姓名时，学号又获得焦点，导致姓名空值却触发检查事件
			var regexCN = new RegExp("^[\u4e00-\u9fa5]+$");
			var regexEN = new RegExp("^[a-zA-Z]+$");
			var resCN = regexCN.test(name[i].value);
			var resEN = regexEN.test(name[i].value);
			if(!resCN && !resEN){
				prompt[3*i].style.display = "block";
				name[i].focus();
				setTimeout(function(){
					prompt[3*i].style.display = "none";
				}, 1000);
				return false;
			} 
			return true; 					
		}
		return false;
	}
	function checkAge(i){
		if(age[i].value!=""){  //避免第一次学号失去焦点进入姓名时，学号又获得焦点，导致姓名空值却触发检查事件
			var regex = new RegExp("^([0-9]){1,3}$");
			var res = regex.test(age[i].value);
			if(!res){
				prompt[3*i+1].style.display = "block";
				age[i].focus();
				setTimeout(function(){
					prompt[3*i+1].style.display = "none";
				}, 1000);
				return false;
			} 
			return true; 
		}
	}
	var t;
	function checkQq(i){
		if(qq[i].value!=""){  //避免第一次学号失去焦点进入姓名时，学号又获得焦点，导致姓名空值却触发检查事件
			var regex = new RegExp("[1-9][0-9]{4,}");
			var res = regex.test(qq[i].value);
			if(!res){
				prompt[3*i+2].style.display = "block";
				qq[i].focus();
				setTimeout(function(){
					prompt[3*i+2].style.display = "none";
				}, 1000);
				return false;
			} 
			if(qq[i].value!=qq[i].defaultValue){  //qq值未修改时，不执行检查
				createXMLHttpRequest();
				var url = "checkQq?qq="+qq[i].value;
				xmlHttp.open("GET", url, true);
				xmlHttp.send(null);
				xmlHttp.onreadystatechange = function() {
					if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
						if(xmlHttp.responseText){
							qq[i].nextSibling.innerHTML = "QQ已存在."
							qq[i].nextSibling.style.display = "block";
							qq[i].focus(); 
							setTimeout(function(){
								qq[i].nextSibling.style.display = "none";
							}, 13);
							t = false; 
							console.log("QQ已存在.");
						} else {
							t = true; 
							console.log("QQ有效.");
						}
					}
				}
			} else if(name[i].value!=name[i].defaultValue || age[i].value!=age[i].defaultValue) { //保存前
				t = true;
			} else {
				t = false;
			}
		}
		return t; 
	}
	function createXMLHttpRequest() {
	    //检查是否支持 ActiveXObject 控件（IE浏览器）
	    if(window.ActiveXObject) {
	        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	    } else if(window.XMLHttpRequest) {
	        xmlHttp = new XMLHttpRequest(); 
	    }
	}
}

</script>
</body>
</html>