/**
 * QA0050模块初始化
 */
$(document).ready(function() {
	init();
});

// 加载模板下拉框选项
function init() {

	// 系统名初始化
	var url = 'QA0050Actioninit';

	ajaxRequest(url, successCallback, null, completecallback);

	function successCallback(data) {
		// システム名
		var projectNameList = new Array();
		var projectName = data.projectNameList;
		for ( var key in projectName) {
			if (projectName.hasOwnProperty(key)) {
				projectNameList.push('<option value= ' + projectName[key].projectId + '>' + projectName[key].projectName + '</option>');
			}
		}
		$('#drpPro').append(projectNameList.join(''));

		// 状態
		var qaAStateList = new Array();
		var qaAState = data.qaAStateList;
		for ( var key in qaAState) {
			if (qaAState.hasOwnProperty(key)) {
				qaAStateList.push('<option value=' + qaAState[key].code + '>' + qaAState[key].name + '</option>');
			}
		}
		$('#drpQAAState').append(qaAStateList.join(''));

		// 質問区分
		var questionDivList = new Array();
		var questionDiv = data.questionDivList;
		for ( var key in questionDiv) {
			if (questionDiv.hasOwnProperty(key)) {
				if (key === '0')
					continue;
				questionDivList.push('<option value=' + questionDiv[key].code + '>' + questionDiv[key].name + '</option>');
			}
		}
		$('#drpQuestionDiv').append(questionDivList.join(''));

		// 対応状態
		var qaQStateList = new Array();
		var qaQState = data.qaQStateList;
		for ( var key in qaQState) {
			if (qaQState.hasOwnProperty(key)) {
				qaQStateList.push('<option value=' + qaQState[key].code + '>' + qaQState[key].name + '</option>');
			}
		}
		$('#drpQAQState').append(qaQStateList.join(''));

		// 摘出作業
		var stageList = new Array();
		var stage = data.stageList;
		for ( var key in stage) {
			if (stage.hasOwnProperty(key)) {
				// 第0个为标题
				if (key === '0')
					continue;
				stageList.push('<option value=' + stage[key].code + '>' + stage[key].name + '</option>');
			}
		}
		$('#drpStage').append(stageList.join(''));

		// 原因区分
		var causeDivList = new Array();
		var causeDiv = data.causeDivList;
		for ( var key in causeDiv) {
			if (causeDiv.hasOwnProperty(key)) {
				// 第0个为标题
				if (key === '0')
					continue;
				causeDivList.push('<option value=' + causeDiv[key].code + '>' + causeDiv[key].name + '</option>');
			}
		}
		$('#drpCauseDiv').append(causeDivList.join(''));

		// グループ名
		var groupIdList = new Array();
		var group = data.groupIdList;
		for ( var key in group) {
			if (group.hasOwnProperty(key)) {
				groupIdList.push('<option value= ' + group[key].groupId + '>' + group[key].groupName + '</option>');
			}
		}
		$('#drpGroupName').append(groupIdList.join(''));
	}

	function completecallback() {
		$('select').material_select();
	}

	// 提出日（开始）、提出日（终了） 后者从前者开始
	fromDateTo('txtQuestionDateFrom', 'txtQuestionDateTo');
	// 期望日（开始）、期望日（终了） 后者从前者开始
	fromDateTo('txtExpDateFrom', 'txtExpDateTo');
	// 回答日（开始）、回答日（终了） 后者从前者开始
	fromDateTo('txtAnswerDateFrom', 'txtAnswerDateTo');

}

/**
 * システム名下拉框的变换处理
 */
$('#drpPro').change(function() {
	var url = 'QA0050ActiongetGroupId';
	var data = {
		'projectId' : $("#drpPro option:selected").val()
	};
	ajaxRequest(url, projectChangeCallback, data);

	function projectChangeCallback(data) {
		// 清空group下拉框
		$drpGroupName = $('#drpGroupName');
		$drpGroupName.children().remove();
		$drpGroupName.append('<option> </option>');
		// 清空module下拉框
		$drpModuleName = $('#drpModuleName');
		$drpModuleName.children().remove()
		$drpModuleName.append('<option> </option>');

		// group
		var groupIdList = new Array();
		var group = data.groupIdList;
		for ( var key in group) {
			if (group.hasOwnProperty(key)) {
				groupIdList.push('<option value= ' + group[key].groupId + '>' + group[key].groupName + '</option>');
			}
		}
		$drpGroupName.append(groupIdList.join(''));

		$('select').material_select();
	}
});

/**
 * グループ名下拉框的变换处理
 */
$('#drpGroupName').change(function() {
	// 清空module下拉框
	$drpModuleName = $('#drpModuleName');
	$drpModuleName.children().remove();
	$drpModuleName.append('<option> </option>');

	var url = 'QA0050ActiongetModuleName';
	var data = {
		'projectId' : $("#drpPro option:selected").val(),
		'groupId' : $("#drpGroupName option:selected").val()
	};
	ajaxRequest(url, groupChangeCallback, data);

	function groupChangeCallback(data) {
		var moduleList = new Array();
		var module = data.moduleNameList;
		for ( var key in module) {
			if (module.hasOwnProperty(key)) {
				moduleList.push('<option value= ' + module[key].moduleId + '>' + module[key].moduleName + '</option>');
			}
		}
		$drpModuleName.append(moduleList.join(''));
		$('select').material_select();
	}
});

