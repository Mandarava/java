/**
 * CST0030页面初始化
 * 
 */

$(function() {
	initCST0030();
})

function initCST0030() {

	$
			.ajax({
				cache : false,
				url : 'CST0030ActiongetCustomerInfo',
				type : 'get',
				async : true,
				data : {
					'customerCode' : $('#txtCstCode').val(),
				},

				success : function(data) {
					// 设置客户编号为只读状态
					document.getElementById("txtCstCode").readOnly = "ture";
					// 取得会社标志
					var companyFlg = data.customerpo.companyFlg;
					// 取得删除标志
					var deleteFlg = data.customerpo.deleteFlg;
					// 根据会社标志选择选中会社
					if (companyFlg == "1") {
						document.getElementById("rdbShagai").checked = "checked";
					}
					// 根据删除标志决定显示或者不显示删除单选框
					if (deleteFlg == "0") {
						document.getElementById("none").style.display = "none";
					} else {
						document.getElementById("delete").checked = "checked"
					}
					// 将客户编号显示在页面相应位置上
					document.getElementById("txtCstCode").value = data.customerpo.customerCode;
					// 将客户名称显示在页面相应位置上
					document.getElementById("txtCstName").value = data.customerpo.customerName;
					// 将客户昵称显示在页面相应位置上
					document.getElementById("txtCstNameSim").value = data.customerpo.customerNameSum;
					// 将客户邮政编号显示在页面相应位置上
					document.getElementById("txtZipCode").value = data.customerpo.zipCode;
					// 将客户地址显示在页面相应位置上
					document.getElementById("txtCstAddress").value = data.customerpo.address;
					// 将客户电话显示在页面相应位置上
					document.getElementById("txtCstPhone").value = data.customerpo.phone;
					// 将客户传真显示在页面相应位置上
					document.getElementById("txtCstFax").value = data.customerpo.fax;
					// 将客户评论显示在页面相应位置上
					document.getElementById("txtComment").value = data.customerpo.comment;

					// 取得部门和课室列表
					var deptInfoList = data.deptInfoList;
					var $ul = $('<ul id="black" class="treeview-black"></ul>');
					// 放置checkboxID
					var cid = 11;
					for (var i = 0, len = deptInfoList.length; i < len; i++) {
						var $li = $('<li>'
								+ '<input type="checkbox" data-value="'
								+ deptInfoList[i].departmentid
								+ '" data-name="'
								+ deptInfoList[i].departmentname + '" id="'
								+ deptInfoList[i].departmentid + '"/>'
								+ '&nbsp;&nbsp;' + '<span>'
								+ deptInfoList[i].departmentname
								+ '</span></li>');
						var $ulin = $('<ul></ul>');
						var cnt = 0;
						for (var j = i; j < len
								&& deptInfoList[i].departmentid == deptInfoList[j].departmentid; j++) {
							if (deptInfoList[j].classname) {
								cnt++;
								var $liin = $(
										'<li><span>'
												+ deptInfoList[j].classname
												+ '</span></li>').appendTo(
										$ulin);
							}
						}
						if (cnt > 0) {
							i += (cnt - 1);
							cid = cid + 1;
						}
						$li.append($ulin).appendTo($ul);
					}

					$('#menu').append($ul);

					$ul.treeview({
						control : "#treecontrol",
						persist : "cookie",
						cookieId : "treeview-black"
					});

					// 复选按钮只能有一个被选中
					$ul.find('input[type="checkbox"]').click(
							function() {

								var value = $(this).attr("data-value");
								departmentName = $(this).attr("data-name");
								departmentId = value;
								// 取消全部选中
								$('input[type="checkbox"]').attr('checked',
										false);
								// 设置当前checkbox选中
								$('input[data-value="' + value + '"]').prop(
										'checked', true);
							});
				}
			});
}

/**
 * CST0030确认编辑按钮
 * 
 * @returns false
 */
$('#btnSave').click(function() {
	var url = "CST0030ActioneditCustomer";
	var data = {

	};
	submitFormAndValidate(url, data, CST0030Callback);
});

/**
 * 回调函数
 * 
 * @returns {Boolean}
 */
function CST0030Callback() {
	$.ajax({
		cache : false,
		url : 'redirectToCST0010',
		type : 'get',
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
	return false;
}

/**
 * CST0030部门编辑按钮
 */

$('#btnInsertDept').click(function() {
	// 取得客户编号
	customerCode = document.getElementById("txtCstCode").value;
	customerName = document.getElementById("txtCstName").value;
	$.ajax({
		cache : false,
		url : 'redirectToCST0040',
		type : 'post',
		async : true,
		data : {
			'customerCode' : customerCode,
			'customerName' : customerName,
		},
		success : function(responseText) {
			$('#rightFrame').html(responseText);
		}
	});
});

// 存储被选中的departmentID
var departmentId = null;
// 存放被选中的departmentNAME
var departmentName = null;

/**
 * CST0030课室编辑按钮
 */
$('#btnInsertTeam').click(function() {
	if (departmentId == null && departmentName == null) {
		alert("请选择部门");
		return;
	}
	// 取得客户编号
	customerCode = document.getElementById("txtCstCode").value;
	var url = 'redirectToCST0050';
	var data = {
		'customerCode' : customerCode,
		'departmentId' : departmentId,
		'departmentName' : departmentName,
	};
	ajaxPageRequest(url, data);
});

/**
 * CST0030取消按钮
 */
$('#btnCancel').on('click', function() {
	ajaxPageRequest('redirectToCST0010');
});

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
