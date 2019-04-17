<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<style>
<!--
div.userDiv{
	float:right;
	width:710px;
}
div.userDiv #catelog{
	display:inline;
	line-height:56px;
}
div.userDiv #catelog a{
	font-size: 50px;
	font-weight: bold;
	color: black;
	text-decoration:none;
	margin-left:33.5px;

}
div.userDiv #catelog a:hover{
	color: #C40000;
	text-decoration: none;
}
div.showDiv{
	display:inline;
	float:right;
	font-family:Arial;
	width:710px;
}
div.userDiv table.showTable{
	color:white;
	width:710px;
	border:1px solid yellow;
	border-collapse:collapse;
	float:right;
}
div.userDiv table.showTable td{
	width:355px;
	overflow:hidden;
	height:45px;
	text-align:center;
	font-size:50px;
	color:black;
}
div.userDiv table.showTable input{
	height:50px;
	width:200px;
}
div.userDiv table.showTable button{
	height:50px;
	width:200px;
	border: 1px solid #C40000;
	background-color: #FFEDED;
	text-align: center;
	line-height: 40px;
	font-size: 16px;
	/* 	font-weight:700; */
	color: #C40000;
	font-family: arial;
}
-->
</style>
<script>
	$(function(){
		var sideheight = $("div.side").get(0).offsetHeight;
		//var titleheight = $("div.#catelog").get(0).offsetHeight;;
		//alert(titleheight);
		//$(".showtable").css("sideheight",sideheight);
		$(".showtable").height(sideheight-61);
		$("table[status]").hide();
		$("table[status=show]").show();
		$("a[status]").click(function(){
			var status = $(this).attr("status");
			$("table[status]").hide();
			$("table[status="+status+"]").show();
			return false;
			
		});
		$("#updatename").click(function(){
			var userName = $("#userName").val();
			if(0==userName.length){
				alert("用户名不能为空");
				return;
			}
			$.ajax({
				url:"admin_user_updatename",
				type:"post",
				data:{"userName":userName},
				success:function(Result){
					if("success"==Result){
						alert("修改成功");
						window.location.href="${contextPath}/admin_user_show";
					}
					else if("fail"==Result){
						alert("用户名已存在，修改失败");
					}
					
				},
			});
			
		});
		$("#updatepassword").click(function(){
			if(0==$("#oldpassword").val().length){
				alert("请输入原密码！");
				return;
			}
			if(${user.password}!=$("#oldpassword").val()){
				alert("原密码错误，请重新输入！");
				return;
			}
			if(0==$("#newpassword").val().length){
				alert("请输入新密码");
				return;
			}
			
			if(0==$("#repeatpassword").val().length){
				alert("请重复密码！！！");
				return;
			}
			if($("#newpassword").val()!=$("#repeatpassword").val()){
				alert("两次密码输入不一致，请重新输入！");
				return;
			}
			if(${user.password}==$("#newpassword").val()){
				alert("和原密码一样，请你重新输入！！");
				
				return;
			}
			var password= $("#repeatpassword").val();
			$.ajax({
				url:"admin_user_updatepassword",
				type:"post",
				data:{"password":password},
				success:function(Result){
					if("success"==Result){
						alert("修改成功");
						window.location.href="${contextPath}/forelogin";
					}
					else{
						alter("修改失败");
					}
				}
			});
		});
	});
</script>
<div class="userDiv">
	<div id="catelog">
		<a href="#nowhere" status="show">用户信息</a>
		<a href="#nowhere" status="updatename">修改信息</a>
		<a href="#nowhere" status="updatepassword">修改密码</a>
	</div>
	<div class="showDiv">
		<table class="showTable" status="show" >
			<tr> 
				<td>用户名:</td>
				<td>${user.name}</td>
			</tr>
			<tr> 
				<td>邮   箱:</td>
				<td>${user.email}</td>
			</tr><tr> 
				<td>博   客:</td>
				<td>${totalArticle}</td>
			</tr>
		</table>
		<table class="showTable" status="updatename" >
			<tr> 
				<td>用户名:</td>
				<td>${user.name}</td>
			</tr>
			<tr> 
				<td>新用户名:</td>
				<td><input type="text" name="userName" id="userName" style=""></td>
			</tr><tr> 
				<td colspan="2"><button type="submit"  id="updatename">确认修改</button></td>
			</tr>
		</table>
		<table class="showTable" status="updatepassword" >
			<tr> 
				<td>原密码:</td>
				<td><input type="password" name="oldpassword" id="oldpassword"></td>
			</tr>
			<tr> 
				<td>新密码:</td>
				<td><input type="password" name="newpassword" id="newpassword"></td>
			</tr><tr> 
				<td>再输一次:</td>
				<td><input type="password" name="repeatpassword" id="repeatpassword"></td>
			</tr>
			<tr> 
				<td colspan="2"><button type="submit" id="updatepassword">确认修改</button></td>
			</tr>
		</table>
	</div>
</div>
<div style="clear:both"></div>

