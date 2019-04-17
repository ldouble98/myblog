<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<script>
$(function(){
	$("ul.pagination li.disabled a").click(function(){
		return false;
	});
});

</script>
<nav>
	<ul class="pagination pagination-lg">
    <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
      <a href="admin_article_show?page.start=0" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
      <a  href="admin_article_show?page.start=${page.start-page.count}" aria-label="Previous" >
        <span aria-hidden="true">‹</span>
      </a>
    </li> 
	  <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
    
    	
		    <li <c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
		    	<a  
		    	href="admin_article_show?page.start=${status.index*page.count}"
		    	<c:if test="${status.index*page.count==page.start}">class="current"</c:if>
		    	>${status.count}</a>
		    </li>
		
    </c:forEach>
	<li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
      <a href="admin_article_show?page.start=${page.start+page.count}" aria-label="Next">
        <span aria-hidden="true">›</span>
      </a>
    </li>
    <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
      <a href="admin_article_show?page.start=${page.last}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>