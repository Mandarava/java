package com.bugqa.qa.interceptor;

import org.apache.struts2.ServletActionContext;

import com.bugqa.qa.model.po.UserMaster;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * session过期、登录有效性及操作的权限验证拦截器
 * 
 * @author zt c.
 *
 */
public class LoginedCheckInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	private UserMaster user = null;

	/**
	 * 拦截请求并进行登录有效性验证
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		if (!ServletActionContext.getRequest().isRequestedSessionIdValid()) {
			// session过期,转向session过期提示页,最终跳转至登录页面
			return "relogin";
		} else {
			user = (UserMaster) ServletActionContext.getRequest().getSession().getAttribute("user"); // 验证是否已经登录
			if (user == null) {
				// 尚未登录,跳转至登录页面
				return "relogin";
			} else {
				return invocation.invoke();

			}
		}
	}

}
