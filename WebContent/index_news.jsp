<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
.news-list ul li {
	
}
</style>
<div class="newsList">
	<h2>新闻动态</h2>
	<ul>
		<c:forEach items="${requestScope.newsList }" var="newsList">
			<li><a href="newsDetail?nid=${newsList.nid }">${newsList.news_title }</a></li>
		</c:forEach>
	</ul>
</div>
