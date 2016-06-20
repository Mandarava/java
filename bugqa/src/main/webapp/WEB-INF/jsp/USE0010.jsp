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
<title>USE0010</title>
</head>
<body>
	<div id="USE0010Table" style="margin-left: 1%; margin-right: 1%">
		<div class="row">
			<div class="card-content ">
				<blockquote>
					<h5 id="errormsg" style="color: red; display: none;">
						<s:text name="noData"></s:text>
					</h5>
				</blockquote>
			</div>
			<h4 class="header waves-effect waves-light" style="display: inline">
				<s:text name="USE0010Title"></s:text>
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
				<%-- <div class="input-field col s3 m3 l2"> 
					<input id="searchKey" name="searchKey" type="text"
					maxlength=20 data-parsley-maxlength-message="<s:text name="USE0009"></s:text>" />
				</div> --%>
				<%-- <div class="input-field col s1 m1 l1"> 
					<label for="" class=""><s:text name=""></s:text></label> 
				</div>
				<div class="col s4 m3 l3">
					<label for="deleteFlg_select"><s:text name="deleteUser"></s:text></label>
					
						<input type="radio" class="with-gap" id="noDel" name="deleteFlg" value="0" checked="checked"/>
							<label for="noDel"><s:text name="notShowUser"></s:text> </label>
								
						<input type="radio" class="with-gap" id="hasDel" name="deleteFlg" value="1" />
						<label for="hasDel"><s:text name="showUser"></s:text> </label>								
								
				</div>		 --%>		
			
			</div>
			
			<div class="progress" id="USE0010Progress">
				<div class="indeterminate"></div>
			</div>
			<div class="col s12">
				<table class="responsive-table highlight " id="USE0010Tbl">
					<thead>
						<tr>
							<th data-field="userId"><a href="#" id="userId"><s:text name="userId"></s:text></a></th>
							<th data-field="userName"><a href="#" id="userName"><s:text name="userName"></s:text></a></th>
							<th data-field="userPrevl"><a href="#" id="userPrevl"><s:text name="userPrevl"></s:text></a></th>
							<th data-field="mailAddress"><a href="#" id="mailAddress"><s:text name="email"></s:text></a></th>
							<th data-field="companyFlg"><a href="#" id="companyFlg"><s:text name="companyFlg"></s:text></a></th>
							<th data-field="updateTime"><a href="#" id="updateTime"><s:text name="updateTime"></s:text></a></th>
							<th data-field="deleteFlg"><a href="#" id="deleteFlg"><s:text name="deleteFlg"></s:text></a></th>
							<th data-field="delete"><s:text name="delete"></s:text></th>
						</tr>
					</thead>
					<tbody id="USE0010Tbody">

					</tbody>
				</table>
				<ul class="pagination right">
					<text id="USE0010PageCount"></text>
					<li class="waves-effect">
					<a id="previousPage">
					<i	class="material-icons">chevron_left</i></a></li>
					<li class="waves-effect">
					<a id="nextPage"><i class="material-icons">chevron_right</i></a></li>
				</ul>
			</div>
			<div class="col s12 m10 l7">
				<button class="btn waves-effect waves-light submit" id="newBtn" name="newBtn"
					type="button">
					<s:text name="newBtn"></s:text>
				</button>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bug/USE0010.js"></script>
</body>
</html>