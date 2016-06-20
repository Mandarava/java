<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String customerCode = request.getParameter("customerCode");
	request.setAttribute("customerCode", customerCode);
	String departmentId = request.getParameter("departmentId");
	request.setAttribute("departmentId", departmentId);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/jquery.treeview.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/active.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/checkbox.css" />
<script
	src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>
<title><s:text name="CST0030"></s:text></title>

</head>
<body>
	<!-- CST0030.js传来的部门ID -->
	<input type="hidden" id="departmentIdHidden" value="${departmentId}">
	<input type="hidden" id="customerCodeHidden" value="${customerCode}">
	<div class="row">
		<div class="col s12 m12 l6">
			<h5 class="header waves-effect waves-light">
				<s:text name="CST0030"></s:text>
			</h5>
			<div class="row">
				<form data-parsley-validate enctype="multipart/form-data">
					<div class="input-field col s12 m6 l10">
						<label for="txtCstCode"> <s:text name="txtCstCode"></s:text></label>
						<input id="txtCstCode" name="customerCode" type="text" length="6"
							readOnly="readOnly" value="${customerCode}" />
					</div>
					<div class="input-field col s12 m6 l10">
						<label for="txtCstName"> <s:text name="txtCstName"></s:text></label>
						<input id="txtCstName" name="customerName" type="text" class=""
							length="50" maxlength=50 value="${customerName}" required
							data-parsley-required-message="<s:text name="USE0001"></s:text>"
							data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
					</div>
					<div class="input-field col s12 m6 l10">
						<label for="txtCstNameSim"> <s:text name="txtCstNameSim"></s:text></label>
						<input id="txtCstNameSim" name="customerNameSum" type="text"
							class="" length="5" maxlength=5 value="${customerNameSum}"
							required pattern="/^([A-Za-z]|[0-9])*$/"
							data-parsley-required-message="<s:text name="USE0001"></s:text>"
							data-parsley-pattern-message="<s:text name="PRO0002"></s:text>"
							data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
					</div>
					<div class="input-field col s12 m6 l10">
						<label for="txtZipCode"> <s:text name="txtZipCode"></s:text></label>
						<input id="txtZipCode" name="zipCode" type="text" class=""
							length="10" maxlength=10 value="${zipCode}" required
							pattern="/^[0-9]\d*$|^0$/"
							data-parsley-required-message="<s:text name="USE0001"></s:text>"
							data-parsley-pattern-message="<s:text name="CST0002"></s:text>"
							data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
					</div>
					<div class="input-field col s12 m6 l10">
						<label for="txtCstAddress"> <s:text name="txtCstAddress"></s:text></label>
						<input id="txtCstAddress" name="address" type="text" class=""
							length="50" maxlength=50 value="${address}" required
							data-parsley-required-message="<s:text name="USE0001"></s:text>"
							data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
					</div>
					<div class="input-field col s12 m6 l10">
						<label for="txtCstPhone"> <s:text name="txtCstPhone"></s:text></label>
						<input id="txtCstPhone" name="phone" type="text" class=""
							length="16" maxlength=16 value="${phone}" required
							pattern="/^[0-9]\d*$|^0$/"
							data-parsley-required-message="<s:text name="USE0001"></s:text>"
							data-parsley-pattern-message="<s:text name="CST0002"></s:text>"
							data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
					</div>
					<div class="input-field col s12 m6 l10">
						<label for="txtCstFax"> <s:text name="txtCstFax"></s:text></label>
						<input id="txtCstFax" name="fax" type="text" class="" length="16"
							maxlength=16 value="${fax}" required pattern="/^[0-9]\d*$|^0$/"
							data-parsley-required-message="<s:text name="USE0001"></s:text>"
							data-parsley-pattern-message="<s:text name="CST0002"></s:text>"
							data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
					</div>

					<div class="input-field col s12 m6 l10">
						<label for="txtComment"> <s:text name="txtComment"></s:text></label>
						<input id="txtComment" name="comment" type="text" class=""
							length="255" maxlength=255 value="${comment}"
							data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
					</div>
					<div class="row">
						<table border=1>
							<tr>
								<td colspan="9" id="errorMsg" style="color: red;"><span
									id="errorMsg" style="color: red;" value="${tblErrorInfo}"></span></td>
							</tr>
						</table>
					</div>

					<!-- 社内和社外单选框 -->
					<div class="row">
						<label class="col-md-2 control-label" name="company"
							style="font-size: 20px;"> <s:text name="company"></s:text></label>

						<div id="radioArea">
							<div class="input-field col s6 m6 l3">
								<input name="companyFlg" type="radio" id="rdbShanai" value="0"
									class="with-gap" data-error=".errorTxt8" checked="checked" />
								<label for="rdbShanai"><s:text name="rdbShanai"></s:text></label>
							</div>
							<div class="input-field col s6 m6 l3">
								<input name="companyFlg" type="radio" id="rdbShagai" value="1"
									class="with-gap" /> <label for="rdbShagai"><s:text
										name="rdbShagai"></s:text></label>
							</div>
							<div id="none">
								<div class="input-field col s6 m6 l3">
									<input name="deleteflag" type="radio" id="delete" value="2"
										class="with-gap" /> <label for="delete"><s:text
											name="rdHasDel"></s:text></label>
								</div>
								<div class="input-field col s6 m6 l3">
									<input name="deleteflag" type="radio" id="noDelete" value="3"
										class="with-gap" /> <label for="noDelete"><s:text
											name="rdNoDel"></s:text></label>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<!-- 保存和取消按钮 -->

						<label class="col-md-2 control-label">&nbsp;</label>
						<div class="col-md-4">
							<button class="btn waves-effect waves-light"
								id="btnSave" name="save" value="1" type="submit">
								<s:text name="btnSave"></s:text>
								<i class="mdi-content-send right"></i>
							</button>
							&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							<button style="margin-left: 35px;"
								class="btn waves-effect waves-light"
								id="btnCancel" name="cancel" type="button">
								<s:text name="btnCancel"></s:text>
								&nbsp;
							</button>
						</div>

					</div>

					<!-- 部门管理和课室管理按钮 -->
					<div class="row">
						<label class="col-md-2 control-label">&nbsp;</label>
						<div class="col-md-8">
							<!-- 部门管理和课室管理树状结构-->
							<div style="float: left">
								<div id="menu"
									style="width: 300px; height: auto; px; border: 1px solid #F00; border-color: gray; background: #66CCCC;">
								</div>
							</div>

							<!-- 上下阶层展开/关闭按钮 -->
							<div class="col-md-4" id="treecontrol">
								<a title="<s:text
								name="btnClose"></s:text>"
									style="margin-left: 30px;"
									class="btn waves-effect waves-light " href="#"><s:text
										name="btnClose"></s:text></a> <br />
								<br />
								<br /> <a title="<s:text name="btnExpand"></s:text>"
									style="margin-left: 30px;"
									class="btn waves-effect waves-light" href="#"><s:text
										name="btnExpand"></s:text></a>
							</div>

						</div>
					</div>

					<div class="row">
						<label class="col-md-2 control-label">&nbsp;</label>
						<!-- 部门编辑和课室编辑 -->
						<div>
							<button class="btn waves-effect waves-light"
								id="btnInsertDept" name="insertDept" type="button">
								<s:text name="btnInsertDept"></s:text>
							</button>
							<button style="margin-left: 50px;"
								class="btn waves-effect waves-light"
								id="btnInsertTeam" name="insertTeam" type="button">
								<s:text name="btnInsertTeam"></s:text>
							</button>
						</div>

					</div>
				</form>
			</div>
		</div>
	</div>

	<script
		src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.treeview.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.cookie.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bug/CST0030.js"></script>
</body>
</html>