<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<script src="<%=request.getContextPath()%>/resources/js/bug/errorMsg.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bug/USE0020.js"></script>
<title>新用户</title>
</head>
<style type="text/css">
.color {
	color: red;
}
</style>

<body>
	<div class="row">
		<div class="col s12 m12 l6">
			
					<div class="card-content ">
							<blockquote>
								<h5 id="errormsg" style="color:red;"></h5>
							</blockquote>
					</div> 
				<h5 class="header waves-effect waves-light">
					<s:text name="newUser"></s:text>
				</h5>
				<div class="errorTxt0" ></div>
				<div class="row">
					<form data-parsley-validate enctype="multipart/form-data" id="USE0020form">
						<div class="row">
							<div class="input-field col s12 m10 l10">
								<label for="userId"><s:text name="userId"></s:text><span style="color: red">*</span></label> 
								<input id="userId" name="userId" type="text" 
								required data-parsley-required-message="<s:text name="USE0001"></s:text>"  
								maxlength=16 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" 
								data-parsley-pattern="[0-9a-zA-Z]+" data-parsley-pattern-message="<s:text name="USE0008"></s:text>" />
							</div>

							<div class="input-field col s12 m10 l10">
								<label for="userName"><s:text name="userName"></s:text><span style="color: red">*</span></label> 
								<input id="userName" name="userName" type="text" 
								required data-parsley-required-message="<s:text name="USE0001"></s:text>"  
							 	maxlength=20 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>"  />
							</div>

							<div class="input-field col s12 m10 l10">
								<label for="password"><s:text name="password"></s:text><span style="color: red">*</span></label> 
								<input id="password" name="password" type="password"  
									required data-parsley-required-message="<s:text name="USE0001"></s:text>"
									maxlength=18 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" 
									data-parsley-pattern="[0-9a-zA-Z]+" data-parsley-pattern-message="<s:text name="USE0008"></s:text>" />
							</div>

							<div class="input-field col s12 m10 l10">
								<label for="repassword"><s:text name="repassword"></s:text><span style="color: red">*</span></label> 
								<input id="repassword" name="repassword" type="password" 
									required data-parsley-required-message="<s:text name="USE0001"></s:text>"
									data-parsley-equalto="#password" data-parsley-equalto-message="<s:text name="USE0003"></s:text>" />
							</div>

							<div class="input-field col s12 m10 l10">
								<select id="userPrevl" name="userPrevl" ></select>
								<label for="userPrevl"><s:text name="userPrevl"></s:text><span style="color: red">*</span></label>
								
							</div>

							<div class="col s12 m10 l10">
								<label for="company_select"><s:text name="company"></s:text><span style="color: red">*</span></label>
								<p>
									<input type="radio" class="with-gap" id="shanai" name="companyFlg" value="0" checked="checked"
										 /><label for="shanai"><s:text name="shanai"></s:text> </label>
								</p>
								<p>
									<input type="radio" class="with-gap" id="shagai" name="companyFlg" value="1" /><label for="shagai"><s:text
											name="shagai"></s:text> </label>
								</p>
								
							</div>

							<div class="input-field col s12 m10 l10">
								<select id="customerCode" name="customerCode" 
								required data-parsley-required-message="<s:text name="USE0001"></s:text>" >
									<option value="-1" disabled selected></option>
								</select><label for="customerCode"><s:text name="customer"></s:text><span style="color: red">*</span> </label>
								
							</div>

							<div class="input-field col s12 m10 l10">
								<select id="departmentId" name="departmentId" 
								required data-parsley-required-message="<s:text name="USE0001"></s:text>" >
									<option value="-1" disabled selected></option>
								</select><label for="department"><s:text name="department"></s:text><span style="color: red">*</span> </label>
								
							</div>

							<div class="input-field col s12 m10 l10">
								<select id="classId" name="classId" >
									<option value="-1" disabled selected></option>
								</select><label for="classId"><s:text name="class"></s:text></label>
								
							</div>

							<div class="input-field col s12 m10 l10">
								<label for="mailAddress"><s:text name="email"></s:text><span style="color: red">*</span></label>
								 <input id="mailAddress" name="mailAddress" type="email"  
									required data-parsley-required-message="<s:text name="USE0001"></s:text>"
									maxlength=40 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" 
									data-parsley-type-message="<s:text name="USE0004"></s:text>" />
							</div>
							<div class="row">
								<div class="input-field col s6 m16 l5">
									<button class="btn waves-effect waves-light grey lighten-1" id="btnCancel" name="cancel" type="button">
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
	<script src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>
	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script> 
</body>
</html>