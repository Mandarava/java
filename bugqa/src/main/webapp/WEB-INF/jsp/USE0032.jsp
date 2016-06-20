<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="<%=request.getContextPath()%>/resources/js/jquery.form.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bug/errorMsg.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bug/USE0032.js"></script>
<title>用户编辑32</title>
</head>
<style type="text/css">
.color {
	color: red;
}
</style>
<body>

	<div class="row">
		<div class="col s12 m12 l8">
			
				<div class="card-content ">
					<blockquote>
						<h5 id="errormsg" style="color: red;"></h5>
					</blockquote>
				</div>
				<h5 class="header waves-effect waves-light">
					<s:text name="updateUser"></s:text>
				</h5>
				<div class="errorTxt0" ></div>
				<div class="row">
					<form data-parsley-validate enctype="multipart/form-data" id="USE0032form">
					<div class="row">

						<div class="input-field col s12 m12 l8">
							<label for="userId" id="lblUserId"><s:text name="userId"></s:text></label>
							<input id="userId" name="userId" type="text" disabled/>	
						</div>

						<div class="input-field col s12 m12 l8">		
							<label for="userName" id="lblUserName"><s:text name="userName"></s:text><span style="color: red">*</span></label>
							<input id="userName" name="userName" type="text"
							required data-parsley-required-message="<s:text name="USE0001"></s:text>"  
							maxlength=20 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
						</div>	


						<div class="input-field col s12 m12 l8">		
							<label for="password" id="lblPassword"><s:text name="password"></s:text><span style="color: red">*</span></label>
							<input id="password" name="password" type="password" 
							required data-parsley-required-message="<s:text name="USE0001"></s:text>"
							maxlength=18 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" 
							data-parsley-pattern="[0-9a-zA-Z]+" data-parsley-pattern-message="<s:text name="USE0008"></s:text>" />
						</div>	

						<div class="input-field col s12 m12 l8">		
							<label for="repassword"><s:text name="repassword"></s:text><span style="color: red">*</span></label>
							<input id="repassword" name="repassword" type="password" 
							required data-parsley-required-message="<s:text name="USE0001"></s:text>"
							data-parsley-equalto="#password" data-parsley-equalto-message="<s:text name="USE0003"></s:text>" />
						</div>	

						<div class="input-field col s12 m12 l8">
							<label for="mailAddress" id="lblMailAddress"><s:text name="email"></s:text><span style="color: red">*</span></label> 
							<input id="mailAddress" name="mailAddress" type="email" 
							required data-parsley-required-message="<s:text name="USE0001"></s:text>"
							maxlength=40 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" 
							data-parsley-email-message="<s:text name="USE0004"></s:text>" />
						</div>	


						<div class="input-field col s12 m12 l8">
							<button class="btn waves-effect waves-light grey lighten-1" id="btnCancel" name="cancel" type="button">
									<s:text name="cancel"></s:text>
									<i class="mdi-content-reply left"></i>
							</button>
							<button class="btn waves-effect waves-light right submit" id="btnSave" name="save" type="submit">
									<s:text name="save"></s:text>
									<i class="mdi-content-send right"></i>
							</button>
						</div>
						
					</div>
				</form>
		
		</div>
	</div>
</div>
	
</body>
</html>