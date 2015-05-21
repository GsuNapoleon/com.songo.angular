/**
 * 
 */
package com.songo.spss.model;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>decription:</p>
 * <p>date:2014年11月27日 上午10:49:00</p>
 * @author gsu·napoleon
 */
public class SourceChannel extends Channel {


	private int totalCount;
	private int dircetAccessCount;
	private int outSiteAccessCount;
	private int adAccessCount;
	private int searchEngineAccessCount;
	private int totalNewAccessCount;
	private int dircetNewAccessCount;
	private int outSiteNewAccessCount;
	private int adAccessNewCount;
	private int searchEngineNewAccessCount;
	protected Set<String> keys = new HashSet<String>(512);

	public SourceChannel(long channelId) {
		super(channelId);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void addTotalCount() {
		this.totalCount++;
	}

	public int getDircetAccessCount() {
		return dircetAccessCount;
	}

	public void addDircetAccessCount() {
		this.dircetAccessCount++;
	}

	public int getOutSiteAccessCount() {
		return outSiteAccessCount;
	}

	public void addOutSiteAccessCount() {
		this.outSiteAccessCount++;
	}

	public int getAdAccessCount() {
		return adAccessCount;
	}

	public void addAdAccessCount() {
		this.adAccessCount++;
	}

	public int getSearchEngineAccessCount() {
		return searchEngineAccessCount;
	}

	public void addSearchEngineAccessCount() {
		this.searchEngineAccessCount++;
	}

	public Set<String> getKey() {
		return keys;
	}

	public boolean addKey(String key) {
		return keys.add(key);
	}

	public int getChannelCount() {
		return keys.size();
	}

	public boolean contain(String key) {
		return keys.contains(key);
	}

	public int getTotalNewAccessCount() {
		return totalNewAccessCount;
	}

	public void addTotalNewAccessCount() {
		totalNewAccessCount++;
	}

	public int getDircetNewAccessCount() {
		return dircetNewAccessCount;
	}

	public void addDircetNewAccessCount() {
		dircetNewAccessCount++;
	}

	public int getOutSiteNewAccessCount() {
		return outSiteNewAccessCount;
	}

	public void addOutSiteNewAccessCount() {
		outSiteNewAccessCount++;
	}

	public int getAdNewAccessCount() {
		return adAccessNewCount;
	}

	public void addAdAccessNewCount() {
		adAccessNewCount++;
	}

	public int getSearchEngineNewAccessCount() {
		return searchEngineNewAccessCount;
	}

	public void addSearchEngineNewAccessCount() {
		searchEngineNewAccessCount++;
	}

}
