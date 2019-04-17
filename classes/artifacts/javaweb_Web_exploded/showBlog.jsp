<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>${article.title}</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<style>
body {
	MARGIN-LEFT: auto;
	MARGIN-RIGHT: auto;
	width: 918px;
}

div.blog-title {
	width: 918px;
	text-align: center;
	float: left;
	display: inline;
	width: 100%;
	padding-bottom: 20px;
	font:600 12px/22px 'Microsoft 宋体';
	
}

div.blog-createDate {
	text-align: center;
	width: 918px;
	border-bottom: 1px solid #dddddd;
	padding-bottom: 20px;
	color:#999999;
	font:200 12px/22px 'Microsoft 宋体';
}

div.blog-content {
	width: 918px;
}
</style>
<body>
	<div class="blog-title">${article.title}</div>
	<div class="blog-createDate">
		发布日期：
		<fmt:formatDate value="${article.createDate}" pattern="yyyy-MM-dd" />
		文章类型 : ${article.category}
	</div>
	<div class="blog-content">${article.content}</div>

</body>
</html>
