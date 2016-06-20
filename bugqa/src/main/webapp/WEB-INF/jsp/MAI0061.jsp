<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<script src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>
<title>MAI0061</title>
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
<body style="overflow-x:hidden">
	<div class="row"></div>
	<div id="QAMyWorkTable" style="margin-left: 1%; margin-right: 1%">
		<div class="row ">
			<h4 class="header waves-effect waves-light hide-on-small-only" style="display: inline">
				<s:text name="myWork"></s:text>
				<span id="qaMyWorkHead">(0)</span>
			</h4>
			<h5 class="header waves-effect waves-light hide-on-med-and-up" style="display: inline">
				<s:text name="myWork"></s:text>
			</h5>

			<div class=" col s3 m2 l1 right">
				<select id="numPerPageSelect">
					<option value="5">5</option>
					<option value="20">20</option>
					<option value="50">50</option>
					<option value="100">100</option>
				</select>
			</div>
			<div class="progress hide-on-small-only" id="qaMyWorkProgress">
				<div class="indeterminate"></div>
			</div>
			<div class="col s12">
				<table class="highlight" id="qaMyWork">
					<thead>
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

					<tbody id="QAMyWorkTbody">

					</tbody>
				</table>
				<ul class="pagination right">
					<text id="qaMyWorkPageCount"></text>
					<li class="waves-effect"><a id="previousPage"><i class="material-icons">chevron_left</i></a></li>
					<li class="waves-effect"><a id="nextPage"><i class="material-icons">chevron_right</i></a></li>
				</ul>
			</div>
		</div>

	</div>

	<div id="QAMyNoticeTable" style="margin-left: 1%; margin-right: 1%">
		<div class="row ">
			<h4 class="header waves-effect waves-light hide-on-small-only" style="display: inline">
				<s:text name="myNotice"></s:text>
				<span id="qaMyNoticeHead">(0)</span>
			</h4>
			<h5 class="header waves-effect waves-light hide-on-med-and-up" style="display: inline">
				<s:text name="myNotice"></s:text>
			</h5>

			<div class=" col s3 m2 l1 right">
				<select id="numPerPageSelect">
					<option value="5">5</option>
					<option value="20">20</option>
					<option value="50">50</option>
					<option value="100">100</option>
				</select>
			</div>
			<div class="progress hide-on-small-only" id="qaMyNoticeProgress">
				<div class="indeterminate"></div>
			</div>
			<div class="col s12">
				<table class=" highlight" id="qaMyNotice">
					<thead>
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
					<tbody id="QAMyNoticeTbody">

					</tbody>
				</table>
				<ul class="pagination right">
					<text id="qaMyNoticePageCount"></text>
					<li class="waves-effect"><a id="previousPage"><i class="material-icons">chevron_left</i></a></li>
					<li class="waves-effect"><a id="nextPage"><i class="material-icons">chevron_right</i></a></li>
				</ul>
			</div>
		</div>
	</div>

	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/qa/MAI0061.js"></script>

</body>
</html>