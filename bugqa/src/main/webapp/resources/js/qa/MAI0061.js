/**
 * MAI0061 js file
 */

// 初始化
$(function() {

	initTableAreaAttr('QAMyWorkTable', initQAMyWork);
	// 私の仕事
	initQAMyWork();

	initTableAreaAttr('QAMyNoticeTable', initQAMyNotice);
	// 私の注目
	initQAMyNotice();
});

/**
 * 私の仕事table初始化
 */
function initQAMyWork() {
	var url = 'MAI0061ActiongetQAMyWork';

	var data = {
		// 每页显示条数
		"limit" : $('#QAMyWorkTable').find('#numPerPageSelect option:selected').html(),
		"currentPage" : $('#QAMyWorkTable').data('currentPage'),
		"sortKey" : $('#QAMyWorkTable').data('sortSql'),
	};
	ajaxRequest(url, qaMyWorkCallback, data);

}

/**
 * 私の注目table初始化
 */
function initQAMyNotice() {
	var url = 'MAI0061ActiongetQAMyNotice';
	var data = {
		// 每页显示条数
		"limit" : $('#QAMyNoticeTable').find('#numPerPageSelect option:selected').html(),
		"currentPage" : $('#QAMyNoticeTable').data('currentPage'),
		"sortKey" : $('#QAMyNoticeTable').data('sortSql'),
	};
	ajaxRequest(url, qaMyNoticeCallback, data);
}

function qaMyWorkCallback(data) {
	if (data === null || data.qaMyWorkList.length === 0) {
		// 隐藏进度条
		$('#qaMyWorkProgress').css('visibility', 'hidden');
		return false;
	}
	var qaMyWork = data.qaMyWorkList;
	var totalQAMyWorkPage = Math.ceil(data.total / $('#QAMyWorkTable').find('#numPerPageSelect option:selected').html());
	var currentQAMyWorkPage = data.currentPage;

	var $QAMyWorkTable = $('#QAMyWorkTable');
	$QAMyWorkTable.data('currentPage', currentQAMyWorkPage);
	$QAMyWorkTable.data('totalPage', totalQAMyWorkPage);

	$('#qaMyWorkPageCount').html(currentQAMyWorkPage + ' of ' + totalQAMyWorkPage);
	$('#qaMyWorkHead').html('(' + data.total + ')');
	$('#QAMyWorkTbody').children().remove();

	var myWorktable = new Array();
	for ( var key in qaMyWork) {
		if (qaMyWork.hasOwnProperty(key)) {
			myWorktable.push('<tr id="' + qaMyWork[key].qaNo + '">');
			myWorktable.push('<td>' + '<a href="javascript:void(0)" onclick="subgo(' + '\'' + qaMyWork[key].qaNo + '\'' 
					+ ',' + '\'' + qaMyWork[key].projectId + '\')">' + qaMyWork[key].qaNo + '</a>' + '</td>');
			myWorktable.push('<td class="hide-on-small-only">' + qaMyWork[key].projectName + '</td>');
			//myWorktable.push('<td class="hide-on-small-only">' + qaMyWork[key].groupName + '</td>');
			//myWorktable.push('<td class="hide-on-med-and-down">' + qaMyWork[key].moduleName + '</td>');
			myWorktable.push('<td >' + qaMyWork[key].qaTitle + '</td>');
			myWorktable.push('<td class="hide-on-med-and-down">' + qaMyWork[key].qaQState + '</td>');
			myWorktable.push('<td class="hide-on-med-and-down">' + qaMyWork[key].qaAState + '</td>');
			myWorktable.push('<td class="hide-on-small-only">' + qaMyWork[key].questioner + '</td>');
			myWorktable.push('<td class="hide-on-med-and-down">' + qaMyWork[key].answerer + '</td>');
			myWorktable.push('<td class="hide-on-med-and-down">' + qaMyWork[key].questionDate + '</td>');
			myWorktable.push('<td class="hide-on-med-and-down">' + qaMyWork[key].expDate + '</td>');
			//myWorktable.push('<td class="hide-on-med-and-down">' + qaMyWork[key].answerDate + '</td>');
			myWorktable.push('</tr>');
		}
	}

	// 添加table
	$('#QAMyWorkTbody').append(myWorktable.join(''));
	// 隐藏进度条
	$('#qaMyWorkProgress').css('visibility', 'hidden');
}

