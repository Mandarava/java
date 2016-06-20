package com.bugqa.qa.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.PropertyManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unchecked")
public class BaseAction<T> extends ActionSupport
		implements RequestAware, SessionAware, ApplicationAware, ParameterAware, ModelDriven<T> {

	private static final long serialVersionUID = 1L;

	protected static final String JSON = "json";

	protected static final String EXCEL = "excel";

	protected T model;

	protected Map<String, Object> jsonMap;

	protected List<T> jsonList = null;

	protected InputStream inputStream = null;

	protected String fileName;

	protected Map<String, Object> application;

	protected Map<String, Object> session;

	protected Map<String, Object> request;

	protected Map<String, String[]> parameter;

	/**
	 * 通过反射动态的创建对象
	 */
	public BaseAction() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		@SuppressWarnings("rawtypes")
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try {
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String getMessage(String messageId, String[] strReplace) {

		PropertyManager propertyManager = PropertyManager
				.getInstance(BaseConstants.MESSAGEFILEPATH);

		String message = propertyManager.getContent(messageId);

		if (strReplace != null) {
			for (int i = 0; i < strReplace.length; i++) {
				message = message.replace("{" + i + "}", strReplace[i]);
			}
		}

		return message;
	}

	/**
	 * 获得报错信息
	 * 
	 * @param messageId
	 *            报错信息ID
	 * @return
	 * @throws BusinessException
	 */
	protected String getMessage(String messageId) {

		String message = getMessage(messageId, new String[] { "" });

		return message;
	}

	protected void generateExcel(Map<String, Object> beanParams, String templateExcelName)
			throws ParsePropertyException, InvalidFormatException, IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		XLSTransformer transformer = new XLSTransformer();
		transformer.transformXLS(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(templateExcelName), beanParams).write(os);
		inputStream = new ByteArrayInputStream(os.toByteArray());
		os.close();
	}

	@Override
	public void setParameters(Map<String, String[]> parameter) {
		this.parameter = parameter;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public T getModel() {
//		Gson gson2 = new GsonBuilder().generateNonExecutableJson().create();
//		Gson gson = new Gson();
//		String json = gson.toJson(model);
//		System.out.println(json);
//		model = (T) gson.fromJson(json, model.getClass());
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	public List<T> getJsonList() {
		return jsonList;
	}

	public void setJsonList(List<T> jsonList) {
		this.jsonList = jsonList;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
