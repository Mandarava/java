
var userprevlMsg;
var companyFlgMsg;
var customerCodeMsg;
var departmentIdMsg;
var classIdMsg;
var mailAddressMsg;
var deleteFlgMsg;
$(document).ready(function(){
	
	// 用户权限检查
	$.ajax({
		url : "USE0031ActionuserPrevlCheck",
		type : "get",
		async : false,
		success : function(data) {

		}
	});
		
	// 取得当前ユーザー信息
	$.ajax({
		url : "USE0031ActionuserMsg",
		type : "get",
		data :{ userId:$("#userId").val()},
		async : false,
		success : function(data) {
			
			
			//激活label框
			$("#lblUserId").addClass("active");
			$("#lblUserName").addClass("active");
			$("#lblPassword").addClass("active");
			$("#lblMailAddress").addClass("active");
			//页面赋值
			$("#userName").val(data.userMsg[0].userName);
			//$("#password").val(data.userMsg[0].password);
			$("#mailAddress").val(data.userMsg[0].mailAddress);
			
			userprevlMsg = data.userMsg[0].userPrevl;		//权限code
			name = data.userMsg[0].name;					//权限名
			companyFlgMsg = data.userMsg[0].companyFlg;		//会社code
			deleteFlgMsg = data.userMsg[0].deleteFlg;		//消除code
			customerCodeMsg = data.userMsg[0].customerCode;	//得意先code
			customerNameMsg = data.userMsg[0].customerName; //得意先名
			departmentIdMsg = data.userMsg[0].departmentId;	//部门id
			departmentNameMsg = data.userMsg[0].departmentName;//部门名
			classIdMsg = data.userMsg[0].classId;			   //课id
			classNameMsg = data.userMsg[0].className;		   //课名
			
			//判断用户所属会社范围，反映在页面
			if(companyFlgMsg == '0'){
				$("#shanai").attr("checked","checked");
			}else if(companyFlgMsg == 1){
				$("#shagai").attr("checked","checked");
			}
			
			//判断消除状态，返回在页面
			if(deleteFlgMsg == '0'){
				$("#noDel").attr("checked","checked");
			}else if(deleteFlgMsg == '1'){
				$("#hasDel").attr("checked","checked");
			}
			
			}		
		});
	
	// 取得汎用信息(ユーザー権限)
	$.ajax({
		url : "USE0031ActionuserPrevlList",
		type : "get",
		async : false,
		success : function(data) {
			
			
			//将用户原权限设为默认值
			$('#userPrevl').append(
					'<option value="' + userprevlMsg + '" selected >'
							+ name + '</option>');
			//插入数据
			for ( var key in data.userPrevlList) {
				if(data.userPrevlList[key].code != userprevlMsg ){
				$('#userPrevl').append(
						'<option value="' + data.userPrevlList[key].code + '" >'
								+ data.userPrevlList[key].name + '</option>');
				}
			}
			//刷新	
			$('select').material_select();
		}
	});
	
		// 初始化得意先下拉框  取得得意先信息
		$.ajax({
			url : "USE0031ActioncustomerMsg",
			type : "get",
			async : false,
			data : {companyFlg : $('input:radio[name="companyFlg"]:checked').val()},
			success : function(data) {
				
				
				var exit = 0;
				//判断原顾客代码是否在返回结果中
				for ( var key in data.customerMsg) {
					if(data.customerMsg[key].customerCode == customerCodeMsg){
						exit = 1;	//数据存在，
					}
				}
				//如果存在，设为默认值
				if(exit == 1){
					$('#customerCode').append(
							'<option value="' + customerCodeMsg + '" selected >'
									+ customerNameMsg + '</option>');
				}else{ //不存在，则设空 为默认值
					$('#customerCode').append(
							'<option value= ""  selected >' + '</option>');
				}
				//插入其他数据
				for ( var key in data.customerMsg) {
					
					if(data.customerMsg[key].customerCode != customerCodeMsg ){
					$('#customerCode').append(
							'<option value="' + data.customerMsg[key].customerCode + '">'
									+ data.customerMsg[key].customerName + '</option>');
					}
					
				}
				//刷新
				$('select').material_select();
				}
			});
		
		// 初始化部門下拉框  取得当前ユーザー所在的会社的所有部門信息
			$.ajax({
				url : "USE0031ActiondepartmentMsg",
				type : "get",
				async : false,
				data : {customerCode : $('#customerCode option:selected').val()},
				success : function(data) {
					
					
					//将原数据设为默认值
					$('#departmentId').append(
							'<option value="' + departmentIdMsg + '" selected >'
									+ departmentNameMsg + '</option>');
					//插入其他数据
					for ( var key in data.departmentMsg) {
						if(data.departmentMsg[key].departmentId != departmentIdMsg ){
						$('#departmentId').append(
								'<option value="' + data.departmentMsg[key].departmentId + '">'
										+ data.departmentMsg[key].departmentName + '</option>');
						}
					}
					//刷新
					$('select').material_select();
				}
			});
		
			// 初始化课下拉框   取得当前ユーザー所在的部門的所有課信息
				$.ajax({
					url : "USE0031ActionclassMsg",
					type : "get",
					async : false,
					data : {customerCode : $('#customerCode option:selected').val(), departmentId : $('#departmentId option:selected').val()},
					success : function(data) {
						
						
						
						//将原数据设为默认值
						$('#classId').append(
								'<option value="' + classIdMsg + '" selected >'
										+ classNameMsg + '</option>');
						//插入其他数据
						for ( var key in data.classMsg) {
							if(data.classMsg[key].classId != classIdMsg ){
							$('#classId').append(
									'<option value="' + data.classMsg[key].classId + '" >'
											+ data.classMsg[key].className + '</option>');
							}
						}
						//刷新
						$('select').material_select();
					}
				});
				
})
				

