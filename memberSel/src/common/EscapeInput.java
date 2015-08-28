/**
 * EscapeInput.java
 * 
 * 分類　　:memberSel-common
 * 名称　　:字符串转义
 * 説明　　：转义SQL语句
 * 備考　　：
 * 作成　　：[日付] 2015/08/24 [氏名] S1507112
 * 履歴：
 * [NO]	[日付]		[Ver]		[更新者]		[内容]
 *	1	2015/08/17	V10L1		S1507112	 初版。　 
 *	2	2015/08/26	V10L1.01	S1507112	修改注释
 *	3	2015/08/28	V10L1.02	S1507112	转义字符从配置文件读取
 */
package common;

/**
 * 字符串转义语句转义
 * 
 * @author S1507112
 * @version 1.01
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
