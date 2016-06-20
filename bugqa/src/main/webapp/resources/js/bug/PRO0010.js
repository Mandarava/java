// 初始化
$(function() {

	initTableAreaAttr('PRO0010Table ', initPRO0010);

	// 项目管理
	initPRO0010();

});

/**
 * 项目管理table初始化
 */
function initPRO0010() {

	var url = 'PRO0010ActionqueryProject';

	var data = {
		"limit" : $('#numPerPageSelect option:selected').html(),
		"currentPage" : $('#PRO0010Table').data('currentPage'),
		'sortKey' : $('#PRO0010Table').data('sortSql'),
		'searchKey' : $('#searchKey').val()
	}

	ajaxRequest(url, PRO0010Callback, data);

}

/**
 * 检索信息
 */
$('#searchKey').keydown(function(e) {
	if (event.keyCode == 13) {

		initTableAreaAttr('PRO0010Table', initPRO0010);

		initPRO0010();
	}

})

/**
 * 查询结果
 * 
 * @param data
 * @returns {Boolean}
 */
function PRO0010Callback(data) {
	// 清空一览
	$('#PRO0010Tbody').empty();

	// 判断结果是否为空
	if (data == null || data.queryProject.length == 0) {
		// 隐藏进度条
		$('#PRO0010Progress').css('visibility', 'hidden');
		$('#errormsg').show();
		return false;
	}
	$('#errormsg').hide();

	var project = data.queryProject;
	var totalPage = Math.ceil(data.total / $('#numPerPageSelect option:selected').html());
	var currentPage = data.currentPage;

	var $PRO0010Table = $('#PRO0010Table');
	$PRO0010Table.data('currentPage', currentPage);
	$PRO0010Table.data('totalPage', totalPage);

	$('#PRO0010PageCount').html(data.currentPage + ' of ' + totalPage);
	$('#totalProject').html('(' + data.total + ')');
	$('#PRO0010').children().remove();

	var table = new Array();
	for ( var key in project) {
		table.push('<tr id="' + project[key].projectId + '" data-projectName="' + project[key].projectName + '">');
		table.push('<td>' + '<a id="editBtn" ' + '" href="javascript:editProject(\'' + project[key].projectId
				+ '\');">' + project[key].projectId + '</a>' + '</td>');
		table.push('<td>' + project[key].projectName + '</td>');
		table.push('<td>' + project[key].startDate + '</td>');
		table.push('<td>' + project[key].endDate + '</td>');
		table.push('<td>' + project[key].chkEndDate + '</td>');
		table.push('<td>' + project[key].stateFlg + '</td>');
		table.push('<td>' + '<a id= "' + project[key].projectId + '" href="javascript:deleteProject(\''
				+ project[key].projectId + '\');"><i class="material-icons">delete</i></a>' + '</td>');
		table.push('</tr>');
	}

	// 添加table
	$('#PRO0010Tbody').append(table.join(''));

	// 隐藏进度条
	$('#PRO0010Progress').css('visibility', 'hidden');
}

/**
 * table每页显示页数变化事件
 */
$("#PRO0010PageSelect").change(function() {
	// 显示进度条
	$('#PRO0010Progress').css('visibility', 'visible');
	// 初始化页数
	currentPage = 1;

	initPRO0010();
});

/**
 * 向PRO0030页面传值
 */
function editProject(id) {
	var projectName = $('#' + id).attr('data-projectName');
	$.ajax({
		cache : false,
		url : 'redirectToPRO0030',
		type : 'post',
		data : {
			'projectId' : id,
			'projectName' : projectName
		},
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
}

/**
 * 跳转页面
 */
$('#newBtn').click(function() {
	$.ajax({
		cache : false,
		url : 'redirectToPRO0020',
		type : 'get',
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
});

/**
 * 删除项目
 * 
 * @param id
 */
function deleteProject(id) {
	if (confirm("削除を確定しますか？")) {
		$.ajax({
			cache : false,
			url : 'PRO0010ActiondeleteProject',
			type : 'get',
			data : {
				projectId : id
			},
			success : function(responseText) {
				$.ajax({
					cache : false,
					url : 'redirectToPRO0010',
					type : 'get',
					success : function(responseText) {
						$('#rightFrame').html(responseText);
					}
				});
			}
		});
	} else {
		return false;
	}
}

/**
 * 前一页
 */
function previousPage() {

	if (currentPage <= 1) {
		return false;
	} else {
		// 显示进度条
		$('#PRO0010Progress').css('visibility', 'visible');
		// 当前页减一
		currentPage = currentPage - 1;

		initPRO0010(currentPage);
	}
}

/**
 * 下一页
 */
function nextPage() {

	if (currentPage >= totalPage) {
		return false;
	} else {
		// 显示进度条
		$('#PRO0010Progress').css('visibility', 'visible');
		// 当前页加一
		currentPage = currentPage + 1;

		initPRO0010(currentPage);

	}
}
