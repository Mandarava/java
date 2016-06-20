package com.mbp.qa.model.po;

import java.io.Serializable;
import java.util.Date;



/**
 * 得意先マスター
 * 
 * @author zt c.
 *
 */
public class CustomerMaster  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 得意先コード
	 */
	private String customerCode;

	/**
	 * 得意先名称
	 */
	private String customerName;

	/**
	 * 得意先略称
	 */
	private String customerNameSum;

	/**
	 * 会社フラグ
	 */
	private String companyFlg;

	/**
	 * 郵便番号
	 */
	private String zipCode;

	/**
	 * 得意先住所
	 */
	private String address;

	/**
	 * 得意先電話
	 */
	private String phone;

	/**
	 * 得意先ファックス
	 */
	private String fax;
	
	/**
	 * コメント
	 */
	private String comment;

	/**
	 * 削除フラグ
	 */
	private String deleteFlg;

	/**
	 * 更新ユーサーＩＤ
	 */
	private String updaterId;

	/**
	 * 更新日時
	 */
	private Date updateTime;

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode == null ? null : customerCode.trim();
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName == null ? null : customerName.trim();
	}

	public String getCustomerNameSum() {
		return customerNameSum;
	}

	public void setCustomerNameSum(String customerNameSum) {
		this.customerNameSum = customerNameSum == null ? null : customerNameSum.trim();
	}

	public String getCompanyFlg() {
		return companyFlg;
	}

	public void setCompanyFlg(String companyFlg) {
		this.companyFlg = companyFlg == null ? null : companyFlg.trim();
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode == null ? null : zipCode.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax == null ? null : fax.trim();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment == null ? null : comment.trim();
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg == null ? null : deleteFlg.trim();
	}

	public String getUpdaterId() {
		return updaterId;
	}

	public void setUpdaterId(String updaterId) {
		this.updaterId = updaterId == null ? null : updaterId.trim();
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}