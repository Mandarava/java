package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 获取config文件
 * 
 * @see java.io.FileInputStream
 * @see java.io.IOException
 * @see java.util.Properties
 * @version 1.01
 */
public class ConfigUtils {
	/** properties */
	private static Properties properties;
	/** 输入流 */
	private FileInputStream inputFile;
	/** 声明一个ConfigUtils类的引用 */
	private static ConfigUtils getConfig = null;
	/**
	 * 构造方法
	 */
	private ConfigUtils() {
		properties = new Properties();
		try {
			inputFile = new FileInputStream(Thread.currentThread()
					.getContextClassLoader().getResource("conf.properties")
					.getPath());
			properties.load(inputFile);
			inputFile.close();
		} catch (IOException ex) {
			System.out.println("读取配置文件失败!");
			ex.printStackTrace();
		}
	}

	/**
	 * 实例化引用
	 * 
	 * @return 该类的实例化对象
	 */
	public static ConfigUtils getInstance() {
		if (getConfig == null) {
			getConfig = new ConfigUtils();
		}
		return getConfig;
	}

	/**
	 * 得到key的值
	 * 
	 * @param key
	 *            取得其值的键
	 * @return key的值，如果不存在返回null
	 */
	public String getValue(String key) {
		if (properties.containsKey(key)) {
			return properties.getProperty(key);
		} else
			return null;
	}
}
