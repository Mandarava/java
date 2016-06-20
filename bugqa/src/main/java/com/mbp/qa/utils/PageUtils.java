package com.mbp.qa.utils;

import java.util.regex.Pattern;

import org.apache.struts2.ServletActionContext;

import com.mbp.qa.model.dto.Page;

public final class PageUtils {

	public static Page initPage() {

		// 当前页
		String currentPage = ServletActionContext.getRequest().getParameter("currentPage");
		String limit = ServletActionContext.getRequest().getParameter("limit");
		// 排序语句
		String sortKey = ServletActionContext.getRequest().getParameter("sortKey");

		Page page = new Page();
		Pattern pattern = Pattern.compile("^[0-9]*$");
		// 判断当前页是否合法
		if (currentPage == null || !pattern.matcher(currentPage).matches()) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}

		// 判断limit是否合法
		if (limit == null || !pattern.matcher(limit).matches()) {
			page.setLimit(99999);
		} else {
			page.setLimit(Integer.valueOf(limit));
		}

		// 设置排序语句
		if (!CommonUtils.isElementBlank(sortKey)) {
			page.setSortKey(sortKey);
		} else {
			page.setSortKey(null);
		}
		
		page.setOffset((page.getCurrentPage() - 1) * page.getLimit());

		return page;

	}

}
