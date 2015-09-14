/**
 * 检索按钮动作
 */
function selectDeptInfo() {
	myform.action = "Select";
	myform.submit();
}

/**
 * 清除按钮动作
 */
function clearView() {
	myform.action = "Clear";
	myform.submit();
}

/**
 * 退出按钮动作
 */
function exit() {
	myform.action = "Exit";
	myform.submit();
}
