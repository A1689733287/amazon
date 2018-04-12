<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="p_category">
	<h2>商品分类</h2>
	<c:if test="${!empty requestScope.category }">
		<c:forEach var="cate" items="${category }">
			<dl>
				<c:if test="${cate.p_cate_id == cate.p_cate_parent_id }">
					<dt>
						<a href="category?cate=parent&c_id=${cate.p_cate_id }">${cate.p_cate_name }</a>
					</dt>
				</c:if>
				<c:forEach var="c" items="${cate.productCategories }">
					<c:if test="${c.p_cate_id != c.p_cate_parent_id }">
						<dd>
							<a href="category?cate=child&c_child_id=${c.p_cate_id }">${c.p_cate_name }</a>
						</dd>
					</c:if>
				</c:forEach>
			</dl>

		</c:forEach>
	</c:if>
</div>

