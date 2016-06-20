	
var userCustomerCode;
var userDepartmentId;
var chargeId = $("#chargeId").val();
var managerId = $("#managerId").val();


/**
 * 画面初始化
 */
$(document).ready(
		function() {
			
			//判断是否能取到プロジェクトID 不能取得的场合(取得值为Nothing)：首页画面迁移
			if($("#projectId").val()==''){console.log('041');
				$.ajax({
					cache : false,
					url : 'redirectToMAI0061',
					type : 'get',
					success : function(responseText) {
						$('#rightFrame').html(responseText);
					}
				});
			}
			//初始化得意先下拉框  取得得意先信息
			customerMsg();
			//初始化部門下拉框  取得部門信息
			departmentMsg();
			//初始化课下拉框
			classMsg();
			//初始化Table
			initTableAreaAttr('PRO0041Table', initPRO0041);
			//经理/负责人管理
			initPRO0041();
			//ユーザー焦点的设置
			document.getElementById("users").focus();	
})



/**
 * 检索一览信息
 */
function initPRO0041(){
	
	var url = 'PRO0041ActionuserMsgSelect';
	
	var data = {
		"limit" : $('#numPerPageSelect option:selected').html(),
		"currentPage" : $('#PRO0041Table').data('currentPage'),	
		'sortKey' : $('#PRO0041Table').data('sortSql'),
		'customerCode' : $('#customerCode option:selected').val(),
		'departmentId' : $('#departmentId option:selected').val(),
		'classId' : $('#classId option:selected').val(),
		'users' : $('#users').val(),
		'projectId' : $('#projectId').val()
	}
	
	ajaxRequest(url, PRO0041Callback, data);
}


/**
 * 返回操作
 * @param response
 * @returns {Boolean}
 */
function PRO0041Callback(response){
	
	//清空消息框
	$('#errormsg').hide();
	//清空一览
	$('#PRO0041Tbody').empty();
	
	//如果结果为空
	if (response == null || response.userMsgSelect.length == 0) {
		$('#errormsg').show();
		// 隐藏进度条
		$('#PRO0041Progress').css('visibility', 'hidden');
		return false;
	}
	var userMsg = response.userMsgSelect;
	var totalPage = Math.ceil(response.total / $('#numPerPageSelect option:selected').html());
	var currentPage = response.currentPage;
	
	var $PRO0041Table = $('#PRO0041Table');
	$PRO0041Table.data('currentPage',currentPage);
	$PRO0041Table.data('totalPage', totalPage);
	
	$('#PRO0041PageCount').html(currentPage + ' of ' + totalPage);
	$('#PRO0041').children().remove();
	$('#totalUser').html('(' + response.total + ')');
	
	
	var table = new Array();
	for ( var key in userMsg) {
		if(chargeId != '' && chargeId == userMsg[key].USERID){
			continue;
		}else if(managerId != '' && managerId == userMsg[key].USERID){
			continue;
		}else{
			table.push('<tr id="' + userMsg[key].USERID + '" data-userName="'+userMsg[key].USERNAME + '">');
			table.push('<td>' + userMsg[key].USERID + '</td>');
			table.push('<td>' + userMsg[key].USERNAME + '</td>');
			table.push('<td>' + '<a id= "select"' + '" href="javascript:selectUser(\'' + userMsg[key].USERID +'\')">选择</a>' + '</td>');
			table.push('</tr>');
		}
	}
	// 添加table
	$('#PRO0041Tbody').append(table.join(''));
	
	// 隐藏进度条
	$('#PRO0041Progress').css('visibility', 'hidden');
	

	
	
}


/**
 * 得意先下拉框选中值变换
 */
	$('#customerCode').change(
		function() {
			$("#departmentId").find("option").remove();
			$("#classId").find("option").remove();
			$.ajax({
				url : "PRO0041ActiondepartmentMsg",
				type : "get",
				data : {
					customerCode : $('#customerCode option:selected').val()
				},
				async : false,
				success : function(response) {
					$('#departmentId').append('<option value="" selected></option>');
					for ( var key in response.departmentMsg) {
						$('#departmentId').append(
								'<option value=' + response.departmentMsg[key].departmentId + '>'
										+ response.departmentMsg[key].departmentName + '</option>');
					}
					$('select').material_select();
				}
			});
});	

	

/**
 * 部门下拉框选中值变换 取得課信息
 */
	$('#departmentId').change(
				function() {
					$("#classId").find("option").remove();
					$.ajax({
						url : "PRO0041ActionclassMsg",
						type : "get",
						data : {
							customerCode : $('#customerCode option:selected').val(),
							departmentId : $('#departmentId option:selected').val()
						},
						async : false,
						success : function(response) {
							$('#classId').append('<option value="" selected></option>');
							for ( var key in response.classMsg) {
								$('#classId').append(
										'<option value=' + response.classMsg[key].classId + '>'
												+ response.classMsg[key].className + '</option>');
							}
							// 刷新界面
							$('select').material_select();
						}
					});
});
	


	

	/**
	 * 检索按钮按下
	 */
	$('#btnSelect').click(function(){
		var flg = 0; //用户输入没有错误
		if($("#users").val().length > 20){
			//$(".errorTxt0").html(USE0009);
			$("#users").focus();
			flg = 1;
		}
		
		if(flg == 0){
			initTableAreaAttr('PRO0041Table', initPRO0041);
			//经理/负责人管理
			initPRO0041();
			//ユーザー焦点的设置
			document.getElementById("users").focus();	
		}
			
})
		

	
/**
 * 选择按钮，将数据返回到相应的页面
 * @param id
 */	
