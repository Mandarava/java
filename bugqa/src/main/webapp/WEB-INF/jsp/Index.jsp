<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<script type="text/javascript">
	function submit() {
		document.form1.submit();
	}
</script>
<body onload="submit()">
	<form action="index" name="form1" method="post"></form>
</body>
</html>