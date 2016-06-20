package com.bugqa.qa.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.model.dto.MAI0050ArgValue;
import com.bugqa.qa.model.dto.MAI0050RetValue;
import com.bugqa.qa.model.form.MAI0050Form;
import com.bugqa.qa.service.MAI0050Service;

/**
 * 获取主页項目によって节点(MAI0050) Action
 * 
 * @author zt c.
 *
 */
public class MAI0050Action extends BaseAction<MAI0050Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(MAI0050Action.class);

	@Resource
	private MAI0050Service mai0050Service;

	/**
	 * 項目によって节点菜单取得
	 * 
	 * @return 項目によって节点
	 */
	public String getProject() {
		try {

			MAI0050ArgValue arg = new MAI0050ArgValue();

			// 取得項目
			MAI0050RetValue ret = mai0050Service.getProject(arg);

			model.setProject(ret.getProject());

			logger.debug("項目によって节点:" + ret);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}
}
