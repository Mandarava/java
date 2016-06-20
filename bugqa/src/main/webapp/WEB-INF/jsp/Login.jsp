<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel='stylesheet prefetch' href='<%=request.getContextPath()%>/resources/css/roboto.css'>
<link rel='stylesheet prefetch' href='<%=request.getContextPath()%>/resources/css/font-awesome.min.css'>
<link href="<%=request.getContextPath()%>/resources/materialize/css/ghpages-materialize.css" type="text/css"
	rel="stylesheet" media="screen,projection">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
<title><s:text name="projectManagementSystem"></s:text></title>
</head>
<script type="text/javascript">
	window.onkeydown = function submitForm() {
		var key = event.which || event.keyCode || 0;
		if (key === 13) {
			document.getElementById('login-button').click();
		}
	};
</script>
<body style="overflow: hidden" class="login-body">
	<div class="pen-title hide-on-small-only">
		<h1>
			<s:text name="projectManagementSystem" />
		</h1>
	</div>
	<div class="pen-title hide-on-med-and-up">
		<h4>
			<s:text name="projectManagementSystem" />
		</h4>
	</div>
	<!-- <div class="logo"></div> -->
	<div class="login-block">
		<h1>Login</h1>
		<s:form name="loginForm" class="form" action="main" namespace="/" method="post">
			<s:fielderror key="errorMsg" />
			<input type="text" maxlength="16" required="required" placeholder="<s:text name="user"></s:text>" id="username"
				name="userId" />
			<input type="password" name="password" maxlength="18" required="required"
				placeholder="<s:text name="password"></s:text>" id="password" />
			<button type="submit" id="login-button">
				<s:text name="login"></s:text>
			</button>
		</s:form>
	</div>
	<div class="footer-copyright hide-on-small-only">
		<div class="container">
			Copyright © 2015 - 2016. All rights reserved. <a class="grey-text text-lighten-4 right" href="#"></a>
		</div>
	</div>

</body>

</html>