
//原负责人信息
var chargeIdBefore;
var chargeNameBefore;

//从PRO0040返回的负责人信息
var chargeIdReturn;
var chargeNameReturn;

//原经理信息
var managerIdBefore;
var managerNameBefore;

//从PRO0040返回的经理信息
var managerIdReturn;
var managerNameReturn;

/**
 * 画面初始化
 */
$(document).ready(function() {
	// 初始化状態下拉框 取得汎用信息(プロジェクト状態)
	proStage();
	// 初始化会社名下拉框 取得本会社信息(COMPANYFLG='0')
	customerMsgName();
	// 初始化得意先下拉框 取得得意先信息(COMPANYFLG='1')
	customerMsg();
})


/**
 * 焦点设置
 */
document.getElementById("projectId").focus();

// 结束日期大于等于 开始日期
fromDateTo('startDate', 'endDate');
// 对应结束日期大于等于结束日期
fromDateTo('endDate', 'chkEndDate');

/**
 * マネージャー选择ボタンを押下処理
 */
$("#btnSelectManager").click(function() {
	$.ajax({
		cache : false,
		url : 'redirectToPRO0041',
		type : 'get',
		data : {
			'projectId' : $('#projectId').val(),
			'managerId' : managerIdReturn,
			'chargeId' : chargeIdReturn,
			'from' : "managerPRO0020"
		},
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
})

/**
 * 责任者选择ボタンを押下処理
 */
$("#btnSelectCharge").click(function() {
	$.ajax({
		cache : false,
		url : 'redirectToPRO0041',
		type : 'get',
		data : {
			'projectId' : $('#projectId').val(),
			'managerId' : managerIdReturn,
			'chargeId' : chargeIdReturn,
			'from' : "chargePRO0020"
		},
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
})

/**
 * 取消按钮按下
 */
$("#btnCancel").click(function() {
	
	$.ajax({
		cache : false,
		url : 'redirectToPRO0010',
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
		//判断负责人选择返回值
		$("#chargeId").val(chargeIdReturn);
		//判断经理选择返回值
		$("#managerId").val(managerIdReturn);
		
		var url = "PRO0020ActionaddProjectMsg";
			/*data = {
				companyName : $('#companyInCode option:selected').attr("data-name"),
			};*/
		submitFormAndValidate(url, null, callback);

	});
});


/**
 * 返回操作
 * 
 * @param data
 */
function callback(data) {
	if(data.exitFlg == "notExit"){
		$("#errormsg").html(COM0001);
		$("#projectId").focus();
		$("#projectId").click(function() {
			$("#errormsg").empty();
		})
		// 各项恢复到初值
		document.getElementById("PRO0020form").reset();
		// 初始化状態下拉框 取得汎用信息(プロジェクト状態)
		proStage();
		// 初始化会社名下拉框 取得本会社信息(COMPANYFLG='0')
		customerMsgName();
		// 初始化得意先下拉框 取得得意先信息(COMPANYFLG='1')
		customerMsg();
	}
	if(data.exitFlg == "exit"){
		$('#errormsg').html("id已經存在");
	}
	return false;

}

/**
 * 将页面数据放入session
 */
$('[name="select"]').click(function() {
	$.ajax({
		async : false,
		url : 'PRO0020ActionbeforeMsg',
		type : 'post',
		data : {
			projectId : $('#projectId').val(),
			projectName : $('#projectName').val(),
			companyInCode : $('#companyInCode option:selected').val(),
			companOutCode : $('#companOutCode option:selected').val(),
			stateFlg : $('#stateFlg option:selected').val(),
			startDate : $('#startDate').val(),
			endDate : $('#endDate').val(),
			chkEndDate : $('#chkEndDate').val(),
			chargeIdReturn : chargeIdReturn,
			chargeNameReturn : chargeNameReturn,
			managerIdReturn : managerIdReturn,
			managerNameReturn : managerNameReturn	
		},
		success : function(responseText) {
		}
	});
})

/**
 * 判断取消按钮是否有值
 */
if($("#cancelfrom").val() == "cancel"){
	//缓存数据取得
	beforeMsgReturn();
}

/**
 * 判断返回值为经理或者负责人
 */
if ($("#fromBack").val() == "chargePRO0020") {
	
	$('#lblChargeId').addClass("active");

	
	//取得负责人选择页面返回的信息
	chargeIdReturn = $('#id').val();
	chargeNameReturn = $('#name').val();
	
	//将负责人返回页面的name值放入负责人input中
	$('#chargeId').val(chargeNameReturn);
	
	//缓存数据取得
	beforeMsgReturn();

} else if ($("#fromBack").val() == "managerPRO0020") {
	
	$('#lblManagerId').addClass("active");
	
	//取得经理选择页面返回的信息
	managerIdReturn = $('#id').val();
	managerNameReturn = $('#name').val();
	
	//将经理返回页面的name值放入负责人input中
	$('#managerId').val(managerNameReturn);
	//缓存数据取得
	beforeMsgReturn();

}


/**
 * 缓存数据取得
 */
function beforeMsgReturn() {

	// 缓存数据取得
	$.ajax({
		url : "PRO0020ActionbeforeMsgReturn",
		type : "post",
		async : false,
		success : function(data) {
			
			// input
			$('#projectId').val(data.beforeMsgReturn.projectId);
			$('#projectName').val(data.beforeMsgReturn.projectName);
			$('#lblProjectId').addClass("active");
			$('#lblProjectName').addClass("active");
			// select
			$("#companyInCode").find('[value="' + data.beforeMsgReturn.companyInCode + '"]').attr("selected",
					"selected");
			$("#companOutCode").find('[value="' + data.beforeMsgReturn.companOutCode + '"]').attr("selected", true);
			$("#stateFlg").find('[value="' + data.beforeMsgReturn.stateFlg + '"]').attr("selected", "selected");
			$('select').material_select();
			// 时间控件
			$('#startDate').val(data.beforeMsgReturn.startDate);
			$('#endDate').val(data.beforeMsgReturn.endDate);
			$('#chkEndDate').val(data.beforeMsgReturn.chkEndDate);
			$('#lblStartDate').addClass("active");
			$('#lblEndDate').addClass("active");
			$('#lblChkEndDate').addClass("active");
			// 责任人赋值
			//从负责人选择页面返回且原先的经理不为空时， 将缓存信息赋值到manager中
			if ($("#fromBack").val() == "chargePRO0020" && data.beforeMsgReturn.managerIdReturn != "") {
				
				managerIdReturn = data.beforeMsgReturn.managerIdReturn;
				managerNameReturn = data.beforeMsgReturn.managerNameReturn;
				$('#managerId').val(managerNameReturn);
				$('#lblManagerId').addClass("active");
			}
			// 经理赋值
			//从经理选择页面返回且原先的负责人不为空时， 将缓存信息赋值到负责人input中
			if ($("#fromBack").val() == "managerPRO0020" && data.beforeMsgReturn.chargeIdReturn != "") {

				chargeIdReturn = data.beforeMsgReturn.chargeIdReturn;
				chargeNameReturn = data.beforeMsgReturn.chargeNameReturn;
				$('#chargeId').val(chargeNameReturn);
				$('#lblChargeId').addClass("active");
			}
			//从选择页面返回时，将缓存数据赋值到页面
			if($('#cancelfrom').val() == "cancel"){
				
				chargeIdReturn = data.beforeMsgReturn.chargeIdReturn;
				chargeNameReturn = data.beforeMsgReturn.chargeNameReturn;
				managerIdReturn = data.beforeMsgReturn.managerIdReturn;
				managerNameReturn = data.beforeMsgReturn.managerNameReturn;
				
				$('#managerId').val(managerNameReturn);
				$('#chargeId').val(chargeNameReturn);
				$('#lblManagerId').addClass("active");
				$('#lblChargeId').addClass("active");
			}

		}
	});

}

/**
 * 初始化状態下拉框
 */
function proStage() {
	$.ajax({
		url : "PRO0020ActionproStage",
		type : "get",
		async : false,
		success : function(data) {
			// 插入空行
			$('#stateFlg').append('<option value="" selected > </option>');
			// 插入查询结果
			for ( var key in data.proStage) {
				$('#stateFlg').append(
						'<option value="' + data.proStage[key].code + '">' + data.proStage[key].name + '</option>');
			}
			// 刷新
			$('select').material_select();
		}
	});
}

/**
 * 初始化会社名下拉框
 */
function customerMsgName() {
	$.ajax({
		url : "PRO0020ActioncustomerMsg",
		type : "get",
		async : false,
		data : {
			companyFlg : 0
		},
		success : function(data) {
			// 插入空行
			$('#companyInCode').append('<option value="" selected > </option>');
			// 插入查询结果
			for ( var key in data.customerMsg) {
				$('#companyInCode').append(
						'<option value="' + data.customerMsg[key].customerCode + '" data-name="'+data.customerMsg[key].customerName+'">'
								+ data.customerMsg[key].customerName + '</option>');
			}
			// 刷新
			$('select').material_select();
		}
	});
}

/**
 * 初始化得意先下拉框
 */
function customerMsg() {
	$.ajax({
		url : "PRO0020ActioncustomerMsg",
		type : "get",
		async : false,
		data : {
			companyFlg : 1
		},
		success : function(data) {
			// 插入空行
			$('#companOutCode').append('<option value="" selected > </option>');
			// 插入查询结果
			for ( var key in data.customerMsg) {
				$('#companOutCode').append(
						'<option value="' + data.customerMsg[key].customerCode + '">'
								+ data.customerMsg[key].customerName + '</option>');
			}
			// 插入空行
			$('select').material_select();
		}
	});
}
