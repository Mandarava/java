// 初始化
$(function() {
	initTableAreaAttr('CST0010Table', initCST0010);

	// 定義済み検索
	initCST0010();
});

/**
 * 用户管理table初始化
 */
function initCST0010() {
	// 每页显示条数
	var limit = $('#numPerPageSelect option:selected').html();
	var url = 'CST0010ActionqueryCustomer';
	var data = {
		"limit" : limit,
		"currentPage" : $('#CST0010Table').data('currentPage'),
		'sortKey' : $('#CST0010Table').data('sortSql')
	};
	ajaxRequest(url, CST0010Callback, data);
}

function CST0010Callback(data) {

	if (data === null || data.customer.length === 0) {
		// 隐藏进度条
		$('#CST0010Progress').css('visibility', 'hidden');
		return false;
	}

	var customer = data.customer;
	// 总页数
	var totalPage = Math.ceil(data.total / $('#numPerPageSelect option:selected').html());
	var currentPage = data.currentPage;
	var $CST0010Table = $('#CST0010Table');
	$CST0010Table.data('currentPage', currentPage);
	$CST0010Table.data('totalPage', totalPage);

	$('#CST0010PageCount').html(data.currentPage + ' of ' + totalPage);
	$('#totalUser').html('(' + data.total + ')');
	$('#CST0010Tbody').empty();

	var table = new Array();
	for ( var key in customer) {
		table.push('<tr id="' + customer[key].customerCode + '">');
		table.push('<td>' + '<a id="editBtn" ' + '" href="javascript:editCustomer(\'' + customer[key].customerCode
				+ '\');">' + customer[key].customerCode + '</a>' + '</td>');
		table.push('<td>' + customer[key].customerName + '</td>');
		table.push('<td>' + customer[key].customerNameSum + '</td>');
		table.push('<td>' + customer[key].companyFlg + '</td>');
		table.push('<td>' + customer[key].zipCode + '</td>');
		table.push('<td>' + customer[key].phone + '</td>');
		table.push('<td>' + customer[key].fax + '</td>');
//		table.push('<td>' + customer[key].deleteFlg + '</td>');
		table.push('<td>' + customer[key].updateTime + '</td>');
		table.push('<td>' + '<a id= "deleteBtn"' + '" href="javascript:deleteCustomer(\'' + customer[key].customerCode
				+ '\');"><i class="material-icons">delete</i></a>' + '</td>');
		table.push('</tr>');
	}
	// 添加table
	$('#CST0010Tbody').append(table.join(''));
	// 隐藏进度条
	$('#CST0010Progress').css('visibility', 'hidden');
}

// 编辑客户按钮
function editCustomer(id) {
	var url = 'redirectToCST0030';
	var data = {
		'customerCode' : id
	};
	ajaxPageRequest(url, data);
}

// 删除客户按钮
function deleteCustomer(customerCode) {
	if (confirm("削除を確定しますか？")) {
		$.ajax({
			cache : false,
			url : 'CST0010ActiondeleteCustomer',
			type : 'get',
			async : true,
			data : {
				"customerCode" : customerCode,
			},
			success : function() {

				// 每页显示条数
				var limit = $('#numPerPageSelect option:selected').html();
				$.ajax({
					cache : false,
					url : 'CST0010ActionqueryCustomer',
					type : 'get',
					async : true,
					data : {
						"limit" : limit,
						"currentPage" : $('#CST0010Table').data('currentPage'),
						'sortKey' : $('#CST0010Table').data('sortSql'),
					},
					success : CST0010Callback,
				});
			}
		});
	} else {
		return false;
	}
}

/**
 * 新建按钮
 */
$('#newBtn').click(function() {
	ajaxPageRequest('redirectToCST0020');
});

/**
 * 测试按钮
 */
$('#test').click(function() {
	ajaxPageRequest('redirectTotest');
});

/**
 * 检索函数
 */
function serch() {

	var serchKey = $('#searchKey').val();
	// 每页显示条数
	var limit = $('#numPerPageSelect option:selected').html();
	var url = "CST0010Actionserch";
	var data = {
		"serchKey" : serchKey,
		"limit" : limit,
		"currentPage" : $('#CST0010Table').data('currentPage'),
		'sortKey' : $('#CST0010Table').data('sortSql'),
	};
	ajaxRequest(url, CST0010serchCallback, data);
}

/**
 * 按钮检索客户
 */
$(function() {
	$('#serch').click(function() {
		serch();
	});
});

/**
 * 回车键检索信息
 */
document.onkeydown = function() {
	if (event.keyCode == 13) {
		serch();
	}
}

/**
 * 检索回调函数
 * 
 * @param data
 * @returns {Boolean}
 */
function CST0010serchCallback(data) {
	if (data === null || data.customer.length === 0) {
		// 隐藏进度条
		$('#CST0010Progress').css('visibility', 'hidden');
		if (data.status != 0) {
			// 清空table
			$('#CST0010Tbody').html("");
			// 提示检索结果为0
			$('#errorMsg').show().html(data.message);
		}
		return false;
	} else {
		$('#errorMsg').show().html("");
	}
	CST0010Callback(data)
}
