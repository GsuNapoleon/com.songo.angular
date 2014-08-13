/**
 * 
 */
package com.songo.angular.model;

/**
 * <p>decription:</p>
 * <p>date:2014年8月13日 下午2:46:39</p>
 * @author gsu·napoleon
 */
public class Dictionary extends BaseModel {

	/**
	 * <p>attribute:</p>
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String catalog;
	private String codeValue;
	private String codeText;
	private String comments;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the catalog
	 */
	public String getCatalog() {
		return catalog;
	}

	/**
	 * @param catalog the catalog to set
	 */
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	/**
	 * @return the codeValue
	 */
	public String getCodeValue() {
		return codeValue;
	}

	/**
	 * @param codeValue the codeValue to set
	 */
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	/**
	 * @return the codeText
	 */
	public String getCodeText() {
		return codeText;
	}

	/**
	 * @param codeText the codeText to set
	 */
	public void setCodeText(String codeText) {
		this.codeText = codeText;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
