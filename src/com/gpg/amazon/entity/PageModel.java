package com.gpg.amazon.entity;

import java.util.ArrayList;
import java.util.List;

public class PageModel<T> {
	private int pageSize;
	private int totalPage;
	private long count;
	private int currentPage;
	private List<T> list = new ArrayList<>();

	public PageModel(int pageSize, Long count, int currentPage, List<T> list) {
		super();
		this.pageSize = pageSize;
		this.count = count;
		this.currentPage = currentPage;
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		totalPage = (int) (count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
		return totalPage;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
