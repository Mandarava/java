package com.bugqa.qa.service;

import java.util.List;

import com.bugqa.qa.model.dto.COM0010ArgValue;
import com.bugqa.qa.model.po.GeneralMaster;

public interface COM0010Service {

	/**
	 * 通用信息
	 * @param map
	 * @return
	 */
	List<GeneralMaster> generalMsg(COM0010ArgValue arg);

}
