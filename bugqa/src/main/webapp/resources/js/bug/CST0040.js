$(function() {

	initTableAreaAttr('CST0040Table', initCST0040);
	// 初始化部门编
	initCST0040();
})

/**
 * CST0040部门编辑页面初始化
 */
function initCST0040() {

	// 部门ID自动获得焦点
	document.getElementById('txtDptId').focus();
	// 取得客户编号
	customerCode = document.getElementById("customerCodeHidden");
	// 客户编号trim处理
	customerCode = trim(customerCode.value);
	// 每页显示条数
	var limit = $('#numPerPageSelect option:selected').html();

	var url = "CST0040ActiongetDepartmentInfo";

	var data = {
		"customerCode" : customerCode,
		"limit" : limit,
		"currentPage" : $('#CST0040Table').data('currentPage'),
		'sortKey' : $('#CST0040Table').data('sortSql')
	};
	ajaxRequest(url, CST0040Callback, data);
	
}

// CST0040页面初始化回调函数
function CST0040Callback(data) {
	
	if (data === null || data.departmentpo.length === 0) {
		// 隐藏进度条
		$('#CST0040Progress').css('visibility', 'hidden');
		return false;
	}
	// 取得action返回来的值
	var departmentpo = data.departmentpo;
	// 总页数
	var totalPage = Math.ceil(data.total
			/ $('#numPerPageSelect option:selected').html());
	// 当前页
	var currentPage = data.currentPage;
	var $CST0040Table = $('#CST0040Table');
	$CST0040Table.data('currentPage', currentPage);
	$CST0040Table.data('totalPage', totalPage);
	$('#CST0040PageCount').html(data.currentPage + ' of ' + totalPage);
	$('#totalUser').html('(' + data.total + ')');
	$('#CST0040Tbody').empty();
	var table = new Array();
	// 添加table
	for ( var key in departmentpo) {
		table.push('<tr id="' + departmentpo[key].customerCode + '">');
		table.push("<td id='departmentId'>" + departmentpo[key].departmentId
				+ "</td>");
		table.push('<td>' + departmentpo[key].departmentName + '</td>');
		table.push('<td>' + '<a id= "deleteBtn"'
				+ '" href="javascript:deleteDept(\''
				+ departmentpo[key].departmentId
				+ '\');"><i class="material-icons">delete</i></a>' + '</td>');
		table.push('</tr>');
	}
	// 清空table
	$('#CST0040Tbody').html("");
	// 添加table
	$('#CST0040Tbody').append(table.toString());
	// 隐藏进度条
	$('#CST0040Progress').css('visibility', 'hidden');
}

// CST0040部门编辑保存按钮
$('#btnSave').click(function() {

	var url = "CST0040ActionsaveDept";
	var data = {
		"customerCode" : customerCode,
	};
	submitFormAndValidate(url, data, CST0040SaveCallback);
})

// 部门保存回调函数
function CST0040SaveCallback(data) {

	if (data.status != 0) {
		$('#errorMsg').show().html(data.message);
		return false;
	} else {
		$.ajax({
			cache : false,
			url : 'redirectToCST0030',
			type : 'get',
			async : true,
			data : {
				'customerCode' : customerCode,
			},
			success : function(responseText) {
				$('#rightFrame').html(responseText);
			}
		});
		return false;
	}
}

// CST0040追加部门
$('#btnAdd').click(function() {
	var url = "CST0040ActionaddDept";
	var data = {
		"customerCode" : customerCode,
	};
	submitFormAndValidate(url, data, CST0040AddCallback);
	
})

// 部门追加回调函数
function CST0040AddCallback(data) {
	
	if (data.status != 0) {
		$('#errorMsg').show().html(data.message);
		return false;
	} else {
		$('#errorMsg').hide();
		$.ajax({
			cache : false,
			url : 'CST0040ActiongetDepartmentInfo',
			type : 'get',
			async : true,
			data : {
				"customerCode" : customerCode,
			},
			success : CST0040Callback,
		});
		return false;
	}
}

// CST0040删除部门信息函数
function deleteDept(departmentId) {
	customerCode = document.getElementById("customerCodeHidden");
	// 客户编号trim处理
	customerCode = trim(customerCode.value);
	$.ajax({
		cache : false,
		url : 'CST0040ActiondeleteDept',
		type : 'get',
		async : true,
		data : {
			"departmentId" : departmentId,
			"customerCode" : customerCode,
		},
		success : deleteCallback,
	});
}

/**
 * 删除部门回调函数
 * @param data
 */
function deleteCallback(data){
	$('#errorMsg').show().html(data.message);
}

// CST0040取消按钮
$('#btnCancel').on('click', function() {
	// 取得客户编号
	customerCode = document.getElementById("customerCodeHidden");
	// 客户编号trim处理
	customerCode = trim(customerCode.value);
	$.ajax({
		cache : false,
		url : 'redirectToCST0030',
		type : 'get',
		async : true,
		data : {
			'customerCode' : customerCode,
		},
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
	return false;

});

/**
 * 截去指定字符的首尾部空白字符
 * 
 * @param str
 *            需要进行trim操作的字符串
 * @returns trim后的字符串
 */
function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}