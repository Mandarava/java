<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% 
String user=request.getParameter("userId");
String user1=request.getParameter("userName");
String fromBack=request.getParameter("from");
String cancel = request.getParameter("cancelfrom");

request.setAttribute("userId",user);
request.setAttribute("userName",user1);
request.setAttribute("fromBack",fromBack);
request.setAttribute("cancelfrom",cancel);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bug/errorMsg.js"></script>
<title>新项目</title>
</head>
<style type="text/css">
.color {
	color: red;
}
</style>
<body>
		<input id="id" type="hidden" value="${userId}" />
		<input id="name" type="hidden" value="${userName}" />
		<input id="fromBack" type="hidden" value="${fromBack}" />
		<input id="cancelfrom" type="hidden" value="${cancelfrom}" />
	<div class="row">
		<div class="col s12 m12 l6">
				<div class="card-content ">
					<blockquote>
						<h5 id="errormsg" style="color: red;"></h5>
					</blockquote>
				</div>
				<h5 class="header waves-effect waves-light">
					<s:text name="PRO0020Title"></s:text>
				</h5>
				
				<div class="row">
					<form data-parsley-validate enctype="multipart/form-data" id="PRO0020form">
						<div class="row">			

							<div class="input-field col s12 m10 l10">
								<label for="projectId" id="lblProjectId"><s:text name="projectId"></s:text><span style="color: red">*</span></label>
								<input id="projectId" name="projectId" type="text"  
								required data-parsley-required-message="<s:text name="USE0001"></s:text>" 
								maxlength=14 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>"
								data-parsley-pattern="[0-9a-zA-Z]+" data-parsley-pattern-message="<s:text name="PRO0002"></s:text>"/>

							</div>

							<div class="input-field col s12 m10 l10">
								<label for="projectName" id="lblProjectName"><s:text name="projectName"></s:text><span style="color: red">*</span></label>
								<input id="projectName" name="projectName" type="text"  
								required data-parsley-required-message="<s:text name="USE0001"></s:text>"
								maxlength=40 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>"/>
							</div>

							<div class="input-field col s12 m10 l10">
								<select id="companyInCode" name="companyInCode" 
								required data-parsley-required-message="<s:text name="USE0001"></s:text>" ></select>
								<label for="companyInCode" id="lblCompanyInCode"><s:text name="companyInCode"></s:text><span style="color: red">*</span></label>
							</div>

							<div class="input-field col s12 m10 l10">
								<select id="companOutCode" name="companOutCode" 
								required data-parsley-required-message="<s:text name="USE0001"></s:text>" ></select>
								<label for="companOutCode" id="lblCompanOutCode"><s:text name="companOutCode"></s:text><span style="color: red">*</span></label>
							</div>

							<div class="input-field col s12 m10 l10">
								<select id="stateFlg" name="stateFlg" 
								required data-parsley-required-message="<s:text name="USE0001"></s:text>" ></select>
								<label for="stateFlg" id="lblStateFlg"><s:text name="stateFlg"></s:text><span style="color: red">*</span></label>
							</div>
							
							<div class="row">
								<div class="input-field col s10 m8 l8">
									<label for="chargeId" id="lblChargeId"><s:text name="chargeId"></s:text></label>
									<input id="chargeId" name="chargeId" type="text" readOnly />
								</div>
								<div class="input-field col s2 m2 l2">
									<button class="btn waves-effect waves-light right submit" id="btnSelectCharge" name="select" type="button">
										<s:text name="select"></s:text>
										<i class="mdi-content-send right"></i>
									</button>
								</div>
							</div>

							<div class="input-field col s12 m10 l10">
								<label for="startDate" id="lblStartDate"><s:text name="startDate"></s:text><span style="color: red">*</span></label>
								<input id="startDate" name="startDate" type="date" class="datepicker" 
								required data-parsley-required-message="<s:text name="USE0001"></s:text>" />
							</div>

							<div class="input-field col s12 m10 l10">
								<label for="endDate" id="lblEndDate"><s:text name="endDate"></s:text><span style="color: red">*</span></label>
								<input id="endDate" name="endDate" type="date" class="datepicker" 
								required data-parsley-required-message="<s:text name="USE0001"></s:text>" />
							</div>

							<div class="input-field col s12 m10 l10">
								<label for="chkEndDate" id="lblChkEndDate"><s:text name="chkEndDate"></s:text><span style="color: red">*</span></label>
								<input id="chkEndDate" name="chkEndDate" type="date" class="datepicker" 
								required data-parsley-required-message="<s:text name="USE0001"></s:text>" />
							</div>

							<div class="row">
								<div class="input-field col s10 m8 l8">
									<label for="managerId" id="lblManagerId"><s:text name="managerId"></s:text></label>
									<input id="managerId" name="managerId" type="text" readOnly />

								</div>
								<div class="input-field col s2 m2 l2">
									<button class="btn waves-effect waves-light right" id="btnSelectManager" name="select" type="button">
										<s:text name="select"></s:text>
										<i class="mdi-content-send right"></i>
									</button>
								</div>
							</div>

							<div class="row">
								<div class="input-field col s6 m16 l5">
									<button class="btn waves-effect waves-light lighten-1" id="btnCancel" name="cancel" type="button">
										<s:text name="cancel"></s:text>
										<i class="mdi-content-reply left"></i>
									</button>
								</div>
								<div class="input-field col s6 m16 l5">
									<button class="btn waves-effect waves-light right submit" id="btnSave" name="save" type="submit">
										<s:text name="save"></s:text>
										<i class="mdi-content-send right"></i>
									</button>
								</div>
							</div>
			
						</div>
					</form>
				
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script> 
	<script src="<%=request.getContextPath()%>/resources/js/bug/PRO0020.js"></script>
</body>
</html>