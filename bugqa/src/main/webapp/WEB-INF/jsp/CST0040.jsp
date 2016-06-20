<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String customerCode = request.getParameter("customerCode");
	request.setAttribute("customerCode", customerCode);
	String customerName = request.getParameter("customerName");
	request.setAttribute("customerName", customerName);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/active.css" />
<script
	src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>
<title><s:text name="CST0040"></s:text></title>
</head>

<body>
	<div class="row"></div>
	<div id="CST0040Table" style="margin-left: 2%; margin-right: 2%">
		<!-- CST0030.js传来的客户编号 -->
		<input type="hidden" id="customerCodeHidden" value="${customerCode}">
		<div class="row">
			<h4 class="header waves-effect waves-light">
				<s:text name="CST0040"></s:text>
				<%-- <span id="totalUser"></span> --%>
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
			<div class="progress hide-on-small-only" id="CST0040Progress">
				<div class="indeterminate"></div>
			</div>
			<div class="row">
				<!-- 当前客户Id -->
				<div class="col s2 m2 l2 ">
					<label for="currentCustomerId"> <s:text
							name="currentCustomerId"></s:text></label> <input id="currentCustomerId"
						name="currentCustomerId" type="text" disabled="disabled"
						value="${customerCode}" />
				</div>
				<!-- 当前客户名 -->
				<div class="col s2 m2 l2 ">
					<label for="currentCustomerName"> <s:text
							name="currentCustomerName"></s:text></label> <input
						id="currentCustomerName" name="currentCustomerName" type="text"
						disabled="disabled" value="${customerName}" />
				</div>
			</div>
			<!-- form表单 -->
			<form data-parsley-validate enctype="multipart/form-data">

				<!-- 部门名称ID -->
				<div class="input-field col s6 m6 l6 ">
					<input id="txtDptId" name="departmentId" type="text" class=""
						length="4" maxlength=4 required pattern="/^([A-Za-z]|[0-9])*$/"
						data-parsley-required-message="<s:text name="USE0001"></s:text>"
						data-parsley-pattern-message="<s:text name="PRO0002"></s:text>"
						data-parsley-maxlength-message="<s:text name="USE0009"></s:text>">
					<label for="txtDptId"> <s:text name="txtDptId"></s:text>*
					</label>
				</div>
				<div class="row"></div>
				<!-- 部门名称 -->
				<div class="input-field col s6 m6 l6 ">
					<input id="txtDptName" name="departmentName" type="text" class=""
						length="40" maxlength=40 required
						data-parsley-required-message="<s:text name="USE0001"></s:text>"
						data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
					<label for="txtDptName"> <s:text name="txtDptName"></s:text>*
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

				<!-- 部门信息列表 -->
				<div class="col s12">
					<h4 class="header waves-effect waves-light">
						<s:text name="deptList"></s:text>
						<span id="totalUser"></span>
					</h4>
					<table class="responsive-table highlight " id="CST0040Tbl">
						<thead>
							<tr>
								<th data-field="customerCode"><s:text name="col1"></s:text></th>
								<th data-field="customerName"><s:text name="col2"></s:text></th>
								<th data-field="customerNameSum"><s:text name="col3"></s:text></th>
							</tr>
						</thead>
						<tbody id="CST0040Tbody">

						</tbody>
					</table>

					<!-- 右下角页数 -->
					<ul class="pagination right">
						<text id="CST0040PageCount"></text>
						<li class="waves-effect"><a id="previousPage"><i
								class="material-icons">chevron_left</i></a></li>
						<li class="waves-effect"><a id="nextPage"><i
								class="material-icons">chevron_right</i></a></li>
					</ul>
				</div>

				<div class="row"></div>
				<!-- 追加 ,保存和取消按钮 -->
				<div class="form-group">
					<label class="col-md-2 control-label">&nbsp;</label>
					<div class="row">
						<!-- 追加按钮 -->
						<button class="btn waves-effect waves-light  "
							id="btnAdd" name="btnAdd" type="submit">
							<s:text name="btnAdd"></s:text>
						</button>
						<!--保存按钮 -->
						<button class="btn waves-effect waves-light"
							id="btnSave" name="btnSave" value="1" type="submit">
							<s:text name="btnSave"></s:text>
						</button>
						<!-- 取消按钮 -->
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
	<script src="<%=request.getContextPath()%>/resources/js/bug/CST0040.js"
		charset="gbk"></script>
</body>
</html>
