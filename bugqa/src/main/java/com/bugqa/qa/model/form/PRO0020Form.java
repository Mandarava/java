package com.bugqa.qa.model.form;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.bugqa.qa.model.po.CustomerMaster;
import com.bugqa.qa.model.po.GeneralMaster;

public final class PRO0020Form extends BaseForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> beforeMsgReturn;
	
	private List<GeneralMaster> proStage;

	private List<CustomerMaster> customerMsg;
	
	private String fromBack;
	
	private boolean flag;
	
	private String exitFlg;
	
	public Map<String, Object> getBeforeMsgReturn() {
		return beforeMsgReturn;
	}
	
	public void setBeforeMsgReturn(Map<String, Object> beforeMsgReturn){
		this.beforeMsgReturn = beforeMsgReturn;
	}

	public List<GeneralMaster> getProStage() {
		return proStage;
	}

	public void setProStage(List<GeneralMaster> proStage) {
		this.proStage = proStage;
	}

	public List<CustomerMaster> getCustomerMsg() {
		return customerMsg;
	}

	public void setCustomerMsg(List<CustomerMaster> customerMsg) {
		this.customerMsg = customerMsg;
	}
	
	public String isFromBack() {
		return fromBack;
	}

	public void setFromBack(String fromBack) {
		this.fromBack = fromBack;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getExitFlg(){
		return exitFlg;
	}
	
	public void setExitFlg(String exitFlg) {
		this.exitFlg = exitFlg;
		
	}

}
