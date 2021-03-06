/**
 * 
 */
package com.songo.angular.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

/**
 * <p>decription:</p>
 * <p>date:2014年7月9日 下午4:28:59</p>
 * @author gsu·napoleon
 */
public class ConsumerPlan extends BaseModel {

	/**
	 * <p>attribute:</p>
	 */
	private static final long serialVersionUID = -1330965459831427733L;

	private Integer id;
	
	@NotNull(message="不能为空")
	@Min(value=1, message="consumerId不能为0")
	private Integer consumerId = 1;
	
	@NotNull
	private String category;
	
	@NotNull
	private String details;
	
	@NotNull
	@NumberFormat(style=Style.NUMBER)
	private BigDecimal expense;
	
	@DateTimeFormat(iso=ISO.DATE, pattern="yyyy-MM-dd")
	private Date purchaseDate;

	private boolean isstatus = Boolean.TRUE.booleanValue();
	
	private Dictionary dictionary;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the consumerId
	 */
	public Integer getConsumerId() {
		return consumerId;
	}

	/**
	 * @param consumerId the consumerId to set
	 */
	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the expense
	 */
	public BigDecimal getExpense() {
		return expense;
	}

	/**
	 * @param expense the expense to set
	 */
	public void setExpense(BigDecimal expense) {
		this.expense = expense;
	}

	/**
	 * @return the purchaseDate
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * @param purchaseDate the purchaseDate to set
	 */
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * @return the isstatus
	 */
	public boolean getIsstatus() {
		return isstatus;
	}

	/**
	 * @param isstatus the isstatus to set
	 */
	public void setIsstatus(boolean isstatus) {
		this.isstatus = isstatus;
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
	
}
