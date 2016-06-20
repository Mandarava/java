/**
 * 画面初始化
 */
$(document).ready(
		function() {
			// 初始化ユーザー権限下拉框 	取得汎用信息(ユーザー権限)
			userPrevl();
			// 初始化得意先下拉框 	取得得意先信息(会社フラグ='0')
			selCustCode();
})
		
/**
 * 初始化用户权限
 */		
function userPrevl() {
	$.ajax({
		url : "USE0020ActionuserPrevl",
		type : "get",
		async : false,
		success : function(data) {
			//插入数据
			for ( var key in data.userPrevlList) {
				$('#userPrevl').append(
						'<option value=' + data.userPrevlList[key].code + '>' + data.userPrevlList[key].name
								+ '</option>');
			}
			//刷新
			$('select').material_select();
		}
	});
}
/**
 * 初始化客户信息
 */
function selCustCode() {
	$.ajax({
		url : "USE0020ActionselCustCode",
		type : "get",
		async : false,
		success : function(data) {
			//插入数据
			for ( var key in data.selCustCodeList) {
				$('#customerCode').append(
						'<option value=' + data.selCustCodeList[key].customerCode + '>'
								+ data.selCustCodeList[key].customerName + '</option>');
			}
			//刷新
			$('select').material_select();
			
		}
	});
}
		
/**
 * 焦点设置
 */
document.getElementById("userId").focus();

/**
 * 会社フラグ变换	取得会社信息
 */
$('input:radio[name="companyFlg"]').click(
		function() {
			$("#customerCode").find("option").remove();
			$("#departmentId").find("option").remove();
			$("#classId").find("option").remove();
			$.ajax({
				url : "USE0020ActioncustomerMsg",
				type : "get",
				data : {
					companyFlg : $('input:radio[name="companyFlg"]:checked').val()
				},
				async : false,
				success : function(response) {
					//插入空行
					$('#customerCode').append('<option value=""' + 'selected >' + '</option>');
					//插入数据
					for ( var key in response.customerMsg) {
						$('#customerCode').append(
								'<option value=' + response.customerMsg[key].customerCode + '>'
										+ response.customerMsg[key].customerName + '</option>');
					}
					//刷新
					$('select').material_select();
				}
			});
		});

/**
 * 得意先变换   取得当前选中的得意先的所有部门信息
 */
$('#customerCode').change(
		function() {
			$("#departmentId").find("option").remove();
			$("#classId").find("option").remove();
			$.ajax({
				url : "USE0020ActiondepartmentMsg",
				type : "get",
				data : {
					customerCode : $('#customerCode option:selected').val()
				},
				async : false,
				success : function(response) {
					//插入空行
					$('#departmentId').append('<option value=""' + 'selected >' + '</option>');
					//插入数据
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
 * 部门变换    取得当前部门的所有课信息
 */
$('#departmentId').change(
		function() {
			$("#classId").find("option").remove();
			$.ajax({
				url : "USE0020ActionclassMsg",
				type : "get",
				data : {
					customerCode : $('#customerCode option:selected').val(),
					departmentId : $('#departmentId option:selected').val()
				},
				async : false,
				success : function(response) {
					//插入空行
					$('#classId').append('<option value=""' + 'selected >' + '</option>');
					//插入数据
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
 * 取消按钮按下
 */
$("#btnCancel").click(function() {
	$.ajax({
		cache : false,
		url : 'redirectToUSE0010',
		type : 'get',
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
})

/**
 * 保存按钮按下
 */
$(function() {
	$("#btnSave").click(function() {
		// 提交数据
			var url = "USE0020ActionaddUserMsg";
			submitFormAndValidate(url, null,callback);
	});
});


/**
 * 插入数据成功
 * @param data
 */
function callback(data) {
		if (data.exitFlg == "notExit") {

			$("#errormsg").html(COM0001);
			$("#userId").focus();
			$("#userId").click(function() {
				$("#errormsg").empty();
			})

			// 各项恢复到初值
			document.getElementById("USE0020form").reset();
			// 初始化ユーザー権限下拉框 取得汎用信息(ユーザー権限)
			userPrevl();
			// 初始化得意先下拉框 取得得意先信息(会社フラグ='0')
			selCustCode();
		}
		if (data.exitFlg == "exit") {
			$('#errormsg').html("id已經存在");
		}

	return false;
}
