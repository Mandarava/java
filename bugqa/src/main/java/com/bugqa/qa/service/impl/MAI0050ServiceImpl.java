package com.bugqa.qa.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bugqa.qa.model.dto.MAI0050ArgValue;
import com.bugqa.qa.model.dto.MAI0050RetValue;
import com.bugqa.qa.model.po.ProjectMaster;
import com.bugqa.qa.service.BaseService;
import com.bugqa.qa.service.MAI0050Service;

/**
 * MAI0050 QA菜单取得service
 * 
 * @author zt c.
 *
 */
@Service
public class MAI0050ServiceImpl extends BaseService implements MAI0050Service {
	
	private static Logger logger = LoggerFactory.getLogger(MAI0050ServiceImpl.class);

	/**
	 * QA菜单项目的取得
	 * 
	 * @param userId
	 *            用户名
	 * @return QA菜单
	 */
	@Override
	public MAI0050RetValue getProject(MAI0050ArgValue arg) {
		List<ProjectMaster> result = super.projectDao.getProject(arg);
		logger.info("getProject result size ： " + result.size());
		MAI0050RetValue ret = new MAI0050RetValue();
		ret.setProject(result);
		return ret;
	}
}
