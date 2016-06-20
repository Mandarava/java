$(function() {
	initTableAreaAttr('CST0050Table', initCST0050);
	// 初始化部门编
	initCST0050();
})

/**
 * CST0040部门编辑页面初始化
 */
function initCST0050() {
	
	// 客室ID自动获得焦点
	document.getElementById('txtClsId').focus();
	// 取得客户编号
	customerCode = document.getElementById("customerCodeHidden");
	// 客户编号trim处理
	customerCode = trim(customerCode.value);
	// 取得部门ID
	departmentId = document.getElementById("departmentIdHidden");
	// 部门IDtrim处理
	departmentId = trim(departmentId.value);
	// 每页显示条数
	var limit = $('#numPerPageSelect option:selected').html();
	var url = "CST0050ActiongetClassInfo";
	var data = {
		"customerCode" : customerCode,
		"departmentId" : departmentId,
		"limit" : limit,
		"currentPage" : $('#CST0050Table').data('currentPage'),
		'sortKey' : $('#CST0050Table').data('sortSql')
	}
	ajaxRequest(url, CST0050Callback, data);
}

// CST0040页面初始化回调函数
function CST0050Callback(data) {
	
	if (data === null || data.classList.length === 0) {
		// 隐藏进度条
		$('#CST0050Progress').css('visibility', 'hidden');
		return false;
	}
	// 取得action返回来的值
	var classList = data.classList;
	// 总页数
	var totalPage = Math.ceil(data.total
			/ $('#numPerPageSelect option:selected').html());
	// 当前页
	var currentPage = data.currentPage;
	var $CST0040Table = $('#CST0050Table');
	$CST0040Table.data('currentPage', currentPage);
	$CST0040Table.data('totalPage', totalPage);
	$('#CST0050PageCount').html(data.currentPage + ' of ' + totalPage);
	$('#totalUser').html('(' + data.total + ')');
	$('#CST0050Tbody').empty();
	var table = new Array();
	// 添加table
	for ( var key in classList) {
		table.push('<tr id="' + classList[key].classId + '">');
		table.push("<td id='departmentId'>" + classList[key].classId + "</td>");
		table.push('<td>' + classList[key].className + '</td>');
		table.push('<td>' + '<a id= "deleteBtn"'
				+ '" href="javascript:deleteClass(\'' + classList[key].classId
				+ '\');"><i class="material-icons">delete</i></a>' + '</td>');
		table.push('</tr>');
	}

	$('#CST0050Tbody').html("");
	// 在页面上显示table
	$('#CST0050Tbody').append(table.toString());
	// 隐藏进度条
	$('#CST0050Progress').css('visibility', 'hidden');
}

// CST0050保存课室
$('#btnSave').click(function() {
	var url = "CST0050ActionsaveClass";
	var data = {
		"customerCode" : customerCode,
		"departmentId" : departmentId,
	};
	submitFormAndValidate(url, data, CST0050SaveCallback);
})

// 保存课室回调函数
function CST0050SaveCallback(data) {
	if (data.status != 0) {
		$('#errorMsg').show().html(data.message);
	} else {
		$.ajax({
			cache : false,
			url : 'redirectToCST0030',
			type : 'get',
			async : true,
			data : {
				"customerCode" : customerCode,
			},
			success : function(responseText) {
				$('#rightFrame').html(responseText);
			}
		});
		return false;
	}
}

// CST0050追加课室
$('#btnAdd').click(function() {
	var url = "CST0050ActionaddClass";
	var data = {
		"customerCode" : customerCode,
		"departmentId" : departmentId,
	};
	submitFormAndValidate(url, data, CST0050AddCallback);
})

// 追加课室回调函数
function CST0050AddCallback(data) {
	if (data.status != 0) {
		$('#errorMsg').show().html(data.message);
	} else {
		$('#errorMsg').hide();
		$.ajax({
			cache : false,
			url : 'CST0050ActiongetClassInfo',
			type : 'get',
			async : true,
			data : {
				"customerCode" : customerCode,
				"departmentId" : departmentId
			},
			success : CST0050Callback,
		});
		return false;
	}

}

// CST0050删除课室信息
function deleteClass(classId) {
	// 取得客户编号
	customerCode = document.getElementById("customerCodeHidden");
	// 客户编号trim处理
	customerCode = trim(customerCode.value);
	// 取得部门ID
	departmentId = document.getElementById("departmentIdHidden");
	// 部门IDtrim处理
	departmentId = trim(departmentId.value);
	$.ajax({
		cache : false,
		url : 'CST0050ActiondeleteClass',
		type : 'get',
		async : true,
		data : {
			"customerCode" : customerCode,
			"departmentId" : departmentId,
			"classId" : classId,
		},
		success : function(data) {
			$('#errorMsg').show().html(data.message);
		},
	});
}

// CST0050取消按钮
$('#btnCancel').on('click', function() {
	// 清空课室列表
	$('#CST0050Tbody').html("");
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
			"customerCode" : customerCode,
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