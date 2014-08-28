/**
 * 
 */
package com.songo.angular.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>decription:</p>
 * <p>date:2014年8月28日 下午3:30:46</p>
 * @author gsu·napoleon
 */
public class Income extends BaseModel {

	/**
	 * <p>attribute:</p>
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int category;
	private int consumerId;
	private BigDecimal gross;
	private BigDecimal net;
	private Date incomeDate;
	private String comments;

	private Dictionary dictionary;
	private Personnel personnel;
	
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
	 * @return the category
	 */
	public int getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(int category) {
		this.category = category;
	}

	/**
	 * @return the consumerId
	 */
	public int getConsumerId() {
		return consumerId;
	}

	/**
	 * @param consumerId the consumerId to set
	 */
	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	/**
	 * @return the gross
	 */
	public BigDecimal getGross() {
		return gross;
	}

	/**
	 * @param gross the gross to set
	 */
	public void setGross(BigDecimal gross) {
		this.gross = gross;
	}

	/**
	 * @return the net
	 */
	public BigDecimal getNet() {
		return net;
	}

	/**
	 * @param net the net to set
	 */
	public void setNet(BigDecimal net) {
		this.net = net;
	}

	/**
	 * @return the incomeDate
	 */
	public Date getIncomeDate() {
		return incomeDate;
	}

	/**
	 * @param incomeDate the incomeDate to set
	 */
	public void setIncomeDate(Date incomeDate) {
		this.incomeDate = incomeDate;
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

	/**
	 * @return the dictionary
	 */
	public Dictionary getDictionary() {
		return dictionary;
	}

	/**
	 * @param dictionary the dictionary to set
	 */
	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	/**
	 * @return the personnel
	 */
	public Personnel getPersonnel() {
		return personnel;
	}

	/**
	 * @param personnel the personnel to set
	 */
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
}
