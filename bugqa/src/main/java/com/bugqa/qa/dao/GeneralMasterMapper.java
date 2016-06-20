package com.bugqa.qa.dao;

import java.util.List;

import com.bugqa.qa.model.dto.COM0010ArgValue;
import com.bugqa.qa.model.dto.COM0020ArgValue;
import com.bugqa.qa.model.po.GeneralMaster;

public interface GeneralMasterMapper {

	/**
	 * 摘出作業情報を取得します。
	 * 
	 * @return 摘出作業情報
	 */
	List<GeneralMaster> getKbn01();

	/**
	 * 职务表情報を取得します。
	 * 
	 * @return 职务表情報
	 */
	List<GeneralMaster> getKbn02();

	List<GeneralMaster> getKbn03();

	List<GeneralMaster> getKbn04();

	/**
	 * 提问者状态情報を取得します。
	 * 
	 * @return 提问者状态情報
	 */
	List<GeneralMaster> getKbn06();

	/**
	 * 回答者状态情報を取得します。
	 * 
	 * @return 回答者状态情報
	 */
	List<GeneralMaster> getKbn07();

	// /**
	// * 摘出作業情報を取得します。
	// *
	// * @return 摘出作業情報
	// */
	// List<GeneralMaster> getKbnQS();

	/**
	 * 質問区分情報を取得します。
	 * 
	 * @return 質問区分情報
	 */
	List<GeneralMaster> getKbnQD();

	List<GeneralMaster> getKbnR1();

	List<GeneralMaster> getKbnR2();

	List<GeneralMaster> getKbnR3();

	List<GeneralMaster> getKbnR4();

	List<GeneralMaster> getKbnR5();

	List<GeneralMaster> getKbnR6();

	List<GeneralMaster> getKbnRD();

	/**
	 * 原因区分情報を取得します。
	 * 
	 * @return 原因区分情報
	 */
	List<GeneralMaster> getKbnRQ();

	List<GeneralMaster> getKbnTD();

	List<GeneralMaster> getKbnUp();

	/**
	 * 影响大小情報を取得します。
	 * 
	 * @return 影响大小情報
	 */
	List<GeneralMaster> getKbnE1();

	List<GeneralMaster> getKbnBT();

	List<GeneralMaster> getKbnCO();

	List<GeneralMaster> getKbnPH();

	/**
	 * 优先级情報を取得します。
	 * 
	 * @return 优先级情報
	 */
	List<GeneralMaster> getKbnYS();

	/**
	 * 通用信息
	 * 
	 * @param map
	 * @return
	 */
	List<GeneralMaster> generalMsgByPage(COM0010ArgValue arg);

	/**
	 * 修改通用信息
	 * 
	 * @param arg
	 * @return
	 */
	List<GeneralMaster> updateGeneralMsg(COM0020ArgValue arg);

	List<GeneralMaster> getKbnReason();

}