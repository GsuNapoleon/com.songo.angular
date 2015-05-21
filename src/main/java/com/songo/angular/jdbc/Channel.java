/**
 * 
 */
package com.songo.angular.jdbc;

/**
 * <p>decription:</p>
 * <p>date:2014年11月7日 上午9:44:45</p>
 * @author gsu·napoleon
 */
public class Channel {

	private int id;
	private int parentId;
	private int rank;
	private String name;

	public Channel() {}
	
	public Channel(int id, int parentId, int rank, String name) {
		this.id = id;
		this.parentId = parentId;
		this.rank = rank;
		this.name = name;
	}
	
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
	 * @return the parentId
	 */
	public int getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Channel:[id={" + this.id + "}, name={" + this.name + "}]";
	}
	
}
