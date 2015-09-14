/**
 * ConfigUtils.java
 * 
 * 分類　　:memberSel-common	
 * 名称　　:用于获得配置文件
 * 説明　　：读取配置文件
 * 備考　　：
 * 作成　　：[日付] 2015/08/26 [氏名] S1507112
 * 履歴：
 * [NO]	[日付]		[Ver]		[更新者]		[内容]
 *	1	2015/08/26	V10L1		S1507112	 初版。　 
 *	2	2015/08/27	V10L1.01	S1507112	修改成单例模式
 */
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
 * @author S1507112
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
