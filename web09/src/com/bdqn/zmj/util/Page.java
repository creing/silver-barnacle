package com.bdqn.zmj.util;

import java.util.List;
/**
 * 分页数据的封装工具类
 * 所有的分页相关的参数都会封装在这个对象里
 *
 */
public class Page<News> {
	private int currentPage;//当前页
	private int PageSize;//每页大小
	private int total;//数据总条数
	private int totalPage;//总页数
	private List<News> data;//数据
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<News> getData() {
		return data;
	}
	public void setData(List<News> data) {
		this.data = data;
	}
	
}
