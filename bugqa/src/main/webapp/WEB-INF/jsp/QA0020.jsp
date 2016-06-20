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
<title>QA0020</title>
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
			<div class="col s12 m4 l2 offset-by-6">
				<h5 class="header">
					<s:text name="QATicket"></s:text>
				</h5>
			</div>
		</div>

		<form data-parsley-validate enctype="multipart/form-data">
			<div class="row">
				<div class="input-field col s12 m4 l6">
					<input id="txtProjectName" name="projectId" type="text" readonly required
						data-parsley-required-message="<s:text name="QA0001"></s:text>" /> 
						<label for="txtProjectName"><s:text name="systemName"></s:text>
							<span style="color: red">*</span>
						</label>
				</div>
				
				<div class="input-field col s12 m4 l3">
					<input id="txtQANO" name="qaNo" type="text" length="11" maxlength="11" readonly> 
					<label for="txtQANO"><s:text name="QANO"></s:text></label>
				</div>
				
				<div class="input-field col s12 m4 l3">
					<input id="txtRelationQAID" name="relationQaNo" type="text" maxlength="11"> 
					<label for="txtRelationQAID"><s:text name="relationQAID"></s:text></label>
				</div>
			</div>

			<div class="row">
				<div class="input-field col s12 m4 l3">
					<select id="drpGroupName" name="groupId" required
						data-parsley-required-message="<s:text name="QA0001"></s:text>">
					</select>
					<label for="drpGroupName"><s:text name="drpGroupName"></s:text>
						<span style="color: red">*</span>
					</label>
				</div>
				
				<div class="input-field col s12 m4 l3">
					<select id="drpModuleName" name="moduleId" required
						data-parsley-required-message="<s:text name="QA0001"></s:text>">
					</select>
					<label for="drpModuleName"><s:text name="drpModuleName"></s:text>
						<span style="color: red">*</span>
					</label>
				</div>
				
				<div class="input-field col s12 m4 l3">
					<input id="txtQuestionDate" name="questionDate" type="date" class="datepicker" maxlength="10"
						required data-parsley-required-message="<s:text name="QA0001"></s:text>"> 
						<label for="txtQuestionDate"><s:text name="questionDate"></s:text>
							<span style="color: red">*</span>
						</label>
				</div>
				
				<div class="input-field col s12 m4 l3">
					<input id="txtExpDate" name="expDate" type="date" class="datepicker" maxlength="10" required
						data-parsley-required-message="<s:text name="QA0001"></s:text>"> 
					<label for="txtExpDate"><s:text name="expDate"></s:text>
						<span style="color: red">*</span>
					</label>
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s12 m12 l12">
					<input id="txtTitle" name="qaTitle" type="text" length="1000" maxlength="1000"
						spellcheck="false" autocapitalize="off" autocomplete="off" autocorrect="off" required
						data-parsley-required-message="<s:text name="QA0001"></s:text>"
						data-parsley-maxlength-message="<s:text name="QA0002"></s:text>"> 
					<label for="txtTitle"><s:text name="title"></s:text>
						<span style="color: red">*</span>
					</label>
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s12 m4 l3">
					<select id="drpQuestionUser" name="questioner" required
						data-parsley-required-message="<s:text name="QA0001"></s:text>">
					</select>
					<label for="drpQuestionUser"><s:text name="questioner"></s:text>
						<span style="color: red">*</span>
					</label>
				</div>
				
				
				<div class="input-field col s12 m4 l3">
					<select id="drpAnswerUser" name="answerer" required
						data-parsley-required-message="<s:text name="QA0001"></s:text>">
					</select>
					<label for="drpAnswerUser"><s:text name="answerer"></s:text>
						<span style="color: red">*</span>
					</label>
				</div>
				
				<div class="file-field input-field col s12 m4 l3">
					<div class="btn-floating indigo lighten-3 right ">
						<i class="material-icons">file_upload</i>
						<input type="file" name="model.QUploadFile" onchange="checkFileValid(this)">
					</div>
					
					<div class="file-path-wrapper">
						<input class="file-path " id="txtQUploadFile" name="qattachedInfo" type="text" readonly
							pattern="/\.(?:csv|xls|xlsx)$/i" 
							data-parsley-pattern-message="<s:text name="QA0009"></s:text>" > 
						<label for="txtQUploadFile" class="active"><s:text name="questionUploadFile"></s:text></label>
					</div>
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
				<div class="input-field col s12 m12 l12">
					<i class="material-icons prefix">mode_edit</i>
					<textarea id="txtQuestion" name="questionInfo" spellcheck="false" autocapitalize="off"
						autocomplete="off" autocorrect="off" class="materialize-textarea" length="1000"
						maxlength="1000" required 
						data-parsley-required-message="<s:text name="QA0001"></s:text>"
						data-parsley-maxlength-message="<s:text name="QA0002"></s:text>"></textarea>
					<label for="txtQuestion"><s:text name="question"></s:text>
						<span style="color: red">*</span>
					</label>
				</div>
			</div>

			<div class="row">
				<div class="col s12 m4 l2">
					<h5 class="header">
						<s:text name="answer"></s:text>
					</h5>
				</div>
			</div>

			<div class="row">
			
				<div class="input-field col s12 m4 l3">
					<input id="txtAnswerUser" name="txtAnswerUser" type="text" readonly> 
					<label for="txtAnswerUser" class="active"><s:text name="answerer"></s:text></label>
				</div>
				
				<div class="input-field col s12 m4 l3">
					<input id="txtAnswerDate" name="answerDate" type="date" class="datepicker" maxlength="10"
						required data-parsley-required-message="<s:text name="QA0001"></s:text>"> 
						<label for="txtAnswerDate" class="active"><s:text name="answerDate"></s:text>
							<span style="color: red">*</span>
						</label>
				</div>
				
				<div class="file-field input-field col s12 m4 l3">
					<div class="btn-floating indigo lighten-3 right ">
						<i class="material-icons">file_upload</i>
						<input type="file" name="model.AUploadFile" onchange="checkFileValid(this)">
					</div>
					
					<div class="file-path-wrapper">
						<input class="file-path " id="txtAUploadFile" name="aattachedInfo" type="text" readonly
							pattern="/\.(?:csv|xls|xlsx)$/i" 
							data-parsley-pattern-message="<s:text name="QA0009"></s:text>" > 
						<label for="txtAUploadFile" class="active"><s:text name="answerUploadFile"></s:text></label>
					</div>
				</div>
				
			</div>
			
			<div class="input-field col s12 m12 l12">
				<i class="material-icons prefix">mode_edit</i>
				<textarea id="txtAnswer" name="answerInfo" spellcheck="false" autocapitalize="off"
					autocomplete="off" autocorrect="off" class="materialize-textarea" length="1000"
					maxlength="1000" required 
					data-parsley-required-message="<s:text name="QA0001"></s:text>"
					data-parsley-maxlength-message="<s:text name="QA0002"></s:text>"></textarea>
				<label for="txtAnswer"><s:text name="answer"></s:text>
					<span style="color: red">*</span>
				</label>
			</div>
			
			<div class="input-field col s12 m12 l12">
				<i class="material-icons prefix">mode_edit</i>
				<textarea id="txtComment" name="remark" spellcheck="false" autocapitalize="off"
					autocomplete="off" autocorrect="off" class="materialize-textarea" length="1000"
					maxlength="1000" 
					data-parsley-maxlength-message="QA0002"></textarea>
				<label for="txtComment"><s:text name="comment"></s:text></label>
			</div>

			<div class="row">
				<div class="col s12 m12 l12" id="causeDivArea">
					<div class="row">
						<div class=" col s12 m12 l12">
							<span><s:text name="causeDiv"></s:text></span>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col s12 m12 l12">
					<div class="input-field col s7 m3 l2 " style="display: none">
						<button class="btn waves-effect waves-light indigo lighten-3 " id="btnBack" type="button">
							<s:text name="return"></s:text>
							<i class="mdi-content-reply left"></i>
						</button>
					</div>
					<div class="input-field col s7 m3 l2" style="display: none">
						<button class="btn waves-effect waves-light indigo lighten-3" id="btnSubmit" type="submit">
							<s:text name="save"></s:text>
						</button>
					</div>
					<div class="input-field col s7 m3 l2 " style="display: none">
						<button class="btn waves-effect waves-light indigo lighten-3 " id="btnRecieve" type="button">
							<s:text name="recieve"></s:text>
						</button>
					</div>
					<div class="input-field col s7 m3 l2 " style="display: none">
						<button class="btn waves-effect waves-light indigo lighten-3 " id="btnAnswer" type="submit">
							<s:text name="answered"></s:text>
						</button>
					</div>
					<div class="input-field col s7 m3 l2" style="display: none">
						<button class="btn waves-effect waves-light indigo lighten-3" id="btnAccept" type="button">
							<s:text name="accept"></s:text>
						</button>
					</div>
					<div class="input-field col s7 m3 l2" style="display: none">
						<button class="btn waves-effect waves-light indigo lighten-3" id="btnNotAccept" type="button">
							<s:text name="notAccept"></s:text>
						</button>
					</div>
					<div class="input-field col s7 m3 l2" style="display: none">
						<button class="btn waves-effect waves-light indigo lighten-3" id="btnMove" type="button">
							<s:text name="move"></s:text>
						</button>
					</div>
					<div class="input-field col s7 m3 l2" style="display: none">
						<button class="btn waves-effect waves-light indigo lighten-3 " id="btnOther" type="button">
							<s:text name="other"></s:text>
						</button>
					</div>
					<div class="input-field col s7 m3 l2" style="display: none">
						<button class="btn waves-effect waves-light indigo lighten-3" id="btnReserve" type="button">
							<s:text name="reserve"></s:text>
						</button>
					</div>
					<div class="input-field col s7 m3 l2" style="display: none">
						<button class="btn waves-effect waves-light indigo lighten-3 " id="btnResCancel" type="button">
							<s:text name="resCancel"></s:text>
						</button>
					</div>
					<div class="input-field col s7 m3 l2 " style="display: none">
						<button class="btn waves-effect waves-light indigo lighten-3 " id="btnDel" type="button">
							<s:text name="delete"></s:text>
						</button>
					</div>
					<div class="input-field col s7 m3 l2" style="display: none">
						<button class="btn waves-effect waves-light indigo lighten-3" id="btnLook" type="button">
							<s:text name="historyLook"></s:text>
						</button>
					</div>
				</div>
			</div>

			<input type="hidden" name="projectId" value=${projectId }> <input type="hidden"
				name="serialNum" value=${serialNum }> <input type="hidden" name="qaNo" value=${qaNo }>
			<input type="hidden" name="updateTime">

		</form>
	</div>

	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/qa/QA0020.js"></script>

</body>
</html>
