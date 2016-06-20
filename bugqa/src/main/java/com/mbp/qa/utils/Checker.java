package com.mbp.qa.utils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.mbp.qa.interceptor.BusinessException;

public final class Checker {
	/**
	 * 检查是否为空
	 * 
	 * @param value
	 * @throws Exception
	 */
	public static void checkNull(String value) throws BusinessException {
		if (StringUtils.isEmpty(value)) {
			throw new BusinessException(MessageConstants.QA0001);
		}
	}

	/**
	 * 检查是否为空
	 * 
	 * @param value
	 * @throws Exception
	 */
	public static void checkNull(Integer value) throws BusinessException {
		if (null == value) {
			throw new BusinessException(MessageConstants.QA0001);
		}
	}

	/**
	 * 检查是否为空
	 * 
	 * @param value
	 * @throws Exception
	 */
	public static void checkNull(Date value) throws BusinessException {
		if (null == value) {
			throw new BusinessException(MessageConstants.QA0001);
		}
	}

	/**
	 * 检查最大长度
	 * 
	 * @param value
	 * @param length
	 * @throws BusinessException
	 */
	public static void checkMaxLength(String value, Integer length) throws BusinessException {
		if (null != value && value.length() > length) {
			throw new BusinessException(MessageConstants.QA0002);
		}
	}

	/**
	 * 检查开始日期是否小于结束日期
	 * 
	 * @param from
	 *            开始日期
	 * @param to
	 *            结束日期
	 * @throws BusinessException
	 */
	public static void compareDate(Date from, Date to) throws BusinessException {
		if (from.compareTo(to) > 0) {
			throw new BusinessException(MessageConstants.QA0003);
		}
	}

	/**
	 * 检查开始日期是否小于结束日期
	 * 
	 * @param from
	 *            开始日期
	 * @param to
	 *            结束日期
	 * @throws BusinessException
	 */
	public static void compareDate(String from, String to) throws BusinessException {
		if (from.compareTo(to) > 0) {
			throw new BusinessException(MessageConstants.QA0003);
		}
	}

	/**
	 * 判断是否是半角英数字
	 */
	public static void checkHalf(String value) throws BusinessException {
		Pattern regxHalf = Pattern.compile("^[0-9a-zA-Z]*");
		Matcher matcher = regxHalf.matcher(value);
		if (!matcher.matches()) {
			throw new BusinessException(MessageConstants.USE0008);
		}
	}

	/**
	 * 判断邮箱格式
	 */
	public static void checkMail(String value) throws BusinessException {
		// Pattern regxMail = Pattern
		// .compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
		Pattern regxMail = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		Matcher matcher = regxMail.matcher(value);
		if (!matcher.matches()) {
			throw new BusinessException(MessageConstants.USE0004);
		}
	}

	/**
	 * 判断电话号码和传真
	 * 
	 * @param value
	 * @throws BusinessException
	 */
	public static void chechIsNumber(String value) throws BusinessException {
		Pattern regTel = Pattern.compile("^[0-9]*");
		Matcher matcher = regTel.matcher(value);
		if (!matcher.matches()) {
			throw new BusinessException(MessageConstants.USE0011);
		}
	}

	/**
	 * 判断密码是否相等
	 */
	public static void checkPassword(String password, String repassword) throws BusinessException {
		if (!password.equals(repassword)) {
			throw new BusinessException(MessageConstants.USE0003);
		}
	}
	/**
	 * 检查是否为空
	 * 
	 * @param value
	 * @throws Exception
	 */
	public static void bugCheckNull(String value) throws BusinessException {
		if (StringUtils.isEmpty(value)) {
			throw new BusinessException(MessageConstants.BUG0002);
		}
	}

	/**
	 * 检查是否为空
	 * 
	 * @param value
	 * @throws Exception
	 */
	public static void bugCheckNull(Integer value) throws BusinessException {
		if (null == value) {
			throw new BusinessException(MessageConstants.BUG0002);
		}
	}

	/**
	 * 检查是否为空
	 * 
	 * @param value
	 * @throws Exception
	 */
	public static void bugCheckNull(Date value) throws BusinessException {
		if (null == value) {
			throw new BusinessException(MessageConstants.BUG0002);
		}
	}

	/**
	 * 检查最大长度
	 * 
	 * @param value
	 * @param length
	 * @throws BusinessException
	 */
	public static void bugCheckMaxLength(String value, Integer length) throws BusinessException {
		if (null != value && value.length() > length) {
			throw new BusinessException(MessageConstants.BUG0003);
		}
	}

	/**
	 * 检查开始日期是否小于结束日期
	 * 
	 * @param from
	 *            开始日期
	 * @param to
	 *            结束日期
	 * @throws BusinessException
	 */
	public static void bugCompareDate(Date from, Date to) throws BusinessException {
		if (from.compareTo(to) >= 0) {
			throw new BusinessException(MessageConstants.PRO0008);
		}
	}

	/**
	 * 检查开始日期是否小于结束日期
	 * 
	 * @param from
	 *            开始日期
	 * @param to
	 *            结束日期
	 * @throws BusinessException
	 */
	public static void bugCompareDate(String from, String to) throws BusinessException {
		if (from.compareTo(to) >= 0) {
			throw new BusinessException(MessageConstants.PRO0008);
		}
	}

}
