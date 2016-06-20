/**
 * QA0020模块初始化
 */
$(document).ready(function() {
	formInit();
});

$("textarea,input[type='text']").characterCounter();

function formInit() {
	// 初始化
	var url = 'QA0020Actioninit';
	var data = {
		'projectId' : $('input[type=hidden][name="projectId"]').val(),
		'qaNo' : $('input[type=hidden][name="qaNo"]').val(),
		'serialNum' : $('input[type=hidden][name="serialNum"]').val()
	};
	ajaxRequest(url, initCallback, data, completeCallback);

	function completeCallback() {
		// 刷新下拉框
		$('select').material_select();
		// 设置input不为空的对应的label为active。
		setInputLabelActive();
	}

	function initCallback(data) {

		// 动态添加质问区分
		var questionDiv = new Array();
		var questionDivList = data.questionDivList;
		for ( var key in questionDivList) {
			if (questionDivList.hasOwnProperty(key)) {
				if (key === '0')
					continue;
				// 每2个换行
				if (key % 2 === 0) {
					questionDiv.push('<div class="row">');
				}
				questionDiv.push('<div class=" col s12 m4 l6">');
				questionDiv.push('<input name="questionDiv" type="radio" class="with-gap" id="rdoKUBUNCheck' + key
						+ '" value=' + questionDivList[key].code + ' />');
				questionDiv.push('<label for="rdoKUBUNCheck' + key + '">' + questionDivList[key].name + '</label>');
				if (key % 2 === 0) {
					questionDiv.push('</div>');
				}
				questionDiv.push('</div>');
			}
		}
		$('#questionDivArea').append(questionDiv.join(''));
		// 式样选中
		//$('#rdoKUBUNCheck3').prop("checked", true);

		// 动态添加stage
		var stage = new Array();
		var stageList = data.stageList;
		for ( var key in stageList) {
			if (stageList.hasOwnProperty(key)) {
				// 第0个为标题
				if (key === '0')
					continue;
				// 每3个换行
				if (key % 4 === 0) {
					stage.push('<div class="row">');
				}
				stage.push('<div class=" col s12 m3 l2">');
				stage.push('<input name="stage" type="radio" class="with-gap" id="rdoSTAGECheck' + key + '" value=' + stageList[key].code + ' />');
				stage.push('<label for="rdoSTAGECheck' + key + '">' + stageList[key].name + '</label>');
				if (key % 4 === 0) {
					stage.push('</div>');
				}
				stage.push('</div>');
			}
		}
		$('#stageArea').append(stage.join(''));
		// 詳細設計选中
		//$('#rdoSTAGECheck3').prop("checked", true);

		// 动态添加原因区分
		var causeDiv = new Array();
		var causeDivList = data.causeDivList;
		for ( var key in causeDivList) {
			if (causeDivList.hasOwnProperty(key)) {
				// 第0个为标题
				if (key === '0')
					continue;
				// 每4个换行
				if (key % 4 === 0) {
					causeDiv.push('<div class="row">');
				}
				causeDiv.push('<div class=" col s12 m3 l2">');
				causeDiv.push('<input name="causeDiv" type="radio" class="with-gap" id="rdoCauseDiv' + key + '" value=' + causeDivList[key].code + ' />');
				causeDiv.push('<label for="rdoCauseDiv' + key + '">' + causeDivList[key].name + '</label>');
				if (key % 4 === 0) {
					causeDiv.push('</div>');
				}
				causeDiv.push('</div>');
			}
		}
		$('#causeDivArea').append(causeDiv.join(''));
		// 仕様不足选中
		$('#rdoCauseDiv4').prop("checked", true);

		// システム名
		$('#txtProjectName').val(data.project.projectName);

		// 発生機能
		var group = new Array();
		var groupList = data.groupList;
		for ( var key in groupList) {
			if (groupList.hasOwnProperty(key)) {
				group.push('<option value= ' + groupList[key].groupId + '>' + groupList[key].groupName + '</option>');
			}
		}
		$('#drpGroupName').append(group.join(''));

		// 発生個所
		var module = new Array();
		var moduleList = data.moduleList;
		for ( var key in moduleList) {
			if (moduleList.hasOwnProperty(key)) {
				module.push('<option value= ' + moduleList[key].moduleId + '>' + moduleList[key].moduleName + '</option>');
			}
		}
		$('#drpModuleName').append(module.join(''));

		// 提出者
		var questioner = new Array();
		var questionerList = data.questionerList;
		for ( var key in questionerList) {
			if (questionerList.hasOwnProperty(key)) {
				questioner.push('<option value = ' + questionerList[key].userId + '>' + questionerList[key].userName + '</option>');
			}
		}
		$('#drpQuestionUser').append(questioner.join(''));

		// 回答者
		var answerer = new Array();
		var answererList = data.answererList;
		for ( var key in answererList) {
			if (answererList.hasOwnProperty(key)) {
				answerer.push('<option value= ' + answererList[key].userId + '>' + answererList[key].userName + '</option>');
			}
		}
		$('#drpAnswerUser').append(answerer.join(''));

		// 将２－８到２－１０取得的数据填充到界面。
		var qaInfo = data.qaInfo;
		// Q&A番号
		$('#txtQANO').val(qaInfo.qaNo);
		// グループ
		$('#drpGroupName option[value=' + qaInfo.groupId + ']').prop("selected", "selected");
		$('#drpModuleName option[value=' + qaInfo.moduleId + ']').prop("selected", "selected");
		// 提出日
		initDatePicker('txtQuestionDate', qaInfo.questionDate);
		// 标题
		$('#txtTitle').val(qaInfo.qaTitle);
		// 质问内容
		var $txtQuestion = $('#txtQuestion');
		$txtQuestion.val(qaInfo.questionInfo);
		$txtQuestion.trigger('keyup');
		// $('#txtQuestion').click(function() {
		// $(this).keyup();
		// });
		$('#drpQuestionUser option[value=' + qaInfo.questioner + ']').prop("selected", "selected");
		$('#drpAnswerUser option[value=' + qaInfo.answerer + ']').prop("selected", "selected");
		// 希望回答日
		initDatePicker('txtExpDate', qaInfo.expDate);
		// 提出日早于回答日
		fromDateTo('txtQuestionDate', 'txtExpDate');
		$('#txtRelationQAID').val(qaInfo.relationQaNo);
		// 质问添附资料
		var $QUploadFile = $('#txtQUploadFile');
		$QUploadFile.val(qaInfo.qattachedInfo);
		if (qaInfo.qattachedInfo) {
			$QUploadFile.css("color", "#039be5").css("cursor", "pointer");
			$QUploadFile.bind('click', function(e) {
				var url = "QA0020ActiondownloadExcel?qattachedInfo=" + qaInfo.qattachedInfo;
				exportExcel(url);
			}).bind('change', function(e) {
				$(this).removeAttr("style");
				$(this).unbind();
			});
		}
		
		// 回答内容
		var $txtAnswer = $('#txtAnswer');
		$txtAnswer.val(qaInfo.answerInfo);
		$txtAnswer.trigger('keyup');
		// 回答者
		$('#txtAnswerUser').val($('#drpAnswerUser option[value=' + qaInfo.answerer + ']').html());
		// 设置回答日
		initDatePicker('txtAnswerDate', qaInfo.answerDate);
		// 回答添附资料
		var $AUploadFile = $('#txtAUploadFile');
		$AUploadFile.val(qaInfo.aattachedInfo);
		if (qaInfo.aattachedInfo) {
			$AUploadFile.css("color", "#039be5").css("cursor", "pointer");
			$AUploadFile.bind('click', function(e) {
				var url = "QA0020ActiondownloadExcel?aattachedInfo=" + qaInfo.aattachedInfo;
				exportExcel(url);
			}).bind('change', function(e) {
				$(this).removeAttr("style");
				$(this).unbind();
			});
		}
		$('#txtComment').val(qaInfo.remark);
		$('input[type=hidden][name="updateTime"]').val(qaInfo.updateTime);
		$('#stageArea input[value="' + qaInfo.stage + '"]').attr("checked", "checked");
		$('#questionDivArea input[value="' + qaInfo.questionDiv + '"]').attr("checked", "checked");
		$('#causeDivArea input[value="' + qaInfo.causeDiv + '"]').attr("checked", "checked");

		// 界面初始化
		// 起動引数的履历连番存在的场合
		if ($('input[type=hidden][name="serialNum"]').val()) {
			// 画面入力项全部不可入力
			setInputFieldDisabled(true);
			// 按钮部只显示「戻る」，其他按钮不显示，处理终了する。
			$('#btnBack').parent('div').show();

			// 起動引数的履历连番不存在的场合
		} else {
			// 提出方状態
			var QAQState = qaInfo.qaQState;
			// 回答方状態
			var QAAState = qaInfo.qaAState;
			// 获得用户成员权限信息
			var member = null;
			$.ajax({
				cache : false,
				url : 'QA0020ActiongetMemberWorkType',
				type : 'get',
				data : {
					'projectId' : $('input[type=hidden][name="projectId"]').val()
				},
				async : false, // false!!
				dataType : 'json',
				success : memberCallback,
			});
			function memberCallback(data) {
				member = data.memberInfo;
			}

			// 提出方状態为未対応の場合、回答方状態为空、移管、他部署対応の場合。
			if (QAQState == '1' && (QAAState == '' || QAAState == '4' || QAAState == '5')) {
				// 登陆用户为项目经理或者项目组长。
				if (member.workType == '1' || member.workType == '3') {
					// システム名、番号、関係Q&A、回答者不可入力，其他入力项可入力。
					setInputFieldDisabled(false);
					$('#txtProjectName').attr("disabled", true);
					$('#txtQANO').attr("disabled", true);
					$('#txtRelationQAID').attr("disabled", true);
					$('#txtAnswerUser').attr("disabled", true);
					// 保存、受付、移管、他部署対応、削除、履歴一覧按钮可使用、其它按钮不可见。
					$('#btnSubmit').parent('div').show();
					$('#btnRecieve').parent('div').show();
					$('#btnMove').parent('div').show();
					$('#btnOther').parent('div').show();
					$('#btnDel').parent('div').show();
					$('#btnLook').parent('div').show();
					// 登陆用户为预定回答者
				} else if (member.userId == $('#drpAnswerUser option:selected').val()) {
					// 予定回答者可入力，其他入力项不可入力。
					setInputFieldDisabled(true);
					$('#drpAnswerUser').attr("disabled", false);
					// 受付、移管、他部署対応、履歴一覧按钮可使用、其它按钮不可见。
					$('#btnRecieve').parent('div').show();
					$('#btnMove').parent('div').show();
					$('#btnOther').parent('div').show();
					$('#btnLook').parent('div').show();
					// 选定其他予定回答者时、受付按钮不可使用
					if ($('#drpAnswerUser option:selected').val() != member.userId) {
						$('#btnRecieve').attr("disabled", true);
					}
					// 登陆用户为项目其他成员。
				} else {
					// 所有入力项不可入力。
					setInputFieldDisabled(true);
					// 履歴一覧按钮可使用、其它按钮不可见。
					$('#btnLook').parent('div').show();
					// 处理终了する。
					return false;
				}
				// 提出方状態为未対応の場合、回答方状態为質問受付、検討中の場合。
			} else if (QAQState == '1' && (QAAState == '1' || QAAState == '2')) {
				// 登陆用户为项目经理或者项目组长。
				if (member.workType == '1' || member.workType == '3') {
					// システム名、番号、関係Q&A、回答者不可入力，其他入力项可入力。
					setInputFieldDisabled(false);
					$('#txtProjectName').attr("disabled", true);
					$('#txtQANO').attr("disabled", true);
					$('#txtRelationQAID').attr("disabled", true);
					$('#txtAnswerUser').attr("disabled", true);
					// 保存、回答完了、検討中（質問受付場合）、削除、履歴一覧按钮可使用、其它按钮不可见。
					$('#btnSubmit').parent('div').show();
					$('#btnAnswer').parent('div').show();
					// 質問受付場合
					if (QAAState == '1') {
						$('#btnReserve').parent('div').show();
					}
					$('#btnDel').parent('div').show();
					$('#btnLook').parent('div').show();
					// 回答日默认设置为当前日期、处理终了する。
					initDatePicker('txtAnswerDate', new Date());
					// 回答日默认为当前时间
					return false;

					// 登陆用户为预定回答者。
				} else if (member.userId == $('#drpAnswerUser option:selected').val()) {
					// 回答内容、回答日、回答添付資料、備考可入力、其他入力项不可入力。
					setInputFieldDisabled(true);
					$('#txtAnswer').attr('disabled', false);
					$('#txtAnswerDate').attr('disabled', false);
					$('#txtAUploadFile').attr('disabled', false);
					$('#txtComment').attr('disabled', false);
					// 保存、回答完了、検討中（質問受付場合）、履歴一覧按钮可使用、其它按钮不可见。
					$('#btnSubmit').parent('div').show();
					$('#btnAnswer').parent('div').show();
					// 質問受付場合
					if (QAAState == '1') {
						$('#btnReserve').parent('div').show();
					}
					$('#btnLook').parent('div').show();
					// 回答日默认为当前时间
					initDatePicker('txtAnswerDate', new Date());
					return false;
					// 登陆用户为项目其他成员。
				} else {
					// 所有入力项不可入力。
					setInputFieldDisabled(true);
					// 履歴一覧按钮可使用、其它按钮不可见。
					$('#btnLook').parent('div').show();
					return false;
				}
				// 提出方状態为未対応の場合、回答方状態为回答済みの場合。
			} else if (QAQState == '1' && QAAState == '3') {
				// 登陆用户为项目经理或者项目组长。
				if (member.workType == '1' || member.workType == '3') {
					// システム名、番号、関係Q&A、回答者不可入力，其他入力项可入力。
					setInputFieldDisabled(false);
					$('#txtProjectName').attr("disabled", true);
					$('#txtQANO').attr("disabled", true);
					$('#txtRelationQAID').attr("disabled", true);
					$('#txtAnswerUser').attr("disabled", true);
					// 保存、承认完了、削除、履歴一覧、再QA按钮可使用、其它按钮不可见。
					$('#btnSubmit').parent('div').show();
					$('#btnAccept').parent('div').show();
					$('#btnDel').parent('div').show();
					$('#btnLook').parent('div').show();
					$('#btnNotAccept').parent('div').show();
					// 处理终了する。
					return false;

					// 登陆用户为提出者。
				} else if (member.userId == $('#drpQuestionUser option:selected').val()) {
					// 原因区分可入力，其他入力项不可入力。
					setInputFieldDisabled(true);
					$('#causeDivArea').find('input[type="radio"]').each(function() {
						$(this).attr("disabled", false);
					});
					// 保存、承认完了、履歴一覧、再QA按钮可使用、其它按钮不可见。
					$('#btnSubmit').parent('div').show();
					$('#btnAccept').parent('div').show();
					$('#btnLook').parent('div').show();
					$('#btnNotAccept').parent('div').show();
					// 处理终了する。
					return false;

					// 登陆用户为项目其他成员。
				} else {
					// 所有入力项不可入力。
					setInputFieldDisabled(true);
					// 履歴一覧按钮可使用、其它按钮不可见。
					$('#btnLook').parent('div').show();
					// 处理终了する。
					return false;
				}

				// 提出方状態为対応済み、検討中の場合、回答方状態为回答済みの場合。
				// TODO 対応済み到底是啥？ 2？？ 3？？
			} else if ((QAQState == '2' || QAQState == '3' || QAQState == '4') && QAAState == '3') {
				// 登陆用户为项目经理或者项目组长。
				if (member.workType == '1' || member.workType == '3') {
					// システム名、番号、関係Q&A、回答者不可入力，其他入力项可入力。
					setInputFieldDisabled(false);
					$('#txtProjectName').attr("disabled", true);
					$('#txtQANO').attr("disabled", true);
					$('#txtRelationQAID').attr("disabled", true);
					$('#txtAnswerUser').attr("disabled", true);
					// 保存、削除、履歴一覧按钮可使用、其它按钮不可见。
					$('#btnSubmit').parent('div').show();
					$('#btnDel').parent('div').show();
					$('#btnLook').parent('div').show();
					// 处理终了する
					return false;

					// 登陆用户为项目其他成员。
				} else {
					// 所有入力项不可入力。
					setInputFieldDisabled(true);
					// 履歴一覧按钮可使用、其它按钮不可见。
					$('#btnLook').parent('div').show();
					// 处理终了する。
					return false;
				}

				// 提出方状態为削除の場合
			} else if (QAQState == '5') {
				// 登陆用户为项目经理或者项目组长。
				if (member.workType == '1' || member.workType == '3') {
					// システム名、番号、関係Q&A、回答者不可入力，其他入力项可入力。
					setInputFieldDisabled(false);
					$('#txtProjectName').attr("disabled", true);
					$('#txtQANO').attr("disabled", true);
					$('#txtRelationQAID').attr("disabled", true);
					$('#txtAnswerUser').attr("disabled", true);
					// 保存、履歴一覧按钮可使用、其它按钮不可见。
					$('#btnSubmit').parent('div').show();
					$('#btnLook').parent('div').show();
					// 处理终了する。
					return false;

					// 登陆用户为项目其他成员。
				} else {
					// 所有入力项不可入力。
					setInputFieldDisabled(true);
					// 履歴一覧按钮可使用、其它按钮不可见。
					$('#btnLook').parent('div').show();
					// 处理终了する。
					return false;
				}
			}
		}
	}
}

