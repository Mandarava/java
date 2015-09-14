<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>search page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="./js/searchView.js"></script>
</head>

<body>
<s:form id="searchViewform" action="" namespace="/" method="post">
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
			<td colspan=3><input type="text"
				style="border: none; width: 98%; color: red" readonly id="errorInfo"
				value="${deptInfo.searchKey.errorMsg}" /></td>
			<td><input type="text" value="${deptInfo.searchKey.checkIndex}"
				name="deptInfo.searchKey.checkIndex" id="checkboxIndex" readonly
				style="display: none;"></td>
		</tr>
		<tr>
			<td colspan=5>检索条件部：</td>
		</tr>
		<tr>
			<td colspan=2>&nbsp;&nbsp;部门コード：</td>
			<td colspan=3><input type="text" style="width: 98%"
				name="deptInfo.searchKey.deptCodeInput" id="deptCodeInput"
				value="${deptInfo.searchKey.deptCodeInput}" /></td>
			<td colspan=1></td>
			<td colspan=1 rowspan=2><input type="button"
				style="width: 100%; height: 100%" value="检索"
				onclick="selectDeptInfo();"></td>
			<td colspan=1 rowspan=2><input type="button"
				style="width: 100%; height: 100%" value="删除" onclick="deleteView();"></td>
			<td colspan=1 rowspan=2><input type="button"
				style="width: 100%; height: 100%" value="新规" onclick="newView();"></td>
			<td colspan=1 rowspan=2><input type="button"
				style="width: 100%; height: 100%" value="更新" onclick="updateView();"></td>
		</tr>
		<tr>
			<td colspan=2>&nbsp;&nbsp;部门名称：</td>
			<td colspan=3><input type="text" style="width: 98%"
				name="deptInfo.searchKey.deptNameInput" id="deptNameInput"
				value="${deptInfo.searchKey.deptNameInput}" /></td>

		</tr>
		<tr>
			<td colspan=2>&nbsp;&nbsp;メンバー姓名：</td>
			<td colspan=3><input type="text" style="width: 98%"
				name="deptInfo.searchKey.nameInput" id="nameInput"
				value="${deptInfo.searchKey.nameInput}" /></td>
		</tr>
	</table>
	<br>
	<br>
	<table border="1"
		style="width: 80%; table-layout: fixed; margin-left: 2%">
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
			<td align="right"><input type="checkbox" onclick="selectAll();"
				id="checkAll"></td>
			<td colspan=1>部门コード</td>
			<td colspan=4>部门名全称</td>
			<td colspan=1>部门名略称</td>
			<td colspan=1>职务レベル</td>
			<td colspan=1>メンバー姓</td>
			<td colspan=1>メンバー名</td>
			<td colspan=1>金额（元）</td>
		</tr>
		<c:forEach begin="0" items="${deptInfo.memDeptInfoList}" var="model"
			varStatus="status">
			<tr align="center">
				<td align="right">${status.index+1}<input type="checkbox"
					name="check" value="${model.deptCode} ${model.memberNO}"></td>
				<td colspan=1 rowspan=1>${model.deptCode}</td>
				<td colspan=4 align="left">${model.deptFullName}</td>
				<td colspan=1 align="left">${model.deptName}</td>
				<td colspan=1>${model.jobLevel}</td>
				<td colspan=1>${model.firstName}</td>
				<td colspan=1>${model.lastName}</td>
				<td colspan=1 align="right">${model.personCount}</td>
			</tr>
		</c:forEach>
	</table>
</s:form>
</body>
</html>