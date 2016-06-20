package com.mbp.qa.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mbp.qa.model.form.MAI0010Form;
import com.mbp.qa.model.po.UserMaster;
import com.mbp.qa.service.MAI0010Service;
import com.mbp.qa.utils.CommonUtils;
import com.mbp.qa.utils.EncryptUtil;
import com.mbp.qa.utils.SessionUtil;

/**
 * 用户登录Action
 * 
 * @author zt
 *
 */
public class MAI0010Action extends BaseAction<MAI0010Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(MAI0010Action.class);

	@Resource
	private MAI0010Service userLoginService;

	/**
	 * 跳转到登陆页面
	 * 
	 * @return
	 */
	public String toIndex() {
		session.clear();
		return SUCCESS;
	}

	/**
	 * 用户登录信息检测
	 * 
	 * @return
	 */
	public String login() {
		try {
			// 用户名
			String userId = model.getUserId();
			// 密码
			String pwd = EncryptUtil.getSHA1(model.getPassword());
			// 检查是否匹配
			boolean result = this.userLoginService.userLogin(userId, pwd);
			// 匹配成功
			if (result) {
				// 获得用户信息
				UserMaster user = this.getUserInfo(model.getUserId());
				// 用户信息放入session
				ServletActionContext.getRequest().getSession().setAttribute("user", user);
				return SUCCESS;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return SUCCESS;
	}

	/**
	 * 输入验证
	 */
	public void validateLogin() {
		// 有输入框没有输入
		if (StringUtils.isEmpty(model.getUserId()) || StringUtils.isEmpty(model.getPassword())) {
			this.addFieldError("errorMsg", "用户名或密码不能为空");
		}

		// 密码是否正确
		boolean result = this.userLoginService.userLogin(model.getUserId(),
				EncryptUtil.getSHA1(model.getPassword()));
		if (!result) {
			this.addFieldError("errorMsg", "您输入的帐号或密码不正确，请重新输入。");
		}

	}

	/**
	 * 首页跳转
	 * 
	 * @return
	 */
	public String toHomepage() {
		// 当前语言
		String lang = CommonUtils.getLocaleLanguage();
		// 设置语言
		session.put("language", CommonUtils.localeToWord(lang));
		return SUCCESS;

	}

	/**
	 * 退出登录
	 * 
	 * @return
	 */
	public String logOut() {
		// 清空session
		session.clear();
		return "logOut";
	}

	/**
	 * 获取登录用户详细信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return 登录用户的详细信息
	 */
	private UserMaster getUserInfo(String userId) {
		UserMaster user = new UserMaster();

		user = this.userLoginService.getUserInfo(userId);

		return user;

	}

	/**
	 * 获得用户
	 * 
	 * @return
	 */
	public String getUserId() {
		model.setUser(SessionUtil.getUser());

		return JSON;
	}

}
