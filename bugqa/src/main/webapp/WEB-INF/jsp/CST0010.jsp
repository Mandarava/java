<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<script
	src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>
<title>CST0010</title>
</head>
<body>
	<div id="CST0010Table" style="margin-left: 1%; margin-right: 1%">
		<div class="row">
			<div class="card-content ">
				<blockquote>
					<h5 id="errormsg" style="color: red; display: none;">
						<s:text name="noData"></s:text>
					</h5>
				</blockquote>
			</div>
			<h4 class="header waves-effect waves-light" style="display: inline">
				<s:text name="CST0010Title"></s:text>
				<span id="totalUser"></span>
			</h4>
			<div class=" col s1 m1 right hide-on-small-only">
				<select id="numPerPageSelect">
					<option value="1">10</option>
					<option value="2">30</option>
					<option value="3">100</option>
					<option value="3">500</option>
				</select>
			</div>

			<div class="row">
				<!-- 检索输入框 -->
				<%-- <div class="input-field col s3 m3 l2"> 
					<input id="searchKey" name="searchKey" type="text"
					maxlength=20 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
				</div> --%>
			<%-- 	<!-- 选择检索全部还是未删除 -->
				<div class="col s2 m2 l2">
				<label for="deleteFlg_select"><s:text name="showFlg"></s:text></label>
					<input type="hidden" id="rdHidden" value="" /> <input
						type="radio" id="rdAll" name="serchflg" value="2" class="with-gap" />
					<label for="rdAll"><s:text name="notShowUser"></s:text></label> <input
						type="radio" id="rdNoDelete" name="serchflg" value="1"
						class="with-gap" /> <label for="rdNoDelete"><s:text
							name="showUser"></s:text></label>
				</div>
 --%>				<%-- <!-- 检索按钮 -->
				<div class="col s2 m3 l3">
					<button class="btn waves-effect waves-light submit" id="serch"
						name="serch" type="button">
						<s:text name="serch"></s:text>
					</button>
				</div> --%>
			</div>
			
			<div class="progress hide-on-small-only" id="CST0010Progress">
				<div class="indeterminate"></div>
			</div>
			<!-- 客户信息列表 -->
			<div class="col s12">
				<table class="responsive-table highlight " id="CST0010Tbl">
					<thead>
						<tr>
							<th data-field="customerCode"><a href="#" id="customerCode"><s:text
										name="customerCode"></s:text></a></th>
							<th data-field="customerName"><a href="#" id="customerName"><s:text
										name="customerName"></s:text></a></th>
							<th data-field="customerNameSum"><a href="#"
								id="customerNameSum"><s:text name="customerNameSum"></s:text></a></th>
							<th data-field="companyFlg"><a href="#" id="companyFlg"><s:text
										name="companyFlg"></s:text></a></th>
							<th data-field="zipCode"><a href="#" id="zipCode"><s:text
										name="zipCode"></s:text></a></th>
							<th data-field="phone"><a href="#" id="phone"><s:text
										name="phone"></s:text></a></th>
							<th data-field="fax"><a href="#" id="fax"><s:text
										name="fax"></s:text></a></th>
							<%-- <th data-field="deleteFlg"><a href="#" id="deleteFlg"><s:text
										name="deleteFlg"></s:text></a></th> --%>
							<th data-field="updateTime"><a href="#" id="updateTime"><s:text
										name="updateTime"></s:text></a></th>
						</tr>
					</thead>
					<tbody id="CST0010Tbody">

					</tbody>
				</table>
				<!-- 错误信息 -->
				<div class="row">
					<table border=1>
						<tr>
							<td colspan="9"><span id="errorMsg" style="color: red;"></span></td>
						</tr>
					</table>
				</div>

				<!-- 右下角页数 -->
				<ul class="pagination right">
					<text id="CST0010PageCount"></text>
					<li class="waves-effect"><a id="previousPage"><i
							class="material-icons">chevron_left</i></a></li>
					<li class="waves-effect"><a id="nextPage"><i
							class="material-icons">chevron_right</i></a></li>
				</ul>
			</div>

			<!-- 新建按钮 -->
			<div class="col s12 m10 l7">
				<button class="btn waves-effect waves-light submit" id="newBtn"
					name="newBtn" type="button">
					<s:text name="newBtn"></s:text>
				</button>
			</div>
		</div>
	</div>
	<script
		src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>

	<script src="<%=request.getContextPath()%>/resources/js/bug/CST0010.js"></script>
</body>
</html>