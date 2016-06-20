<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/materialize/css/ghpages-materialize.css" />
<title><s:text name="timeout"></s:text></title>
</head>
<body>
	<form action="index" method="post">
		<br />
		<div align="center">
			<h5 class="header">
				<s:text name="sessionTimeOut"></s:text>
			</h5>
			<br /> <br />
			<button id="login-button" class="waves-effect waves-light btn" type="submit">
				<s:text name="login"></s:text>
			</button>
		</div>
	</form>

</body>
</html>