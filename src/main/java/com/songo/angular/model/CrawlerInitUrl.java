/**
 * 
 */
package com.songo.angular.model;

/**
 * <p>decription:</p>
 * <p>date:2014年9月11日 下午12:12:17</p>
 * @author gsu·napoleon
 */
public class CrawlerInitUrl extends BaseModel {

	/**
	 * <p>attribute:</p>
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String directory;
	private String url;
	private boolean visit;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the directory
	 */
	public String getDirectory() {
		return directory;
	}

	/**
	 * @param directory the directory to set
	 */
	public void setDirectory(String directory) {
		this.directory = directory;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the visit
	 */
	public boolean isVisit() {
		return visit;
	}

	/**
	 * @param visit the visit to set
	 */
	public void setVisit(boolean visit) {
		this.visit = visit;
	}
}
