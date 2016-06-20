package com.bugqa.qa.service;

import com.bugqa.qa.model.dto.QA0010ArgValue;
import com.bugqa.qa.model.dto.QA0010RetValue;

public interface QA0010Service {

	QA0010RetValue getInitData(QA0010ArgValue arg);

	QA0010RetValue getProjectChangeData(QA0010ArgValue arg);

	QA0010RetValue getGroupChangeData(QA0010ArgValue arg);

	String addQA(QA0010ArgValue arg) throws Exception;

}
