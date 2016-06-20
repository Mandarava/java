//存放数据库原数据的长度
var dataLength;

/**
 * 画面初始化
 */
$(document).ready(
		function() {
			
			//初始化Table
			initTableAreaAttr('GRO0040Table', initGRO0040);
			
			initGRO0040();
			//ユーザー焦点的设置
			document.getElementById("groupId").focus();	
			
})
			
/**
 * 检索一览信息
 */
function initGRO0040() {

	
	var url = 'GRO0040ActiongroupList';
	
	var data = {
		"limit" : $('#numPerPageSelect option:selected').html(),
		"currentPage" : $('#GRO0040Table').data('currentPage'),	
		'sortKey' : $('#GRO0040Table').data('sortSql'),
		'projectId' : $('#projectId').val()
	}
	
	ajaxRequest(url, GRO0040Callback, data);

}


function  GRO0040Callback(response){
	//清空消息框
	$('#errormsg').hide();
	//清空一览
	$('#GRO0040Tbody').empty();
	
	//如果结果为空
	if (response == null || response.groupList.length == 0) {
		dataLength = 0;
		$('#errormsg').show();
		// 隐藏进度条
		$('#GRO0040Progress').css('visibility', 'hidden');
		return false;
	}
	var groupMsg = response.groupList;
	
	var totalPage = Math.ceil(response.total / $('#numPerPageSelect option:selected').html());
	var currentPage = response.currentPage;
	
	var $GRO0040Table = $('#GRO0040Table');
	$GRO0040Table.data('currentPage',currentPage);
	$GRO0040Table.data('totalPage', totalPage);
	
	$('#GRO0040PageCount').html(currentPage + ' of ' + totalPage);
	$('#GRO0040').children().remove();
	//$('#totalGroup').html('(' + response.total + ')');
	
	
	dataLength = groupMsg.length;
	dataList = response.groupList;
	var table = new Array();
	var i = 1;
	for ( var key in groupMsg) {
			table.push('<tr id="' + groupMsg[key].groupId + '" data-userName="'+groupMsg[key].groupName + '" data-key="'+ i +'">');
			table.push('<td>' + groupMsg[key].groupId + '</td>');
			table.push('<td>' + groupMsg[key].groupName + '</td>');
			table.push('<td>' + '<a id= "delete"' + '" href="javascript:deleteGroup(\'' + groupMsg[key].groupId +'\')">删除</a>' + '</td>');
			table.push('</tr>');
		i = i + 1;
	}
	// 添加table
	$('#GRO0040Tbody').append(table.join(''));
	
	// 隐藏进度条
	$('#GRO0040Progress').css('visibility', 'hidden');
}
	
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


//var addlength = 0;
	
 //addlength = dataLength + 1 ;	
//存放一览数据
var dataList;
	
	/**
	 * 添加按钮按下(仅从页面添加数据)
	 */
	$("#btnAdd").click(function() {
		var addlength = 0;
		addlength = dataLength + 1 ;	
		
		submitFormAndValidate(null, null, null);
		var groupId = $('#groupId').val();
		var groupName = $('#groupName').val();
		if(groupId != null && groupId != '' && groupName != null  && groupName != '' ){
		var table = new Array();
		
			table.push('<tr id="' + groupId + '" data-userName="'+ groupName + '" data-key="'+addlength+'">');
			table.push('<td>' +  groupId + '</td>');
			table.push('<td>' +  groupName + '</td>');
			table.push('<td>' + '<a id= "delete"' + '" href="javascript:deleteGroup(\'' + groupId +'\')">删除</a>' + '</td>');
			table.push('</tr>');
			addlength = addlength + 1 ;
	// 添加table
	$('#GRO0040Tbody').append(table.toString());
	}
	})

/**
 * 保存按钮按下
 */
$("#btnSave").click(function() {
	
		
	//循环读取页面数据，如果原数据没有，则在数据库中删除该数据，如果为新数据，则添加新数据到数据库
	//循环查找要删除的数据
	for(var key in dataList){
		
		//存放数据是否在页面上删除的信息
		var delPage = 0;//0表示在页面上已经删除
		
		$('#GRO0040Tbody tr').each(function () {   
			//判断是否要删除数据
			if(dataList[key].groupId == $(this).attr('id') && $(this).attr('data-key')<= dataLength){
				delPage = 1; //表示在页面上存在该数据
			}
	    })
	    
	    //页面上删除了该数据
	    if(delPage == 0){
	    	//在数据库中删除此数据
	    	$.ajax({
	    		url : "GRO0040ActiondeleteGroupMember",
	    		type : "get",
	    		data : {
	    			projectId : $('#projectId').val(),
	    			groupId : dataList[key].groupId
	    		},
	    		async : false,
	    		success : function(response) {
	   
	    		}	
	    	})
	    }	
	}
	
	
	//循环查找要添加的数据
	$('#GRO0040Tbody tr').each(function () {   
	
		//判断是否要删除数据
		if($(this).attr('data-key') > dataLength){
			//在数据库中添加该数据
			$.ajax({
				url : "GRO0040ActionaddGroupMember",
				type : "post",
				data : {
					projectId : $('#projectId').val(),
					groupId : $(this).attr('id'),
					groupName : $(this).attr('data-userName')
				},
				async : false,
				success : function(response) {
					
				}
			})
		}
    })

	
  //检索一览信息
  //初始化Table
	initTableAreaAttr('GRO0040Table', initGRO0040);
	initGRO0040();
    
})


/**
 * 删除(仅从页面删除)
 */	
function deleteGroup(id){	
	$('#'+id).remove();		
}




/**
 * 前一页
 */
function previousPage() {

	if (currentPage <= 1) {
		return false;
	} else {
		// 显示进度条
		$('#GRO0040Progress').css('visibility', 'visible');
		// 当前页减一
		currentPage = currentPage - 1;

		initGRO0040(currentPage);
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
		$('#GRO0040Progress').css('visibility', 'visible');
		// 当前页加一
		currentPage = currentPage + 1;

		initGRO0040(currentPage);

	}	
}