/**
 * 画面初始化
 */
$(document).ready(
		function() {
		
			initTableAreaAttr('COM0010Table', initCOM0010);
			// 用户管理
			initCOM0010();

		})

		
function initCOM0010() {
	
	var url = 'COM0010ActiongeneralMsg';
	
	var data = {
			"limit" : $('#numPerPageSelect option:selected').html(),
			"currentPage" : $('#COM0010Table').data('currentPage'),	
			'sortKey' : $('#COM0010Table').data('sortSql'),
			'searchKey' : $('#condition').val()
		}
		
		ajaxRequest(url, COM0010Callback, data);
	
	
}		

		
/**
 * 检索按钮按下
 */
$('#condition').keydown(
		function(e) {
			if (event.keyCode == 13) {
				
				initTableAreaAttr('COM0010Table', initCOM0010);
				// 用户管理
				initCOM0010();
				
			}
		})

/**
 * 取消按钮按下
 */
$("#btnCancel").click(function() {
	$.ajax({
		cache : false,
		url : 'redirectToMAI0060',
		type : 'get',
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
})

/**
 * table每页显示页数变化事件
 */
$("#COM0010PageSelect").change(function() {
	// 显示进度条
	$('#COM0010Progress').css('visibility', 'visible');
	// 初始化页数
	currentPage = 1;
	
	//初始化
	initCOM0010();
});


/**
 * 向COM0020页面传值
 * 
 * @param id
 */
function updateName(id) {
	var code = $('#' + id).attr('data-code');
	var kbn = $('#' + id).attr('data-value');
	var remark = $('#' + id).attr('data-remark');
	$.ajax({
		cache : false,
		url : 'redirectToCOM0020',
		type : 'post',
		data : {
			'name' : id,
			'kbn' : kbn,
			'code' : code,
			'remark' : remark
		},
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
}

/**
 * 前一页
 */
function previousPage() {

	if (currentPage <= 1) {
		return false;
	} else {
		// 显示进度条
		$('#COM0010Progress').css('visibility', 'visible');
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
		$('#COM0010Progress').css('visibility', 'visible');
		// 当前页加一
		currentPage = currentPage + 1;

		initUSE0010(currentPage);

	}	
}

/**
 * 返回操作
 */
function COM0010Callback(response){
	
	// 清空一览
	$('#COM0010Tbody').empty();
	$('#errormsg').hide();
	
	// 判断结果是否为空
	if (response == null || response.generalMsg.length == '0') {
		$('#errormsg').show();
		// 隐藏进度条
		$('#COM0010Progress').css('visibility', 'hidden');
		return false;
	}
	var generalMsg = response.generalMsg;
	var totalPage = Math.ceil(response.total / $('#numPerPageSelect option:selected').html());
	var currentPage = response.currentPage;
	
	var $COM0010Table = $('#COM0010Table');
	$COM0010Table.data('currentPage',currentPage);
	$COM0010Table.data('totalPage', totalPage);
	
	$('#COM0010PageCount').html(currentPage + ' of ' + totalPage);
	$('#COM0010').children().remove();
	
	$('#totalCOM').html('(' + response.total + ')');
	
	
	var table = new Array();
	for ( var key in generalMsg) {
		table.push('<tr id="' + generalMsg[key].name + '" data-code="' + generalMsg[key].code
				+ '" data-value="' + generalMsg[key].kbn + '" data-remark="'+ generalMsg[key].remark +'">');
		table.push('<td>' + generalMsg[key].kbn + '</td>');
		table.push('<td>' + generalMsg[key].code + '</td>');
		table.push('<td>' + '<a id= "update"' + '" href="javascript:updateName(\''
				+ generalMsg[key].name + '\')">' + generalMsg[key].name + '</a>' + '</td>');
		table.push('<td>' + generalMsg[key].remark + '</td>');
		table.push('</tr>');
	}
	// 添加table
	$('#COM0010Tbody').append(table.join(''));

	// 隐藏进度条
	$('#COM0010Progress').css('visibility', 'hidden');
	
}
