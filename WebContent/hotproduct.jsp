<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="hot_sale">
	<h2>热卖推荐</h2>
	<ul>
		<c:forEach var="hotpro" items="${requestScope.hotProduct }">
			<li>
				<dl>
					<dt>
						<a href="productDetail?pid=${hotpro.p_id }" target="_self"> <img src="${hotpro.p_file_name }" /></a>
					</dt>
					<dd class="p_name">
						<a href="productDetail?pid=${hotpro.p_id }" target="_self">${hotpro.p_name }</a>
					</dd>
					<dd class="price">￥${hotpro.p_price }</dd>
				</dl>
			</li>
		</c:forEach>
	</ul>
</div>
