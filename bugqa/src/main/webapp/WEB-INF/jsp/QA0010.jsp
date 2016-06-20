<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<script src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>
<title>新規画面</title>
</head>
<body>
	<div class="row"></div>
	<div class="row" style="margin-left: 1%; margin-right: 1%">
		<div class="card-content ">
			<blockquote>
				<h5 id="errormsg" style="color: red; display: none;"></h5>
			</blockquote>
		</div>
		<div class="row">
			<div class="col s12 m4 l2">
				<h5 class="header">
					<s:text name="newQA"></s:text>
				</h5>
			</div>
		</div>
		
		<form data-parsley-validate enctype="multipart/form-data">
			<div class="row">
				<div class="input-field col s12 m6 l6">
					<select id="drpProjectName" required
						data-parsley-required-message="<s:text name="QA0001"></s:text>">
					</select>
					<label for="drpProjectName"><s:text name="systemName"></s:text>
						<span style="color: red">*</span>
					</label>
				</div>
				
				<div class="input-field col s12 m6 l3">
					<input id="txtSystemType" disabled type="text" length="11" maxlength=11> 
					<label for="txtSystemType"><s:text name="QANO"></s:text></label>
				</div>
				
				<div class="input-field col s12 m6 l3">
					<input id="txtRelationQAID" name="relationQaNo" type="text" disabled length="11" maxlength=11>
					<label for="txtRelationQAID" id="lblRelationQAID"> <s:text name="relationQAID"></s:text></label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12 m4 l3">
					<select id="drpGroupName" name="groupId" required
						data-parsley-required-message="<s:text name="QA0001"></s:text>">
						<option value=" " disabled selected></option>
					</select>
					<label for="drpGroupName"><s:text name="drpGroupName"></s:text>
						<span style="color: red">*</span>
					</label>
				</div>
				
				<div class="input-field col s12 m4 l3">
					<select id="drpModuleName" name="moduleId" required
						data-parsley-required-message="<s:text name="QA0001"></s:text>">
						<option value=" " disabled selected></option>
					</select>
					<label for="drpModuleName"><s:text name="drpModuleName"></s:text>
						<span style="color: red">*</span>
					</label>
				</div>
				
				<div class="input-field col s12 m4 l3">
					<input id="txtOccurdate" name="questionDate" type="date" class="datepicker" maxlength=10
						required data-parsley-required-message="<s:text name="QA0001"></s:text>" /> 
						<label for="txtOccurdate"><s:text name="questionDate"></s:text>
							<span style="color: red">*</span>
						</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12 m12 l12">
					<input id="txtTitle" name="qaTitle" type="text" length="1000" maxlength=1000 spellcheck="false"
						autocapitalize="off" autocomplete="off" autocorrect="off" required
						data-parsley-required-message="<s:text name="QA0001"></s:text>" 
						data-parsley-maxlength-message="<s:text name="QA0002"></s:text>"> 
						<label for="txtTitle"><s:text name="title"></s:text><span style="color: red">*</span></label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12 m12 l12">
					<i class="material-icons prefix">mode_edit</i>
					<textarea id="txtQuestion" spellcheck="false" autocapitalize="off" autocomplete="off"
						autocorrect="off" name="questionInfo" length="1000" maxlength=1000
						class="materialize-textarea" required data-parsley-required-message="<s:text name="QA0001"></s:text>"></textarea>
					<label for="txtQuestion"><s:text name="question"></s:text><span style="color: red">*</span></label>
				</div>
			</div>
			<div class="row">
				<div class="col s12 m12 l3" id="questionDivArea">
					<div class="row">
						<div class=" col s12 m12 l12">
							<span><s:text name="questionDiv"></s:text></span>
						</div>
					</div>
				</div>
				<div class="col s12 m12 l9" id="stageArea">
					<div class="row">
						<div class=" col s12 m12 l12">
							<span><s:text name="stage"></s:text><span style="color: red">*</span></span>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12 m4 l3">
					<select id="drpDetector" name="questioner" required
						data-parsley-required-message="<s:text name="QA0001"></s:text>">
					</select>
					<label for="drpDetector"><s:text name="questioner"></s:text><span style="color: red">*</span></label>
				</div>
				<div class="input-field col s12 m4 l3">
					<select id="drpAnswer" name="answerer" required
						data-parsley-required-message="<s:text name="QA0001"></s:text>">
						<option value="" disabled selected></option>
					</select>
					<label for="drpAnswer"><s:text name="answerer"></s:text><span style="color: red">*</span></label>
				</div>
				<div class="input-field col s12 m4 l3">
					<input id="txtExpDate" name="expDate" type="date" class="datepicker" maxlength=10 required
						data-parsley-required-message="<s:text name="QA0001"></s:text>"> 
						<label for="txtExpDate" class="active"><s:text name="expDate"></s:text><span style="color: red">*</span></label>
				</div>
				<div class="file-field input-field col s12 m4 l3">
					<div class="btn-floating  indigo lighten-3 right ">
						<i class="material-icons">file_upload</i><input type="file" name="model.file"
							onchange="checkFileValid(this)">
					</div>
					<div class="file-path-wrapper">
						<input class="file-path " name="qattachedInfo" type="text" readonly
							pattern="/\.(?:csv|xls|xlsx)$/i" data-parsley-pattern-message="<s:text name="QA0009"></s:text>">
						<label for="txtQUploadFile" class="active"><s:text name="questionUploadFile"></s:text></label>
					</div>
				</div>
			</div>
			<div class="row">
				
				
			</div>
			<div class="row">
				<div class="col s6 m6 l3 offset-s6">
					<input class="btn waves-effect waves-light  indigo lighten-3 " type="submit" id="qasave"
						value="<s:text name="save"></s:text>">
				</div>
			</div>

			<input type="hidden" name="argprojectId" value=${param.projectId }> 
			<input type="hidden" name="qaNo" value=${qaNo }>
		</form>
	</div>

	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/qa/QA0010.js"></script>

</body>
</html>