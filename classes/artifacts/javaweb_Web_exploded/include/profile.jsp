<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>


<div id="side" >           
<div class="side">
<div id="panel_Profile" class="panel">
<ul class="panel_head"><span>个人资料</span></ul>
<ul class="panel_body profile">
    <div id="blog_userface">
        <a href="admin_user_show" target="_blank">
        <img src="img/header.png" style="max-width:90%">
        </a>
        <br>
        <span><a href="admin_user_show" class="user_name" target="_blank">${user.name}</a></span>
    </div>
    <ul id="blog_statistics">
        <li>原创：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#C40000; text-align:center;"><a href="admin_article_show?param=all" target="_blank"style="text-decoration:none;color: #C40000;">${totalArticle}</a></span></li>
    </ul>
</ul>


</div>
<div class="panel" id="panel_Search">
    <ul class="panel_head"><span>文章搜索</span></ul>
    <ul class="panel_body">
        <form id="frmSearch" action="#nowhere"  target="_blank" >
        <span><input id="inputSearch" type="text" class="blogsearch" title="请输入关键字"></span>
        <input id="btnSubmit" type="button" value="搜索" title="search in blog">
        <input type="hidden" name="q" id="inputQ">
        <input type="hidden" name="t" value="blog">
        <a id="btnSearchBlog" target="_blank"></a>
        </form>
    </ul>
</div>

<script type="text/javascript">

   
    $(function () {
        $("#btnSubmit").unbind("click");
        $("#btnSubmit").click(function () {           
            search();
        });

        $("#frmSearch").submit(function () {           
            search();
            return false;
        });

        function search()
        {
            if ($("#inputSearch").val() == "") {               
                alert("请录入搜索关键词！");                         
                return false;
            }         
            var url = "https://www.baidu.com/";
            window.location.href = url;
        }   
    });
</script>
<div id="panel_Category" class="panel">
<ul class="panel_head"><span>文章分类</span></ul>
<ul class="panel_body">
	
	<c:forEach items="${each_category}" var="category" varStatus="st">    
    <li>
      <a href="admin_article_show?param=${category['key']}" target="_blank" >${category["key"]}</a><span>(${category["value"]})</span>
    </li>
    </c:forEach>
 	

</ul>
</div>
</div>
</div>


