<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<script src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>
<title>QA0060</title>
</head>
<style type="text/css">
table tr td{
	word-wrap: break-word;
	word-break: break-all;
}

table tr{
	word-wrap: break-word;
	word-break: keep-all;
}

/* table {table-layout:fixed;}
td {white-space:nowrap;overflow:hidden;} */
</style>
<body>
	<input type="hidden" id="lblflg" value=${flg }>
	<input type="hidden" id="lblprojectId" value=${projectId }>

	<div class="fixed-action-btn horizontal click-to-toggle " style="bottom: 15px; right: 15px; visibility: hidden"
		id="export">
		<a class="btn-floating  green  lighten-1" id="exportExcel"><i class="material-icons">receipt</i></a>
	</div>
	<div class="row"></div>
	<div id="QA0060Table" style="margin-left: 1%; margin-right: 1%">
		<div class="row ">
			<h4 class="header waves-effect waves-light hide-on-small-only" style="display: inline">
				<c:if test="${flg eq '1' }">
					<s:text name="childNode25"></s:text>
				</c:if>
				<c:if test="${flg eq '2' }">
					<s:text name="childNode26"></s:text>
				</c:if>
				<c:if test="${flg eq '3' }">
					<s:text name="childNode27"></s:text>
				</c:if>
				<c:if test="${flg eq '4' }">
					<s:text name="childNode28"></s:text>
				</c:if>
				<c:if test="${flg eq '5' }">
					<s:text name="childNode29"></s:text>
				</c:if>
				<c:if test="${flg eq '6' }">
					<s:text name="parentNode8"></s:text>
				</c:if>
				<span id="baseQAHead">(0)</span>
			</h4>
			<h5 class="header waves-effect waves-light hide-on-med-and-up" style="display: inline">
				<c:if test="${flg eq '1' }">
					<s:text name="childNode25"></s:text>
				</c:if>
				<c:if test="${flg eq '2' }">
					<s:text name="childNode26"></s:text>
				</c:if>
				<c:if test="${flg eq '3' }">
					<s:text name="childNode27"></s:text>
				</c:if>
				<c:if test="${flg eq '4' }">
					<s:text name="childNode28"></s:text>
				</c:if>
				<c:if test="${flg eq '5' }">
					<s:text name="childNode29"></s:text>
				</c:if>
				<c:if test="${flg eq '6' }">
					<s:text name="parentNode8"></s:text>
				</c:if>
				<span id="baseQAHead"></span>
			</h5>

			<div class=" col s3 m2 l1 right ">
				<select id="numPerPageSelect">
					<option value="10">10</option>
					<option value="30">30</option>
					<option value="100">100</option>
					<option value="500">500</option>
				</select>
			</div>
			<div class="progress hide-on-small-only" id="tableProgress">
				<div class="indeterminate"></div>
			</div>
			<div class="col s12">
				<table class=" highlight">
					<thead>
						<%-- <tr>
							<th data-field="QANO"><a href="#" id="QANO"><s:text name="QANO"></s:text></a></th>
							<th class="hide-on-small-only" data-field="projectName"><a href="#" id="PROJECTNAME"><s:text name="projectName"></s:text></a></th>
							<th class="hide-on-med-and-down" data-field="QAAState"><a href="#" id="QAASTATE"><s:text name="QAAState"></s:text></a></th>
							<th class="hide-on-small-only" data-field="groupName"><a href="#" id="GROUPNAME"><s:text name="groupName"></s:text></a></th>
							<th class="hide-on-med-and-down" data-field="moduleName"><a href="#" id="MODULENAME"><s:text name="moduleName"></s:text></a></th>
							<th data-field="QATitle"><a href="#" id="QATitle"><s:text name="title"></s:text></a></th>
							<th class="hide-on-small-only" data-field="questioner"><a href="#" id="QUESTIONER"> <s:text name="questioner"></s:text></a></th>
							<th class="hide-on-med-and-down" data-field="QAQState"><a href="#" id="QAQSTATE"><s:text name="QAQState"></s:text></a></th>
							<th class="hide-on-med-and-down" data-field="questionDate"><a href="#" id="QUESTIONDATE"><s:text name="questionDate"></s:text></a></th>
							<th class="hide-on-med-and-down" data-field="expDate"><a href="#" id="EXPDATE"><s:text name="expDate"></s:text></a></th>
							<th class="hide-on-med-and-down" data-field="answerer"><a href="#" id="ANSWERER"><s:text name="answerer"></s:text></a></th>
							<th class="hide-on-med-and-down" data-field="answerDate"><a href="#" id="ANSWERDATE"><s:text name="answerDate"></s:text></a></th>
						</tr> --%>
						<tr>
							<th data-field="QANO" style="width:91px" colspan = "1"><a href="#" id="QANO"><s:text name="QANO"></s:text></a></th>
							<th class="hide-on-small-only" data-field="projectName" style="width:133px" colspan = "1"><a href="#" id="PROJECTNAME"><s:text
										name="projectName"></s:text></a></th>
							<%-- <th class="hide-on-small-only" data-field="groupName"><a href="#" id="GROUPNAME"><s:text
										name="groupName"></s:text></a></th>
							<th class="hide-on-med-and-down" data-field="moduleName"><a href="#" id="MODULENAME"><s:text
										name="moduleName"></s:text></a></th> --%>
							<th data-field="QATitle"><a href="#" id="QATitle"><s:text name="title"></s:text></a></th>
							<th class="hide-on-med-and-down" data-field="QAQState" style="width:85px" colspan = "1"><a href="#" id="QAQSTATE"><s:text name="QAQState"></s:text></a></th>
							<th class="hide-on-med-and-down" data-field="QAAState" style="width:85px" colspan = "1"><a href="#" id="QAASTATE"><s:text name="QAAState"></s:text></a></th>
							<th class="hide-on-small-only" data-field="questioner" style="width:75px" colspan = "1"><a href="#" id="QUESTIONER"> <s:text
										name="questioner"></s:text>
							</a></th>
							<th class="hide-on-med-and-down" data-field="answerer" style="width:75px"><a href="#" id="ANSWERER"><s:text name="answerer"></s:text></a></th>
							<th class="hide-on-med-and-down" data-field="questionDate" style="width:90px" colspan = "1"><a href="#" id="QUESTIONDATE"><s:text
										name="questionDate"></s:text></a></th>
							<th class="hide-on-med-and-down" data-field="expDate" style="width:90px" colspan = "1"><a href="#" id="EXPDATE"><s:text name="expDate"></s:text></a></th>
							<%-- <th class="hide-on-med-and-down" data-field="answerDate"><a href="#" id="ANSWERDATE"><s:text
										name="answerDate"></s:text></a></th> --%>
						</tr>
					</thead>
					<tbody id="baseQATbody">

					</tbody>
				</table>
				<ul class="pagination right">
					<text id="baseQAPageCount"></text>
					<li class="waves-effect"><a id="previousPage"><i class="material-icons">chevron_left</i></a></li>
					<li class="waves-effect"><a id="nextPage"><i class="material-icons">chevron_right</i></a></li>
				</ul>
			</div>
		</div>
	</div>

	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/qa/QA0060.js"></script>

</body>
</html>