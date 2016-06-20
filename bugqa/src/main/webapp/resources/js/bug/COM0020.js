
$("#lblkbn").addClass("active");
$("#lblcode").addClass("active");
$("#lblname").addClass("active");
$("#lblremark").addClass("active");

/**
 * 保存按钮按下
 */
$("#btnSave").click(function() {
	
	var url = "COM0020ActionupdateGeneralMsg";
	submitFormAndValidate(url, null, callback);	
})

function callback(data) {
	$("#errormsg").html("更新成功");
	$.ajax({
		cache : false,
		url : 'redirectToCOM0010',
		type : 'get',
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
}

/**
 * 取消按钮按下
 */
$("#btnCancel").click(function() {
	$.ajax({
		cache : false,
		url : 'redirectToCOM0010',
		type : 'get',
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
})
