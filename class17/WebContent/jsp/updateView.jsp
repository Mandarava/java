<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>update page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="./js/searchView.js"></script>
</head>
<body>
<s:form id="updateViewform" action="" namespace="/" method="post">
	<table border="0"
		style="width: 88%; table-layout: fixed; margin-left: 2%">
		<colgroup>
			<col style="width: 8%" />
			<col style="width: 8%" />
			<col style="width: 8%" />
			<col style="width: 8%" />
			<col style="width: 8%" />
			<col style="width: 8%" />
			<col style="width: 8%" />
			<col style="width: 8%" />
			<col style="width: 8%" />
			<col style="width: 8%" />
			<col style="width: 8%" />
		</colgroup>

		<tr>
			<td colspan=2>部門コード</td>
			<td colspan=3><input type="text" style="width: 98%" /></td>
		</tr>
		<tr>
			<td colspan=2>メンバー番号</td>
			<td colspan=3><input type="text" style="width: 98%" /></td>
		</tr>
		<tr>
			<td colspan=2>メンバー姓</td>
			<td colspan=3><input type="text" style="width: 98%" /></td>
		</tr>
		<tr>
			<td colspan=2>メンバー名</td>
			<td colspan=3><input type="text" style="width: 98%" /></td>
		</tr>
		<tr>
			<td colspan=2>職務レベル:</td>
			<td colspan=2><select>
				<option value="A">A</option>
				<option value="B">B</option>
				<option value="C">C</option>
				<option value="D">D</option>
				<option value="E">E</option>
			</select></td>
		</tr>
		<tr>
			<td colspan=2>年収（元）:</td>
			<td colspan=3><input type="text" style="width: 98%" /></td>
			<td colspan=1><input type="text"
				style="border: none; width: 98%; color: red" readonly id="errorInfo"
				value="" /></td>
		</tr>
		<tr>
			<td colspan=1></td>
			<td colspan=1><input type="button" style="width: 100%"
				value="返回一览画面" onclick="goToSearchView();"></td>
			<td colspan=1></td>
			<td colspan=1><input type="button" style="width: 100%"
				value="更新" ></td>
		</tr>
	</table>
</s:form>
</body>
</html>