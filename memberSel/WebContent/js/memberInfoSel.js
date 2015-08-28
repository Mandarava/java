/**
 * 查找按钮的动作
 * 
 */
function doselect() {
	var myform = document.getElementById("myform");
	var memberCodeInput = document.getElementById("memberCodeInput").value;
	var nameInput = document.getElementById("nameInput").value;
	doCheck(memberCodeInput, nameInput);
}
/**
 * 对用户输入进行判断
 * 
 * @param workerId
 *            工号
 * @param nameInput
 *            输入的部门名或姓名
 */
function doCheck(workerId, nameInput) {
	// 当[工号]输入框中的有输入的时候,trim 处理
	trimedWorkerId = workerId.length != 0 ? workerId.trim() : "";
	// 当[名称]输入框中有输入的时候,TRIM处理
	trimedNameInput = nameInput.length != 0 ? nameInput.trim() : "";

	// 位数为0的话
	if (trimedWorkerId.length == 0) {
		// 位数为0的话，直接处理noInput
		if (trimedNameInput.length == 0) {
			document.getElementById("errorInfo").value = "请输入！";
		} else {
			document.getElementById("errorInfo").value = "";
			myform.action = "Select";
			myform.submit();
		}
		// 位数不足8位的时候在MSG区域报消息、处理终止
	} else if (trimedWorkerId.length < 8) {
		document.getElementById("errorInfo").value = "工号位数不足8位";
	} else if (trimedWorkerId.length == 8) {
		document.getElementById("errorInfo").value = "";
		myform.action = "Select";
		myform.submit();
	}
}

/**
 * 清除按钮的动作
 * 
 */
function doclear() {
	var myform = document.getElementById("myform");
	myform.action = "Clear";
	myform.submit();
}

/**
 * 当用户文本框内有输入时清空报错栏信息
 * 
 */
function onInput() {
	document.getElementById("errorInfo").value = "";
	if (event.keyCode == 13) {
		doselect();
	}
}