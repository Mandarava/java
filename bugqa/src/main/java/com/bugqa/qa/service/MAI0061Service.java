package com.bugqa.qa.service;

import com.bugqa.qa.model.dto.MAI0061ArgValue;
import com.bugqa.qa.model.dto.MAI0061RetValue;

/**
 * 首页Q&A情报取得interface
 * 
 * @author zt c.
 *
 */
public interface MAI0061Service {

	MAI0061RetValue getQAMyWork(MAI0061ArgValue arg);

	MAI0061RetValue getQAMyNotice(MAI0061ArgValue arg);
}
