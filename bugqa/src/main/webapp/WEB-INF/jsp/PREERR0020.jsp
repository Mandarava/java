<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/resources/js/jquery-2.1.4.min.js"></script>
<title>timeout</title>
<script type="text/javascript">
		<%-- window.top.location.href="<%=basePath%>jsp/ERR0020.jsp"; --%>
		$(document).ready(function(){
			document.form1.submit();	
		});	
</script>
</head>
<body>
	<form action="timeout" name="form1" method="post"></form>
</body>
</html>