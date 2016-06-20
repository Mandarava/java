package com.bugqa.qa.service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bugqa.qa.dao.BugHistoryMapper;
import com.bugqa.qa.dao.BugMapper;
import com.bugqa.qa.dao.ClassMasterMapper;
import com.bugqa.qa.dao.CustomerMasterMapper;
import com.bugqa.qa.dao.DepartmentMasterMapper;
import com.bugqa.qa.dao.GeneralMasterMapper;
import com.bugqa.qa.dao.GroupMasterMapper;
import com.bugqa.qa.dao.IdMasterMapper;
import com.bugqa.qa.dao.ModuleMasterMapper;
import com.bugqa.qa.dao.ProjectMasterMapper;
import com.bugqa.qa.dao.ProjectMemberMasterMapper;
import com.bugqa.qa.dao.QAHistoryMapper;
import com.bugqa.qa.dao.QAIdMasterMapper;
import com.bugqa.qa.dao.QAMapper;
import com.bugqa.qa.dao.UserMasterMapper;
import com.bugqa.qa.utils.CommonUtils;

@Service
public class BaseService {

	@Resource
	protected GeneralMasterMapper generalDao;

	@Resource
	protected ProjectMasterMapper projectDao;

	@Resource
	protected GroupMasterMapper groupDao;

	@Resource
	protected UserMasterMapper userDao;

	@Resource
	protected ProjectMemberMasterMapper projectMemberDao;

	@Resource
	protected ModuleMasterMapper moduleDao;

	@Resource
	protected QAMapper qaDao;

	@Resource
	protected QAIdMasterMapper qaIdDao;

	@Resource
	protected QAHistoryMapper qaHistoryDao;

	@Resource
	protected BugHistoryMapper bugHistoryDao;

	@Resource
	protected BugMapper bugDao;

	@Resource
	protected ClassMasterMapper classDao;

	@Resource
	protected CustomerMasterMapper customerDao;

	@Resource
	protected DepartmentMasterMapper departmentDao;

	@Resource
	protected IdMasterMapper idDao;

	@Target({ ElementType.METHOD, ElementType.TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 30, rollbackFor = Exception.class)
	public @interface Transaction {

	}

	/**
	 * 空转null
	 * 
	 * @param value
	 * @return
	 */
	protected Object changeSpaceToNull(Object value) {

		if (value instanceof String) {
			if (StringUtils.isEmpty((String) value)) {
				return null;
			} else {
				return value;
			}
		} else {
			return value;
		}
	}

	/**
	 * null 转为空字符串
	 * 
	 * @param value
	 * @return
	 */
	protected String escapeNull(String value) {

		return CommonUtils.escapeNull(value);
	}
	
	/**
	 * HTML escape
	 * @param str
	 * @return
	 */
	protected String escapeHTML(String str) {
		if(str == null ){
			return "";
		}
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("'", "&#39;");
		return str;
	}
	
}
