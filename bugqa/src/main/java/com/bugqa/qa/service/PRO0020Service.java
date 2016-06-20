package com.bugqa.qa.service;

import java.util.List;

import com.bugqa.qa.model.dto.PRO0020ArgValue;
import com.bugqa.qa.model.po.CustomerMaster;
import com.bugqa.qa.model.po.GeneralMaster;

public interface PRO0020Service {

	/**
	 * 初始化状態下拉框 取得汎用信息(プロジェクト状態)
	 * 
	 * @return
	 */
	List<GeneralMaster> proStage();

	/**
	 * 初始化会社名下拉框(取得本会社信息) 初始化得意先下拉框(取得得意先信息)
	 * 
	 * @param companyFlg
	 * @return
	 */
	List<CustomerMaster> customerMsg(String companyFlg);

	/**
	 * 登录项目相关信息
	 * 
	 * @param arg
	 */
	String addProjectMsg(PRO0020ArgValue arg) throws Exception;

}
