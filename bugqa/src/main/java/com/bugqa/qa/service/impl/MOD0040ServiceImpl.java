package com.bugqa.qa.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bugqa.qa.model.dto.MOD0040ArgValue;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.po.ModuleMaster;
import com.bugqa.qa.service.BaseService;
import com.bugqa.qa.service.MOD0040Service;

@Service
public class MOD0040ServiceImpl extends BaseService implements MOD0040Service {

	/**
	 * 检索模块信息
	 */
	@Override
	public List<ModuleMaster> moduleList(MOD0040ArgValue arg, Page page) {
		return super.moduleDao.moduleListByPage(arg, page);
	}

	/**
	 * 添加模块信息
	 */
	@Override
	public void addModule(HashMap<String, String> map) {
		super.moduleDao.addModule(map);
		
	}

	/**
	 * 删除模块信息
	 */
	@Override
	public void deleteModule(HashMap<String, String> map) {
		super.moduleDao.deleteModule(map);
		
	}

}
