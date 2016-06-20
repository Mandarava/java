package com.mbp.qa.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class StringInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();

		Enumeration<String> paramName = request.getParameterNames();

		while (paramName.hasMoreElements()) {
			String key = paramName.nextElement();

			String[] value = request.getParameterValues(key);

			for (int i = 0; i < value.length; i++) {
				String str = value[i];
				str = str.replaceAll("^　+|　+$", "");
				str = str.replaceAll("\"", "&quot;");
				str = str.replaceAll("&", "&amp;");
				str = str.replaceAll("<", "&lt;");
				str = str.replaceAll(">", "&gt;");
				str = str.replaceAll("'", "&#39;");
				value[i] = str;
			}

			request.setAttribute(key, value);
		}
		return invocation.invoke();
	}

}
