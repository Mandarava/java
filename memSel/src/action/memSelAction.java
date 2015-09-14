
package action;

import java.io.IOException;

import org.apache.commons.lang.xwork.StringEscapeUtils;

import com.opensymphony.xwork2.ActionSupport;

import databean.MemSelDatabean;
import service.memSelService;

/**
 * 查找action
 * 
 * @see java.io.IOException
 * @see org.apache.commons.lang.xwork.StringEscapeUtils
 * @see com.opensymphony.xwork2.ActionSupport
 * @see databean.MemSelDatabean
 * @see service.memSelService
 * @version 1.0
 * 
 */
public class memSelAction extends ActionSupport {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 总的databean */
	private MemSelDatabean deptInfo = new MemSelDatabean();

	/**
	 * 总的dataBean 的取得
	 * 
	 * @return 总的dataBean
	 */
	public MemSelDatabean getDeptInfo() {
		return deptInfo;
	}

	/**
	 * 总的dataBean 的设定
	 * 
	 * @param deptInfo
	 *            总的dataBean
	 */
	public void setDeptInfo(MemSelDatabean deptInfo) {
		this.deptInfo = deptInfo;
	}

	/**
	 * 查找员工数据
	 * 
	 * @return success
	 */
	public String doSelect() {
		deptInfo.setMemDeptInfoList(new memSelService().getData(deptInfo
				.getMemSelKey()));
		// 部门号输入栏HTML转义
		deptInfo.getMemSelKey().setDeptCodeInput(
				StringEscapeUtils.escapeHtml(deptInfo.getMemSelKey()
						.getDeptCodeInput()));
		// 部门名输入栏HTML转义
		deptInfo.getMemSelKey().setDeptNameInput(
				StringEscapeUtils.escapeHtml(deptInfo.getMemSelKey()
						.getDeptNameInput()));
		// 姓名输入栏HTML转义
		deptInfo.getMemSelKey().setNameInput(
				StringEscapeUtils.escapeHtml(deptInfo.getMemSelKey()
						.getNameInput()));
		if (deptInfo.getMemSelKey().getSearchCondition().equals("0")) {
			deptInfo.getMemSelKey().setTableHead("人数（人）");
		} else {
			deptInfo.getMemSelKey().setTableHead("金额（元）");
		}
		return "success";
	}

	/**
	 * 清除画面
	 * 
	 * @return success
	 */
	public String viewClear() {
		deptInfo.setMemDeptInfoList(null);
		deptInfo.setMemSelKey(null);
		return "success";
	}

	/**
	 * 系统退出
	 * 
	 */
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
