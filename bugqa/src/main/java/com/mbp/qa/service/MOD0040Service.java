package com.mbp.qa.service;

import java.util.HashMap;
import java.util.List;

import com.mbp.qa.model.dto.MOD0040ArgValue;
import com.mbp.qa.model.dto.Page;
import com.mbp.qa.model.po.ModuleMaster;

public interface MOD0040Service {

	/**
	 * 检索模块信息
	 * 
	 * @param parameter
	 * @return
	 */
	List<ModuleMaster> moduleList(MOD0040ArgValue arg, Page page);

	/**
	 * 添加模块信息
	 * 
	 * @param map
	 */
	void addModule(HashMap<String, String> map);

	/**
	 * 删除模块信息
	 * 
	 * @param map
	 */
	void deleteModule(HashMap<String, String> map);

}
