
$(document).ready(function(){			
	// 取得当前ユーザー信息
	$.ajax({
		url : "USE0032ActionuserMsg",
		type : "get",
		async : false,
		success : function(data) {
			//激活label框
			$("#lblUserId").addClass("active");
			$("#lblUserName").addClass("active");
			$("#lblPassword").addClass("active");
			$("#lblMailAddress").addClass("active");
			//给页面赋值
			$("#userId").val(data.userMsgCom[0].userId);
			$("#userName").val(data.userMsgCom[0].userName);
			//$("#password").val(data.userMsgCom[0].password);
			$("#mailAddress").val(data.userMsgCom[0].mailAddress);
			
			}		
		});				
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
 * 保存按钮压下
 */
$(function(){
	$("#btnSave").click(function(){
		var url = "USE0032ActionupdateUser";
		submitFormAndValidate(url,null,callback);
		
	})
})


/**
 * 更新成功后的操作
 * @param data
 */
function callback(data) {
	$("#errormsg").html("更新成功");
	$.ajax({
		cache : false,
		url : 'redirectToMAI0060',
		type : 'get',
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
}


