<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<style>
div.main{
	float:right;
	width:710px;
	display:inline;
}
div.main a{
	color:black;
	
}
div.write-article textarea.write{
	
}
</style>
<script>
	var sideheight = $("div.side").get(0).offsetHeight;
		//var titleheight = $("div.#catelog").get(0).offsetHeight;;
		//alert(titleheight);
		//$(".showtable").css("sideheight",sideheight);
		$(".main").height(sideheight);
</script>
<div class="main">
	
	
	<div class="write-article" >
		<form action="admin_article_add" method="post">
			<table>
			<tr>
			<span>文章标题</span>
			<span><input type="text" name="title" id="title"></span>		
			</tr>
			<tr>
				<td><span>文章类型</span></td>
				<td><select name="category">
					<c:forEach items="${each_category}" var="category">
						<option >${category["key"]}</option>
					</c:forEach>
				</select>
				<td>
			</tr>
			<tr>
				<td><span>文章内容</span></td>
				<td><textarea name="content" id="content" cols="100" rows="20" wrap="physical" ></textarea></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center;"><button type="submit" style="border: 1px solid #C40000;
				background-color: #FFEDED;text-align: center;line-height: 40px;
				font-size: 16px;color: #C40000;font-family: arial;width:100px;">发布</button></td>
			</tr>
			</table>
			
		</form>
	</div>
</div>
<div style="clear:both"></div>
