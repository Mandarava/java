//登录用户ID
var userId = getUser().userId;

/**
 * QA0010模块初始化
 */
$(document).ready(function() {
	init();
});

$("textarea,input[type='text']").characterCounter();

// 初始化
function init() {

	// 下拉列表初始化
	var url = 'QA0010Actioninit';
	var data = {
		// 再QA启动引数
		'projectId' : $('input[type=hidden][name=argprojectId]').val()
	};

	ajaxRequest(url, initCallback, data);

	function initCallback(data) {

		// var fragment = document.createDocumentFragment();

		// 动态添加原因区分
		var questionDiv = new Array();
		// 质问区分结果
		var questionDivList = data.questionDivList;
		for ( var key in questionDivList) {
			if (questionDivList.hasOwnProperty(key)) {
				// 第0个为title
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
		$('#rdoKUBUNCheck3').prop("checked", true);

		// 动态添加stage
		var stage = new Array();
		var stageList = data.stageList;
		for ( var key in stageList) {
			if (stageList.hasOwnProperty(key)) {
				if (key === '0')
					continue;
				// 每3个换行
				if (key % 4 === 0) {
					stage.push('<div class="row">');
				}
				stage.push('<div class=" col s12 m3 l3">');
				stage.push('<input name="stage" type="radio" class="with-gap" id="rdoSTAGECheck' + key + '" value='
						+ stageList[key].code + ' />');
				stage.push('<label for="rdoSTAGECheck' + key + '">' + stageList[key].name + '</label>');
				if (key % 4 === 0) {
					stage.push('</div>');
				}
				stage.push('</div>');
			}
		}
		$('#stageArea').append(stage.join(''));
		// 詳細設計选中
		$('#rdoSTAGECheck3').prop("checked", true);

		// 系统名称
		var project = new Array();
		var projectList = data.projectList;
		for ( var key in projectList) {
			if (projectList.hasOwnProperty(key)) {
				project.push('<option value= ' + projectList[key].projectId + '>' + projectList[key].projectName + '</option>');
			}
		}
		$('#drpProjectName').append(project.join(''));

		// group下拉列表初始化
		var group = new Array();
		var groupList = data.groupList;
		for ( var key in groupList) {
			if (groupList.hasOwnProperty(key)) {
				group.push('<option value= ' + groupList[key].groupId + '>' + groupList[key].groupName + '</option>');
			}
		}
		$('#drpGroupName').append(group.join(''));

		// 提出者情報下拉列表初始化
		var detector = new Array();
		var detectorList = data.detectorList;
		for ( var key in detectorList) {
			if (detectorList.hasOwnProperty(key)) {
				// 默认选中登录用户
				if (detectorList[key].userId == userId) {
					detector.push('<option selected value= ' + detectorList[key].userId + '>' + detectorList[key].userName + '</option>');
				} else {
					detector.push('<option value= ' + detectorList[key].userId + '>' + detectorList[key].userName + '</option>');
				}
			}
		}
		$('#drpDetector').append(detector.join(''));

		// 回答者情报下拉列表初始化
		var answerer = new Array();
		var answererList = data.answererList;
		for ( var key in answererList) {
			if (answererList.hasOwnProperty(key)) {
				answerer.push('<option value= ' + answererList[key].userId + '>' + answererList[key].userName + '</option>');
			}
		}
		$('#drpAnswer').append(answerer.join(''));

		// 提出日日期控件
		var from_$input = $('#txtOccurdate').pickadate();
		var from_picker = from_$input.pickadate('picker');
		from_picker.set('min', new Date());
		// 提出日默认为当前时间
		from_picker.set('select', new Date());
		$("#txtOccurdate~label").addClass("active");
		// 希望日大于提出日
		fromDateTo('txtOccurdate', 'txtExpDate');

		// 起動引数存在时
		var argprojectId = $('input[type=hidden][name="argprojectId"]').val();
		var qaNo = $('input[type=hidden][name="qaNo"]').val();
		if (isElementBlank(argprojectId) || isElementBlank(qaNo)) {
			// do nothing
		} else {
			// 引数的Q&A番号,显示在関連Q&A番号文本框内
			$('#txtRelationQAID').attr("value", qaNo);
			$("#lblRelationQAID").addClass("active");
			// システム名选择传入的プロジェクトＩＤ、システム名のドロップダウンリスト不可编辑。
			$('#drpProjectName').prop({
				'disabled' : true
			});
			$('#drpProjectName option[value=' + argprojectId + ']').prop("selected", "selected");
		}
		$('select').material_select();
	}
}

/**
 * 项目ID变化事件
 */
$('#drpProjectName').change(
		function() {
			// 清空原先的
			var $drpGroupName = $('#drpGroupName');
			$drpGroupName.children().remove();
			$drpGroupName.append('<option value=" " disabled selected></option>');
			// module名
			var $drpModuleName = $('#drpModuleName');
			$drpModuleName.children().remove();
			$drpModuleName.append('<option value=" " disabled selected></option>');
			$('#drpDetector').children().remove();
			// 回答者
			var $drpAnswer = $('#drpAnswer');
			$drpAnswer.children().remove();
			$drpAnswer.append('<option value=" " disabled selected></option>');

			var url = 'QA0010ActionprojectChange';
			var data = {
				'projectId' : $("#drpProjectName option:selected").val()
			};

			ajaxRequest(url, projectChangeCallback, data);

			function projectChangeCallback(data) {
				// group下拉列表初始化
				var group = new Array();
				var groupList = data.groupList;
				for ( var key in groupList) {
					if (groupList.hasOwnProperty(key)) {
						group.push('<option value= ' + groupList[key].groupId + '>' + groupList[key].groupName + '</option>');
					}
				}
				$('#drpGroupName').append(group.join(''));

				// 提出者情报下拉列表初始化
				var detector = new Array();
				var detectorList = data.detectorList;
				for ( var key in detectorList) {
					if (detectorList.hasOwnProperty(key)) {
						// 默认选中登录用户
						if (detectorList[key].userId == userId) {
							detector.push('<option selected value= ' + detectorList[key].userId + '>' + detectorList[key].userName + '</option>');
						} else {
							detector.push('<option value= ' + detectorList[key].userId + '>' + detectorList[key].userName + '</option>');
						}
					}
				}
				$('#drpDetector').append(detector.join(''));

				// 回答者情报下拉列表初始化
				var answerer = new Array();
				var answererList = data.answererList;
				for ( var key in answererList) {
					if (answererList.hasOwnProperty(key)) {
						answerer.push('<option value= ' + answererList[key].userId + '>' + answererList[key].userName + '</option>');
					}
				}
				$('#drpAnswer').append(answerer.join(''));

				$('select').material_select();
			}
		});

/**
 * group下拉列表变化事件
 */
$('#drpGroupName').change(
		function() {
			$drpModuleName = $('#drpModuleName'); 
			$drpModuleName.children().remove();
			$drpModuleName.append('<option value=" " disabled selected></option>');
			// 発生個所のドロップダウンリスト情報
			var url = 'QA0010ActionmoduleDropDown';
			var data = {
				'projectId' : $("#drpProjectName option:selected").val(),
				'groupId' : $("#drpGroupName option:selected").val()
			};
			ajaxRequest(url, groupChangeCallback, data);

			function groupChangeCallback(data) {
				var module = new Array();
				var moduleList = data.moduleList;
				for ( var key in moduleList) {
					if (moduleList.hasOwnProperty(key)) {
						module.push('<option value= ' + moduleList[key].moduleId + '>' + moduleList[key].moduleName + '</option>');
					}
				}
				$('#drpModuleName').append(module.join(''));

				$('select').material_select();
			}
		});

// 提交表单
$('#qasave').click(function() {
	var url = "QA0010ActionaddQA";
	var data = {
		'projectId' : $('#drpProjectName').val(),
		'relationQaNo' : $('#txtRelationQAID').val(),
	};
	submitFormAndValidate(url, data, QACallback);
});

function QACallback(data) {
	if (data.status != 0) {
		$('#errormsg').show().html(data.message);
		Materialize.toast('新建失败!', 4000);
		return false;
	}

	$('#errormsg').hide();

	var data = {
		'projectId' : $('#drpProjectName').val(),
		'qaNo' : data.qaNo
	};
	ajaxPageRequest('redirectToQA0020', data);
}
