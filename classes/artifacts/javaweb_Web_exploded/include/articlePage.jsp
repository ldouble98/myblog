<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<style>
div.show {
	width: 710px;
	float: right;
}

div.showArticleTable table {
	width: 710px;
	text-align: center;
}

div.showArticleTable table a {
	text-decoration: none;
}

div.showArticleTable tr {
	border: 1px solid black;
	height: 30px;
}

div.search {
	text-align: center;
	font-size: 15px;
	font-weight: bold;
}

div.search input[type=date],select {
	height: 30px;
}

div.search button {
	border: 1px solid transparent;
	background-color: white;
	font-size: 15px;
	font-weight: bold;
}

div.search button:hover {
	color: #C44444;
}
</style>
<script>
	$(function(){
		var sideheight = $("div.side").get(0).offsetHeight;
		$(".show").height(sideheight);
	});
	function searchByItem() {
		var startDate = $("#startdate").val();
		var endDate = $("#enddate").val();
		var category = $("#category").val();
		var url = "admin_article_show";
		var now = new Date().getTime();
		alert(startDate);
		if (new Date(startDate).getTime() > now) {
			alert("起始不可超过当前时间");
			return;
		}
		if (new Date(endDate).getTime() < Date(startDate).getTime() > now) {
			alert("结束时间应大于开始时间");
			return;
		}
		$.get(url, {
			"startDate" : startDate,
			"endDate" : endDate,
			"category" : category,
		}, function(data) {

		});
	}
</script>
<div class="show">
	<div class="search" style="margin:15px 0;">
		<span>按时间类型查询:</span> <input type="date" name="startdate"
			id="startdate"> <input type="date" name="enddate"
			id="enddate"> <select name="category" id="category">
			<option selected>All</option>
			<c:forEach items="${each_category}" var="category">
				<option>${category["key"]}</option>
			</c:forEach>
		</select>
		<button id="search" onclick="searchByItem()">查询</button>
	</div>
	<div class="showArticleTable">
		<table class="table table-hover table-condensed">
			<thead >
				<th style="text-align:center;">id</th>
				<th style="text-align:center;">标题</th>
				<th style="text-align:center;">类别</th>
				<th style="text-align:center;">时间</th>
				<th style="text-align:center;">操作</th>
			</thead>
			<tbody>
			<c:forEach items="${articles}" var="eachArticle" varStatus="st">
				<tr>
					<td>${st.count}</td>
					<td><a href="admin_article_showblog?aid=${eachArticle.id}" target="_blank">${eachArticle.title}</a></td>
					<td>${eachArticle.category}</td>
					<td><fmt:formatDate value="${eachArticle.createDate}" pattern="yyyy-MM-dd"/></td>
					<td><span><a href="admin_article_showblog?aid=${eachArticle.id}" target="_blank">详情&nbsp;&nbsp;</a></span><span><a
							href="admin_article_update?aid=${eachArticle.id}" target="_blank">修改&nbsp;&nbsp;</a></span><span><a href="admin_article_del?aid=${eachArticle.id}">删除</a></span></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="pageDiv" style="text-align:center">
			<%@include file="page.jsp" %>
		</div>
	</div>
</div>
