<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% 
String name=request.getParameter("name");
String code=request.getParameter("code"); 
String kbn=request.getParameter("kbn"); 
String remark=request.getParameter("remark"); 
request.setAttribute("name",name);
request.setAttribute("code",code);
request.setAttribute("kbn",kbn);
request.setAttribute("remark",remark);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bug/errorMsg.js"></script>

<title>通用编辑</title>
</head>
<style type="text/css">
	.input-field { 
	margin-bottom: -4px;
}
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
					<s:text name="updateGeneral"></s:text>
				</h5>
				<div class="row">
					<form data-parsley-validate enctype="multipart/form-data" id="COM0020form">
					<div class="row">
				
						<div class="input-field col s12 m10 l7">
							<label for="kbn" id="lblkbn"><s:text name="kbn"></s:text></label>
							<input id="kbn" name="kbn" type="text" data-error=".errorTxt1" value="${kbn}" readonly="readonly" />	
							<div class="errorTxt1 color"></div>
						</div>	
						
						<div class="input-field col s12 m10 l7">		
							<label for="code" id="lblcode" ><s:text name="code"></s:text></label>
							<input id="code" name="code" type="text" data-error=".errorTxt2" value="${code}" readonly="readonly" />
							<div class="errorTxt2 color"></div>
						</div>		
			
						<div class="input-field col s12 m10 l7">		
							<label for="name" id="lblname"><s:text name="name"></s:text><span style="color: red">*</span></label>
							<input id="name" name="name" type="text" value="${name}" class="active"
							required data-parsley-required-message="<s:text name="USE0001"></s:text>" 
							maxlength=50 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>"  />
							
						</div>		
					
						<div class="input-field col s12 m10 l7">		
							<label for="remark" id="lblremark"><s:text name="remark"></s:text></label>
							<input id="remark" name="remark" type="text" value="${remark}"
							maxlength=100 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
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
					
	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bug/COM0020.js"></script>
	</body>
</html>