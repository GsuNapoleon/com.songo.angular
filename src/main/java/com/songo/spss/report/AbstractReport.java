/**
 * 
 */
package com.songo.spss.report;

import java.util.Map;

import com.songo.spss.model.ReportParameter;
import com.songo.spss.model.SourceChannel;
import com.songo.spss.request.FilterUrlManager;
import com.songo.spss.request.Request;
import com.songo.spss.utils.SourceTypeUtils;

/**
 * <p>decription:</p>
 * <p>date:2014年11月27日 上午10:52:18</p>
 * @author gsu·napoleon
 */
public abstract class AbstractReport<T extends SourceChannel> implements Report<T> {

	//每天结束的时间，即最后一个定时任务23:45
	public static final int DAY_END_HHMM_INT = 2345;
	
	private ReportParameter<T> parameter;

	/* (non-Javadoc)
	 * @see com.songo.spss.report.Report#init()
	 */
	@Override
	public void init() throws Exception {
		initParameter();
		
		readFile();
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2014年11月27日 上午11:11:18</p>
	 * @author gsu·napoleon
	 */
	public abstract void readFile();

	/**
	 * <p>decription:</p>
	 * <p>date:2014年11月27日 上午11:10:26</p>
	 * @author gsu·napoleon
	 */
	public abstract void initParameter();

	/* (non-Javadoc)
	 * @see com.songo.spss.report.Report#setChannels(java.util.Map)
	 */
	@Override
	public void setChannels(Map<Long, T> channels) {
		
	}

	/* (non-Javadoc)
	 * @see com.songo.spss.report.Report#count(com.songo.spss.request.Request)
	 */
	@Override
	public void count(Request request) {
		T channel = null;
		
		if ((channel = verify(request)) == null) {
			return;
		}
		
		//计算来源
		boolean counted = countSource(channel, request);
		
		//计算总数
		countTotal(channel, request, counted);
	}
	
	@SuppressWarnings("unchecked")
	protected boolean countSource(T channel, Request req) {
		int type = 0;
		// 如果来源没有统计过的话，增加来源
		if (addKey(req)) {
			type = SourceTypeUtils.referType(req);
			while (channel != null) {
				addSourceType(channel, type);
				channel = (T) channel.getParent();
			}
			parameter.writeCompleted(req, type);
		}
		return false;
	}
	
	private boolean addKey(Request req) {
		return parameter.getSiteChannel().addKey(req.getIpAddress());
	}
	
	protected int addSourceType(T channel, int type) {
		switch (type) {
			case SourceTypeUtils.DIRCET_ACCESS_TYPE:
				channel.addDircetAccessCount();
				break;
			case SourceTypeUtils.OUTSITE_ACCESS_TYPE:
				channel.addOutSiteAccessCount();
				break;
			case SourceTypeUtils.SEARCH_ENGINE_ACCESS_TYPE:
				channel.addSearchEngineAccessCount();
				break;
			case SourceTypeUtils.AD_ACCESS_TYPE:
				channel.addAdAccessCount();
				break;
		}
		return type;
	}

	/**
	 * @param channel
	 * @param req
	 * @param siteCounted 此记录来源在此之前是否被统计过，即不是第一次入网站
	 */
	@SuppressWarnings("unchecked")
	protected void countTotal(T channel, Request req, boolean siteCounted) {
		// 计数栏目总数，如果子栏目不能增加总数，那么父栏目也不增加总数
		while (channel != null) {
			if (!addChannelKey(channel, req)) {
				break;
			}
			channel = ((T) channel.getParent());
		}
	}

	private boolean addChannelKey(T channel, Request req) {
		return channel.addKey(req.getIpAddress());
	}

	/* (non-Javadoc)
	 * @see com.songo.spss.report.Report#shutdown()
	 */
	@Override
	public void shutdown() throws Exception {
		
	}

	/**
	 * 验证req的有效性，如果有效，返回channel
	 *
	 * @param req
	 * @return
	 */
	public T verify(Request req) {
		// 屏蔽php的来源
		if (req.getReferer() != null
				&& req.getReferer().startsWith("http://php.3conline.com")) {
			return null;
		}
		
		//过滤无效的URL记录
		if ("".equals(req.getReferer()) && "".equals(req.getCurrentUrl())) {
			parameter.accumulationNoUrlNum();
			return null;
		}
		
		if (FilterUrlManager.isMatch(req.getCurrentUrl())) {
			parameter.accumulationFilterUrlNum();
			return null;
		}
		
		if (FilterUrlManager.
				isRefererMatch(req.getReferer(), req.getCurrentUrl())) {
			parameter.accumulationRefererFilterUrlNum();
			return null;
		}
		
		T channel = parameter.getChannels().get(req.getChannelId());
		isUnmatchChannel(channel);
		return channel;
	}
	
	protected void isUnmatchChannel(T channel) {
		if (channel == null) {
			parameter.accumulationUnmatchChannelNum();
		}
	}
	
}
