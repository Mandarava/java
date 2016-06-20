<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<script src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>

<title>検索オプション画面</title>
</head>
<style type="text/css">
.input-field {
	margin-bottom: -10px;
}
</style>
<body>
	<div class="row"></div>
	<div class="row" style="margin-left: 1%; margin-right: 1%" id="searchArea">
		<div class="card-content ">
			<blockquote>
				<h5 id="errormsg" style="color: red; display: none;">
					<s:text name="noData"></s:text>
				</h5>
			</blockquote>
		</div>
		<%-- <div class="col s12 m4 l2">
			<h5 class="header">
				<s:text name="searchOption"></s:text>
				<span id="searchTitle"></span>
			</h5>
		</div> --%>
		<div class="col s12 m12 l12">
			<form class="col s12" id="customQASearchForm" method="post">
				<div class="row">
					<div class="input-field col s12 m6 l3">
						<select id="drpPro" name="projectId">
						</select> <label><s:text name="systemName"></s:text></label>
					</div>

					<div class="input-field col s12 m6 l3">
						<input id="txtQANo" name="qaNo" type="text" class="" length="11" maxlength=11> <label
							for="txtQANo"><s:text name="NO"></s:text></label>
					</div>

					<c:if test="${user.companyFlg == 0 }">
						<div id="radioArea">
							<div class="input-field col s3 m3 l2">
								<input name="rdbShanai" type="radio" id="rdbShanai" value="0" class="with-gap" /> <label
									for="rdbShanai"><s:text name="shanai"></s:text></label>
							</div>
							<div class="input-field col s3 m3 l2">
								<input name="rdbShanai" type="radio" id="rdbShagai" value="1" class="with-gap" /> <label
									for="rdbShagai"><s:text name="shagai"></s:text></label>
							</div>
							<div class="input-field col s3 m3 l2">
								<input name="rdbShanai" type="radio" id="rdbAll" value="2" class="with-gap" checked /> <label
									for="rdbAll"><s:text name="shaall"></s:text></label>
							</div>
						</div>
					</c:if>

				</div>
				<div class="row">
					<div class="input-field col s12 m6 l3">
						<select id="drpQAQState" name="qaQState">
							<option selected></option>
						</select> <label><s:text name="QAQState"></s:text></label>
					</div>
					<div class="input-field col s12 m6 l3">
						<select id="drpQAAState" name="qaAState">
							<option selected></option>
						</select> <label><s:text name="QAAState"></s:text></label>
					</div>
					<div class="input-field col s12 m6 l3">
						<select id="drpStage" name="stage">
							<option selected></option>
						</select> <label><s:text name="stage"></s:text></label>
					</div>
					<div class="input-field col s12 m6 l3">
						<select id="drpQuestionDiv" name="questionDiv">
							<option selected></option>
						</select> <label><s:text name="questionDiv"></s:text></label>
					</div>

				</div>
				<div class="row">
					<div class="input-field col s12 m6 l3">
						<select id="drpCauseDiv" name="causeDiv">
							<option selected></option>
						</select> <label><s:text name="causeDiv"></s:text></label>
					</div>
					<div class="input-field col s12 m6 l3">
						<select id="drpGroupName" name="groupId">
							<option selected></option>
						</select> <label><s:text name="groupName"></s:text></label>
					</div>
					<div class="input-field col s12 m6 l3">
						<select id="drpModuleName" name="moduleId">
							<option selected></option>
						</select> <label><s:text name="moduleName"></s:text></label>
					</div>
					<div class="input-field col s12 m6 l3">
						<input id="txtQuestionInfo" name="questionInfo" spellcheck="false" autocapitalize="off"
							autocomplete="off" autocorrect="off" type="text" class="" length="1000" maxlength=1000>
						<label for="txtQuestionInfo"><s:text name="questionInfo"></s:text> </label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12 m6 l3">
						<input id="txtQuestioner" name="questioner" type="text" class="" length="20" maxlength=20>
						<label for="txtQuestioner"><s:text name="questioner"></s:text></label>
					</div>
					<div class="input-field col s12 m6 l3">
						<input id="txtAnswerer" name="answerer" type="text" class="" length="20" maxlength=20>
						<label for="txtAnswerer"><s:text name="answerer"></s:text> </label>
					</div>
					<div class="input-field col s12 m6 l3">
						<input id="txtQuestionDateFrom" name="questionDateFrom" type="date" class="datepicker"
							maxlength=10 /><label for="txtQuestionDateFrom"><s:text name="questionDateFrom"></s:text>
						</label>
					</div>
					<div class="input-field col s12 m6 l3">
						<input id="txtQuestionDateTo" name="questionDateTo" type="date" class="datepicker"
							maxlength=10 /><label for="txtQuestionDateTo"><s:text name="questionDateTo"></s:text>
						</label>
					</div>

				</div>
				<div class="row">
					<div class="input-field col s12 m6 l3">
						<input id="txtExpDateFrom" name="expDateFrom" type="date" class="datepicker" maxlength=10 /><label
							for="txtExpDateFrom"><s:text name="expDateFrom"></s:text></label>
					</div>
					<div class="input-field col s12 m6 l3">
						<input id="txtExpDateTo" name="expDateTo" type="date" class="datepicker" maxlength=10 /><label
							for="txtExpDateTo"><s:text name="expDateTo"></s:text> </label>
					</div>
					<div class="input-field col s12 m6 l3">
						<input id="txtAnswerDateFrom" name="answerDateFrom" type="date" class="datepicker"
							maxlength=10 /><label for="txtAnswerDateFrom"><s:text name="answerDateFrom"></s:text></label>
					</div>
					<div class="input-field col s12 m6 l3">
						<input id="txtAnswerDateTo" name="answerDateTo" type="date" class="datepicker" maxlength=10 /><label
							for="txtAnswerDateTo"><s:text name="answerDateTo"></s:text> </label>
					</div>
					<button class="btn waves-effect waves-light indigo lighten-3 right" style="margin-top: 20px"
						id="customQASearchBtn">
						<i class="material-icons">search</i>
					</button>
				</div>
			</form>
		</div>
	</div>
	<label id="location"></label>
	<div id="searchResult" style="display: none">
		<div class="fixed-action-btn horizontal click-to-toggle "
			style="bottom: 15px; right: 15px; visibility: hidden" id="export">
			<a class="btn-floating  green  lighten-1" id="exportExcel"><i class="material-icons">receipt</i></a>
		</div>
