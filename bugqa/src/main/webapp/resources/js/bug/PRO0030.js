
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

//初始化下拉框信息
var loginStage;
var loginCompanyInCode;
var loginCompanOutCode;

//结束日期大于等于 开始日期
fromDateTo('startDate', 'endDate');
// 对应结束日期大于等于结束日期
fromDateTo('endDate', 'chkEndDate');

/**
 * 检索项目信息
 */
$.ajax({
	url : "PRO0030ActionprojectList",
	type : "get",
	data : {
		projectId : $('#projectId').val(),
	},
	async : false,
	success : function(response) {
		$('#projectName').val(response.projectList[0].projectName);
		//下拉框赋值
		
		loginStage = response.projectList[0].stateFlg;
		loginCompanyInCode = response.projectList[0].companyInCode;
		loginCompanOutCode = response.projectList[0].companOutCode;
		
		//刷新下拉框
		$('select').material_select();
		//时间控件赋值
		$('#startDate').val(response.projectList[0].startDate);
		$('#endDate').val(response.projectList[0].endDate);
		$('#chkEndDate').val(response.projectList[0].chkEndDate);
		
		//负责人信息
		chargeIdBefore = response.projectList[0].chargeId;
		chargeNameBefore = response.projectList[0].chargeName
		$('#chargeId').val(chargeNameBefore);
		
		chargeIdReturn = chargeIdBefore;
		chargeNameReturn = chargeNameBefore;
		
		
		
		//检索经理信息
		projectManagerMsg();
		// 初始化状態下拉框 取得汎用信息(プロジェクト状態)
		proStage();
		// 初始化会社名下拉框 取得本会社信息(COMPANYFLG='0')
		customerMsgName();
		// 初始化得意先下拉框 取得得意先信息(COMPANYFLG='1')
		customerMsg();
		//检索项目成员信息
		initTableAreaAttr('PRO0030Table ', initPRO0030);
		initPRO0030();
		//检索模块信息
		getModule();
		
	}
})


/**
 * 追加按钮压下
 */
