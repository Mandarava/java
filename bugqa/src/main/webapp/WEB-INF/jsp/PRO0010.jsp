<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>
<title>PRO0010</title>
</head>
<body>
	<div id="PRO0010Table" style="margin-left: 1%; margin-right: 1%">
		<div class="row">
			<div class="card-content ">
				<blockquote>
					<h5 id="errormsg" style="color: red; display: none;">
						<s:text name="noData"></s:text>
					</h5>
				</blockquote>
			</div>
			<h4 class="header waves-effect waves-light" style="display: inline">
				<s:text name="PRO0010Title"></s:text>
				<span id="totalProject"></span>
			</h4>
			<div class=" col s1 m1 right hide-on-small-only">
				<select id="numPerPageSelect">
					<option value="1">10</option>
					<option value="2">30</option>
					<option value="3">100</option>
					<option value="3">500</option>
				</select>
			</div>
			
			<%-- <div class="row">
				<div class="input-field col s3 m3 l2"> 
					<input id="searchKey" name="searchKey" type="text"
					maxlength=20 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
				</div>		
			
			</div>
			 --%>
			
			<div class="progress" id="PRO0010Progress">
				<div class="indeterminate"></div>
			</div>
			<div class="col s12">
				<table class="responsive-table highlight " id="PRO0010Tbl">
					<thead>
						<tr>
							<th data-field="projectId"><a href="#" id="projectId"><s:text name="projectId"></s:text></a></th>
							<th data-field="projectName"><a href="#" id="projectName"><s:text name="projectName"></s:text></a></th>
							<th data-field="startDate"><a href="#" id="startDate"><s:text name="startDate"></s:text></a></th>
							<th data-field="endDate"><a href="#" id="endDate"><s:text name="endDate"></s:text></a></th>
							<th data-field="chkendDate"><a href="#" id="chkendDate"><s:text name="chkEndDate"></s:text></a></th>
							<th data-field="stateFlg"><a href="#" id="stateFlg"><s:text name="stateFlg"></s:text></a></th>
							<th data-field="delete"><s:text name="delete"></s:text></th>
						</tr>
					</thead>
					<tbody id="PRO0010Tbody">

					</tbody>
				</table>
				<ul class="pagination right">
					<text id="PRO0010PageCount"></text>
					<li class="waves-effect">
					<a id="previousPage">
					<i	class="material-icons">chevron_left</i></a></li>
					<li class="waves-effect">
					<a id="nextPage"><i class="material-icons">chevron_right</i></a></li>
				</ul>
			</div>
			<div class="col s12 m10 l7">
				<button class="btn waves-effect waves-light submit" id="newBtn" name="newProBtn"
					type="button">
					<s:text name="newProBtn"></s:text>
				</button>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bug/PRO0010.js"></script>
</body>
</html>