<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<% 
String project=request.getParameter("projectId"); 
String groupId = request.getParameter("groupId");
String groupName = request.getParameter("groupName");
request.setAttribute("projectId",project);
request.setAttribute("groupId",groupId);
request.setAttribute("groupName",groupName);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="<%=request.getContextPath()%>/resources/js/bug/errorMsg.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bug/MOD0040.js"></script>
<title>模块编辑</title>
</head>
<style type="text/css">
.input-field {
	margin-bottom: -4px;
}
.color {
	color: red;
}
.hide {
	display:none;
}
</style>
<body>
			<input id="projectId" class="hide" value="${projectId}" />
			
	<div id="MOD0040Table" style="margin-left: 0; margin-right: 0">
		<div class="row ">
			<div class="card-content ">
					<blockquote>
						<h5 id="errormsg" style="color: red;"></h5>
					</blockquote>
			</div>
			<h4 class="header waves-effect waves-light" style="display: inline" id="titleH4">
				<s:text name="moduleEdit"></s:text>
				<span id="totalModule"></span>
			</h4>
			<div class=" col s1 m1 right hide-on-small-only">
				<select id="numPerPageSelect">
					<option value="1">10</option>
					<option value="2">30</option>
					<option value="3">100</option>
					<option value="3">500</option>
				</select>
			</div>
			<form data-parsley-validate enctype="multipart/form-data" id="MOD40form">
			
			<div class="row">
				<div class="input-field col s6 m5 l5">
					<label for="groupId" class="active"><s:text name="groupId"></s:text></label>
					<input id="groupId" name="groupId" type="text"  readOnly value="${groupId}" />
				</div>
							
				<div class="input-field col s6 m5 l5">
					<label for="groupName" class="active"><s:text name="groupName"></s:text></label>
					<input id="groupName" name="groupName" type="text"  readOnly value="${groupName}" />
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s6 m5 l5">
					<label for="moduleId"><s:text name="moduleId"></s:text><span style="color: red">*</span></label>
					<input id="moduleId" name="moduleId" type="text" maxlength=18 pattern="/^([A-Za-z]|[0-9])*$/"
					required data-parsley-required-message="<s:text name="USE0001"></s:text>"
					data-parsley-pattern-message="<s:text name="PRO0002"></s:text>"/>
				</div>
							
				<div class="input-field col s6 m5 l5">
					<label for="moduleName"><s:text name="moduleName"></s:text><span style="color: red">*</span></label>
					<input id="moduleName" name="moduleName" type="text" maxlength=50
					required data-parsley-required-message="<s:text name="USE0001"></s:text>"/>
				</div>
			</div>
						
			<div class="progress" id="MOD0040Progress">
				<div class="indeterminate"></div>
			</div>
			
			<div class="col s12">
				<table class="responsive-table highlight " id="MOD0040Tbl">
					<thead>
						<tr>
							<th data-field="moduleId"><a href="#" id="moduleId"><s:text name="moduleId"></s:text></a></th>
							<th data-field="moduleName"><a href="#" id="moduleName"><s:text name="moduleName"></s:text></a></th>
							<th data-field="delete"><s:text name="delete"></s:text></th>
						</tr>
					</thead>
					<tbody id="MOD0040Tbody">
					</tbody>
				</table>
				<ul class="pagination right">
					<text id="MOD0040PageCount"></text>
					<li class="waves-effect">
					<a id="previousPage">
					<i	class="material-icons">chevron_left</i></a></li>
					<li class="waves-effect">
					<a id="nextPage"><i class="material-icons">chevron_right</i></a></li>
				</ul>
			</div>
			
			<div class="row">
			<div class="input-field col s3 m3 l3">
				<button class="btn waves-effect waves-light left submit" id="btnAdd" name="add" type="submit">
					<s:text name="add"></s:text>
					<i class="mdi-content-send right"></i>
				</button>
			</div>
			<div class="input-field col s6 m6 l6">
				<button class="btn waves-effect waves-light right submit" id="btnSave" name="save" type="button">
					<s:text name="save"></s:text>
					<i class="mdi-content-send right"></i>
				</button>
			</div>
			<div class="input-field col s3 m3 l3">
				<button class="btn waves-effect waves-light grey lighten-1" id="btnCancel" name="cancel" type="button">
					<s:text name="cancel"></s:text>
					<i class="mdi-content-reply left"></i>
				</button>
			</div>
			</div>
			</form>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
</body>
</html>