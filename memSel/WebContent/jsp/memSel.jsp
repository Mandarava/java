<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>部门检索</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="./js/memSel.js"></script>
</head>

<body>
<s:form id="myform" action="Clear" namespace="/" method="post">
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
			<td colspan=5>检索条件部：</td>
			<td colspan=1></td>
			<td colspan=5>检索方式部</td>
		</tr>
		<tr>
			<td colspan=2>&nbsp;&nbsp;部门コード：</td>
			<td colspan=3><input type="text" style="width: 98%"
				name="deptInfo.memSelKey.deptCodeInput" id="deptCodeInput"
				value="${deptInfo.memSelKey.deptCodeInput}" /></td>
			<td colspan=1></td>
			<td colspan=5>&nbsp;&nbsp;<input type="radio"
				name="deptInfo.memSelKey.searchCondition" id="searchCondition0"
				<c:if test="${deptInfo.memSelKey.searchCondition eq 0}">checked</c:if>
				value="0" checked>部门别 人数</td>
		</tr>
		<tr>
			<td colspan=2>&nbsp;&nbsp;部门名称：</td>
			<td colspan=3><input type="text" style="width: 98%"
				name="deptInfo.memSelKey.deptNameInput" id="deptNameInput"
				value="${deptInfo.memSelKey.deptNameInput}" /></td>
			<td colspan=1></td>
			<td colspan=5>&nbsp;&nbsp;<input type="radio"
				name="deptInfo.memSelKey.searchCondition" id="searchCondition1"
				<c:if test="${deptInfo.memSelKey.searchCondition eq 1}">checked</c:if>
				value="1">部门别 年收最大/最小</td>
		</tr>
		<tr>
			<td colspan=2>&nbsp;&nbsp;メンバー姓名：</td>
			<td colspan=3><input type="text" style="width: 98%"
				name="deptInfo.memSelKey.nameInput" id="nameInput"
				value="${deptInfo.memSelKey.nameInput}" /></td>
			<td colspan=1></td>
			<td colspan=5>&nbsp;&nbsp;<input type="radio"
				name="deptInfo.memSelKey.searchCondition" id="searchCondition2"
				<c:if test="${deptInfo.memSelKey.searchCondition eq 2}">checked</c:if>
				value="2">部门别 + 职务级别 年收合计</td>
		</tr>
		<tr>
			<td colspan=2>&nbsp;&nbsp;请点击:</td>
			<td colspan=1 align="left">
			<button type="button" style="width: 90%" onclick="selectDeptInfo();">检索</button>
			</td>
			<td colspan=1 align="center">
			<button type="button" style="width: 90%" onclick="clearView();">清空</button>
			</td>
			<td colspan=1 align="right">
			<button type="button" style="width: 90%" onclick="exit();">退出</button>
			</td>
			<td colspan=1></td>
			<td colspan=5>&nbsp;&nbsp;<input type="radio"
				name="deptInfo.memSelKey.searchCondition" id="searchCondition3"
				<c:if test="${deptInfo.memSelKey.searchCondition eq 3}">checked</c:if>
				value="3">普通检索</td>
		</tr>
	</table>
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
		</colgroup>
		<tr>
			<td colspan=1>部门コード</td>
			<td colspan=4>部门名全称</td>
			<td colspan=1>部门名略称</td>
			<td colspan=1>职务レベル</td>
			<td colspan=1>メンバー姓</td>
			<td colspan=1>メンバー名</td>
			<td colspan=1><label id="tableHead">${deptInfo.memSelKey.tableHead}</label></td>
		</tr>
		<c:forEach begin="0" items="${deptInfo.memDeptInfoList}" var="model">

			<tr align="center">
				<td colspan=1 rowspan =1>${model.deptCode}</td>
				<td colspan=4 align="left">${model.deptFullName}</td>
				<td colspan=1 align="left">${model.deptName}</td>
				<td colspan=1>${model.jobLevel}</td>
				<td colspan=1>${model.firstName}</td>
				<td colspan=1>${model.lastName}</td>
				<td colspan=1
					<c:if test="${deptInfo.memSelKey.searchCondition ne 0}">align="right"</c:if>>${model.personCount}</td>
			</tr>
		</c:forEach>
	</table>
</s:form>
</body>
</html>