/**
 * 発生機能选择処理,発生個所情報の取得。
 */
$('#drpGroupName').change(
		function() {
			// 発生個所のドロップダウンリストの默认值设为空白。
			var $drpModuleName = $('#drpModuleName'); 
			$drpModuleName.children().remove();
			$drpModuleName.append('<option value=" " disabled></option>');

			var url = 'QA0020ActiongetModuleList';
			var data = {
				'projectId' : $('input[type=hidden][name="projectId"]').val(),
				'groupId' : $('#drpGroupName option:selected').val()
			};
			ajaxRequest(url, groupChangeCallback, data);

			function groupChangeCallback(data) {
				// 発生個所
				var module = new Array();
				var moduleList = data.moduleList;
				for ( var key in moduleList) {
					if (moduleList.hasOwnProperty(key)) {
						module.push('<option value= ' + moduleList[key].moduleId + '>' + moduleList[key].moduleName + '</option>');
					}
				}
				$drpModuleName.append(module.join(''));
				
				$('select').material_select();
			}
		});

// 削除処理
$('#btnDel').click(function() {
	if (confirm("削除を確定しますか？")) {
		var url = 'QA0020ActiondeleteQA';
		var data = {
			'projectId' : $('input[type=hidden][name="projectId"]').val(),
			'qaNo' : $('input[type=hidden][name="qaNo"]').val(),
			'remark' : $('#txtComment').html(),
			'updateTime' : $('input[type=hidden][name="updateTime"]').val()
		};
		ajaxRequest(url, callback, data);
	} else {
		return false;
	}
});

