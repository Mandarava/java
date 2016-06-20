/**
 * COMMON FILE
 */

// 页面超时跳转
//setTimeout("window.parent.location.href=\"../SessionTimeOut.jsp\"", 3600000);
/**
 * 设置结束的时间小于开始时间的不能选
 * 
 * @param from
 *            开始日元素id
 * @param to
 *            结束日元素id
 */
function fromDateTo(from, to) {
	var from_$input = $('#' + from).pickadate();
	var from_picker = from_$input.pickadate('picker');

	var to_$input = $('#' + to).pickadate();
	var to_picker = to_$input.pickadate('picker');

	// Check if there’s a “from” or “to” date to start with.
	if (from_picker.get('value')) {
		to_picker.set('min', from_picker.get('select'));
	}
	if (to_picker.get('value')) {
		from_picker.set('max', to_picker.get('select'));
	}

	// When something is selected, update the “from” and “to” limits.
	from_picker.on('set', function(event) {
		if (event.select) {
			to_picker.set('min', from_picker.get('select'));
		} else if ('clear' in event) {
			to_picker.set('min', false);
		}
	});
	to_picker.on('set', function(event) {
		if (event.select) {
			from_picker.set('max', to_picker.get('select'));
		} else if ('clear' in event) {
			from_picker.set('max', false);
		}
	});
}

/**
 * 初始化时间控件，开始时间不小于当前时间
 * 
 * @param id
 *            日期input元素id
 * @param date
 *            想要设置的时间
 */
function initDatePicker(id, date) {
	var input = $('#' + id).pickadate();
	var picker = input.pickadate('picker');
	if (date) {
		picker.set('select', new Date(date));
	}
	picker.set('min', new Date());

}

/**
 * 获得元素相对顶端位置
 * 
 * @param element
 *            the element object
 * @returns
 */
function getElementTop(element) {
	var actualTop = element.offsetTop;
	var current = element.offsetParent;
	while (current !== null) {
		actualTop += current.offsetTop;
		current = current.offsetParent;
	}
	return actualTop;
}

$(document).ajaxError(function(e, xhr, settings, error) {
	var url = 'redirectToPREERR0010';
	ajaxPageRequest(url);
});

$.ajaxSetup({
	cache : false,
// timeout : 60000,
});

var pendingRequests = {};
$.ajaxPrefilter(function(options, originalOptions, jqXHR) {
	var key = options.url;
	if (!pendingRequests[key]) {
		pendingRequests[key] = jqXHR;
	} else {
		jqXHR.abort();
	}
	var complete = options.complete;
	options.complete = function(jqXHR, textStatus) {
		pendingRequests[key] = null;
		if ($.isFunction(complete)) {
			complete.apply(this, arguments);
		}
	};
});

/**
 * 导出excel
 * 
 * @param url
 */
function exportExcel(url) {
	if ($('#downloadexcel').length <= 0)
		$('body').append("<iframe id=\"downloadexcel\" style=\"display:none\"></iframe>");
	$('#downloadexcel').attr('src', url);
}

/**
 * 判断元素是否为空
 * 
 * @param element
 *            元素
 * @returns 空为true 非空为false
 */
function isElementBlank(element) {
	if (!element) {
		return true;
	}
	return false;
}

/**
 * 设置输入数据不为空元素的对应的label为active状态
 */
function setInputLabelActive() {
	var $form = $("form");
	// 遍历input
	$form.find("input").each(function() {
		if ($(this).val()) {
			$("form").find("label[for='" + $(this).attr("id") + "']").addClass("active");
		}
	});
	// 遍历textarea
	$form.find("textarea").each(function() {
		if ($(this).val()) {
			$("form").find("label[for='" + $(this).attr("id") + "']").addClass("active");
		}
	});
}

/**
 * 画面入力项可否入力 除button外。 flag:true 不可以入力
 */
function setInputFieldDisabled(flag) {
	$('form').find(':input').not('button').each(function() {
		$(this).attr("disabled", Boolean(flag));
	});
}

/**
 * 初始化表格区域排序翻页数据
 * <p>
 * jsp选择页数select下拉框 id:numPerPageSelect, 
 * 上一页a标签的 id:previousPage, 
 * 下一页a标签的 id:nextPage,
 * </p>
 * 
 * @param tableId
 *            整个table区域的id,包含翻页 下拉框 table等元素
 * @param initTable
 *            初始化table用函数
 * @param options 
 * 			  分页配置选项
 */
