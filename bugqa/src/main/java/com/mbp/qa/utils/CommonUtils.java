package com.mbp.qa.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

public final class CommonUtils {

	/**
	 * 判断元素是否空
	 * 
	 * @param element
	 * @return 空返回true 否则返回false
	 */
	public static boolean isElementBlank(String element) {
		if (BaseConstants.UNDEFINED.equals(element) || BaseConstants.BLANK.equals(element)
				|| element == null || trimFull(element).length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 当前日期．年 ＋ 当前日期．月 ＋ 当前日期．日 ＋ 当前日期．时 ＋ 当前日期．分 ＋ 当前日期．秒
	 * 
	 * @return
	 */
	public static String getFullTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(cal.getTime());
	}

	/**
	 * 当前日期．年 ＋ 当前日期．月 ＋ 当前日期．日
	 * 
	 * @return
	 */
	public static String getTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(cal.getTime());
	}

	/**
	 * null 转为空字符串
	 * 
	 * @param value
	 * @return
	 */
	public static String escapeNull(String value) {
		if (value == null) {
			return "";
		} else {
			return value;
		}
	}

	/**
	 * 获得文件类型
	 * 
	 * @param fileName
	 *            文件名
	 * @return 文件类型 (.xls .txt and so on)
	 */
	public static String getFileType(String fileName) {
		if (fileName == null) {
			return null;
		}
		int index = fileName.lastIndexOf(".");
		String fileType = null;
		if (index == -1) {
			fileType = "";
		} else {
			fileType = fileName.substring(index, fileName.length());
		}
		return fileType;

	}

	/**
	 * 上传文件重命名
	 * 
	 * @param NO
	 *            番号
	 * @param ext
	 *            文件扩展名
	 * @return
	 */
	public static String newUploadFileName(String NO, String originalFileName) {
		// 添付資料ファイル名＝番号 ＋ 当前日期．年 ＋ 当前日期．月 ＋ 当前日期．日 ＋ 当前日期．时 ＋ 当前日期．分
		// ＋ 当前日期．秒 ＋ アップロードの拡張子名
		return NO + CommonUtils.getFullTime() + CommonUtils.getFileType(originalFileName);
	}

	/**
	 * 将当前语言缩写代码转成文字
	 * 
	 * @param language
	 *            语言缩写代码
	 * @return
	 */
	public static String localeToWord(String language) {
		// 如果为 zh
		if (language.equals(BaseConstants.CHINESECODE)) {
			language = BaseConstants.CHINESE;
			// 如果为 ja
		} else if (language.equals(BaseConstants.JAPANESECODE)) {
			language = BaseConstants.JAPANESE;
			// 如果为en
		} else if (language.equals(BaseConstants.ENGLISHCODE)) {
			language = BaseConstants.ENGLISH;
		}

		return language;
	}

	/**
	 * 获得当前语言
	 * 
	 * @return
	 */
	public static String getLocaleLanguage() {
		// Locale locale2 = (Locale)
		// ServletActionContext.getRequest().getSession().getAttribute("WW_TRANS_I18N_LOCALE");
		return ActionContext.getContext().getLocale().getLanguage();
	}

	/**
	 * 把list中所有string类型的null值转成空串
	 * 
	 * @param list
	 * @throws Exception
	 */
	public static void convertNullToEmptyString(List<?> list) {
		if (list == null) {
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			convertNullToEmptyString(list.get(i));
			// 顺便转义HTML
			escapeHtml(list.get(i));
		}
	}

	/**
	 * 把dataBean中所有String类型的null转成空字符串(注意get/set的规范性)
	 * 
	 * @param obj
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static void convertNullToEmptyString(Object obj) {
		try {
			if (obj != null) {
				@SuppressWarnings("rawtypes")
				Class classz = obj.getClass();
				Field[] fields = classz.getDeclaredFields();
				for (Field field : fields) {
					Type t = field.getGenericType();
					if (t.toString().equals("class java.lang.String")
							&& Modifier.toString(field.getModifiers()).equals("private")) {

						Method m = classz.getMethod("get" + change(field.getName()));

						Object name = m.invoke(obj);

						if (name == null) {
							Method mtd = classz.getMethod("set" + change(field.getName()),
									new Class[] { String.class });// 取得所需类的方法对象
							mtd.invoke(obj, new Object[] { "" });// 执行相应赋值方法
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * html转义
	 * 
	 * @param obj
	 */
	@SuppressWarnings("unchecked")
	public static void escapeHtml(Object obj) {
		try {
			if (obj != null) {
				@SuppressWarnings("rawtypes")
				Class classz = obj.getClass();
				Field[] fields = classz.getDeclaredFields();
				for (Field field : fields) {
					Type t = field.getGenericType();
					if (t.toString().equals("class java.lang.String")
							&& Modifier.toString(field.getModifiers()).equals("private")) {

						Method m = classz.getMethod("get" + change(field.getName()));

						Object name = m.invoke(obj);

						Method mtd = classz.getMethod("set" + change(field.getName()),
								new Class[] { String.class });// 取得所需类的方法对象
						mtd.invoke(obj, escapeString(name));// 执行相应赋值方法
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object escapeString(Object str) {
		if (str instanceof String) {
			String str2 = (String) str;
			str2 = str2.replaceAll("\"", "&quot;");
			str2 = str2.replaceAll("&", "&amp;");
			str2 = str2.replaceAll("<", "&lt;");
			str2 = str2.replaceAll(">", "&gt;");
			str2 = str2.replaceAll("'", "&#39;");
			return str2;
		} else {
			return str;
		}
	}
	

	/**
	 * @param src
	 *            源字符串
	 * @return 字符串，将src的第一个字母转换为大写，src为空时返回null
	 */
	public static String change(String src) {
		if (src != null) {
			StringBuffer sb = new StringBuffer(src);
			sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
			return sb.toString();
		} else {
			return null;
		}
	}

	/**
	 * trim全角和半角空格
	 * 
	 * @return
	 */
	public static String trimFull(String str) {
		// 用半角空格替换调字符串中所有的全角空格,再trim
		return str.replaceAll("^　+|　+$", "").trim();
	}

}
