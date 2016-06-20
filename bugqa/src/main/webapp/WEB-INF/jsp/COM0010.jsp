<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="<%=request.getContextPath()%>/resources/js/jquery.form.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bug/errorMsg.js"></script>
<title>通用</title>
</head>
<style type="text/css">
.color {
	color: red;
}

.hide {
	display: none;
}
</style>
<body>
	<div id="COM0010Table" style="margin-left: 1%; margin-right: 1%">
		<div class="row">
			<div class="card-content ">
				<blockquote>
					<h5 id="errormsg" style="color: red; display: none;">
						<s:text name="noData"></s:text>
					</h5>
				</blockquote>
			</div>
			<h4 class="header waves-effect waves-light" style="display: inline">
				<s:text name="generalManage"></s:text>
				<span id="totalCOM"></span>
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
				<div class="input-field col s4 m3 l2 left">
					<input id="condition" name="condition" type="text" maxlength=8 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
				</div>
			</div> --%>
			
			<div class="progress" id="COM0010Progress">
				<div class="indeterminate"></div>
			</div>

			<div class="col s12">
				<table class=" highlight " id="COM0010Tbl">
					<thead>
						<tr>
							<th data-field="kbn"><a href="#" id="kbn"><s:text name="kbn"></s:text></a></th>
							<th data-field="code"><a href="#" id="code"><s:text name="code"></s:text></a></th>
							<th data-field="name"><a href="#" id="name"><s:text name="name"></s:text></a></th>
							<th data-field="remark"><a href="#" id="remark"><s:text name="remark"></s:text></a></th>
						</tr>
					</thead>
					<tbody id="COM0010Tbody">
					</tbody>
				</table>
				<ul class="pagination right">
					<text id="COM0010PageCount"></text>
					<li class="waves-effect">
					<a id="previousPage">
					<i	class="material-icons">chevron_left</i></a></li>
					<li class="waves-effect">
					<a id="nextPage"><i class="material-icons">chevron_right</i></a></li>
				</ul>
				
			</div>

		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bug/COM0010.js"></script>
</body>
</html>