function qaMyNoticeCallback(data) {
	if (data === null || data.qaMyNoticeList.length === 0) {
		// 隐藏进度条
		$('#qaMyNoticeProgress').css('visibility', 'hidden');
		return false;
	}
	var qaMyNotice = data.qaMyNoticeList;
	var totalQAMyNoticePage = Math.ceil(data.total / $('#QAMyNoticeTable').find('#numPerPageSelect option:selected').html());
	var currentQAMyNoticePage = data.currentPage;

	var $QAMyNoticeTable = $('#QAMyNoticeTable');
	$QAMyNoticeTable.data('currentPage', currentQAMyNoticePage);
	$QAMyNoticeTable.data('totalPage', totalQAMyNoticePage);

	$('#qaMyNoticePageCount').html(currentQAMyNoticePage + ' of ' + totalQAMyNoticePage);
	$('#qaMyNoticeHead').html('(' + data.total + ')');
	$('#QAMyNoticeTbody').children().remove();

	var myNoticeTable = new Array();
	for ( var key in qaMyNotice) {
		if (qaMyNotice.hasOwnProperty(key)) {
			myNoticeTable.push('<tr id="' + qaMyNotice[key].qaNo + '">');
			myNoticeTable.push('<td>' + '<a href="javascript:void(0)" onclick="subgo(' + '\'' + qaMyNotice[key].qaNo + '\''
							+ ',' + '\'' + qaMyNotice[key].projectId + '\')">' + qaMyNotice[key].qaNo + '</a>' + '</td>');
			myNoticeTable.push('<td class="hide-on-small-only">' + qaMyNotice[key].projectName + '</td>');
			//myNoticeTable.push('<td class="hide-on-small-only">' + qaMyNotice[key].groupName + '</td>');
			//myNoticeTable.push('<td class="hide-on-med-and-down">' + qaMyNotice[key].moduleName + '</td>');
			myNoticeTable.push('<td>' + qaMyNotice[key].qaTitle + '</td>');
			myNoticeTable.push('<td class="hide-on-med-and-down">' + qaMyNotice[key].qaQState + '</td>');
			myNoticeTable.push('<td class="hide-on-med-and-down">' + qaMyNotice[key].qaAState + '</td>');
			myNoticeTable.push('<td class="hide-on-small-only">' + qaMyNotice[key].questioner + '</td>');
			myNoticeTable.push('<td class="hide-on-med-and-down">' + qaMyNotice[key].answerer + '</td>');
			myNoticeTable.push('<td class="hide-on-med-and-down">' + qaMyNotice[key].questionDate + '</td>');
			myNoticeTable.push('<td class="hide-on-med-and-down">' + qaMyNotice[key].expDate + '</td>');
			//myNoticeTable.push('<td class="hide-on-med-and-down">' + qaMyNotice[key].answerDate + '</td>');
			myNoticeTable.push('</tr>');
		}
	}
	// 添加table
	$('#QAMyNoticeTbody').append(myNoticeTable.join(''));
	// 隐藏进度条
	$('#qaMyNoticeProgress').css('visibility', 'hidden');
}

/**
 * QA番号点击跳转
 * 
 * @param QANO
 *            QA番号
 * @param projectId
 *            项目ID
 */
function subgo(QANO, projectId) {
	var url = 'redirectToQA0020';
	var data = {
		'qaNo' : QANO,
		'projectId' : projectId
	};
	ajaxPageRequest(url, data);
}
