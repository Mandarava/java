package com.bugqa.qa.service;

import com.bugqa.qa.model.dto.QA0060ArgValue;
import com.bugqa.qa.model.dto.QA0060RetValue;

/**
 * 预定义Q&A情报取得interface
 * 
 * @author zt c.
 *
 */
public interface QA0060Service {

	QA0060RetValue baseQASearch(QA0060ArgValue arg);

}
