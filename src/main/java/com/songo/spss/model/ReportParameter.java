/**
 * 
 */
package com.songo.spss.model;

import java.io.PrintWriter;
import java.util.Map;

import com.songo.spss.request.Request;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2014年11月27日 上午11:01:00
 * </p>
 * 
 * @author gsu·napoleon
 */
public class ReportParameter<T> {
	
	private int unmatchChannelNum;
	
	private Map<Long, T> channels;
	
	private long siteChannelId;
	
	private T siteChannel;
	
	private String logFileFolder;
	
	private String completedFolder;
	
	private PrintWriter completedWriter;
	
	private int filterUrlNum;
	
	private int refererFilterUrlNum;
	
	private int noUrlNum;
	
	private Task task;
	
	public ReportParameter() {
		
	}

	public ReportParameter(long siteChannelId) {
		this.siteChannelId = siteChannelId;
	}

	/**
	 * @return the unmatchChannelNum
	 */
	public int getUnmatchChannelNum() {
		return unmatchChannelNum;
	}

	/**
	 * @param unmatchChannelNum the unmatchChannelNum to set
	 */
	public void setUnmatchChannelNum(int unmatchChannelNum) {
		this.unmatchChannelNum = unmatchChannelNum;
	}

	public void accumulationUnmatchChannelNum() {
		this.unmatchChannelNum ++;
	}
	
	/**
	 * @return the channels
	 */
	public Map<Long, T> getChannels() {
		return channels;
	}

	/**
	 * @param channels the channels to set
	 */
	public void setChannels(Map<Long, T> channels) {
		this.channels = channels;
	}

	/**
	 * @return the siteChannelId
	 */
	public long getSiteChannelId() {
		return siteChannelId;
	}

	/**
	 * @param siteChannelId the siteChannelId to set
	 */
	public void setSiteChannelId(long siteChannelId) {
		this.siteChannelId = siteChannelId;
	}

	/**
	 * @return the siteChannel
	 */
	public T getSiteChannel() {
		return siteChannel;
	}

	/**
	 * @param siteChannel the siteChannel to set
	 */
	public void setSiteChannel(T siteChannel) {
		this.siteChannel = siteChannel;
	}

	/**
	 * @return the logFileFolder
	 */
	public String getLogFileFolder() {
		return logFileFolder;
	}

	/**
	 * @param logFileFolder the logFileFolder to set
	 */
	public void setLogFileFolder(String logFileFolder) {
		this.logFileFolder = logFileFolder;
	}

	/**
	 * @return the completedFolder
	 */
	public String getCompletedFolder() {
		return completedFolder;
	}

	/**
	 * @param completedFolder the completedFolder to set
	 */
	public void setCompletedFolder(String completedFolder) {
		this.completedFolder = completedFolder;
	}

	/**
	 * @return the completedWriter
	 */
	public PrintWriter getCompletedWriter() {
		return completedWriter;
	}

	/**
	 * @param completedWriter the completedWriter to set
	 */
	public void setCompletedWriter(PrintWriter completedWriter) {
		this.completedWriter = completedWriter;
	}

	/**
	 * @return the filterUrlNum
	 */
	public int getFilterUrlNum() {
		return filterUrlNum;
	}

	/**
	 * @param filterUrlNum the filterUrlNum to set
	 */
	public void setFilterUrlNum(int filterUrlNum) {
		this.filterUrlNum = filterUrlNum;
	}
	
	public void accumulationFilterUrlNum() {
		this.filterUrlNum ++;
	}

	/**
	 * @return the refererFilterUrlNum
	 */
	public int getRefererFilterUrlNum() {
		return refererFilterUrlNum;
	}

	/**
	 * @param refererFilterUrlNum the refererFilterUrlNum to set
	 */
	public void setRefererFilterUrlNum(int refererFilterUrlNum) {
		this.refererFilterUrlNum = refererFilterUrlNum;
	}
	
	public void accumulationRefererFilterUrlNum() {
		this.refererFilterUrlNum ++;
	}

	/**
	 * @return the noUrlNum
	 */
	public int getNoUrlNum() {
		return noUrlNum;
	}

	/**
	 * @param noUrlNum the noUrlNum to set
	 */
	public void setNoUrlNum(int noUrlNum) {
		this.noUrlNum = noUrlNum;
	}
	
	public void accumulationNoUrlNum() {
		this.noUrlNum ++;
	}

	/**
	 * @return the task
	 */
	public Task getTask() {
		return task;
	}

	/**
	 * @param task the task to set
	 */
	public void setTask(Task task) {
		this.task = task;
	}
	
	/**
	 * 写已完成的信息到文件里
	 *
	 * @param req
	 * @param type
	 */
	public void writeCompleted(Request req, int type) {
		SourceDetail detail = new SourceDetail(type, req.getChannelId());
		detail.setOtherInfoForRequest(req);
		completedWriter.println(detail);
		completedWriter.println(req);
		completedWriter.flush();
	}
}