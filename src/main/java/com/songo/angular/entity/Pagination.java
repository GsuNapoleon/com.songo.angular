/**
 * 
 */
package com.songo.angular.entity;

import java.util.ArrayList;
import java.util.List;

import com.songo.angular.model.BaseModel;

/**
 * <p>decription:</p>
 * <p>date:2014年8月5日 上午9:13:48</p>
 * @author gsu·napoleon
 * @param <T>
 */
public class Pagination<T extends BaseModel> {

	public static final int DEFAULT_PAGE_SIZE = 10;
	
	private int totalRecords;	// 总记录数
	private int currentPage;	// 当前页
	private int startIndex;		// 开始索引
	private int totalPages;		// 总页数
	private int pageSize = DEFAULT_PAGE_SIZE;		// 每页显示的记录数
	private List<T> results = new ArrayList<T>();
	private int [] pageItems;

	private T parameter;
	
	public Pagination() {}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Pagination transform(Pagination old) {
		Pagination pagination = new Pagination();
		pagination.setCurrentPage(old.getCurrentPage());
		pagination.setPageSize(old.pageSize == 0 ? DEFAULT_PAGE_SIZE : old.pageSize);
		pagination.setParameter(old.getParameter());
		return pagination;
	}
	
	/**
	 * @return the totalRecords
	 */
	public int getTotalRecords() {
		return totalRecords;
	}

	/**
	 * @param totalRecords the totalRecords to set
	 */
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the startIndex
	 */
	public int getStartIndex() {
		startIndex = currentPage != 0 ? (currentPage - 1) * pageSize : 0;
		return startIndex;
	}

	/**
	 * @param startIndex the startIndex to set
	 */
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the results
	 */
	public List<T> getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(List<T> results) {
		this.results = results;
	}

	/**
	 * @return the parameter
	 */
	public T getParameter() {
		return parameter;
	}

	/**
	 * @param parameter the parameter to set
	 */
	public void setParameter(T parameter) {
		this.parameter = parameter;
	}

	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		totalPages = pageSize != 0 ? (totalRecords / pageSize) : 0;
		return totalPages;
	}

	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	/**
	 * @return the pages
	 */
	public int[] getPageItems() {
		pageItems = new int[totalPages];
		for (int i = 0; i < totalPages; i ++) {
			pageItems[i] = i + 1;
		}
		return pageItems;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setPageItems(int[] pageItems) {
		this.pageItems = pageItems;
	}
	
}
