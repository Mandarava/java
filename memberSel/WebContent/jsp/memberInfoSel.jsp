<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>员工信息检索</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="./js/memberInfoSel.js"></script>
</head>

<body>
<s:form id="myform" action="Clear" namespace="/" method="post">
	<table border="1" style="width: 70%; table-layout: fixed">
		<colgroup>
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
		</colgroup>
		<tr>
			<td rowspan=3 colspan=7 align="center" valign="top" height="66px">
			検索条件設定</td>
			<td rowspan=3 colspan=7>工号: <input type="text"
				name="pageBean.searchKey.memberCodeInput" id="memberCodeInput"
				maxlength=8 value="${pageBean.searchKey.memberCodeInput}"
				onkeyup="onInput();" /></td>
			<td rowspan=3 colspan=6 align="center" valign="middle"><img
				src="./img/memberInfoSel1.jpg" style="width: 100px; height: 60px"></td>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
		<tr>
			<td rowspan=4 colspan=5 valign="middle" height="88px">&nbsp; <input
				type="radio" name="pageBean.searchKey.deptName" id="deptName"
				value="0" checked onclick="onInput();"
				<c:if test="${pageBean.searchKey.deptName eq 0}">checked</c:if>>
			部门名<br />
			&nbsp; <input type="radio" name="pageBean.searchKey.deptName"
				id="workerName" value="1" onclick=" onInput();"
				<c:if test="${pageBean.searchKey.deptName eq 1}">checked</c:if>>员工姓名
			</td>
			<td rowspan=3 colspan=7 valign="middle"><input type="text"
				style="width: 98%" maxlength=40 name="pageBean.searchKey.nameInput"
				id="nameInput" value="${pageBean.searchKey.nameInput}"
				onkeyup="onInput();" /></td>
			<td rowspan=3 colspan=8 align="center" valign="middle">&nbsp;<input
				type="button" name="select" id="select" value="檢索"
				style="height: 100px; height: 30px" onclick="doselect();">
			&nbsp;<input type="button" name="clear" id="clear" value="清除"
				style="height: 80px; height: 30px" onclick="doclear();"></td>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
		<tr>
			<td rowspan=1 colspan=15 height="22px"><input type="text"
				style="border: none; width: 98%; color: red" readonly id="errorInfo"
				value="${pageBean.searchKey.msg}" name="${pageBean.searchKey.msg}" /></td>
		</tr>
	</table>
	<br>
	<table border="1" style="width: 70%; table-layout: fixed">
		<colgroup>
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
			<col style="width: 3.5%" />
		</colgroup>
		<tr align="center">
			<th colspan=8 height="22px">员工信息</th>
			<th rowspan=2 colspan=4>年收</th>
			<th rowspan=2 colspan=3>所属部门<br />
			CODE</th>
			<th rowspan=2 colspan=5>所属部门<br />
			名称</th>
		</tr>
		<tr align="center">
			<th colspan=2 height="22px">工号</th>
			<th colspan=3>姓名</th>
			<th colspan=3>職務レベル</th>
		</tr>
		<c:forEach begin="0" items="${pageBean.modelList}" var="model">
			<tr align="center">
				<td colspan=2 height="22">${model.memberCode}</td>
				<td colspan=3 height="22">${model.name}</td>
				<td colspan=3 height="22">${model.jobLevel}</td>
				<td align="right" colspan=4 height="22">${model.annualIncome}</td>
				<td colspan=3 height="22">${model.deptCode}</td>
				<td align="left" colspan=5 height="22">${model.deptNm}</td>
			</tr>
		</c:forEach>
	</table>
</s:form>
</body>
</html>