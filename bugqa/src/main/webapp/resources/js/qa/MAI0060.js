/**
 * qa menu tree
 */
// 动态菜单
(function() {
	// navbar dropdown initialize
	$(".dropdown-button").dropdown();

	// 自动清除overlaybug
	$('body').click(function(e) {
		if (e.target.id == 'bug' || e.target.id == 'manage' || e.target.id == 'qa' || e.target.id == 'dashboard')
			return false;
		$('div[id^=sidenav-overlay]').remove();
	});

	// 主页面内容初始化
	ajaxPageRequest('redirectToMAI0061');

	// 菜单初始化
	$.ajax({
		url : "MAI0050ActiongetProject",
		type : "get",
		dataType : 'json',
		async : true,
		success : function(data) {
			var project = data.project;
			for ( var key in project) {
				if (project.hasOwnProperty(key)) {
					$('#QAProject').after(
							'<li><a style="color:#444" href="#" id = \"' + project[key].projectId + '\"' + '>' + project[key].projectName + '</a></li>');
					// 添加点击跳转事件,項目によって画面に遷移する
					$("#" + project[key].projectId).on("click", {
						projectId : project[key].projectId
					}, qaClickHandler);
				}
			}
			// BUG
			for ( var key in project) {
				if (project.hasOwnProperty(key)) {
					$('#BUGProject').after(
							'<li><a style="color:#444" href="#" id = \"' + project[key].projectId + '\"' + '>' + project[key].projectName + '</a></li>');
					// 添加点击跳转事件,項目によって画面に遷移する
					$("#" + project[key].projectId).on("click", {
						projectId : project[key].projectId
					}, bugClickHandler);
				}
			}
		}
	});

	function qaClickHandler(event) {
		var data = {
			'flg' : 6,
			'projectId' : event.data.projectId
		};
		var url = 'redirectToQA0060';
		ajaxPageRequest(url, data);
	}

	function bugClickHandler(event) {
		var data = {
			'flg' : 6,
			'projectId' : event.data.projectId
		};
		var url = 'redirectToBUG0060';
		ajaxPageRequest(url, data);
	}

	/**
	 * QA菜单点击跳转
	 */
	$('#childNode22').click(function() {
		ajaxPageRequest('redirectToMAI0061');
	});

	$('#childNode23').click(function() {
		ajaxPageRequest('redirectToQA0010');
	});

	$('#childNode24').click(function() {
		ajaxPageRequest('redirectToQA0050');
	});

	// 私が提出したＱ＆Ａ画面に遷移する
	$('#childNode25').click(function() {
		var data = {
			"flg" : 1
		};
		ajaxPageRequest('redirectToQA0060', data);
	});

	// 私が回答するＱ＆Ａ画面に遷移する
	$('#childNode26').click(function() {
		var data = {
			"flg" : 2
		};
		ajaxPageRequest('redirectToQA0060', data);
	});

	// 全て未回答のＱ＆Ａ画面に遷移する
	$('#childNode27').click(function() {
		var data = {
			"flg" : 3
		};
		ajaxPageRequest('redirectToQA0060', data);
	});

	// 全てみ承認のＱ＆Ａ画面に遷移する
	$('#childNode28').click(function() {
		var data = {
			"flg" : 4
		};
		ajaxPageRequest('redirectToQA0060', data);
	});

	// 全てのＱ＆Ａ画面に遷移する
	$('#childNode29').click(function() {
		var data = {
			"flg" : 5
		};
		ajaxPageRequest('redirectToQA0060', data);
	});

	/**
	 * BUG菜单点击跳转事件
	 */
	$('#childNode18').click(function() {
		ajaxPageRequest('redirectToUSE0010');
	});

	/**
	 * BUG菜单点击跳转事件
	 */
	$('#childNode19').click(function() {
		ajaxPageRequest('redirectToPRO0010');
	});

	/**
	 * BUG新规
	 */
	$('#childNode2').click(function() {
		ajaxPageRequest('redirectToBUG0010');
	});

	/**
	 * 不具合検索オプション
	 */
	$('#childNode3').click(function() {
		ajaxPageRequest('redirectToBUG0050');
	});

	/**
	 * 我发行的不具合
	 */
	$('#childNode4').click(function() {
		var data = {
			"flg" : 1
		};
		ajaxPageRequest('redirectToBUG0060', data);
	});

	/**
	 * 我担当的不具合
	 */
	$('#childNode5').click(function() {
		var data = {
			"flg" : 2
		};
		ajaxPageRequest('redirectToBUG0060', data);
	});

	/**
	 * 我检证的不具合
	 */
	$('#childNode6').click(function() {
		var data = {
			"flg" : 3
		};
		ajaxPageRequest('redirectToBUG0060', data);
	});

	/**
	 * 所有未完成的不具合
	 */
	$('#childNode7').click(function() {
		var data = {
			"flg" : 4
		};
		ajaxPageRequest('redirectToBUG0060', data);
	});

	/**
	 * 所有未修正的不具合
	 */
	$('#childNode8').click(function() {
		var data = {
			"flg" : 5
		};
		ajaxPageRequest('redirectToBUG0060', data);
	});

	/**
	 * 所有不具合
	 */
	$('#childNode9').click(function() {
		var data = {
			"flg" : 6
		};
		ajaxPageRequest('redirectToBUG0060', data);
	});

	/**
	 * 得意先菜单点击跳转
	 */
	$('#childNode21').click(function() {
		ajaxPageRequest('redirectToCST0010');
	});

	/**
	 * 凡用master
	 */
	$('#childNode20').click(function() {
		ajaxPageRequest('redirectToCOM0010');
	});
	
	/**
	 * 修改个人信息
	 */
	$('#modifyUserInfo').click(function(){
		ajaxPageRequest('redirectToUSE0032');
	});
})();
