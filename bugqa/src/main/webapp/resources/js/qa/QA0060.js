/**
 * QA0060 js file
 */

// 初始化
$(function() {

	initTableAreaAttr('QA0060Table', initTable);

	// 定義済み検索
	initTable();
});

/**
 * table初始化
 */
function initTable() {
	var url = 'QA0060ActionQASearch';

	var data = {
		// 每页显示条数
		"limit" : $('#numPerPageSelect option:selected').html(),
		"currentPage" : $('#QA0060Table').data('currentPage'),
		'flg' : $('#lblflg').val(),
		'projectId' : $('#lblprojectId').val(),
		'sortKey' : $('#QA0060Table').data('sortSql')
	};

	ajaxRequest(url, baseQACallback, data);

}

function baseQACallback(data) {

	if (data === null || data.baseQAList.length === 0) {
		// 隐藏进度条
		$('#tableProgress').css('visibility', 'hidden');
		return false;
	}
	// 检索结果大于0件且检索flag为6
	if ($('#lblflg').val() == 6) {
		$('#export').css('visibility', 'visible');
	}

	var baseQA = data.baseQAList;
	var totalPage = Math.ceil(data.total / $('#numPerPageSelect option:selected').html());
	var currentPage = data.currentPage;

	var $QA0060Table = $('#QA0060Table');
	$QA0060Table.data('currentPage', currentPage);
	$QA0060Table.data('totalPage', totalPage);

	$('#baseQAPageCount').html(currentPage + ' of ' + totalPage);
	$('#baseQAHead').html('(' + data.total + ')');
	$('#baseQATbody').children().remove();

	var baseQAArray = new Array();
	for ( var key in baseQA) {
		if (baseQA.hasOwnProperty(key)) {
			baseQAArray.push('<tr id="' + baseQA[key].qaNo + '">');
			baseQAArray.push('<td>' + '<a href="javascript:void(0)" onclick="subgo(' + '\'' + baseQA[key].qaNo + '\''
					+ ',' + '\'' + baseQA[key].projectId + '\')">' + baseQA[key].qaNo + '</a>' + '</td>');
			baseQAArray.push('<td class="hide-on-small-only">' + baseQA[key].projectName + '</td>');
			//baseQAArray.push('<td class="hide-on-small-only">' + baseQA[key].groupName + '</td>');
			//baseQAArray.push('<td class="hide-on-med-and-down">' + baseQA[key].moduleName + '</td>');
			baseQAArray.push('<td>' + baseQA[key].qaTitle + '</td>');
			baseQAArray.push('<td class="hide-on-med-and-down">' + baseQA[key].qaQState + '</td>');
			baseQAArray.push('<td class="hide-on-med-and-down">' + baseQA[key].qaAState + '</td>');
			baseQAArray.push('<td class="hide-on-small-only">' + baseQA[key].questioner + '</td>');
			baseQAArray.push('<td class="hide-on-med-and-down">' + baseQA[key].answerer + '</td>');
			baseQAArray.push('<td class="hide-on-med-and-down">' + baseQA[key].questionDate + '</td>');
			baseQAArray.push('<td class="hide-on-med-and-down">' + baseQA[key].expDate + '</td>');
			//baseQAArray.push('<td class="hide-on-med-and-down">' + baseQA[key].answerDate + '</td>');
			baseQAArray.push('</tr>');
		}
	}
	$('#baseQATbody').append(baseQAArray.join(''));
	// 隐藏进度条
	$('#tableProgress').css('visibility', 'hidden');
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
		"qaNo" : QANO,
		"projectId" : projectId
	};
	ajaxPageRequest(url, data);

}

$('#exportExcel').click(function() {
	var url = "QA0070ActiondownloadExcel?pageDiff=QA0060&projectId=" + $('#lblprojectId').val();
	exportExcel(url);
});
