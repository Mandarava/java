package action;

import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;

import databean.MemSelDatabean;
import service.memSelService;

public class memSelAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MemSelDatabean deptInfo = new MemSelDatabean();

	public MemSelDatabean getDeptInfo() {
		return deptInfo;
	}

	public void setDeptInfo(MemSelDatabean deptInfo) {
		this.deptInfo = deptInfo;
	}

	public String doSelect() {
		deptInfo.setMemDeptInfoList(new memSelService().getData(deptInfo.getMemSelKey()));
		return "success";
	}

	public String viewClear() {
		deptInfo.setMemDeptInfoList(null);
		deptInfo.setMemSelKey(null);
		return "success";
	}

	public void sysExit() {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			Runtime.getRuntime().exec("taskkill /F /IM iexplorer.exe");
			Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
			Runtime.getRuntime().exec("taskkill /F /IM safari.exe");
			Runtime.getRuntime().exec("taskkill /F /IM opera.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}