// 保留処理
$('#btnReserve').click(function() {
	var url = 'QA0020ActionreserveQA';
	var data = {
		'projectId' : $('input[type=hidden][name="projectId"]').val(),
		'qaNo' : $('input[type=hidden][name="qaNo"]').val(),
		'remark' : $('#txtComment').val(),
		'updateTime' : $('input[type=hidden][name="updateTime"]').val()
	};
	ajaxRequest(url, callback, data);
});

// 保留取消処理
$('#btnResCancel').click(function() {
	var url = 'QA0020ActioncancelReserveQA';
	var data = {
		'projectId' : $('input[type=hidden][name="projectId"]').val(),
		'qaNo' : $('input[type=hidden][name="qaNo"]').val(),
		'updateTime' : $('input[type=hidden][name="updateTime"]').val()
	};
	ajaxRequest(url, callback, data);
});

// 承认完了処理
$('#btnAccept').click(function() {
	var url = 'QA0020ActionadmitQA';
	var data = {
		'projectId' : $('input[type=hidden][name="projectId"]').val(),
		'qaNo' : $('input[type=hidden][name="qaNo"]').val(),
		'updateTime' : $('input[type=hidden][name="updateTime"]').val(),
		'causeDiv' : $('input[type=radio][name=causeDiv]:checked').val(),
		'relationQaNo' : $('#txtRelationQAID').val()
	};
	ajaxRequest(url, callback, data);
});

