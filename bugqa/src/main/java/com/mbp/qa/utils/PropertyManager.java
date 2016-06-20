package com.mbp.qa.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import com.mbp.qa.interceptor.BusinessException;

/**
 * property读取工具
 * 
 * @author s1507112
 *
 */
public final class PropertyManager {

	/** properties */
	private static Properties properties;
	/** 输入流 */
	private InputStreamReader input;
	/** 声明一个PropertyManager类的引用 */
	private static PropertyManager content = null;

	/**
	 * 构造方法
	 * 
	 * @throws BusinessException
	 */
	private PropertyManager(String fileName) {
		properties = new Properties();
		try {
			input = new InputStreamReader(this.getClass().getResourceAsStream("/" + fileName),
					"UTF-8");
			properties.load(input);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 实例化引用
	 * 
	 * @return 该类的实例化对象
	 * @throws BusinessException
	 */
	public static PropertyManager getInstance(String fileName) {
		if (content == null) {
			content = new PropertyManager(fileName);
		}
		return content;
	}

	/**
	 * 得到key的值
	 * 
	 * @param key
	 *            取得其值的键
	 * @return key的值，如果不存在返回null
	 */
	public String getContent(String key) {

		// 国际化 zh_ERR0010 ja_ERR0010 etc.
		key = CommonUtils.getLocaleLanguage() + "_" + key;

		if (properties.containsKey(key)) {
			return properties.getProperty(key);
		} else
			return null;
	}
}
