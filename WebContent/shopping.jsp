<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊- 购物车</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script type="text/javascript" src="scripts/shopping.js"></script>
</head>
<body>
	<%@ include file="index_top.jsp"%>

	<div id="position" class="wrap">
		您现在的位置：<a href="index">亚马逊</a> &gt; 购物车
	</div>
	<div class="wrap">
		<div id="shopping">
			<form action="doBuy" method="post">
				<c:if test="${!empty requestScope.carts }">
					<table>
						<tr>
							<th></th>
							<th>商品名称</th>
							<th>商品价格</th>
							<th>购买数量</th>
							<th>操作</th>
						</tr>


						<!-- 根据用户购物车生成列表 -->

						<c:forEach var="cart" items="${requestScope.carts }">
							<tr id="product_id_1">
								<td><input type="checkbox" name="cid" value="${cart.cid }" /></td>
								<td class="thumb"><img style="width: 100px; height: 100px;"
									src="${pageContext.request.contextPath }/${cart.product.p_file_name}" /><a
									href="productDetail?pid=${cart.product.p_id }">${cart.product.p_name }</a></td>
								<td class="price" id="price_id_1">￥${cart.product.p_price}<span
									id="span_1"></span> <input type="hidden" id="subPrice" value=""
									name="sumPrice" /> <input type="hidden" value="" name="pId" />
									<input type="hidden" value="${cart.product.p_stock }"
									name="hpStock" id="hpStock${cart.cid }" />
								</td>
								<td class="number"><c:set var="hcid"
										value="${cart.product.p_cate_id }"></c:set> <input
									type="button" id="minus" value=" - "
									onclick="reduce(${cart.cid })" width="3px" name="minusButton">
									<input id="${cart.cid }" type="text" name="number"
									value="${cart.quantity }" maxlength="5" size="1"
									style="text-align: center; vertical-align: middle"
									onblur="checkStock(${hcid })" /> <input type="button" id="add"
									value=" + " width="2px" onclick="increase(${cart.cid })"
									name="addButton"></td>
								<td class="delete"><a href="carDelete?cid=${cart.cid }">删除</a></td>
							</tr>
						</c:forEach>

					</table>

					<div class="button">
						<input type="submit" value="" />
					</div>
				</c:if>
				<c:if test="${empty requestScope.carts }">
					<p>购物车中没有商品！</p>
				</c:if>
			</form>
		</div>
	</div>
	<div id="footer">Copyright &copy; 2018 上海海文 All Rights Reserved.
	</div>
</body>
</html>