// 受付処理
$('#btnRecieve').click(function() {
	var url = 'QA0020ActionreceiveQA';
	var data = {
		'projectId' : $('input[type=hidden][name="projectId"]').val(),
		'qaNo' : $('input[type=hidden][name="qaNo"]').val(),
		'updateTime' : $('input[type=hidden][name="updateTime"]').val(),
	};
	ajaxRequest(url, callback, data);
});

// 移管処理
$('#btnMove').click(function() {
	var url = 'QA0020ActionmoveQA';
	var data = {
		'projectId' : $('input[type=hidden][name="projectId"]').val(),
		'qaNo' : $('input[type=hidden][name="qaNo"]').val(),
		'updateTime' : $('input[type=hidden][name="updateTime"]').val(),
		'answerer' : $('#drpAnswerUser option:selected').val()
	};
	ajaxRequest(url, callback, data);
});

// 他部署对应処理
$('#btnOther').click(function() {
	var url = 'QA0020ActionotherQA';
	var data = {
		'projectId' : $('input[type=hidden][name="projectId"]').val(),
		'qaNo' : $('input[type=hidden][name="qaNo"]').val(),
		'updateTime' : $('input[type=hidden][name="updateTime"]').val(),
	}
	ajaxRequest(url, callback, data);
});

// 点击QA履历情报时处理
$('#btnLook').click(function() {
	var url = 'redirectToQA0030';
	var data = {
		'qaNo' : $('input[type=hidden][name="qaNo"]').val(),
		'projectId' : $('input[type=hidden][name="projectId"]').val(),
	};
	ajaxPageRequest(url, data);
});

