package com.mbp.qa.service;

import com.mbp.qa.model.dto.QA0020ArgValue;
import com.mbp.qa.model.dto.QA0020RetValue;
import com.mbp.qa.model.po.ProjectMemberMaster;

public interface QA0020Service {

	QA0020RetValue getInitData(QA0020ArgValue arg);

	QA0020RetValue getGroupChangeData(QA0020ArgValue arg);

	ProjectMemberMaster getUserWorkType(String userId, String projectId);

	void saveQA(QA0020ArgValue arg) throws Exception;

	void changeQAState(QA0020ArgValue arg) throws Exception;

	void answerQA(QA0020ArgValue arg) throws Exception;

}