function selectUser(id) {
	//var userName = $('#'+id).data('username');
	var userName = $('#'+id).attr('data-userName');
	// from 上个页面的按钮判断
	var root = $('#fromId').val();
	
	if( root == "chargePRO0020" || root == "managerPRO0020"){
		$.ajax({
			cache : false,
			url : 'redirectToPRO0020',
			type : 'post',
			data : {
				'userId' : id,
				'userName': userName,
				'from' : $('#fromId').val()
			},
			success : function(responseText) {
				$('#rightFrame').html(responseText);
			}
		});
	}
	if( root == "chargePRO0030" || root == "managerPRO0030"){
		$.ajax({
			cache : false,
			url : 'redirectToPRO0030',
			type : 'post',
			data : {
				'userId' : id,
				'userName': userName,
				'from' : $('#fromId').val()
			},
			success : function(responseText) {
				$('#rightFrame').html(responseText);
			}
		});
	}
	
}


	
	/**
	 * 取消按钮按下 返回到相应页面
	 */
	
	$('#btnCancel').click(function(){
		var root = $('#fromId').val();
		if( root == "chargePRO0020" || root == "managerPRO0020"){
			$.ajax({
				cache : false,
				url : 'redirectToPRO0020',
				type : 'get',
				data :{
					cancelfrom : "cancel" 
				},
				success : function(responseText) {
					$('#rightFrame').html(responseText);
				}
			});
		}
		if( root == "chargePRO0030" || root == "managerPRO0030"){
			$.ajax({
				cache : false,
				url : 'redirectToPRO0030',
				type : 'get',
				data :{
					cancelfrom : "cancel" 
				},
				success : function(responseText) {
					$('#rightFrame').html(responseText);
				}
			});
		}
		
})



	/**
	 * 初始化得意先下拉框  取得得意先信息
	 */
function customerMsg(){
		$.ajax({
			url : "PRO0041ActioncustomerMsg",
			type : "get",
			async : false,
			success : function(response) {
				userCustomerCode = response.userCustomerCode[0].CUSTOMERCODE;//当前用户所属会社
				userDepartmentId = response.userCustomerCode[0].DEPARTMENTID;//当前用户所属部门
				$("#customerCode").find("option").remove();
				
				for ( var key in response.customerMsg) {
					if(response.customerMsg[key].customerCode == userCustomerCode){
						$('#customerCode').append(
								'<option value="' + response.customerMsg[key].customerCode + '" selected >'
										+ response.customerMsg[key].customerName + '</option>');
					} else {
						$('#customerCode').append(
								'<option value=' + response.customerMsg[key].customerCode + '>'
										+ response.customerMsg[key].customerName + '</option>');
					}
				}
				// 刷新界面
				$('select').material_select();
			}
		});
}
	
	/**
	 * 初始化部門下拉框  取得部門信息
	 */
function departmentMsg(){
		$.ajax({
			url : "PRO0041ActiondepartmentMsg",
			type : "get",
			data : {
				customerCode : $('#customerCode option:selected').val()
			},
			async : false,
			success : function(response) {
				$("#departmentId").find("option").remove();
				$("#classId").find("option").remove();
				
				for ( var key in response.departmentMsg) {
					if(response.departmentMsg[key].departmentId == userDepartmentId){
						$('#departmentId').append(
								'<option value="' + response.departmentMsg[key].departmentId + '" selected >'
										+ response.departmentMsg[key].departmentName + '</option>');
					} else{
						$('#departmentId').append(
								'<option value=' + response.departmentMsg[key].departmentId + '>'
										+ response.departmentMsg[key].departmentName + '</option>');
					}
				}
				$('select').material_select();
			}
		});
}
	
	/**
	 * 初始化课下拉框
	 */
function classMsg(){
		$.ajax({
			url : "PRO0041ActionclassMsg",
			type : "get",
			data : {
				customerCode : $('#customerCode option:selected').val(),
				departmentId : $('#departmentId option:selected').val()
			},
			async : false,
			success : function(response) {
				$("#classId").find("option").remove();
				$('#classId').append('<option value="" selected></option>');
				for ( var key in response.classMsg) {
					$('#classId').append(
							'<option value=' + response.classMsg[key].classId + '>'
									+ response.classMsg[key].className + '</option>');
				}
				// 刷新界面
				$('select').material_select();
				;
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
		$('#PRO0041Progress').css('visibility', 'visible');
		// 当前页减一
		currentPage = currentPage - 1;

		initPRO0041(currentPage);
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
		$('#PRO0041Progress').css('visibility', 'visible');
		// 当前页加一
		currentPage = currentPage + 1;

		initPRO0041(currentPage);

	}	
}
	