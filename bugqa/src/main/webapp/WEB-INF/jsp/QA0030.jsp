<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<script src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>
<title>QA0030</title>
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
	<input type="hidden" id="lblQANo" value=${qaNo }>
	<input type="hidden" id="lblProjectId" value=${projectId }>

	<div class="row"></div>
	<div id="QA0030Table" style="margin-left: 1%; margin-right: 1%">
		<div class="row">
			<div class="card-content ">
				<blockquote>
					<h5 id="errormsg" style="color: red; display: none;">
						<s:text name="noData"></s:text>
					</h5>
				</blockquote>
			</div>

			<h4 class="header waves-effect waves-light hide-on-small-only" style="display: inline">
				<s:text name="QA0030lblTitle"></s:text>
			</h4>
			<h5 class="header waves-effect waves-light hide-on-med-and-up" style="display: inline">
				<s:text name="QA0030lblTitle"></s:text>
			</h5>

			<div class=" col s3 m2 l1 right">
				<select id="numPerPageSelect">
					<option value="1">10</option>
					<option value="2">30</option>
					<option value="3">50</option>
					<option value="3">100</option>
				</select>
			</div>
			<div class="progress hide-on-small-only" id="QA0030Progress">
				<div class="indeterminate"></div>
			</div>
			<div class="col s12">
				<table class="responsive-table highlight">
					<thead>
						<tr>
							<th data-field="serialNum"><a href="#" id="serialNum"><s:text name="serialNo"></s:text></a></th>
							<th data-field="QANO"><a href="#" id="QANO"><s:text name="QANO"></s:text></a></th>
							<th data-field="projectName"><a href="#" id="projectName"><s:text name="projectName"></s:text></a></th>
							<th data-field="QAAState"><a href="#" id="QAAState"><s:text name="QAAState"></s:text></a></th>
							<th data-field="groupName"><a href="#" id="groupName"><s:text name="groupName"></s:text></a></th>
							<th data-field="moduleName"><a href="#" id="moduleName"><s:text name="moduleName"></s:text></a></th>
							<th data-field="questioner"><a href="#" id="questioner"><s:text name="questioner"></s:text></a></th>
							<th data-field="QAQState"><a href="#" id="QAQState"><s:text name="QAQState"></s:text></a></th>
							<th data-field="questionDate"><a href="#" id="questionDate"><s:text name="questionDate"></s:text></a></th>
							<%-- <th data-field="expDate"><a href="#" id="expDate"><s:text name="expDate"></s:text></a></th> --%>
							<th data-field="answerer"><a href="#" id="answerer"><s:text name="answerer"></s:text></a></th>
							<th data-field="answerDate"><a href="#" id="answerDate"><s:text name="answerDate"></s:text></a></th>
							<th data-field="updaterName"><a href="#" id="updaterName"><s:text name="updaterName"></s:text></a></th>
							<th data-field="updateTime"><a href="#" id="updateTime"><s:text name="updateTime"></s:text></a></th>
						</tr>
					</thead>
					<tbody id="QA0030Tbody">

					</tbody>
				</table>
				<ul class="pagination right">
					<text id="QA0030PageCount"></text>
					<li class="waves-effect"><a id="previousPage"><i class="material-icons">chevron_left</i></a></li>
					<li class="waves-effect"><a id="nextPage"><i class="material-icons">chevron_right</i></a></li>
				</ul>
			</div>
			<div class="row">
				<div class="input-field col s6 m6 l2">
					<button class="btn waves-effect waves-light indigo lighten-3" id="return" type="button">
						<s:text name="return"></s:text>
						<i class="mdi-content-reply left"></i>
					</button>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/qa/QA0030.js"></script>
</body>
</html>