/**
 * 会社フラグ变换 取得会社信息
 */
$('input:radio[name="companyFlg"]').click(
		function() {
			
			$("#customerCode").find("option").remove();
			$("#departmentId").find("option").remove();
			$("#classId").find("option").remove();
			$.ajax({
				url : "USE0031ActioncustomerMsg",
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
								'<option value="' + response.customerMsg[key].customerCode + '" >'
										+ response.customerMsg[key].customerName + '</option>');
					}
					//刷新
					$('select').material_select();
				}
			});
		});

/**
 * 得意先变换	 取得当前选中的得意先的所有部门信息
 */
$('#customerCode').change(
		function() {
			$("#departmentId").find("option").remove();
			$("#classId").find("option").remove();
			$.ajax({
				url : "USE0031ActiondepartmentMsg",
				type : "get",
				data : {
					customerCode : $('#customerCode option:selected').val()
				},
				async : false,
				success : function(response) {
					//插入空行
					$('#departmentId').append(
							'<option value=""'
									+ 'selected >' + '</option>');
					//插入数据
					for ( var key in response.departmentMsg) {
						$('#departmentId').append(
								'<option value="' + response.departmentMsg[key].departmentId
										+ '">' + response.departmentMsg[key].departmentName
										+ '</option>');
					}
					//刷新
					$('select').material_select();
				}
			});
		});

/**
 * 部门变换   取得当前部门的所有课信息
 * 
 */
$('#departmentId').change(
		function() {
			$("#classId").find("option").remove();
			$.ajax({
				url : "USE0031ActionclassMsg",
				type : "get",
				data : {
					customerCode : $('#customerCode option:selected').val(),
					departmentId : $('#departmentId option:selected').val()
				},
				async : false,
				success : function(response) {
					//插入空行
					$('#classId').append(
							'<option value="" '
									+ 'selected >' + '</option>');
					//插入数据
					for ( var key in response.classMsg) {
						$('#classId')
								.append(
										'<option value="'
												+ response.classMsg[key].classId + '" >'
												+ response.classMsg[key].className
												+ '</option>');
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
 * 保存按钮压下
 */
$(function(){
	$("#btnSave").click(function(){
		var url = "USE0031ActionupdateUser";
		submitFormAndValidate(url,null,callback);
	})
})


/**
 * 更新成功的操作
 * @param data
 */
function callback(data) {
	$("#errormsg").html("更新成功");
	$.ajax({
		cache : false,
		url : 'redirectToUSE0010',
		type : 'get',
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
}


