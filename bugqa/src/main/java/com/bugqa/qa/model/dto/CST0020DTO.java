package com.bugqa.qa.model.dto;

import java.io.Serializable;

/**
 * 新建用户DTO
 * 
 */
public class CST0020DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String txtCstCode;

	private String txtCstName;

	private String txtCstNameSim;

	private String txtZipCode;

	private String txtCstAddress;

	private String txtCstPhone;

	private String txtCstFax;

	private String txtComment;

	private String tblErrorInfo;

	private String hiddenRadio;

	public String getTxtCstCode() {
		return txtCstCode;
	}

	public void setTxtCstCode(String txtCstCode) {
		this.txtCstCode = txtCstCode;
	}

	public String getTxtCstName() {
		return txtCstName;
	}

	public void setTxtCstName(String txtCstName) {
		this.txtCstName = txtCstName;
	}

	public String getTxtCstNameSim() {
		return txtCstNameSim;
	}

	public void setTxtCstNameSim(String txtCstNameSim) {
		this.txtCstNameSim = txtCstNameSim;
	}

	public String getTxtZipCode() {
		return txtZipCode;
	}

	public void setTxtZipCode(String txtZipCode) {
		this.txtZipCode = txtZipCode;
	}

	public String getTxtCstAddress() {
		return txtCstAddress;
	}

	public void setTxtCstAddress(String txtCstAddress) {
		this.txtCstAddress = txtCstAddress;
	}

	public String getTxtCstPhone() {
		return txtCstPhone;
	}

	public void setTxtCstPhone(String txtCstPhone) {
		this.txtCstPhone = txtCstPhone;
	}

	public String getTxtCstFax() {
		return txtCstFax;
	}

	public void setTxtCstFax(String txtCstFax) {
		this.txtCstFax = txtCstFax;
	}

	public String getTxtComment() {
		return txtComment;
	}

	public void setTxtComment(String txtComment) {
		this.txtComment = txtComment;
	}

	public String getTblErrorInfo() {
		return tblErrorInfo;
	}

	public void setTblErrorInfo(String tblErrorInfo) {
		this.tblErrorInfo = tblErrorInfo;
	}

	public String getHiddenRadio() {
		return hiddenRadio;
	}

	public void setHiddenRadio(String hiddenRadio) {
		this.hiddenRadio = hiddenRadio;
	}

}
