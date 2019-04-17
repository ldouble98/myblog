<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登陆</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
body {
	background: #FFF;
	font-size: 12px;
}

body,td,th,input,textarea,select,button,div {
	color: #666;
	font: 12px "Lucida Grande", Verdana, Lucida, Helvetica, Arial,
		sans-serif;
	font-family: Arial, Helvetica, sans-serif;
	resize: none;
}

button {
	cursor: pointer;
}

input {
	border: medium none;
	position: static;
	position: static;
	vertical-align: -2px;
	margin: 0px;
}

body,ul,dl,dd,p,h1,h2,h3,h4,h5,h6,form,div,fieldset {
	margin: 0;
	padding: 0;
}

a img {
	border: none;
}

em,cite,th {
	font-style: normal;
	font-weight: normal;
}

table {
	border-collapse: collapse;
}

body {
	background-color: #ffffff;
}

body {
	background: url("img/bg-yellow.png") repeat;
}

div.loginDiv {
	position: absolute;
	width: 100%;
	left: 35%;
	top: 20%;
}

div.loginDiv table.loginTable {
	margin-top: 20px;
}

div.loginDiv table.loginTable tr {
	width: 355px;
	overflow: hidden;
	height: 60px;
	text-align: center;
	font-size: 50px;
}

div.loginDiv table.loginTable td {
	width: 355px;
	overflow: hidden;
	height: 45px;
	text-align: center;
	font-size: 50px;
	border: 2px solid black;
}

div.loginDiv table.loginTable input {
	height: 50px;
	width: 200px;
}
</style>
</head>
<script type="text/javascript" src="js/jquery/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$("form.loginForm").submit(function() {
			if (0 == $("#email").val().length) {
				alert("邮箱不能为空");
				return false;
			}
			if (0 == $("#password").val().length) {
				alert("密码不能为空");
				return false;
			}
			return true;
		});

	});
</script>
<body>

	<div class="loginDiv">
		<div>
			<div
				style="font-size:50px;font-weight:blod; color:#666;width:710px;text-align:center;">Li-Blog</div>
		</div>
		<form action="forelogin" method="post" class="loginForm">
			<table class="loginTable">
				<tr>
					<td>邮箱:</td>
					<td><input type="text" id="email" name="email"
						placeholder="邮箱账号"></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="password" id="password"></td>
				</tr>
				<tr style="">
					<td><input type="submit" value="登录"
						style="
	color: #C40000;
	background-color:transparent;
	font-size:40px;"></td>
					<td><a href="foreregister"
						style="text-decoration:none;color: #C40000;font-size:40px;"
						target="_blank">注册</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
