package com.bugqa.qa.service;

import com.bugqa.qa.model.dto.QA0070ArgValue;
import com.bugqa.qa.model.dto.QA0070RetValue;

/**
 * QA0070 Excelファイル導出
 * 
 * @author zt c.
 *
 */
public interface QA0070Service {

	QA0070RetValue getExportData(QA0070ArgValue arg);

}