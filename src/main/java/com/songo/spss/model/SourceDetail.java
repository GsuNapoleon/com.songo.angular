/**
 * 
 */
package com.songo.spss.model;

import java.io.File;

import com.songo.spss.request.Request;
import com.songo.spss.utils.FunctionUtils;
import com.songo.spss.utils.SourceTypeUtils;

/**
 * <p>decription:</p>
 * <p>date:2014年11月27日 上午11:47:41</p>
 * @author gsu·napoleon
 */
public class SourceDetail {


	public final static String SPLIT_MARK = "##";
	public final static char SOURCETYPE_SPLIT_MARK = '#';
	public final static char AD_MARK = ':';
	public final static char FIRST_CHANNEL_MARK = '@';
	protected int sourceType;
	protected int adId;
	private int siteAdId;
	protected long firstChannelId;
	protected String detail;
	protected String domain;

	public SourceDetail() {
	}

	public SourceDetail(String detail) {
		setDetail(detail);
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public SourceDetail(int sourceType, long firstChannelId) {
		this.sourceType = sourceType;
		this.firstChannelId = firstChannelId;
	}

	public int getSourceType() {
		return sourceType;
	}

	public void setSourceType(int sourceType) {
		this.sourceType = sourceType;
	}

	public int getAdId() {
		return adId;
	}

	public String getDomain() {
		return domain;
	}

	protected void setAdId(int adId) {
		this.adId = adId;
	}

	public long getFirstChannelId() {
		return firstChannelId;
	}

	public void setFirstChannelId(long firstChannelId) {
		this.firstChannelId = firstChannelId;
	}

	/**
	 * 从Request设置其它详情
	 *
	 * @param Request
	 */
	public void setOtherInfoForRequest(Request req) {
		//设置广告
		if (sourceType == SourceTypeUtils.AD_ACCESS_TYPE) {
			setAdId(req.getAdId());
		} else if (sourceType == SourceTypeUtils.OUTSITE_ACCESS_TYPE) {
			setDomain(FunctionUtils.getDomain(req.getReferer()));
		}
	}

	protected void parse(String detail) {
		detail = detail.replace(SPLIT_MARK, "");
		char prefix = ' ';
		String value = "";
		for (char c : detail.toCharArray()) {
			if (isCompleted(c)) {
				setVaule(prefix, value);
				value = "";
				prefix = c;
				continue;
			}
			value += c;
		}
		setVaule(prefix, value);
	}
	
	public static void main(String[] args) {
		SourceDetail sd = new SourceDetail();
		sd.parse("###3-3_3@5654!24");
	}

	protected void setVaule(char prefic, String value) {
		if (value == null || "".equals(value)) {
			return;
		}
		switch (prefic) {
			case SOURCETYPE_SPLIT_MARK:
				setSourceType(Integer.parseInt(value));
				break;
			case AD_MARK:
				setAdId(Integer.parseInt(value));
				break;
			case FIRST_CHANNEL_MARK:
				setFirstChannelId(Integer.parseInt(value));
				break;
		}
	}

	protected boolean isCompleted(char c) {
		switch (c) {
			case SOURCETYPE_SPLIT_MARK:
			case AD_MARK:
			case FIRST_CHANNEL_MARK:
				return true;
		}
		return false;
	}

	public String format() {
		return SPLIT_MARK
				+ SOURCETYPE_SPLIT_MARK + sourceType
				+ FIRST_CHANNEL_MARK + firstChannelId
				+ (adId > 0 ? AD_MARK + "" + adId : "");
	}

	public String getDetail() {
		if (detail == null) {
			detail = format();
		}
		return detail;
	}

	public void setDetail(String detail) {
		parse(detail);
	}

	@Override
	public String toString() {
		return getDetail();
	}

	/**
	 * 根据folder生成一个存放信息的目录。<br>
	 * 在folder下增加一个以日为单位的目录
	 *
	 * @param folder
	 * @param task
	 * @return
	 */
	public static String getSourceFolder(String folder, Task task) {
		folder = folder + task.getYmd() + "/";
		File dic = new File(folder);
		if (!dic.exists()) {
			dic.mkdir();
		}
		return folder;
	}

	/**
	 * 创建detail，如果dtail是符合detail规则
	 *
	 * @param detail
	 * @return
	 */
	public static SourceDetail createDetail(String detail) {
		if (detail != null && detail.startsWith(SPLIT_MARK)) {
			return new SourceDetail(detail);
		}
		return null;
	}

	public int getSiteAdId() {
		return siteAdId;
	}

	public void setSiteAdId(int siteAdId) {
		this.siteAdId = siteAdId;
	}

}
