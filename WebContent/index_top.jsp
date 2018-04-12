<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	double num = Math.random();
%>

<div id="header">
	<div class="login_menu">
		<div class="login_container">
			<c:if test="${empty sessionScope.user }">
				<ul class="m_left">
					<li><a href="login.jsp" class="c_red">请登录</a>&nbsp;&nbsp;&nbsp;</li>
					<li><a href="register.jsp">请注册</a></li>
				</ul>
			</c:if>
			<c:if test="${!empty sessionScope.user }">
				<ul class="m_left">
					<li class="c_red">欢迎您，${sessionScope.user.uname }&nbsp;&nbsp;&nbsp;</li>
					<li><a href="userInfo?uid=${sessionScope.user.uid }">个人中心&nbsp;&nbsp;&nbsp;</a></li>
					<li><a href="userExit">退出</a>
				</ul>
			</c:if>
			<ul class="m_right">
				<li><img src="images/icon_3.png"><a href="car"
					class="c_red">购物车</a></li>
				<li><img src="images/icon_4.png"><a
					href="javascript:AddFavorite('我的网站',location.href)">收藏</a></li>
				<li><img src="images/icon_2.png"><a
					href="${pageContext.request.contextPath }/commentAll">留言</a></li>
				<li><img src="images/icon_1.png"><a href="index">首页</a></li>
			</ul>
		</div>
	</div>
	<div class="logo_search">
		<div class="logo">
			<img src="images/LOGO.png">
		</div>
		<div class="search">
			<input type="text" placeholder="输入宝贝" id="qname" />
			<button class="query_button" onclick="">搜索</button>
		</div>
	</div>
	<div class="nav_bar">
		<div class="nav_bar_container">
			<ul>
				<c:forEach var="p" items="${requestScope.pageModel.list }" begin="0" end ="9">
					<li><a href="productDetail?pid=${p.p_id }">${p.p_name }|</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
