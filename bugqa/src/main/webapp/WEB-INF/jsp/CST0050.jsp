<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String customerCode = request.getParameter("customerCode");
	request.setAttribute("customerCode", customerCode);

	String departmentId = request.getParameter("departmentId");
	request.setAttribute("departmentId", departmentId);

	String departmentName = new String(request.getParameter(
			"departmentName").getBytes("ISO-8859-1"), "utf-8");
	request.setAttribute("departmentName", departmentName);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script
	src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>
<title><s:text name="CST0050"></s:text></title>
</head>
<body>

	<div id="CST0050Table" style="margin-left: 2%; margin-right: 2%">
		<!-- CST0030.js传来的客户编号 -->
		<input type="hidden" id="customerCodeHidden" value="${customerCode}">
		<!-- CST0030.js传来的部门ID -->
		<input type="hidden" id="departmentIdHidden" value="${departmentId}">

		<div class="row">
			<h4 class="header waves-effect waves-light">
				<s:text name="CST0050"></s:text>

			</h4>

			<div class=" col s3 m2 l1 right">
				<select id="numPerPageSelect">
					<option value="1">10</option>
					<option value="2">30</option>
					<option value="3">100</option>
					<option value="3">500</option>
				</select>
			</div>
			<!-- 进度条 -->
			<div class="progress hide-on-small-only" id="CST0050Progress">
				<div class="indeterminate"></div>
			</div>
			<div class="row">
				<!-- 当前部门Id -->
				<div class="col s2 m2 l2 ">
					<label for="currentDepartmentId"> <s:text
							name="currentDepartmentId"></s:text></label> <input
						id="currentDepartmentId" name="currentDepartmentId" type="text"
						disabled="disabled" value="${departmentId}" />
				</div>
				<!-- 当前部门名 -->
				<div class="col s2 m2 l2 ">
					<label for="currentDepartmentName"> <s:text
							name="currentDepartmentName"></s:text></label> <input
						id="currentDepartmentName" name="currentDepartmentName"
						type="text" disabled="disabled" value="${departmentName}" />
				</div>
			</div>
			<!-- form表单 -->
			<form data-parsley-validate enctype="multipart/form-data">
				<!-- 课室ID -->
				<div class="input-field col s6 m6 l6 ">
					<input id="txtClsId" name="classId" type="text" maxlength=4
						required pattern="/^([A-Za-z]|[0-9])*$/"
						data-parsley-required-message="<s:text name="USE0001"></s:text>"
						data-parsley-pattern-message="<s:text name="PRO0002"></s:text>"
						data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
					<label for="txtClsId"> <s:text name="txtClsId"></s:text>*
					</label>
				</div>
				<!-- 客室名称 -->
				<div class="input-field col s6 m6 l6 ">
					<input id="txtClsName" name="className" type="text" maxlength=40
						required
						data-parsley-required-message="<s:text name="USE0001"></s:text>"
						data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
					<label for="txtClsName"> <s:text name="txtClsName"></s:text>*
					</label>
				</div>
				<!-- 错误信息 -->
				<div class="input-field col s12 m6 l10 ">
					<table border=1>
						<tr>
							<td colspan="9" id="errorMsg" style="color: red;"></td>
						</tr>
					</table>
				</div>
				<!-- 课室信息列表 -->
				<div class="col s12">
					<h4 class="header waves-effect waves-light">
						<s:text name="classList"></s:text>
						<span id="totalUser"></span>
					</h4>
					<table border="0" class="responsive-table highlight "
						id="CST0050Tbl">
						<thead>
							<tr>
								<th name="col1" class="list-th1"><s:text name="txtClsId"></s:text></th>
								<th name="col2" class="list-th1"><s:text name="txtClsName"></s:text></th>
								<th name="col3" class="list-th1"><s:text name="delete"></s:text></th>
							</tr>
						</thead>
						<tbody id="CST0050Tbody">

						</tbody>
					</table>
					<!-- 右下角页数 -->
					<ul class="pagination right">
						<text id="CST0050PageCount"></text>
						<li class="waves-effect"><a id="previousPage"><i
								class="material-icons">chevron_left</i></a></li>
						<li class="waves-effect"><a id="nextPage"><i
								class="material-icons">chevron_right</i></a></li>
					</ul>
				</div>
				<!-- 追加 ,保存和取消按钮 -->
				<div class="form-group">
					<label class="col-md-2 control-label">&nbsp;</label>
					<div class="row">
						<!-- 追加按钮 -->
						<button class="btn waves-effect waves-light "
							id="btnAdd" name="btnAdd" type="submit">
							<s:text name="btnAdd"></s:text>
						</button>
						<!-- 保存按钮 -->
						<button class="btn waves-effect waves-light  "
							id="btnSave" name="btnSave" value="1" type="submit">
							<s:text name="btnSave"></s:text>
						</button>
						<!--取消按钮 -->
						<button class="btn waves-effect waves-light "
							id="btnCancel" name="btnCancel" value="0" type="button">
							<s:text name="btnCancel"></s:text>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<script
		src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bug/CST0050.js"></script>
</body>
</html>