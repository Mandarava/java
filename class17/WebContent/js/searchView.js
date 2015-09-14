/**
 * 检索按钮动作
 */
function selectDeptInfo() {
	searchViewform.action = "Select";
	searchViewform.submit();
}

function deleteView() {
	// 初始化，清空按钮内容
	document.getElementById("checkboxIndex").value = "";
	var inputs = document.getElementsByName("check");
	var index = "";
	for ( var i = 0; i < inputs.length; i++) {
		if (inputs[i].getAttribute("type") == "checkbox" && inputs[i].checked) {
			index = index + inputs[i].value + " ";
			document.getElementById("checkboxIndex").value = index;
		}
	}
	searchViewform.action = "deleteView";
	searchViewform.submit();
}

function updateView() {
	searchViewform.action = "updateView";
	searchViewform.submit();
}

function newView() {
	searchViewform.action = "newView";
	searchViewform.submit();
}

function selectAll() {
	// var inputs = document.getElementsByTagName("input");
	var inputs = document.getElementsByName("check");
	if (document.getElementById("checkAll").checked == true) {
		for ( var i = 0; i < inputs.length; i++) {
			if (inputs[i].getAttribute("type") == "checkbox") {
				inputs[i].checked = true;
			}
		}
	} else {
		for ( var i = 0; i < inputs.length; i++) {
			if (inputs[i].getAttribute("type") == "checkbox") {
				inputs[i].checked = false;
			}
		}
	}
}