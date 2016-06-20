package com.mbp.qa.service;

import com.mbp.qa.model.dto.QA0030ArgValue;
import com.mbp.qa.model.dto.QA0030RetValue;

/**
 * QA历史记录获得
 * 
 * @author zt c.
 *
 */
public interface QA0030Service {

	QA0030RetValue QAHistorySerach(QA0030ArgValue arg);

}
