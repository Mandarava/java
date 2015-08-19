/**查找按钮的动作*/
function doselect() {
	var myform = document.getElementById("myform");
	var membercodeInput = document.getElementById("membercodeInput").value;
	var nameInput = document.getElementById("nameInput").value;
	if (nameInput.trim().length != 0) { // 如果名称有输入优先判断
		isNameInput(nameInput);
		return;
	}
	isWorkerIdInput(membercodeInput, nameInput);
}

/**清除按钮的动作*/
function doclear() {
	var myform = document.getElementById("myform");
	myform.action = "Clear";
	myform.submit();
}

/**当用户文本框内有输入时清空报错栏信息*/
function onInput() {
	document.getElementById("errorInfo").innerHTML = "";
}

/**以下为内部函数*/

/**工号输入框判断*/
function isWorkerIdInput(workerId, nameInput) {
	if (workerId.length != 0) { // 当[工号]输入框中的有输入的时候
		var trimedWorkerId = workerId.trim(); // trim 处理
		if (trimedWorkerId.length == 0) { // 位数为0的话，直接处理isWorkerIdInput
			isNameInput(nameInput);
		} else if (trimedWorkerId.length < 8) { // 位数不足8位的时候在MSG区域报消息、处理终止
			document.getElementById("errorInfo").innerHTML = "位数不足8位";
		} else if (trimedWorkerId.length == 8) {
			document.getElementById("errorInfo").innerHTML = "";
			myform.action = "Select";
			myform.submit();
		}
	} else { // 当[工号]输入框中的没输入的时候
		isNameInput(nameInput);
	}
}

/**名称输入框判断*/
function isNameInput(nameInput) { // 当[名称]输入框中有输入的时候
	if (nameInput.length != 0) {
		var trimedNameInput = nameInput.trim();// TRIM处理
		if (trimedNameInput.length == 0) { // 位数为0的话，直接处理noInput
			noInput();
		} else {
			document.getElementById("errorInfo").innerHTML = "";
			myform.action = "Select";
			myform.submit();
		}
	} else { // 当名称输入框中也没有输入的时候
		noInput();
	}
}

/**工号和名称都没有输入时*/
function noInput() {
	document.getElementById("errorInfo").innerHTML = "请输入！";
}
