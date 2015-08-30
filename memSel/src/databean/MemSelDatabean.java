package databean;

import java.util.ArrayList;
import java.util.List;

public class MemSelDatabean {

	private List<MemSelDeptInfoDatabean> memDeptInfoList = new ArrayList<MemSelDeptInfoDatabean>();

	private MemSelKeyDatabean memSelKey = new MemSelKeyDatabean();

	public List<MemSelDeptInfoDatabean> getMemDeptInfoList() {
		return memDeptInfoList;
	}

	public void setMemDeptInfoList(List<MemSelDeptInfoDatabean> memDeptInfoList) {
		this.memDeptInfoList = memDeptInfoList;
	}

	public MemSelKeyDatabean getMemSelKey() {
		return memSelKey;
	}

	public void setMemSelKey(MemSelKeyDatabean memSelKey) {
		this.memSelKey = memSelKey;
	}
}
