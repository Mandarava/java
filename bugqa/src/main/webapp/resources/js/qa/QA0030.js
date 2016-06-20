// 初始化
$(function() {

	initTableAreaAttr('QA0030Table', initTable);

	// 定義済み検索
	initTable();
});

/**
 * table初始化
 */
function initTable() {
	var url = 'QA0030ActionQAHistorySearch';
	var data = {
		// 每页显示条数
		"limit" : $('#numPerPageSelect option:selected').html(),
		"currentPage" : $('#QA0030Table').data('currentPage'),
		'projectId' : $('#lblProjectId').val(),
		'qaNo' : $('#lblQANo').val(),
		'sortKey' : $('#QA0030Table').data('sortSql')
	};

	ajaxRequest(url, QA0030Callback, data);

}

function QA0030Callback(data) {
	if (data === null || data.qaHistoryList.length === 0) {
		// 隐藏进度条
		$('#QA0030Progress').css('visibility', 'hidden');
		$('#errormsg').show();
		return false;
	}
	// 检索大于0件
	$('#errormsg').hide();

	var totalPage = Math.ceil(data.total / $('#numPerPageSelect option:selected').html());
	var currentPage = data.currentPage;

	var $QA0030Table = $('#QA0030Table');
	$QA0030Table.data('currentPage', currentPage);
	$QA0030Table.data('totalPage', totalPage);

	$('#QA0030PageCount').html(currentPage + ' of ' + totalPage);
	$('#QA0030Tbody').children().remove();

	var qaHistory = data.qaHistoryList;
	var qaHistoryArray = new Array();
	for ( var key in qaHistory) {
		if (qaHistory.hasOwnProperty(key)) {
			qaHistoryArray.push('<tr id="' + qaHistory[key].serialNum + '">');
			qaHistoryArray.push('<td>' + '<a href="javascript:void(0)" onclick="subgo(' + '\''
					+ qaHistory[key].serialNum + '\')">' + qaHistory[key].serialNum + '</a>' + '</td>');
			qaHistoryArray.push('<td>' + qaHistory[key].qaNo + '</td>');
			qaHistoryArray.push('<td>' + qaHistory[key].projectName + '</td>');
			qaHistoryArray.push('<td>' + qaHistory[key].qaAState + '</td>');
			qaHistoryArray.push('<td>' + qaHistory[key].groupName + '</td>');
			qaHistoryArray.push('<td>' + qaHistory[key].moduleName + '</td>');
			qaHistoryArray.push('<td>' + qaHistory[key].questioner + '</td>');
			qaHistoryArray.push('<td>' + qaHistory[key].qaQState + '</td>');
			qaHistoryArray.push('<td>' + qaHistory[key].questionDate + '</td>');
//			qaHistoryArray.push('<td>' + qaHistory[key].expDate + '</td>');
			qaHistoryArray.push('<td>' + qaHistory[key].answerer + '</td>');
			qaHistoryArray.push('<td>' + qaHistory[key].answerDate + '</td>');
			qaHistoryArray.push('<td>' + qaHistory[key].updaterName + '</td>');
			qaHistoryArray.push('<td>' + qaHistory[key].updateTime + '</td>');
			qaHistoryArray.push('</tr>');
		}
	}
	$('#QA0030Tbody').append(qaHistoryArray.join(''));
	// 隐藏进度条
	$('#QA0030Progress').css('visibility', 'hidden');
}

/**
 * 返回按钮
 */
$('#return').click(function() {
	var url = 'redirectToQA0020';
	var data = {
		'qaNo' : $('#lblQANo').val(),
		'projectId' : $('#lblProjectId').val(),
	};
	ajaxPageRequest(url, data);
});

/**
 * 連番点击跳转
 * 
 * @param serialNo
 *            当前连番
 */
function subgo(serialNum) {
	var url = 'redirectToQA0020';
	var data = {
		"qaNo" : $('#lblQANo').val(),
		"projectId" : $('#lblProjectId').val(),
		"serialNum" : serialNum
	};
	ajaxPageRequest(url, data);
}
