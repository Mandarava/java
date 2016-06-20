<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% 
String user=request.getParameter("userId"); 
request.setAttribute("userId",user);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="<%=request.getContextPath()%>/resources/js/jquery.form.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bug/errorMsg.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bug/USE0031.js"></script>
<title>用户编辑31</title>
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
					<form data-parsley-validate enctype="multipart/form-data" id="USE0031form">
					<div class="row">
				
						<div class="input-field col s12 m10 l7">
							<label for="userId" id="lblUserId"><s:text name="userId"></s:text></label>
							<input id="userId" name="userId" type="text"  value="${userId}" 
							data-parsley-pattern="[0-9a-zA-Z]+" data-parsley-pattern-message="<s:text name="USE0008"></s:text>"
							maxlength=16 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />								
						</div>	
						
						<div class="input-field col s12 m10 l7">		
							<label for="userName" id="lblUserName"><s:text name="userName"></s:text><span style="color: red">*</span></label>
							<input id="userName" name="userName" type="text"  
							required data-parsley-required-message="<s:text name="USE0001"></s:text>"  
							maxlength=20 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
						</div>		
			
						<div class="input-field col s12 m10 l7">		
							<label for="password" id="lblPassword"><s:text name="password"></s:text></label>
							<input id="password" name="password" type="password"  
							maxlength=18 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" 
							data-parsley-pattern="[0-9a-zA-Z]+" data-parsley-pattern-message="<s:text name="USE0008"></s:text>"/>	
						</div>		
					
						<div class="input-field col s12 m10 l7">		
							<label for="repassword"><s:text name="repassword"></s:text></label>
							<input id="repassword" name="repassword" type="password" 
							data-parsley-equalto="#password" data-parsley-equalto-message="<s:text name="USE0003"></s:text>"
							data-parsley-pattern="[0-9a-zA-Z]+" data-parsley-pattern-message="<s:text name="USE0008"></s:text>" 
							maxlength=18 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />							
						</div>			
					
						<div class="input-field col s12 m10 l7">		
							<select id="userPrevl" name="userPrevl" ></select>
							<label for="userPrevl"><s:text name="userPrevl"></s:text><span style="color: red">*</span></label>						
						</div>	
											
						<div class="col s12 m10 l7">
							<label for="company_select"><s:text name="company"></s:text><span style="color: red">*</span></label>
							<p>
								<input type="radio" class="with-gap" id="shanai" name="companyFlg" value="0"  />
								<label for="shanai"><s:text name="shanai"></s:text> </label>
							</p>
							<p>
								<input type="radio" class="with-gap" id="shagai" name="companyFlg" value="1" />
								<label for="shagai"><s:text name="shagai"></s:text> </label>
							</p>
						</div>		
					
						<div class="input-field col s12 m10 l7">	
							<select id="customerCode" name="customerCode" 
							required data-parsley-required-message="<s:text name="USE0001"></s:text>" >
							</select>
							<label for="customerCode"><s:text name="customer"></s:text><span style="color: red">*</span> </label>
						</div>	
			
						<div class="input-field col s12 m10 l7">	
							<select id="departmentId" name="departmentId" 
							required data-parsley-required-message="<s:text name="USE0001"></s:text>" > 
							</select>
							<label for="department"><s:text name="department"></s:text><span style="color: red">*</span> </label>
						</div>	
						
						<div class="input-field col s12 m10 l7">
							<select id="classId" name="classId"  ></select>
							<label for="classId"><s:text name="class"></s:text></label>
						</div>	
					
						<div class="input-field col s12 m10 l7">
							<label for="mailAddress" id="lblMailAddress"><s:text name="email"></s:text><span style="color: red">*</span></label> 
							<input id="mailAddress" name="mailAddress" type="email" 
							required data-parsley-required-message="<s:text name="USE0001"></s:text>"
							maxlength=40 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" 
							data-parsley-type-message="<s:text name="USE0004"></s:text>" />
						</div>	
					
						<div class="col s12 m10 l7">		
							<label for="deleteFlg_select"><s:text name="deleteFlg"></s:text><span style="color: red">*</span></label>
					　　		<p>
									<input type="radio" class="with-gap" id="noDel" name="deleteFlg" value="0" />
									<label for="noDel"><s:text name="noDel"></s:text> </label>
								</p>
								<p>
									<input type="radio" class="with-gap" id="hasDel" name="deleteFlg" value="1" /><label for="hasDel"><s:text
											name="hasDel"></s:text> </label>
								</p>
						</div>	
					
						<div class="input-field col s12 m10 l7">
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