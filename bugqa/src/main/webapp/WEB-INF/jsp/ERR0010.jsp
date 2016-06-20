<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/materialize/css/ghpages-materialize.css" />
<title>error</title>
</head>
<body>
	<form action="homepage" method="post">
		<br />
		<div align="center">
			<h4 class="header">
				<s:text name="error"></s:text>
			</h4>
			<br /> <br />
			<button id="reload" class="waves-effect waves-light btn" type="submit">
				<s:text name="return"></s:text>
			</button>
		</div>
	</form>
</body>
</html>