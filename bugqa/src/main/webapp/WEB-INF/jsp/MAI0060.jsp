<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>homepage</title>
<!--  Android 5 Chrome Color-->
<meta name="theme-color" content="#E0E0E0 ">
<!-- CSS-->
<link href="<%=request.getContextPath()%>/resources/materialize/css/ghpages-materialize.css"
	type="text/css" rel="stylesheet" media="screen,projection">
<link href="<%=request.getContextPath()%>/resources/materialize/css/css.css" rel="stylesheet"
	type="text/css">
<link href="<%=request.getContextPath()%>/resources/materialize/css/icon.css" rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
<%-- <link href="<%=request.getContextPath()%>/resources/materialize/css/style.min.css" type="text/css" rel="stylesheet"
	media="screen,projection"> --%>
<script src="<%=request.getContextPath()%>/resources/materialize/js/live.js"></script>
</head>
<body id="main">
	<div class="col s3">
		<header>
			<div class="container">
				<a href="#" data-activates="nav-mobile"
					class="button-collapse top-nav waves-effect waves-light circle hide-on-large-only"><i
					class="mdi-navigation-menu"></i></a>
			</div>
			<ul id="nav-mobile" class="side-nav fixed ">
				<li class="logo"><a id="logo-container" href="homepage" class="brand-logo"> <object
							id="front-page-logo" type="image/svg+xml"
							data="<%=request.getContextPath()%>/resources/materialize/images/materialize.svg"></object>
				</a></li>

				<li class="bold"><a id="dashboard" href="#"
					class="collapsible-header waves-effect waves-ripple">DashBoard</a></li>
				<li class="no-padding">
					<ul class="collapsible collapsible-accordion">
						<li class="bold" style="display:none"><a id="bug" class="collapsible-header  waves-effect waves-ripple"><s:text name="parentNode1"></s:text></a>
							<div class="collapsible-body">
								<ul>
									<li><a href="#" id="childNode1"><s:text name="childNode1"></s:text></a></li>
									<li><a href="#" id="childNode2"><s:text name="childNode2"></s:text></a></li>
									<li><a href="#" id="childNode3"><s:text name="childNode3"></s:text></a></li>
									<li style="background-color: #f2f2f2"><a href="#"
										class="collapsible-header waves-effect waves-ripple "><s:text name="parentNode2"></s:text></a></li>
									<li class="no-padding">
										<ul class="collapsible collapsible-accordion">
											<li class="bold" style="background-color: #f5f5f5"><a class="collapsible-header  waves-effect waves-ripple active" style="color:#444"><s:text
														name="parentNode2"></s:text></a>
												<div class="collapsible-body">
													<ul>
														<li><a style="color: #444" href="#" id="childNode4"><s:text name="childNode4"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode5"><s:text name="childNode5"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode6"><s:text name="childNode6"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode7"><s:text name="childNode7"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode8"><s:text name="childNode8"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode9"><s:text name="childNode9"></s:text></a></li>
														<li class="no-padding">
															<ul class="collapsible collapsible-accordion">
																<li class="bold" style="background-color: #f5f5f5"><a style="color: #444" class="collapsible-header  waves-effect waves-ripple"><s:text
																			name="parentNode3"></s:text></a>
																	<div class="collapsible-body">
																		<ul id="BUGProject">
																		</ul>
																	</div></li>
															</ul>
														</li>
													</ul>
												</div></li>
										</ul>
									</li>
									
									<li class="no-padding">
										<ul class="collapsible collapsible-accordion">
											<li class="bold" style="background-color: #f5f5f5"><a class="collapsible-header  waves-effect waves-ripple" style="color:#444"><s:text
														name="parentNode4"></s:text></a>
												<div class="collapsible-body">
													<ul>
														<li><a style="color: #444" href="#" id="childNode10"><s:text name="childNode10"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode11"><s:text name="childNode11"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode12"><s:text name="childNode12"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode13"><s:text name="childNode13"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode14"><s:text name="childNode14"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode15"><s:text name="childNode15"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode16"><s:text name="childNode16"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode17"><s:text name="childNode17"></s:text></a></li>
													</ul>
												</div></li>
										</ul>
									</li>
								</ul>
							</div></li>

						<c:if test="${user.userPrevl eq 1}">
							<li class="bold"><a id="manage" class="collapsible-header  waves-effect waves-ripple"><s:text
										name="parentNode5"></s:text></a>
								<div class="collapsible-body">
									<ul>
										<li><a href="#" id="childNode18"><s:text name="childNode18"></s:text></a></li>
										<li><a href="#" id="childNode19"><s:text name="childNode19"></s:text></a></li>
										<%-- <li><a href="#" id="childNode20"><s:text name="childNode20"></s:text></a></li> --%>
										<li><a href="#" id="childNode21"><s:text name="childNode21"></s:text></a></li>
									</ul>
								</div></li>
						</c:if>
						<li class="bold"><a id="qa" class="collapsible-header  waves-effect waves-ripple"><s:text
									name="parentNode6"></s:text></a>
							<div class="collapsible-body">
								<ul>
									<li><a href="#" id="childNode22"><s:text name="childNode22"></s:text></a></li>
									<li><a href="#" id="childNode23"><s:text name="childNode23"></s:text></a></li>
									<li><a href="#" id="childNode24"><s:text name="childNode24"></s:text></a></li>
									<%-- <li style="background-color: #f2f2f2"><a href="#" class="waves-effect waves-ripple"><s:text
												name="parentNode7"></s:text></a></li> --%>
									<li class="no-padding">
										<ul class="collapsible collapsible-accordion">
											<li class="bold" style="background-color: #f5f5f5"><a class="collapsible-header  waves-effect waves-ripple active" style="color:#444"><s:text
														name="parentNode7"></s:text></a>
												<div class="collapsible-body">
													<ul>
														<li><a style="color: #444" href="#" id="childNode25"><s:text name="childNode25"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode26"><s:text name="childNode26"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode27"><s:text name="childNode27"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode28"><s:text name="childNode28"></s:text></a></li>
														<li><a style="color: #444" href="#" id="childNode29"><s:text name="childNode29"></s:text></a></li>
														<li class="no-padding">
															<ul class="collapsible collapsible-accordion">
																<li class="bold" style="background-color: #f5f5f5"><a style="color: #444" class="collapsible-header  waves-effect waves-ripple"><s:text
																			name="parentNode8"></s:text></a>
																	<div class="collapsible-body">
																		<ul id="QAProject">
																		</ul>
																	</div></li>
															</ul>
														</li>
													</ul>
												</div></li>
										</ul>
									</li>
								</ul>
							</div></li>
					</ul>
				</li>
			</ul>
		</header>
	</div>
	<ul id="dropdown1" class="dropdown-content">
		<li><a href="homepage?request_locale=en_US" id="en">English</a></li>
		<li><a href="homepage?request_locale=ja_JP" id="ja">日本語</a></li>
		<li><a href="homepage?request_locale=zh_CN" id="zh">简体中文</a></li>
	</ul>
	<ul id="dropdown2" class="dropdown-content">
		<li><a href="#" id="modifyUserInfo"><s:text name="changePwd"></s:text></a></li>
		<li><a href="index"><s:text name="logout"></s:text></a></li>
	</ul>
	<main>
	<nav>
		<div class="nav-wrapper">
			<a href="homepage" class="brand-logo hide-on-small-only"></a> <a href="homepage"
				class="brand-logo hide-on-med-and-up"></a>
			<ul class="right hide-on-med-and-down">
				<%-- Dropdown Trigger --%>
				<li><a class="dropdown-button" href="#!" data-activates="dropdown1"><span
						id="languagespan">${language}</span><i class="material-icons right">arrow_drop_down</i></a></li>
				<li><a class="dropdown-button" href="#!" data-activates="dropdown2">${user.userName }<i
						class="material-icons right">arrow_drop_down</i></a></li>
			</ul>
		</div>
	</nav>
	<div id="rightFrame" class="col s9">
		<%-- 右侧页面内容区域 --%>
	</div>
	</main>
	<!--  Scripts-->
	<script src="<%=request.getContextPath()%>/resources/js/jquery-2.1.4.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/materialize/js/materialize.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/materialize/js/init.js"></script>
	<script src="<%=request.getContextPath()%>/resources/materialize/js/jquery.timeago.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/qa/common.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/qa/MAI0060.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.form.min.js" defer></script>
	<script src="<%=request.getContextPath()%>/resources/js/parsley.js" defer></script>
	<%-- <script src="<%=request.getContextPath()%>/resources/js/jquery.history.js"></script> --%>

</body>
</html>