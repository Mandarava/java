package com.mbp.qa.service;

import com.mbp.qa.model.dto.QA0050ArgValue;
import com.mbp.qa.model.dto.QA0050RetValue;

/**
 * QA0050 interface
 * 
 * @author zt c.
 *
 */
public interface QA0050Service {

	QA0050RetValue getGroupID(String projectId);

	QA0050RetValue getModuleName(String projectId, String groupId);

	QA0050RetValue initSelectOptionData(String userId);

	QA0050RetValue customQASearchByPage(QA0050ArgValue arg);

}
