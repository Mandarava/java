<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% 
String id=request.getParameter("projectId");
String userid=request.getParameter("userId");
String name=request.getParameter("userName");
String fromBack=request.getParameter("from");
String pro0050 = request.getParameter("pro0050");
String cancel = request.getParameter("cancelfrom");

request.setAttribute("projectId",id);
request.setAttribute("userId",userid);
request.setAttribute("userName",name);
request.setAttribute("fromBack",fromBack);
request.setAttribute("pro0050",pro0050);
request.setAttribute("cancelfrom",cancel);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.form.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/js/treeview/jquery.treeview.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/js/treeview/screen.css"/>
<script src="<%=request.getContextPath()%>/resources/js/bug/errorMsg.js"></script>

<title>项目编辑</title>
</head>
<style type="text/css">
.color {
	color: red;
}

.div {
	border-style:solid;
	border-color:rgb(92,107,192);
	overflow:auto;
	height:200px;
	width:100%
}

[type="checkbox"]:not(:checked), 
[type="checkbox"]:checked {
     position: relative; 
     left: 2px; 
     opacity: 1; 
     color : black;
}
.blockUI input{ vertical-align:middle; margin:0; padding:0}
.blockUI .file-box{ position:relative;width:340px}
.blockUI .txt{ height:25px; border:1px solid #cdcdcd; width:200px; color:black;}
.blockUI .btn{ background-color:#FFF; border:1px solid #CDCDCD;height:28px; width:70px; color:black;}
.blockUI .file{ position:absolute; top:0; right:80px; height:24px; filter:alpha(opacity:0);opacity: 0;width:260px; color:black;}
</style>

<body>

		<input id="projectId" type="hidden" value="${projectId}" />
		<input id="userId" type="hidden" value="${userId}" />
		<input id="userName" type="hidden" value="${userName}" />
		<input id="fromBack" type="hidden" value="${fromBack}" />
		<input id="pro0050AddMember" type="hidden" value="${pro0050}" />
		<input id="cancelfrom" type="hidden" value="${cancelfrom}" />
					
		<div class="col s12 m12 l6">
			
				<div class="card-content ">
					<blockquote>
						<h5 id="errormsg" style="color: red;"></h5>
					</blockquote>
				</div>
				<h5 class="header waves-effect waves-light">
					<s:text name="PRO0030Title"></s:text>
				</h5>
				<div class="errorTxt0 color" ></div>
			<form data-parsley-validate enctype="multipart/form-data" id="PRO0030form">			
			<div class="row">
				<div class="input-field col s3 m3 l3">
					<label for="projectName" id="lblProjectName" class="active" ><s:text name="projectName"></s:text><span style="color: red">*</span></label>
					<input id="projectName" name="projectName" type="text"  
					required data-parsley-required-message="<s:text name="USE0001"></s:text>" 
					maxlength=40 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>"/>
				</div>
				
				<div class="input-field col s3 m3 l3">
					<select id="companyInCode" name="companyInCode" 
					required data-parsley-required-message="<s:text name="USE0001"></s:text>"></select>
					<label for="companyInCode" id="lblCompanyInCode"  ><s:text name="companyInCode"></s:text><span style="color: red">*</span></label>
					
				</div>
				
				<div class="input-field col s3 m3 l3">
					<label for="chargeId" id="lblChargeId" class="active"><s:text name="chargeId"></s:text></label>
					<input id="chargeId" name="chargeId" type="text" readOnly />
					
				</div>
				
				<div class="input-field col s2 m2 l2">
					<button class="btn waves-effect waves-light  right submit" id="btnSelectCharge" name="select" type="button">
							<s:text name="select"></s:text>
					</button>
				</div>
				
				
			</div>
			
			<div class="row">
				
				<div class="input-field col s3 m3 l3">
					<select id="companOutCode" name="companOutCode" 
								required data-parsley-required-message="<s:text name="USE0001"></s:text>" ></select>
					<label for="companOutCode" id="lblCompanOutCode"  ><s:text name="companOutCode"></s:text><span style="color: red">*</span></label>
					
				</div>
				
				<div class="input-field col s3 m3 l3">
					<select id="stateFlg" name="stateFlg" 
					required data-parsley-required-message="<s:text name="USE0001"></s:text>"></select>
					<label for="stateFlg" id="lblStateFlg" ><s:text name="stateFlg"></s:text><span style="color: red">*</span></label>
					
				</div>
		
				<div class="input-field col s3 m3 l3">
					<label for="managerId" id="lblManagerId" class="active"><s:text name="managerId"></s:text></label>
					<input id="managerId" name="managerId" type="text" readOnly />
					
				</div>
				
				<div class="input-field col s2 m2 l2">
					<button class="btn waves-effect waves-light  right submit" id="btnSelectManager" name="select" type="button">
							<s:text name="select"></s:text>
					</button>
				</div>
				
			</div>
			
			<div class="row">
			
				<div class="input-field col s3 m3 l3">
					<label for="startDate" id="lblStartDate" class="active"><s:text name="startDate"></s:text><span style="color: red">*</span></label>
					<input id="startDate" name="startDate" type="date" class="datepicker" 
					required data-parsley-required-message="<s:text name="USE0001"></s:text>"/>
					
				</div>
				
				<div class="input-field col s3 m3 l3">
					<label for="endDate" id="lblEndDate" class="active"><s:text name="endDate"></s:text><span style="color: red">*</span></label>
					<input id="endDate" name="endDate" type="date" class="datepicker" 
					required data-parsley-required-message="<s:text name="USE0001"></s:text>"/>
					
				</div>
					
				<div class="input-field col s3 m3 l3">
					<label for="chkEndDate" id="lblChkEndDate" class="active"><s:text name="chkEndDate"></s:text><span style="color: red">*</span></label>
					<input id="chkEndDate" name="chkEndDate" type="date" class="datepicker" 
					required data-parsley-required-message="<s:text name="USE0001"></s:text>"/>
					
				</div>
				
				<div class="input-field col s2 m2 l2">
					<button class="btn waves-effect waves-light  right submit" id="btnSave" name="save" type="submit">
							<s:text name="save"></s:text>
					</button>
				</div>
				
			</div>
		</form>
	</div>	
	<div class="row">
		<div class="row" id="PRO0030Table">	
			<div class="progress" >
			</div>		
			<div class="card-content ">
				<blockquote>
					<h5 id="errormsg" style="color: red; display: none;">
						<s:text name="noData"></s:text>
					</h5>
				</blockquote>
			</div>
			<div class="col s12 m12 l6">
				<h5 class="header waves-effect waves-light" style="display: inline">
					<s:text name="projectMember"></s:text>
					<span id="totalProjectMember"></span>
				</h5>
			</div>
			<div class=" col s1 m1 right hide-on-small-only">
				<select id="numPerPageSelect">
					<option value="1">10</option>
					<option value="2">30</option>
					<option value="3">100</option>
					<option value="3">500</option>
				</select>
			</div>
			<div class="col s12">
				<table class="responsive-table highlight " id="PRO0030Tbl">
					<thead>
						<tr>
							<th data-field="userId"><a href="#" id="userId"><s:text name="userId"></s:text></a></th>
							<th data-field="userName"><a href="#" id="userName"><s:text name="userName"></s:text></a></th>
							<th data-field="workType"><a href="#" id="workType"><s:text name="workType"></s:text></a></th>
							<th data-field="delete"><s:text name="delete"></s:text></th>
						</tr>
					</thead>
					<tbody id="PRO0030Tbody">
					</tbody>
				</table>
				
				<div class="row">			
					<ul class="pagination right">
						<text id="PRO0030PageCount"></text>
						<li class="waves-effect">
						<a id="previousPage">
						<i	class="material-icons">chevron_left</i></a></li>
						<li class="waves-effect">
						<a id="nextPage"><i class="material-icons">chevron_right</i></a></li>
					</ul>
					<div class="input-field col s10 m10 l10">
						<button class="btn waves-effect waves-light  right submit" id="btnAdd" name="add" type="button">
							<s:text name="memberAdd"></s:text>
						</button>
					</div>
			
				</div>
			</div>	
		</div>
	</div>
	<div class="row">	
			<div class="progress" >
			</div>
			<div class="row">
				<div class="col s12 m12 l6">
					<h5 class="header waves-effect waves-light" style="display: inline">
						<s:text name="module"></s:text>
						<span id="module"></span>
					</h5>
				</div>
				<div class="input-field col s8 m8 l8 div" >
					<div class="st_tree" id="st_tree">
					
					</div>	
				</div>	
				
				<div class="input-field col s3 m3 l3" >
					<div class="row">
						<button class="btn waves-effect waves-light  right submit" id="btnGroupEdit" name="groupEdit" type="button">
							<s:text name="groupEdit"></s:text>
							
						</button>
					</div>
					
					<div class="row">
						<button class="btn waves-effect waves-light  right submit" id="btnModuleEdit" name="moduleEdit" type="button">
							<s:text name="moduleEdit"></s:text>
							
						</button>
					</div>
					
					<div class="row">
						<button class="btn waves-effect waves-light  right submit" id="btnCSVImport" name="csvImport" type="button">
							<s:text name="csvimport"></s:text>
							
						</button>
					</div>
					
				</div>
				
			</div>
			
			<div class="row">
				<div class="input-field col s2 m2 l2">
					<button class="btn waves-effect waves-light  submit" id="btnOpen" name="open" type="button">
						<s:text name="open"></s:text>
					</button>
				</div>
				<div class="input-field col s2 m2 l2">
					<button class="btn waves-effect waves-light  submit" id="btnClose" name="close" type="button">
						<s:text name="close"></s:text>
					</button>
				</div>
				
				<div class="input-field col s5 m5 l5">
				</div>
				
				<div class="input-field col s3 m3 l3">
					<a id="csvTemplate" name="csvTemplate" style="text-align:right;border-bottom:#000000 solid 1px;"><s:text name="csvTemplate"></s:text></a>
				</div>
				
			</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>
	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script> 
	<script src="<%=request.getContextPath()%>/resources/js/treeview/jquery.treeview.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.blockUI.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bug/PRO0030.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bug/IMP0010.js"></script>
</body>
</html>