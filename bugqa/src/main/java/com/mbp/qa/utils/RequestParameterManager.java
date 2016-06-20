package com.mbp.qa.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts2.ServletActionContext;

import com.mbp.qa.model.dto.BaseArgValue;

/**
 * 获得url中请求的参数
 * 
 * @author zt c.
 *
 */
public final class RequestParameterManager {

	static {
		ConvertUtils.register(new DateConverter(), java.util.Date.class);
	}

	public static Map<String, Object> requestToMap() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Enumeration<?> enumeration = request.getParameterNames();
		Map<String, Object> modelMap = new HashMap<>();
		while (enumeration.hasMoreElements()) {
			String parameterName = (String) enumeration.nextElement();

			if (CommonUtils.isElementBlank(request.getParameter(parameterName))) {
				modelMap.put(parameterName, null);
			} else {
				// 此处接受到的都是string 剔除全角和半角空格
				modelMap.put(parameterName,
						CommonUtils.trimFull(request.getParameter(parameterName)));
			}

		}
		return modelMap;
	}

	public static BaseArgValue getArgValue(BaseArgValue arg) throws IllegalAccessException,
			InvocationTargetException {

		Map<String, Object> request = RequestParameterManager.requestToMap();

		BeanUtils.copyProperties(arg, request);

		return arg;
	}

}
