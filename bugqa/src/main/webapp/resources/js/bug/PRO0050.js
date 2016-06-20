var workType;
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
			if($("#projectId").val()==''){
				$.ajax({
					cache : false,
					url : 'redirectToMAI0061',
					type : 'get',
					success : function(responseText) {
						$('#rightFrame').html(responseText);
					}
				});
			}
			
			//所有担当类型的取得  取得汎用信息(担当类型)
			$.ajax({
					url : "PRO0050ActionworkTypeMsg",
					type : "get",
					async : false,
					success : function(response) {
						workType = response.workTypeMsg;
					}
				});
			
			//初始化得意先下拉框  取得得意先信息
			$.ajax({
					url : "PRO0050ActioncustomerMsg",
					type : "get",
					async : false,
					success : function(response) {
						userCustomerCode = response.userCustomerCode[0].CUSTOMERCODE;
						userDepartmentId = response.userCustomerCode[0].DEPARTMENTID;
						//清空下拉框 
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
			
			//初始化部門下拉框  取得部門信息
				$.ajax({
					url : "PRO0050ActiondepartmentMsg",
					type : "get",
					data : {
						customerCode : $('#customerCode option:selected').val()
					},
					async : false,
					success : function(response) {
						//清空下拉框
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
						//刷新下拉框
						$('select').material_select();
					}
				});
			
				//初始化課下拉框 取得課信息
					$.ajax({
						url : "PRO0050ActionclassMsg",
						type : "get",
						data : {
							customerCode : $('#customerCode option:selected').val(),
							departmentId : $('#departmentId option:selected').val()
						},
						async : false,
						success : function(response) {
							//清空下拉框
							$("#classId").find("option").remove();
							//插入空option
							$('#classId').append('<option value="" selected></option>');
							
							for ( var key in response.classMsg) {
								$('#classId').append(
										'<option value=' + response.classMsg[key].code + '>'
												+ response.classMsg[key].name + '</option>');
							}
							// 刷新界面
							$('select').material_select();
						}
					});
					
					//初始化Table
					initTableAreaAttr('PRO0050Table', initPRO0050);
					//初始化列表
					initPRO0050();
					
					//ユーザー焦点的设置
					document.getElementById("users").focus();
		})

		/**
 * 检索一览信息
 */
function initPRO0050(){
	
	var url = 'PRO0050ActionlistUserMsg';
	
	var data = {
		"limit" : $('#numPerPageSelect option:selected').html(),
		"currentPage" : $('#PRO0050Table').data('currentPage'),	
		'sortKey' : $('#PRO0050Table').data('sortSql'),
		'customerCode' : $('#customerCode option:selected').val(),
		'departmentId' : $('#departmentId option:selected').val(),
		'classId' : $('#classId option:selected').val(),
		'users' : $('#users').val(),
		'projectId' : $('#projectId').val()
	}
	
	ajaxRequest(url, PRO0050Callback, data);
}

/**
 * 返回操作
 * @param response
 * @returns {Boolean}
 */
function PRO0050Callback(response){

	//清空消息框
	$('#errormsg').hide();
	//清空一览
	$('#PRO0050Tbody').empty();
	
	//如果结果为空
	if (response == null || response.listUserMsg.length == 0) {
		$('#errormsg').show();
		// 隐藏进度条
		$('#PRO0050Progress').css('visibility', 'hidden');
		//ユーザー焦点的设置
		document.getElementById("users").focus();
		return false;
	}
	
	var totalPage = Math.ceil(response.total / $('#numPerPageSelect option:selected').html());
	var currentPage = response.currentPage;
	
	var $PRO0050Table = $('#PRO0050Table');
	$PRO0050Table.data('currentPage',currentPage);
	$PRO0050Table.data('totalPage', totalPage);
	
	$('#PRO0050PageCount').html(currentPage + ' of ' + totalPage);
	$('#PRO0050').children().remove();
	$('#totalUser').html('(' + response.total + ')');
	
	
	var userMsg = response.listUserMsg;
	var table = new Array();
	for ( var key in userMsg) {
		if(chargeId != '' && chargeId == userMsg[key].USERID){
			continue;
		}else if(managerId != '' && managerId == userMsg[key].USERID){
			continue;
		}else{
			table.push('<tr id="' + userMsg[key].USERID + '" data-userName="'+userMsg[key].USERNAME+'">');
			table.push('<td>' +'<input type="checkbox" id="test' + key + '" name="checkbox" value="' + userMsg[key].USERID + '"/><label for="test' + key + '"></label>'+ '</td>');
			table.push('<td>' + userMsg[key].USERID + '</td>');
			table.push('<td>' + userMsg[key].USERNAME + '</td>');
			table.push('<td>' + '<select id="select' +key +'"></select>' + '</td>');
			table.push('</tr>');
		}
	}
				
	// 添加table
	$('#PRO0050Tbody').append(table.join(''));
	
	//在一览添加下拉框
	for ( var key in userMsg) {
		for ( var key1 in workType){
			if(key1 == 0){
				$('#select'+key).append(
						'<option value="' + workType[key1].code + '" selected="selected">'
								+ workType[key1].name + '</option>');
			}else{
				$('#select'+key).append(
						'<option value=' + workType[key1].code + '>'
								+ workType[key1].name + '</option>');
			}
		}
	}
	//刷新下拉框
	$('select').material_select();
	// 隐藏进度条
	$('#PRO0050Progress').css('visibility', 'hidden');
}

		
	/**
	 * 得意先下拉框选中值变换
	 */
	$('#customerCode').change(
		function() {
			$("#departmentId").find("option").remove();
			$("#classId").find("option").remove();
			$.ajax({
				url : "PRO0050ActiondepartmentMsg",
				type : "get",
				data : {
					customerCode : $('#customerCode option:selected').val()
				},
				async : false,
				success : function(response) {
					//插入空行
					$('#departmentId').append('<option value="" selected>'+ '</option>');
					for ( var key in response.departmentMsg) {
						$('#departmentId').append(
								'<option value=' + response.departmentMsg[key].departmentId + '>'
										+ response.departmentMsg[key].departmentName + '</option>');
					}
					//刷新
					$('select').material_select();
				}
			});
		});

/**
 * 部门下拉框选中值变换 取得課信息
 */
$('#departmentId').change(
		function() {
			//清空下拉框
			$("#classId").find("option").remove();
			$.ajax({
				url : "PRO0050ActionclassMsg",
				type : "get",
				data : {
					customerCode : $('#customerCode option:selected').val(),
					departmentId : $('#departmentId option:selected').val()
				},
				async : false,
				success : function(response) {
					//插入空行
					$('#classId').append('<option value="" selected>'+ '</option>');
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
$("#btnSelect").click(function() {
	var flg = 0; //用户输入没有错误
	//判断user框输入的数据是否超过20位
	if($("#users").val().length > 20){
		$(".errorTxt0").html(USE0009);
		$("#users").focus();
		flg = 1;
	}
	
	if(flg == 0){
		//初始化Table
		initTableAreaAttr('PRO0050Table', initPRO0050);
		//初始化列表
		initPRO0050();
		
		//ユーザー焦点的设置
		document.getElementById("users").focus();
	}
	
	
})


/**
 *確認処理
 */
$('#btnConfirm').click(function() {
	var worktype;
	var userId;
	var obj = document.getElementsByName("checkbox");
	//判断checkBox被选中（依次）
	for( var i=0; i<=obj.length;i++){
		if($("#test"+i).is(':checked')==true){
			var id = "select"+i+"  option:selected";
			userId = $("#test"+i).val();
			worktype = $("#"+id).val();
			//插入メンバーマスター
			$.ajax({
				cache : false,
				url : 'PRO0050ActioninsertUserMsg',
				type : 'get',
				data : {
					workType : worktype,
					userId : userId,
					projectId : $('#projectId').val()
				},
				success : function(responseText) {
					
					$(".errorTxt0").html("提交成功");
					//返回父页面
					$.ajax({
						cache : false,
						url : 'redirectToPRO0030',
						type : 'get',
						data : {'cancelfrom' : "cancel"},
						success : function(responseText) {
							$('#rightFrame').html(responseText);
						}
					});
					
				}
			});
		}
	}
	
});

	/**
	 *キャンセルボタンを押下処理
	 */
$('#btnCancel').click(function() {
	//返回父页面
	$.ajax({
		cache : false,
		url : 'redirectToPRO0030',
		type : 'get',
		data : {'cancelfrom' : "cancel"},
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
		$('#PRO0050Progress').css('visibility', 'visible');
		// 当前页减一
		currentPage = currentPage - 1;

		initPRO0050(currentPage);
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
		$('#PRO0050Progress').css('visibility', 'visible');
		// 当前页加一
		currentPage = currentPage + 1;

		initPRO0050(currentPage);

	}	
}