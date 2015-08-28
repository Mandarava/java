/**
 * EscapeInput.java
 * 
 * 分類　　:memberSel-common
 * 名称　　:字符串转义
 * 説明　　：转义SQL语句
 */
package common;

/**
 * 字符串转义语句转义
 * 
 * @version 1.0
 */
public class EscapeInput {
	/**
	 * SQL语句转义
	 * 
	 * @param keyWord
	 *            需要转义的字符串
	 * @return 转义后的字符串
	 */
	public String sqlEscape(String keyWord) {
		// 转义字符
		String escape = ConfigUtils.getInstance().getValue("escape");
		keyWord = keyWord.replace(escape, escape + escape);
		keyWord = keyWord.replace("%", escape + "%");
		keyWord = keyWord.replace("_", escape + "_");
		return keyWord;
	}
}