// 查看QA履历情报时、点击戻る按钮时处理。
$('#btnBack').click(function() {
	var url = 'redirectToQA0030';
	var data = {
		'qaNo' : $('input[type=hidden][name="qaNo"]').val(),
		'projectId' : $('input[type=hidden][name="projectId"]').val(),
	};
	ajaxPageRequest(url, data);

});

// 查看QA履历情报时、点击再QA処理按钮时处理。
$('#btnNotAccept').click(function() {
	var url = 'redirectToQA0010';
	var data = {
		'qaNo' : $('input[type=hidden][name="qaNo"]').val(),
		'projectId' : $('input[type=hidden][name="projectId"]').val(),
	};
	ajaxPageRequest(url, data);
});

// 回答完了処理
$('#btnAnswer').click(function() {
	var url = "QA0020ActionanswerQA";
	var data = {
		'updateTime' : $('input[type=hidden][name="updateTime"]').val(),
	};
	submitFormAndValidate(url, data, callback);
});

// 保存
$('#btnSubmit').click(function() {
	//保存情况下以下两项非必须
	$('#txtAnswerDate').removeAttr("required");
	$('#txtAnswer').removeAttr("required");
	var url = "QA0020ActionsaveQA";
	var data = {
		'relationQaNo' : $('#txtRelationQAID').val(),
	};
	submitFormAndValidate(url, data, callback);
});

function callback(data) {
	if (data.status != 0) {
		$('#errormsg').show().html(data.message);
		Materialize.toast('操作失败!', 4000);
		return false;
	} else {
		$('#errormsg').hide();
		var url = "redirectToQA0020";
		var data = {
			'qaNo' : $('input[type=hidden][name="qaNo"]').val(),
			'projectId' : $('input[type=hidden][name="projectId"]').val(),
		}
		ajaxPageRequest(url, data);
	}
}
