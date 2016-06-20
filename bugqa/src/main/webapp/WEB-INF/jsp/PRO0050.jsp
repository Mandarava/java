<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% 
String project=request.getParameter("projectId"); 
String charge = request.getParameter("chargeId");
String manager = request.getParameter("managerId");
request.setAttribute("projectId",project);
request.setAttribute("chargeId",charge);
request.setAttribute("managerId",manager);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="<%=request.getContextPath()%>/resources/js/jquery.form.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bug/errorMsg.js"></script>
<title>追加</title>
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
		<input id="projectId" type="hidden" value="${projectId}" />
		<input id="chargeId" type="hidden" value="${chargeId}" />
		<input id="managerId" type="hidden" value="${managerId}" />
		
	<div id="PRO0050Table" style="margin-left: 0; margin-right: 0">
		<div class="row">
			<div class="card-content ">
				<blockquote>
					<h5 id="errormsg" style="color: red; display: none;">
						<s:text name="noData"></s:text>
					</h5>
				</blockquote>
			</div>
			<h4 class="header waves-effect waves-light" style="display: inline">
				<s:text name="PRO0050Title"></s:text>
				<span id="totalUser"></span>
			</h4>
			<div class="errorTxt0 color" ></div>
			<div class=" col s1 m1 right hide-on-small-only">
				<select id="numPerPageSelect">
					<option value="1">10</option>
					<option value="2">30</option>
					<option value="3">100</option>
					<option value="3">500</option>
				</select>
			</div>
			<div class="row">
				<div class="input-field col s6 m5 l5">
					<select id="customerCode" name="customerCode" ></select>
					<label for="customerCode"><s:text name="customer"></s:text></label>
				</div>
					
				<div class="input-field col s6 m5 l5">
					<select id="departmentId" name="departmentId" ></select>
					<label for="departmentId"><s:text name="department"></s:text></label>
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s6 m5 l5">
					<select id="classId" name="classId" ></select>
					<label for="classId"><s:text name="class"></s:text></label>
				</div>
							
				<div class="input-field col s4 m5 l5">
					<label for="users"><s:text name="user"></s:text></label>
					<input id="users" name="users" type="text" maxlength=20/>
				</div>
							
				<div class="input-field col s2 m2 l2">
					<button class="btn waves-effect waves-light right submit" id="btnSelect" name="select" type="button">
						<s:text name="select"></s:text><i class="mdi-content-send right"></i>
					</button>
				</div>
			</div>
			
			<div class="progress" id="PRO0050Progress">
				<div class="indeterminate"></div>
			</div>

			<div class="col s12">
				<table class="responsive-table highlight " id="PRO0050Tbl">
					<thead>
						<tr>
								<th data-field="select"></th>
								<th data-field="userId"><a href="#" id="userId"><s:text name="userId"></s:text></a></th>
								<th data-field="userName"><a href="#" id="userName"><s:text name="userName"></s:text></a></th>
								<th data-field="workType"><s:text name="workType"></s:text></th>
						</tr>
					</thead>
					<tbody id="PRO0050Tbody">

					</tbody>
				</table>
				<ul class="pagination right">
					<text id="PRO0050PageCount"></text>
					<li class="waves-effect">
					<a id="previousPage">
					<i	class="material-icons">chevron_left</i></a></li>
					<li class="waves-effect">
					<a id="nextPage"><i class="material-icons">chevron_right</i></a></li>
				</ul>
				
			</div>
			<div class="col s12 m10 l7">
				<button class="btn waves-effect waves-light submit" id="btnConfirm" name="confirm"
					type="button">
					<s:text name="confirm"></s:text>
				</button>
				<button class="btn waves-effect waves-light submit" id="btnCancel" name="cancel"
					type="button">
					<s:text name="cancel"></s:text>
				</button>	　　　　　　　　
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bug/PRO0050.js"></script>
</body>
</html>