<!-- 		<div class="row"></div> -->
		<div id="QA0050Table" style="margin-left: 1%; margin-right: 1%">
			<div class="row">
				<h4 class="header waves-effect waves-light hide-on-small-only" style="display: inline">
					<s:text name="QA0050lblTitle"></s:text>
					<span id="customQAHead"></span>
				</h4>
				<h5 class="header waves-effect waves-light hide-on-med-and-up" style="display: inline">
					<s:text name="QA0050lblTitle"></s:text>
					<span id="customQAHead"></span>
				</h5>
				<div class=" col s3 m2 l1 right">
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
					<table class="responsive-table highlight">
						<thead>
							<tr>
								<th data-field="QANO"><a href="#" id="QANO"><s:text name="QANO"></s:text></a></th>
								<th data-field="projectName"><a href="#" id="PROJECTNAME"><s:text
											name="projectName"></s:text></a></th>
								<th data-field="groupName"><a href="#" id="GROUPNAME"><s:text name="groupName"></s:text></a></th>
								<th data-field="moduleName"><a href="#" id="MODULENAME"><s:text name="moduleName"></s:text></a></th>
								<th data-field="QATitle"><a href="#" id="QATitle"><s:text name="title"></s:text></a></th>
								<th data-field="QAAState"><a href="#" id="QAASTATE"><s:text name="QAAState"></s:text></a></th>
								<th data-field="stage"><a href="#" id="STAGE"><s:text name="stage"></s:text></a></th>
								<th data-field="questionDiv"><a href="#" id="QUESTIONDIV"><s:text
											name="questionDiv"></s:text></a></th>
								<th data-field="causeDiv"><a href="#" id="CAUSEDIV"><s:text name="causeDiv"></s:text></a></th>
								<th data-field="questioner"><a href="#" id="QUESTIONER"><s:text name="questioner"></s:text></a></th>
								<th data-field="QAQState"><a href="#" id="QAQSTATE"><s:text name="QAQState"></s:text></a></th>
								<th data-field="questionDate"><a href="#" id="QUESTIONDATE"><s:text
											name="questionDate"></s:text></a></th>
								<th data-field="expDate"><a href="#" id="EXPDATE"><s:text name="expDate"></s:text></a></th>
								<th data-field="answerer"><a href="#" id="ANSWERER"><s:text name="answerer"></s:text></a></th>
								<th data-field="answerDate"><a href="#" id="ANSWERDATE"><s:text name="answerDate"></s:text></a></th>
							</tr>
						</thead>
						<tbody id="customQATbody">

						</tbody>
					</table>
					<ul class="pagination right">
						<text id="customQAPageCount"></text>
						<li class="waves-effect"><a id="previousPage"><i class="material-icons">chevron_left</i></a></li>
						<li class="waves-effect"><a id="nextPage"><i class="material-icons">chevron_right</i></a></li>
					</ul>
				</div>
			</div>
		</div>
		<br/>
	</div>
	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/qa/QA0050.js"></script>

</body>
</html>