function initTableAreaAttr(tableId, initTable, options) {

	if (!options) {
		// 配置
		var options = {
			// 是否分页
			pagination : true,
			// 是否限制每页条数
			limit : true,
			// 是否排序
			sort : true
		}
	}

	// 整个表格区域
	var $table_area = $('#' + tableId);

	// 当前页数
	$table_area.data('currentPage', 1);
	// 总页数
	$table_area.data('totalPage', 1);
	// 排序状态标记,表格标题点击的是否为同一属性
	$table_area.data('sortOrderFlag', '');
	// 排序语句
	$table_area.data('sortSql', '');

	if (true === options.pagination) {

		// 上一页
		$table_area.find('#previousPage').unbind('click');
		$table_area.find('#previousPage').bind("click", function(e) {
			// 整个表格区域，非table本身
			var $table = $(e.target).parents('#' + tableId);
			var currentPage = $table.data('currentPage');
			if (currentPage <= 1) {
				return false;
			} else {
				// 显示进度条
				$table.find('.progress').css('visibility', 'visible');
				// 当前页减一
				$table.data('currentPage', currentPage - 1);
				initTable();
			}
		});

		// 下一页
		$table_area.find('#nextPage').unbind('click');
		$table_area.find('#nextPage').bind("click", function(e) {
			var $table = $(e.target).parents('#' + tableId);
			var currentPage = $table.data('currentPage');
			if (currentPage >= $table.data('totalPage')) {
				return false;
			} else {
				// 显示进度条
				$table.find('.progress').css('visibility', 'visible');
				// 当前页加一
				$table.data('currentPage', currentPage + 1);
				initTable();
			}

		});

	}

	if (true === options.limit) {
		// 每页显示条数
		$table_area.find('#numPerPageSelect').unbind('change');
		$table_area.find('#numPerPageSelect').bind("change", function(e) {
			var $table = $(e.target).parents('#' + tableId);
			// 显示进度条
			$table.find('.progress').css('visibility', 'visible');
			// 初始化页数
			$table.data('currentPage', 1);
			initTable();
		});
	}

	if (true === options.sort) {
		// 表格排序
		$table_area.find('table th a').each(function() {
			// 防止重复绑定事件
			$(this).unbind('click');
			$(this).bind("click", function(e) {
				var $table = $(e.target).parents('#' + tableId);
				// 显示进度条
				$table.find('.progress').css('visibility', 'visible');
				// 初始化页数
				$table.data('currentPage', 1);
				if ($table.data('sortOrderFlag') != "" && ($table.data('sortOrderFlag') == e.target.id)) {
					$table.data('sortSql', e.target.id + " DESC");
					initTable();
					// 重置
					$table.data('sortOrderFlag', '');
				} else {
					$table.data('sortSql', e.target.id + " ASC");
					initTable();
					$table.data('sortOrderFlag', e.target.id);
				}
			});
		});
	}
}

/**
 * 获得当前登录用户
 */
function getUser() {
	var user = "";
	$.ajax({
		url : "MAI0010ActiongetUserId",
		type : "get",
		cache : false,
		async : false,
		success : callback
	});
	function callback(data) {
		user = data.user;
	}
	return user;
}

/**
 * 页面跳转用ajax
 * 
 * @param url
 * @param data
 */
function ajaxPageRequest(url, data) {
	$.ajax({
		cache : false,
		url : url,
		type : 'get',
		data : data,
		async : true,
		success : function(responseText) {
			$('#rightFrame').html(responseText);
			// var isHistoryApi = !!(window.history && history.pushState);
			// if (isHistoryApi) {
			// var str = $(this).attr('url');
			// var url = str.substr(0, str.indexOf('?'))
			// History.pushState(null, null, url);
			// }

		}
	});
}

// $('#main').on('click', 'a', function(e) {
// window.history.pushState(null, null, $(this).attr('href'));
// anchorClick($(this).attr('href'));
// e.preventDefault();
// });
//
// function anchorClick(link) {
// var linkSplit = link.split('/').pop();
// }
//
// window.addEventListener('popstate', function(e) {
// anchorClick(location.pathname);
// });

/**
 * ajax请求
 * 
 * @param url
 * @param callback
 * @param data
 */
function ajaxRequest(url, successcallback, data, completecallback) {
	$.ajax({
		cache : false,
		url : url,
		type : 'post',
		data : data,
		async : true,
		dataType : 'json',
		success : successcallback,
		complete : completecallback
	});
}

/**
 * 检查文件类型及大小是否符合要求
 */
function checkFileValid(obj) {
	// 获得文件后缀名
	var ext = obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();
	if (ext != '.xls' && ext != '.xlsx' && ext != '.csv') {
		alert("文件格式不正确");
		return false;
	}
	var fileSize = 0;
	var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
	if (isIE && !obj.files) {
		var filePath = obj.value;
		var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
		var file = fileSystem.GetFile(filePath);
		fileSize = file.Size;
	} else {
		fileSize = obj.files[0].size;
	}
	if (fileSize >= 52428800) {
		alert("文件大小超过50MB");
		return false;
	}
}

/**
 * 验证并提交表单処理
 * 
 * @param url
 * @param data
 * @param callback
 */
function submitFormAndValidate(url, data, callback) {
	$(function() {
		window.ParsleyConfig = $.extend(window.ParsleyConfig || {}, {
			// successClass : 'valid',
			errorClass : 'invalid',
		// errorsContainer : '<span id="code_errors"></span>',
		});

		var $form = $('form');

		$form.parsley().on('form:error', function() {
			$.each(this.fields, function(key, field) {
				var element = field.$element;
				if (field.validationResult !== true) {
					var label = element.closest("form").find("label[for='" + element.attr("id") + "']");
					// label.attr('data-error');
					// label.addClass('active');
				}
			});
		});

		$form.parsley().on('field:validated', function() {
			var element = this.$element;
			if (this.validationResult === true) {
				element.closest("form").find("label[for='" + element.attr("id") + "']").removeAttr("data-error");
			}
			// else {
			// this.$element.closest("form").find("label[for='" +
			// element.attr("id") + "']").attr(
			// 'data-error', 'error');
			// }
		}).on('form:submit', function() {
			var options = {
				url : url,
				type : 'post',
				beforeSubmit : function() {
				},
				success : callback,
				data : data
			};

			$form.ajaxSubmit(options);
			// Don't submit form
			return false;
		});
	});
}
