package com.bugqa.qa.service;

import java.util.List;

import com.bugqa.qa.model.dto.COM0020ArgValue;
import com.bugqa.qa.model.po.GeneralMaster;

public interface COM0020Service {

	/**
	 * 修改通用信息
	 * @param arg
	 * @return
	 */
	List<GeneralMaster> updateGeneralMsg(COM0020ArgValue arg) throws Exception ;


}
