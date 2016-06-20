// 初始化
$(function() {

	initTableAreaAttr('USE0010Table', initUSE0010);

	// 用户管理
	initUSE0010();
});

/**
 * 用户管理table初始化
 */
function initUSE0010() {

	var url = 'USE0010ActionqueryUser';

	var data = {
		"limit" : $('#numPerPageSelect option:selected').html(),
		"currentPage" : $('#USE0010Table').data('currentPage'),
		'sortKey' : $('#USE0010Table').data('sortSql'),
		'searchKey' : $('#searchKey').val(),
		'deleteFlg' : $('input[name="deleteFlg"]:checked').val()
	}

	ajaxRequest(url, USE0010Callback, data);

}

/**
 * 检索信息
 */
$('#searchKey').keydown(function(e) {
	if (event.keyCode == 13) {
		initTableAreaAttr('USE0010Table', initUSE0010);

		initUSE0010();
	}
})

/**
 * 返回值插入到页面table中
 * 
 * @param data
 * @returns {Boolean}
 */
function USE0010Callback(data) {

	// 清空一览
	$('#USE0010Tbody').empty();

	// 判断返回结果是否为空
	if (data == null || data.queryUserList.length == 0) {
		// 隐藏进度条
		$('#USE0010Progress').css('visibility', 'hidden');
		$('#errormsg').show();
		return false;
	}
	$('#errormsg').hide();

	var user = data.queryUserList;
	var totalPage = Math.ceil(data.total / $('#numPerPageSelect option:selected').html());
	var currentPage = data.currentPage;

	var $USE0010Table = $('#USE0010Table');
	$USE0010Table.data('currentPage', currentPage);
	$USE0010Table.data('totalPage', totalPage);

	$('#USE0010PageCount').html(currentPage + ' of ' + totalPage);
	$('#USE0010').children().remove();

	$('#totalUser').html('(' + data.total + ')');

	var table = new Array();
	for ( var key in user) {
		table.push('<tr id="' + user[key].userId + '">');
		table.push('<td>' + '<a id="editBtn" ' + '" href="javascript:editUser(\'' + user[key].userId + '\');">'
				+ user[key].userId + '</a>' + '</td>');
		table.push('<td>' + user[key].userName + '</td>');
		table.push('<td>' + user[key].userPrevl + '</td>');
		table.push('<td>' + user[key].mailAddress + '</td>');
		table.push('<td>' + user[key].companyFlg + '</td>');
		table.push('<td>' + user[key].updateTime + '</td>');
		table.push('<td>' + user[key].deleteFlg + '</td>');
		table.push('<td>' + '<a id= "' + user[key].userId + '" href="javascript:deleteUser(\'' + user[key].userId
				+ '\');"><i class="material-icons">delete</i></a>' + '</td>');
		table.push('</tr>');
	}

	// 添加table
	$('#USE0010Tbody').append(table.join(''));

	// 隐藏进度条
	$('#USE0010Progress').css('visibility', 'hidden');
}

/**
 * table每页显示页数变化事件
 */
$("#USE0010PageSelect").change(function() {
	// 显示进度条
	$('#USE0010Progress').css('visibility', 'visible');
	// 初始化页数
	currentPage = 1;

	// 用户管理table初始化
	initUSE0010();
});

/**
 * 编辑用户
 */
function editUser(id) {
	$.ajax({
		cache : false,
		url : 'redirectToUSE0031',
		type : 'get',
		data : {
			'userId' : id
		},
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
}

/**
 * 删除用户
 * 
 * @param id
 */
function deleteUser(id) {
	if (confirm("削除を確定しますか？")) {
		$.ajax({
			cache : false,
			url : 'USE0010ActiondeleteUser',
			type : 'get',
			data : {
				userId : id
			},
			success : function(responseText) {

				$.ajax({
					cache : false,
					url : 'redirectToUSE0010',
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
 * 新建用户
 */
$('#newBtn').click(function() {
	$.ajax({
		cache : false,
		url : 'redirectToUSE0020',
		type : 'get',
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
});

/**
 * 前一页
 */
function previousPage() {

	if (currentPage <= 1) {
		return false;
	} else {
		// 显示进度条
		$('#USE0010Progress').css('visibility', 'visible');
		// 当前页减一
		currentPage = currentPage - 1;

		initUSE0010(currentPage);
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
		$('#USE0010Progress').css('visibility', 'visible');
		// 当前页加一
		currentPage = currentPage + 1;

		initUSE0010(currentPage);

	}
}
