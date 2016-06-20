package com.mbp.qa.model.dto;

import java.io.Serializable;

public class COM0020ArgValue extends BaseArgValue implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 区分
	 */
	private String kbn;

	/**
	 * コード
	 */
	private String code;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 備考
	 */
	private String remark;

	public String getKbn() {
		return kbn;
	}

	public void setKbn(String kbn) {
		this.kbn = kbn == null ? null : kbn.trim();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
}
