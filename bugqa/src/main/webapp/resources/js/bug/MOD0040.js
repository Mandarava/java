//存放数据库原数据的长度
var dataLength;
/**
 * 画面初始化
 */
$(document).ready(
		function() {
			
			initTableAreaAttr('MOD0040Table', initMOD0040);
			//检索一览信息
			initMOD0040();
			//ユーザー焦点的设置
			document.getElementById("moduleId").focus();	
})
			
/**
 * 取消按钮按下
 */
$("#btnCancel").click(function() {
		$.ajax({
			cache : false,
			url : 'redirectToPRO0030',
			type : 'get',
			data : {'cancelfrom' : "cancel"},
			success : function(responseText) {
				$('#rightFrame').html(responseText);
			}
		});
})

//存放一览数据
var dataList;

/**
 * 添加按钮按下(仅从页面添加数据)
 */
$("#btnAdd").click(function() {
		//add开始添加的长度
		var addlength;
		addlength = dataLength + 1 ;
		
		submitFormAndValidate(null, null, null);
		var table = new Array();
		var moduleId = $('#moduleId').val();
		var moduleName = $('#moduleName').val();
		if(moduleId != null && moduleId != '' && moduleName != null  && moduleName != ''){
			
		table.push('<tr id="' + moduleId + '" data-userName="'+moduleName + '" data-key="'+addlength+'">');
		table.push('<td>' + moduleId + '</td>');
		table.push('<td>' + moduleName + '</td>');
		table.push('<td>' + '<a id= "delete"' + '" href="javascript:deleteModule(\'' + moduleId +'\')">删除</a>' + '</td>');
		table.push('</tr>');
		addlength = addlength + 1 ;	
		// 添加table
		$('#MOD0040Tbody').append(table.toString());
		}
})

/**
 * 保存按钮按下(修改模块名)
 */
$("#btnSave").click(function() {
	
	//循环查找要删除的数据
	for(var key in dataList){
		
		//存放数据是否在页面上删除的信息
		var delPage = 0;//0表示在页面上已经删除
		var delModuleId;//待删除的ID
		$('#MOD0040Tbody tr').each(function () { 
			//alert($(this).attr('id'));
			//判断是否要删除数据
			if(dataList[key].moduleId == $(this).attr('id') && $(this).attr('data-key')<= dataLength){
				delPage = 1; //表示在页面上存在该数据
			}
	    })
	    
	    //页面上删除了该数据
	    if(delPage == 0){
	    	console.log($(this));
	    	//在数据库中删除此数据
	    	$.ajax({
	    		url : "MOD0040ActiondeleteModule",
	    		type : "get",
	    		data : {
	    			projectId : $('#projectId').val(),
	    			groupId :  $('#groupId').val(),
	    			moduleId : dataList[key].moduleId
	    		},
	    		async : false,
	    		success : function(response) {
	   
	    		}	
	    	})
	    }	
	}

	//循环查找要添加的数据
	$('#MOD0040Tbody tr').each(function () {   
		
		//判断是否要删除数据
		if($(this).attr('data-key') > dataLength){
			//在数据库中添加该数据
			$.ajax({
				url : "MOD0040ActionaddModule",
				type : "post",
				data : {
					projectId : $('#projectId').val(),
					groupId : $('#groupId').val(),
					moduleId : $(this).attr('id'),
					moduleName : $(this).attr('data-userName')
				},
				async : false,
				success : function(response) {
					
				}
			})
		}
    })
    
    
   initTableAreaAttr('MOD0040Table', initMOD0040);
  //检索一览信息
	initMOD0040();
})

/**
 * 删除(仅从页面删除)
 */	
function deleteModule(id){	
	$('#'+id).remove();		
}

/**
 * 检索一览信息
 */
function initMOD0040() {

	
	var url = 'MOD0040ActionmoduleList';
	var data = {
			"limit" : $('#numPerPageSelect option:selected').html(),
			"currentPage" : $('#MOD0040Table').data('currentPage'),	
			'sortKey' : $('#MOD0040Table').data('sortSql'),
			'groupId' : $('#groupId').val(),
			'projectId' : $('#projectId').val()
		}
	
	ajaxRequest(url, MOD0040Callback, data);
}

function MOD0040Callback(response){
	
	//清空消息框
	$('#errormsg').hide();
	//清空一览
	$('#MOD0040Tbody').empty();
	
	//如果结果为空
	if (response == null || response.moduleList.length == 0) {
		dataLength = 0;
		$('#errormsg').show();
		// 隐藏进度条
		$('#MOD0040Progress').css('visibility', 'hidden');
		return false;
	}
	var moduleMsg = response.moduleList;
	
	var totalPage = Math.ceil(response.total / $('#numPerPageSelect option:selected').html());
	var currentPage = response.currentPage;
	
	var $MOD0040Table = $('#MOD0040Table');
	$MOD0040Table.data('currentPage',currentPage);
	$MOD0040Table.data('totalPage', totalPage);
	
	$('#MOD0040PageCount').html(currentPage + ' of ' + totalPage);
	$('#MOD0040').children().remove();
	$('#totalModule').html('(' + response.total + ')');
	
	dataList = response.moduleList;
	dataLength = moduleMsg.length;
	var table = new Array();
	var i = 1;
	
	for ( var key in moduleMsg) {
		
			table.push('<tr id="' + moduleMsg[key].moduleId + '" data-userName="'+moduleMsg[key].moduleName +  '" data-key="'+ i +'">');
			table.push('<td>' + moduleMsg[key].moduleId + '</td>');
			table.push('<td>' + moduleMsg[key].moduleName + '</td>');
			table.push('<td>' + '<a id= "delete"' + '" href="javascript:deleteModule(\'' + moduleMsg[key].moduleId +'\')">删除</a>' + '</td>');
			table.push('</tr>');
		
	}
	// 添加table
	$('#MOD0040Tbody').append(table.join(''));
	
	// 隐藏进度条
	$('#MOD0040Progress').css('visibility', 'hidden');
}



/**
 * 前一页
 */
function previousPage() {

	if (currentPage <= 1) {
		return false;
	} else {
		// 显示进度条
		$('#MOD0040Progress').css('visibility', 'visible');
		// 当前页减一
		currentPage = currentPage - 1;

		initMOD0040(currentPage);
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
		$('#MOD0040Progress').css('visibility', 'visible');
		// 当前页加一
		currentPage = currentPage + 1;

		initMOD0040(currentPage);

	}	
}

