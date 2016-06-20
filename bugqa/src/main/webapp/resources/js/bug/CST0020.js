
/**
 * 初始化
 */
$(document).ready(function() {
	document.getElementById("txtCstCode").focus();
})

/**
 * 保存按钮按下
 */
$(function() {
	$('#btnSave').click(function() {
		var url = "CST0020ActionnewCustomer";
		var data = {

		};
		submitFormAndValidate(url, data, CST0020Callback);

	});
});

/**
 * CST0020Callback
 * 
 * @param data
 */
function CST0020Callback(data) {
	if (data.status != 0) {
		// 提示客户编号已存在
		$('#errorMsg').show().html(data.message);
	} else {
		$('#errorMsg').show().html(data.message);
		// 清空表单
		clearForm();
	}
	document.getElementById("txtCstCode").focus();
	$("#txtCstCode").click(function() {
		$("#errorMsg").show().html("");
	})
}

/**
 * CST0030新建客户取消按钮
 */
$('#btnCancel').click(function() {
	$.ajax({
		cache : false,
		url : 'redirectToCST0010',
		async : true,
		type : 'get',
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
	return false;

})



/**
 * 新建完成后清空表单
 */
function clearForm() {
	document.getElementById("CST0020Form").reset();
}

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
