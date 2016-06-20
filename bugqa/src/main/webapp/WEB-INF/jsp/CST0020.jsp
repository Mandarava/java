<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script
	src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>
<title><s:text name="CST0020"></s:text></title>
</head>
<body>
	<div class="row">
		<div class="col s12 m12 l6">
			<div class="row card-panel" style="margin-left: 1%; margin-right: 1%">
				<div class="row">
					<div class="col s12 m12 l12">
						<h5 class="header">
							<s:text name="CST0020"></s:text>
						</h5>
					</div>
				</div>
				<form data-parsley-validate enctype="multipart/form-data" id="CST0020Form">
					<div class="input-field col s12 m6 l10 ">
						<input id="txtCstCode" name="customerCode" type="text" length="6"
							maxlength=6 required pattern="/^([A-Za-z]|[0-9])*$/"
							data-parsley-required-message="<s:text name="USE0001"></s:text>"
							data-parsley-pattern-message="<s:text name="PRO0002"></s:text>"
							data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
						<label for="txtCstCode"> <s:text name="txtCstCode"></s:text>
						</label>
					</div>
					<div class="input-field col s12 m6 l10 ">
						<input id="txtCstName" name="customerName" type="text" length="50"
							maxlength=50 required
							data-parsley-required-message="<s:text name="USE0001"></s:text>"
							data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
						<label for="txtCstName"> <s:text name="txtCstName"></s:text>
						</label>
					</div>
					<div class="input-field col s12 m6 l10">
						<input id="txtCstNameSim" name="customerNameSum" type="text"
							length="5" maxlength=5 required pattern="/^([A-Za-z]|[0-9])*$/"
							data-parsley-required-message="<s:text name="USE0001"></s:text>"
							data-parsley-pattern-message="<s:text name="PRO0002"></s:text>"
							data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
						<label for="txtCstNameSim"> <s:text name="txtCstNameSim"></s:text>
						</label>
					</div>
					<div class="input-field col s12 m6 l10">
						<input id="txtZipCode" name="zipCode" type="text" class=""
							length="10" maxlength=10 required pattern="/^[0-9]\d*$|^0$/"
							data-parsley-required-message="<s:text name="USE0001"></s:text>"
							data-parsley-pattern-message="<s:text name="CST0002"></s:text>"
							data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
						<label for="txtZipCode"> <s:text name="txtZipCode"></s:text>
						</label>
					</div>
					<div class="input-field col s12 m6 l10">
						<input id="txtCstAddress" name="address" type="text" length="50"
							maxlength=50 required
							data-parsley-required-message="<s:text name="USE0001"></s:text>"
							data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
						<label for="txtCstAddress"> <s:text name="txtCstAddress"></s:text>
						</label>
					</div>
					<div class="input-field col s12 m6 l10">
						<input id="txtCstPhone" name="phone" type="text" class=""
							length="16" maxlength=16 required pattern="/^[0-9]\d*$|^0$/"
							data-parsley-required-message="<s:text name="USE0001"></s:text>"
							data-parsley-pattern-message="<s:text name="CST0002"></s:text>"
							data-parsley-maxlength-message="<s:text name="USE0009"></s:text>">
						<label for="txtCstPhone"> <s:text name="txtCstPhone"></s:text>
						</label>
					</div>
					<div class="input-field col s12 m6 l10">
						<input id="txtCstFax" name="fax" type="text" class="" length="16"
							maxlength=16 required pattern="/^[0-9]\d*$|^0$/"
							data-parsley-required-message="<s:text name="USE0001"></s:text>"
							data-parsley-pattern-message="<s:text name="CST0002"></s:text>"
							data-parsley-maxlength-message="<s:text name="USE0009"></s:text>">
						<label for="txtCstFax"> <s:text name="txtCstFax"></s:text>
						</label>
					</div>
					<div class="row">
						<div class="input-field col s12 m6 l10">
							<input id="txtComment" name="comment" type="text" class=""
								length="255" maxlength=255
								data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
							<label for="txtComment"> <s:text name="txtComment"></s:text>
							</label>
						</div>
					</div>
					<!-- 错误信息 -->
					<div class="row">
						<table border=1>
							<tr>
								<td colspan="9"><span id="errorMsg" style="color: red;">

								</span></td>
							</tr>
						</table>
					</div>

					<!-- 社内和社外单选框 -->
					<div class="row">
						<label class="col-md-2 control-label" name="company"
						style="font-size: 20px;"> <s:text name="company"></s:text></label>
						<div id="radioArea">
							<input type="hidden" id="hiddenRadioId" name="hiddenRadio"
								value="" />
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
						</div>
					</div>
					<div class="row"></div>
					<!-- 保存和取消按钮 -->
					<div class="row">
						<div class=" col s6 m6 l5">
							<button class="btn waves-effect waves-light left"
								id="btnCancel" name="cancel" value="0" type="button">
								<s:text name="btnCancel"></s:text>
								<i class="mdi-content-reply left"></i>
							</button>
						</div>
						<div class=" col s6 m6 l5">
							<button class="btn waves-effect waves-light right submit"
								id="btnSave" name="save" value="1" type="submit">
								<s:text name="btnSave"></s:text>
								<i class="mdi-content-send right"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bug/CST0020.js"></script>
</body>
</html>