$('#btnAdd').click(function() {
	//将页面数据放入session
	addToSession();
	//跳转页面
	$.ajax({
		cache : false,
		url : 'redirectToPRO0050',
		data : {
			projectId : $('#projectId').val(),
			managerId : managerIdReturn,
			chargeId : chargeIdReturn
		},
		type : 'get',
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
});


/**
* マネージャー选择ボタンを押下処理
*/
$("#btnSelectManager").click(function() {
	//将页面数据放入session
	addToSession();
	//页面跳转
	$.ajax({
		cache : false,
		url : 'redirectToPRO0041',
		type : 'get',
		data : {
			'projectId' : $('#projectId').val(),
			'managerId' : managerIdReturn,
			'chargeId' : chargeIdReturn,
			'from' : "managerPRO0030"
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
	//将页面数据放入session
	addToSession();
	//页面跳转
	$.ajax({
		cache : false,
		url : 'redirectToPRO0041',
		type : 'get',
		data : {
			'projectId' : $('#projectId').val(),
			'managerId' : managerIdReturn,
			'chargeId' : chargeIdReturn,
			'from' : "chargePRO0030"
		},
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
})


/**
 * 判断返回值为经理或者负责人
 */
if($("#fromBack").val() == "chargePRO0030"){
	
	$('#lblChargeId').addClass("active");
	
	//返回信息
	chargeIdReturn = $('#userId').val(); 
	chargeNameReturn = $('#userName').val();
	$('#chargeId').val(chargeNameReturn); 
	
	//缓存数据取得
	beforeMsgReturn();
	//重新检索项目成员信息
	initTableAreaAttr('PRO0030Table ', initPRO0030);
	initPRO0030();
	//tree信息
	getModule();
	proStage();
	// 初始化会社名下拉框 取得本会社信息(COMPANYFLG='0')
	customerMsgName();
	// 初始化得意先下拉框 取得得意先信息(COMPANYFLG='1')
	customerMsg();
	
}else if($("#fromBack").val() == "managerPRO0030"){
	
	$('#lblManagerId').addClass("active");
	//返回信息
	managerIdReturn = $('#userId').val();
	managerNameReturn = $('#userName').val();
	$('#managerId').val(managerNameReturn);
		
	//缓存数据取得
	beforeMsgReturn();
	//重新检索项目成员信息
	initTableAreaAttr('PRO0030Table ', initPRO0030);
	initPRO0030();
	//tree信息
	getModule();
	proStage();
	// 初始化会社名下拉框 取得本会社信息(COMPANYFLG='0')
	customerMsgName();
	// 初始化得意先下拉框 取得得意先信息(COMPANYFLG='1')
	customerMsg();
	
}


/**
 * 判断成员追加页面传来的返回值
 */
if($('#pro0050AddMember').val == "success"){
	//缓存数据取得
	beforeMsgReturn();
	//重新检索项目成员信息
	initTableAreaAttr('PRO0030Table ', initPRO0030);
	initPRO0030();
	//tree信息
	getModule();
	proStage();
	// 初始化会社名下拉框 取得本会社信息(COMPANYFLG='0')
	customerMsgName();
	// 初始化得意先下拉框 取得得意先信息(COMPANYFLG='1')
	customerMsg();
}

/**
 * 判断取消按钮是否有值
 */
if($("#cancelfrom").val() == "cancel"){
	//缓存数据取得
	beforeMsgReturn();
	//重新检索项目成员信息
	initTableAreaAttr('PRO0030Table ', initPRO0030);
	initPRO0030();
	//tree信息
	getModule();
	proStage();
	// 初始化会社名下拉框 取得本会社信息(COMPANYFLG='0')
	customerMsgName();
	// 初始化得意先下拉框 取得得意先信息(COMPANYFLG='1')
	customerMsg();
}



/**
 * 保存按钮按下
 */
$(function() {
	$("#btnSave").click(function() {
					
		//提交表单
		var url = "PRO0030ActionupdateProjectMsg";
		data = {
				projectId :  $('#projectId').val(),
				chargeIdReturn : chargeIdReturn,	//负责人
				managerIdBefore : managerIdBefore, //原项目经理
				managerIdReturn : managerIdReturn	//现项目经理
		};
		submitFormAndValidate(url, data, callback);
	})
})


/**
 * 返回操作
 * 
 * @param data
 */
function callback(data) {
	managerIdBefore = managerIdReturn;
	managerNameBefore = managerNameReturn;
	$('#errormsg').html("修改完毕");
	return false;

}

/**
 * 取得module信息
 */
function getModule(){
	
	//清空树列表
	 $('#st_tree').empty();
	$.ajax({
		url : "PRO0030ActionmoduleMsg",
		type : "post",
		async : false,
		data : {
			projectId :  $('#projectId').val()
		},
		success : function(data) {	
			
			 var msg = data.moduleMsg;
			 //放置checkboxID
			 var cid = 11;
			 //放置<ul>地址
			 var Id = 111;
			 
			 var $ul = $('<ul id="black" class="treeview-black"></ul>');
			 for(var i=0,len=msg.length; i<len; i++){
				 var $lio = $('<li>'+'<input type="checkbox" data-value="'+ msg[i].groupId +'" data-name="'+ msg[i].groupName +'" id="'+ cid +'"/>'+ '&nbsp;&nbsp;'+msg[i].groupName+'</li>');
				 
				 var cnt = 0;
				 var html = '';
				 for(var j = i; j < len && msg[i].groupId == msg[j].groupId; j++){
					 cnt++;
					 if(msg[j].moduleName!=''&& msg[j].moduleName!= null){
						 html += ('<li>'+msg[j].moduleName+'</li>'); 
					 }
				 }
				 if(cnt > 0){
					 $('<ul name="uname">'+html+'</ul>').appendTo($lio);
					 i += (cnt-1);
					 cid = cid + 1;
				 }
				 $ul.append($lio);
			 }
			 $ul.appendTo( $('#st_tree'));
			 $ul.treeview({/*
				*/});				 
				 
		}
})	
}


//存储被选中的groupID
var groupID;
//存放被选中的group名
var groupNAME;		
/**
 * 复选按钮只能有一个被选中
 */
$('input[type="checkbox"]').click(function(){
	
	var value = $(this).attr("data-value");
	groupNAME = $(this).attr("data-name");
	groupID = value;
	
	//取消全部选中
    $('input[type="checkbox"]').attr('checked',false);
    //设置当前checkbox选中
    $('input[data-value="'+value+'"]').prop('checked',true);

});
		
		
/**
 * 下阶层展开处理
 */
$("#btnOpen").click(function() {
	$("ul").find('[name="uname"]').show();
})


/**
 * 下阶层关闭处理
 */
$("#btnClose").click(function() {
	$("ul").find('[name="uname"]').hide();
})


/**
 * 组编辑ボタンを押下処理
 */
$("#btnGroupEdit").click(function() {
	//将页面数据放入session
	addToSession();
	//页面跳转
	$.ajax({
		cache : false,
		url : 'redirectToGRO0040',
		type : 'post',
		data : {
			projectId : $('#projectId').val(),
			projectName : $('#projectName').val()
		},
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
})

/**
 * 模块编辑ボタンを押下処理
 */
$("#btnModuleEdit").click(function() {
	//将页面数据放入session
	addToSession();
	
	//页面跳转
	$.ajax({
		cache : false,
		url : 'redirectToMOD0040',
		type : 'post',
		data : {
			projectId : $('#projectId').val(),
			groupId : groupID,
			groupName : groupNAME
		},
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
})

/**
 * CSV导入処理
 */
$("#btnCSVImport").click(function() {
	//将页面数据放入session
	addToSession();
	var block = $('<form id="IMP0010form" method="post" enctype="multipart/form-data" >'+ 
						'<input type="text" name="textfield" id="textfield" class="txt" />  '+
						'<input type="button" class="btn" value="参照..." />'+
						'<input type="file" name="fileField" class="file" id="fileField" size="28" onchange="document.getElementById(\'textfield\').value=this.value" />'+
						'<p>'+
						'<button id="btnConfirm" style="color:black; margin-left:15%; margin-top:15%">confirm</button>'+
						'<button id="btnCancel" style="color:black; margin-left:40%;margin-top:15%">cancel</button>'+
						'</p>'+
					'</form>'	);
	$.blockUI({
        message:  block,
        css: {
            width: '500px',
            height: '250px',
            top: '20%',
            left: '30%',
            right: '20%',
            border: 'none',
            padding: '5px',
            backgroundColor: 'white',
            '-webkit-border-radius': '10px',
            '-moz-border-radius': '10px',
            opacity: .9,
            color:'white'
            
        }
    });
	
	//取消按钮
	block.find('#btnCancel').click(function(){
		$.unblockUI();
		return false;
	});
	
	//确认按钮
	block.find('#btnConfirm').click(function(){
		//读取csv文件
		$.ajax({
			url : "PRO0030ActionimportCsv",
			type : "post",
			async : false,
			data : {
				url : $('#fileField').val(),
				projectId : $('#projectId').val()
				
			},
			success : function(data) {
				//检索模块信息
				getModule();
			}
		}); 
		//关闭div
		$.unblockUI();
		return false;
	});
})

/**
 * 将页面数据放入session
 */
function addToSession() {

	$.ajax({
		async : false,
		url : 'PRO0030ActionbeforeMsg',
		type : 'post',
		data : {projectId :  $('#projectId').val(),
				projectName : $('#projectName').val(),
				companyInCode : $('#companyInCode option:selected').val(),
				companOutCode : $('#companOutCode option:selected').val(),
				stateFlg : $('#stateFlg option:selected').val(),
				startDate : $('#startDate').val(),
				endDate : $('#endDate').val(),
				chkEndDate : $('#chkEndDate').val(),
				chargeIdBefore : chargeIdBefore,					//负责人原信息
				chargeNameBefore : chargeNameBefore,
				chargeIdReturn : chargeIdReturn,					//负责人返回信息
				chargeNameReturn : chargeNameReturn,
				managerIdBefore : managerIdBefore,					//经理原信息
				managerNameBefore : managerNameBefore,
				managerIdReturn : managerIdReturn,					//经理返回信息
				managerNameReturn : managerNameReturn
				},
		success : function(responseText) {
			
		}
	});
}

/**
 * 缓存数据取得
 */
function beforeMsgReturn() {
	
	
	//缓存数据取得
	$.ajax({
		url : "PRO0030ActionbeforeMsgReturn",
		type : "post",
		async : false,
		success : function(data) {	
			
			//input
			$('#projectId').val(data.beforeMsgReturn.projectId);
			$('#projectName').val(data.beforeMsgReturn.projectName);
			$('#lblProjectId').addClass("active");
			$('#lblProjectName').addClass("active");
			
			//select
			$("#companyInCode").find('[value="'+data.beforeMsgReturn.companyInCode+'"]').attr("selected","selected");
			$("#companOutCode").find('[value="'+data.beforeMsgReturn.companOutCode+'"]').attr("selected",true);
			$("#stateFlg").find('[value="'+data.beforeMsgReturn.stateFlg+'"]').attr("selected","selected");
			//刷新
			$('select').material_select();
			
			//时间控件
			$('#startDate').val(data.beforeMsgReturn.startDate);
			$('#endDate').val(data.beforeMsgReturn.endDate);
			$('#chkEndDate').val(data.beforeMsgReturn.chkEndDate);
			//激活
			$('#lblStartDate').addClass("active");
			$('#lblEndDate').addClass("active");
			$('#lblChkEndDate').addClass("active");
			
			chargeIdBefore = data.beforeMsgReturn.chargeIdBefore;
			chargeNameBefore = data.beforeMsgReturn.chargeNameBefore;
			managerIdBefore = data.beforeMsgReturn.managerIdBefore;
			managerNameBefore = data.beforeMsgReturn.managerNameBefore;
			
			//责任人赋值
			//从负责人选择页面返回且原先的经理不为空时， 将缓存信息赋值到manager中
			if( $("#fromBack").val() == "chargePRO0030" && data.beforeMsgReturn.managerIdReturn != ""){
				
				managerIdReturn = data.beforeMsgReturn.managerIdReturn;
				managerNameReturn = data.beforeMsgReturn.managerNameReturn;
				
				$('#managerId').val(managerNameReturn); //将name值放入input
				$('#lblManagerId').addClass("active");
			}
			//经理赋值
			//从经理选择页面返回且原先的负责人不为空时， 将缓存信息赋值到负责人input中
			if($("#fromBack").val() == "managerPRO0030" && data.beforeMsgReturn.chargeIdReturn != ""){

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
 * 删除项目成员
 * @param id
 */
function deleteProjectMember(id) {
	

	$.ajax({
		cache : false,
		url : 'PRO0030ActiondeleteProjectMember',
		type : 'get',
		data : {
			userId : id,
			projectId : $('#projectId').val()
		},
		success : function(responseText) {
			//重新检索项目成员信息
			initTableAreaAttr('PRO0030Table ', initPRO0030);
			initPRO0030();
			
		}
		
	});
}

/**
 * 检索项目成员信息
 */
function initPRO0030() {
	
	var url = 'PRO0030ActionprojectMemberList';
	
	var data = {
			"limit" : $('#numPerPageSelect option:selected').html(),
			"currentPage" : $('#PRO0030Table').data('currentPage'),	
			'sortKey' : $('#PRO0030Table').data('sortSql'),
			'projectId' : $('#projectId').val()
		}
	
	ajaxRequest(url, PRO0030Callback, data);
	
}

function PRO0030Callback(response) {
	//清空提示消息
	$('#PRO0030Tbody').empty();
	//清空一览
	$('#PRO0030Tbody').empty();
	
	//判断返回结果是否为空
	if (response == null || response.projectMemberList.length == 0) {
		$('#errormsg').show();
		return false;
	}
	
	var userMsg = response.projectMemberList;
	var totalPage = Math.ceil(response.total / $('#numPerPageSelect option:selected').html());
	var currentPage = response.currentPage;
	
	var $PRO0030Table = $('#PRO0030Table');
	$PRO0030Table.data('currentPage',currentPage);
	$PRO0030Table.data('totalPage', totalPage);
	
	
	$('#PRO0030PageCount').html(response.currentPage + ' of ' + totalPage);
	$('#totalProjectMember').html('(' + response.total + ')');
	$('#PRO000').children().remove();
	
	
	
	
	var table = new Array();
	for ( var key in userMsg) {
			table.push('<tr id="' + userMsg[key].userId + '" data-userName="'+userMsg[key].userName + '">');
			table.push('<td>' + userMsg[key].userId + '</td>');
			table.push('<td>' + userMsg[key].userName + '</td>');
			table.push('<td>' + userMsg[key].name + '</td>');
			table.push('<td>' + '<a id= "delete"' + '" href="javascript:deleteProjectMember(\'' + userMsg[key].userId +'\')">消除</a>' + '</td>');
			table.push('</tr>');
	}
	// 添加table
	$('#PRO0030Tbody').append(table.join(''));
}

/**
 * 检索经理信息
 */
function projectManagerMsg() {
	$.ajax({
		url : "PRO0030ActionprojectManagerMsg",
		type : "get",
		data : {
			projectId : $('#projectId').val(),
		},
		async : false,
		success : function(response) {
			//经理存在时，放入页面
			if(response.projectManagerMsg.length != '0'){
				
				managerIdBefore = response.projectManagerMsg[0].managerId;
				managerNameBefore = response.projectManagerMsg[0].managerName;
				$('#managerId').val(managerNameBefore);
				
				managerIdReturn = managerIdBefore;
				managerNameReturn = managerNameBefore;
				
			}
		}
	})
}

/**
 * 创建空模板
 */
$('#csvTemplate').click(function(){
	$.ajax({
		url : "PRO0030ActionexportCsv",
		type : "post",
		async : false,
		success : function(response) {
		}
	})
})


/**
 * 初始化状態下拉框
 */
function proStage() {
	$.ajax({
		url : "PRO0030ActionproStage",
		type : "get",
		async : false,
		success : function(data) {			
			for ( var key in data.proStage) {
				if(data.proStage[key].code == loginStage){
					$('#stateFlg').append(
							'<option value="' + data.proStage[key].code + '" selected>' + data.proStage[key].name + '</option>');
				}
				if(data.proStage[key].code != loginStage){
					$('#stateFlg').append(
							'<option value="' + data.proStage[key].code + '">' + data.proStage[key].name + '</option>');
				}
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
		url : "PRO0030ActioncustomerMsg",
		type : "get",
		async : false,
		data : {
			companyFlg : 0
		},
		success : function(data) {

			// 插入查询结果
			for ( var key in data.customerMsg) {
				
				if(data.customerMsg[key].customerCode == loginCompanyInCode){
					$('#companyInCode').append(
							'<option value="' + data.customerMsg[key].customerCode + '" data-name="'+data.customerMsg[key].customerName+'" selected>'
									+ data.customerMsg[key].customerName + '</option>');
				}
				if(data.customerMsg[key].customerCode != loginCompanyInCode){
					$('#companyInCode').append(
							'<option value="' + data.customerMsg[key].customerCode + '" data-name="'+data.customerMsg[key].customerName+'">'
									+ data.customerMsg[key].customerName + '</option>');
				}
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
		url : "PRO0030ActioncustomerMsg",
		type : "get",
		async : false,
		data : {
			companyFlg : 1
		},
		success : function(data) {
			
			// 插入查询结果
			for ( var key in data.customerMsg) {
				if(data.customerMsg[key].customerCode == loginCompanOutCode){
					$('#companOutCode').append(
							'<option value="' + data.customerMsg[key].customerCode + '" selected >'
									+ data.customerMsg[key].customerName + '</option>');
				}
				if(data.customerMsg[key].customerCode != loginCompanOutCode ){
					$('#companOutCode').append(
							'<option value="' + data.customerMsg[key].customerCode + '">'
									+ data.customerMsg[key].customerName + '</option>');
				}
			}
			// 插入空行
			$('select').material_select();
		}
	});
}
