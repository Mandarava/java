package com.bugqa.qa.service;

import com.bugqa.qa.model.dto.MAI0050ArgValue;
import com.bugqa.qa.model.dto.MAI0050RetValue;

/**
 * QA菜单获得interface
 * 
 * @author zt c.
 *
 */
public interface MAI0050Service {

	MAI0050RetValue getProject(MAI0050ArgValue arg);

}