$("#customQASearchBtn").click(function() {

	// 报错信息
	var $errormsg = $('#errormsg');
	// 隐藏原来搜索结果表格
	$('#searchResult').hide();
	// システム名内容的检查
	if (isElementBlank($("#drpPro option:selected").val())) {
		// 检索无数据时消息（标签）可见，并显示字体颜色红色信息
		$errormsg.show();
		return false;
	}

	// 检查通过・错误信息一览不可见，并且清空
	$errormsg.hide();

	// 搜索并显示表格
	initTableAreaAttr('QA0050Table', initTable);

	initTable();
	// always return false to prevent standard browser submit and page
	// navigation
	return false;
});

function initTable() {
	var options = {
		url : 'QA0050ActioncustomQASearch',
		type : 'post',
		success : customQACallback,
		data : {
			'currentPage' : $('#QA0050Table').data('currentPage'),
			'limit' : $('#numPerPageSelect option:selected').html(),
			'sortKey' : $('#QA0050Table').data('sortSql')
		},
	};
	$('#customQASearchForm').ajaxSubmit(options);
}

function customQACallback(data) {
	// 报错信息
	var $errormsg = $('#errormsg');
	// 结果table
	var $searchResult = $('#searchResult');
	
	// 检索0件的场合
	if (data === null || data.customQAList.length === 0) {
		// 检索无数据时消息（标签）可见，并显示字体颜色红色信息
		$errormsg.show();
		$('#searchResult').hide();
		// 隐藏进度条
		$('#tableProgress').css('visibility', 'hidden');
		return false;
	}
	
	
	$searchResult.show();

	// 检索结果大于0件
	$('#export').css('visibility', 'visible');
	$errormsg.hide();

	var customQA = data.customQAList;
	var totalPage = Math.ceil(data.total / $('#numPerPageSelect option:selected').html());
	var currentPage = data.currentPage;

	var $QA0050Table = $('#QA0050Table');
	$QA0050Table.data('currentPage', currentPage);
	$QA0050Table.data('totalPage', totalPage);

	$('#customQAPageCount').html(currentPage + ' of ' + totalPage);
	$('#customQAHead').html('(' + data.total + ')');
	$('#customQATbody').children().remove();

	var customQAArray = new Array();
	for ( var key in customQA) {
		if (customQA.hasOwnProperty(key)) {
			customQAArray.push('<tr id="' + customQA[key].qaNo + '">');
			customQAArray.push('<td>' + '<a href="javascript:void(0)" onclick="subgo(' + '\'' + customQA[key].qaNo
					+ '\'' + ',' + '\'' + customQA[key].projectId + '\')">' + customQA[key].qaNo + '</a>' + '</td>');
			customQAArray.push('<td>' + customQA[key].projectName + '</td>');
			customQAArray.push('<td>' + customQA[key].groupName + '</td>');
			customQAArray.push('<td>' + customQA[key].moduleName + '</td>');
			customQAArray.push('<td>' + customQA[key].qaTitle.substring(0, 20) + '</td>');
			customQAArray.push('<td>' + customQA[key].qaAState + '</td>');
			customQAArray.push('<td>' + customQA[key].stage + '</td>');
			customQAArray.push('<td>' + customQA[key].questionDiv + '</td>');
			customQAArray.push('<td>' + customQA[key].causeDiv + '</td>');
			customQAArray.push('<td>' + customQA[key].questioner + '</td>');
			customQAArray.push('<td>' + customQA[key].qaQState + '</td>');
			customQAArray.push('<td>' + customQA[key].questionDate + '</td>');
			customQAArray.push('<td>' + customQA[key].expDate + '</td>');
			customQAArray.push('<td>' + customQA[key].answerer + '</td>');
			customQAArray.push('<td>' + customQA[key].answerDate + '</td>');
			customQAArray.push('</tr>');
		}
	}
	$('#customQATbody').append(customQAArray.join(''));
	// 隐藏进度条
	$('#tableProgress').css('visibility', 'hidden');
	// 滚动滚动条
	$("#main").animate({scrollTop:getElementTop($('#location')[0]) - 5},"normal");
//	$("#main").scrollTop(getElementTop($('#location')[0]) - 5);
}

/**
 * QA番号点击跳转
 * 
 * @param QANO
 *            QA番号
 * @param projectId
 *            项目ID
 */
function subgo(qaNo, projectId) {
	var url = 'redirectToQA0020';
	var data = {
		"qaNo" : qaNo,
		"projectId" : projectId,
		"projectName" : $('#drpPro option:selected').html()
	};
	ajaxPageRequest(url, data);

}

$('#exportExcel').click(function() {
	var url = "QA0070ActiondownloadExcel?pageDiff=QA0050&projectId=" + $('#drpPro option:selected').val();
	exportExcel(url);
});
