<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆</title>
<link href="${pageContext.request.contextPath }/css/manage.css"
	rel="stylesheet" />
</head>
<body>
	<div class="bg">
		<form class="from" action="manage/login" method="post">
			<h2>用户登录</h2>
			<input type="text" id="username" name="username" class="input"
				placeholder="用户名" /> <span class="tip uname">用户名为3~12个字符,不包含特殊符号</span>
			<br /> <input type="password" id="password" name="userpwd"
				class="input" placeholder="密码" /> <span class="tip upass">密码为3~16个字符不以数字开头</span>
			<br />
			<button type="submit" class="input btn" id="login">登录</button>
		</form>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js"></script>
	<script type="text/javascript">
		$("#username").focus(function() {
			showUnameTip();
		});

		$("#password").focus(function() {
			showUpassTip();
		});

		$("#username").blur(function() {
			$(".uname").css({
				"display" : "none"
			});
			var username = $("#username").val();
			if (username == "") {
				showUnameTip();
				$(".uname").text("用户名不能为空");
			}

		});

		$("#password").blur(function() {
			$(".upass").css({
				"display" : "none"
			});

			var userpwd = $("#password").val();
			if ("" == userpwd) {
				showUpassTip();
				$(".upass").text("密码不能为空");
			}
		});

		$("#username").bind("input propertychange", function() {
			var username = $("#username").val();
			if (username == "") {
				$(".uname").text("用户名不能为空");
			} else {
				var reg_uname = /[a-zA-z0-9]{3,12}/;
				if (reg_uname.test(username)) {
					$(".uname").text("用户名可用");
				} else {
					$(".uname").text("用户名为3~12个字符,不包含特殊符号");
				}
			}
		});

		$("#password").bind("input propertychange", function() {
			var userpwd = $("#password").val();
			if ("" == userpwd) {
				$(".upass").text("密码不能为空");
			} else {
				var reg_pass = /^[\w]{3,16}/;
				if (reg_pass.test(userpwd)) {
					$(".upass").text("密码可用");
				} else {
					$(".upass").text("密码为3~16个字符不以数字开头");
				}
			}
		});

		$("#login").click(function() {
			var username = $("#username").val();
			var userpwd = $("#password").val();
			if ("" == username) {
				showUnameTip();
				$(".uname").text("用户名不能为空");
				return false;
			}
			if ("" == userpwd) {
				showUpassTip();
				$(".upass").text("密码不能为空");
				return false;
			}
		});

		function showUnameTip() {
			$(".uname").css({
				"display" : "block"
			});
		}

		function showUpassTip() {
			$(".upass").css({
				"display" : "block"
			});
		}
	</script>
</body>
</html>