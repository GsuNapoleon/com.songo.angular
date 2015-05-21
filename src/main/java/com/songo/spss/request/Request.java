/**
 * 
 */
package com.songo.spss.request;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.songo.spss.utils.RequestUtils;

/**
 * <p>decription:</p>
 * <p>date:2014年11月26日 上午11:16:23</p>
 * @author gsu·napoleon
 */
public class Request {


	public final static int REFERER_DIRECT = 1;
	public final static int REFERER_INSITE = 2;
	public final static int REFERER_OUTSITE = 3;
	
	protected String line;
	protected long currentTimeYmdhms;
	protected String currentUrl;
	protected String referer;
	protected String ipAddress; // include xForward;
	protected long channelId;
	protected String oldChannel;
	protected int adId;
	protected String resolution;
	protected String type;
	
	// uv related
	protected String suv;
	protected String uvdata;
	protected long currentTimeInMillis;
	protected long lastAccessTime;
	
	//补丁字段，用来链接第一次和第二次访问，items[14]
	private String pcxuv;
	private String ldjc;
	
	//来源类型，直接1站内2站外3，如果是0，则没有处理
	protected int refererType;

	public Request() {
		currentTimeYmdhms = 0;
		currentUrl = "";
		referer = "";
		ipAddress = "";
		channelId = 0;
		oldChannel = "";
		adId = 0;
		resolution = "";
		type = "1";
		suv = "";
		uvdata = "";
		currentTimeInMillis = 0;
	}
	
	public static Request getInstance(String line) {
		
		if (line.indexOf("show6.xinyaya.com") > -1
				|| line.indexOf("heatmap.pcauto.com.cn/tuiguang/x.html") > -1
				|| line.indexOf("ad=0001") > -1 || line.indexOf("ad=0002") > -1
				|| line.indexOf("autox/x.html") > -1) {
			return null;
		}

		String[] fields = line.split(RequestUtils.SEPERATOR, 20);

		if (fields.length < 12) {
			return null;
		}

		Request req = new Request();
		
		try {
			req.setCurrentTimeYmdhms(fields[0]);
			req.setType(fields[1]);
			req.setIpAddress(fields[2]);
			req.setResolution(fields[3]);
			req.setCurrentUrl(fields[4]);
			req.setReferer(fields[5]);
			req.setChannelId(fields[6]);
			req.setAdId(fields[7]); // First set adId
			req.setOldChannel(fields[8].trim());
			req.setSuv(fields[9]);
			req.setUvdata(fields[10]);
			req.setCurrentTimeInMillis(fields[11]);
			// lastAccessTime
			req.setLastAccessTime(uvdata2LastAccessTime(req.getUvdata()));
			// 判断refer类型
			req.setRefererType(referType(req.getReferer()));
			// 增加refer与ad之间的对照 , second set adId
			req.setAdId(referToAd(req.getRefererType(), req.getReferer(),
					req.getAdId()));
			if (fields.length >= 16) {
				if (StringUtils.isNotBlank(fields[15])) {
					req.setPcxuv(fields[15].trim());
				}
				req.setLdjc(fields[14]);
			}

			req.setLine(line);
		} catch (Exception ee) {
			ee.printStackTrace(System.out);
			return null;
		}
		
		// remove autox
		if (req.getSuv() != null && req.getSuv().indexOf(".ax.") > -1) {
			return null;
		}
		
		return req;
	
	}
	
	private static long uvdata2LastAccessTime(String uvdata) {
		if (uvdata == null) {
			return 0;
		}
		int startIndex = uvdata.indexOf("lastAccessTime=");
		if (startIndex == -1) {
			return 0;
		}
		int endIndex = uvdata.indexOf("|", startIndex);
		if (endIndex == -1) {
			return 0;
		}
		return NumberUtils.toLong(uvdata.substring(startIndex + 15, endIndex), -1);
	}
	
	/**
	 * 来源类型，直接1站内2站外3
	 *
	 * @param refer
	 * @return
	 */
	protected static int referType(String refer) {
		int referType;
		if (refer == null || "".equals(refer)) {
			referType = Request.REFERER_DIRECT;
		} else if (ApplicationManager.matchSite(refer)) {
			referType = Request.REFERER_INSITE;
		} else {
			referType = Request.REFERER_OUTSITE;
		}
		return referType;
	}

	/**
	 * refer与ad之间的对照表。返回有AD
	 *
	 * @param refer
	 * @param ad
	 * @return
	 */
	public static int referToAd(int referType, String refer, int ad) {
		switch (referType) {
			case 1:
				break;
			case 2:
				ad = inSiteAd(refer);
				break;
			case 3:
				ad = outSiteAd(refer, ad);
				break;
		}
		return ad;
	}
	
	protected static int outSiteAd(String refer, int ad) {
		if (ad > 0) {
			return ad;
		} //站外广告特别处理
		else {
			return AdvertisementManager.matchOutSite(refer);
		}
	}

	protected static int inSiteAd(String refer) {
		//站外广告特别处理
		return AdvertisementManager.matchInSite(refer);
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public long getCurrentTimeYmdhms() {
		return currentTimeYmdhms;
	}

	public void setCurrentTimeYmdhms(String currentTimeYmdhms) {
		this.currentTimeYmdhms = NumberUtils.toLong(currentTimeYmdhms);
	}

	public String getCurrentUrl() {
		return currentUrl;
	}

	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl.trim();
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer.trim();
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public long getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = NumberUtils.toLong(channelId, 0);
	}

	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	public String getOldChannel() {
		return oldChannel;
	}

	public void setOldChannel(String oldChannel) {
		this.oldChannel = oldChannel;
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = NumberUtils.toInt(adId, 0);
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type.trim();
	}

	public String getSuv() {
		return suv;
	}

	public void setSuv(String suv) {
		this.suv = suv.trim();
	}

	public long getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(long lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public String getUvdata() {
		return uvdata;
	}

	public void setUvdata(String uvdata) {
		this.uvdata = uvdata.trim();
	}

	public long getCurrentTimeInMillis() {
		return this.currentTimeInMillis;
	}

	public void setCurrentTimeInMillis(String currentTimeInMillis) {
		this.currentTimeInMillis = NumberUtils.toLong(currentTimeInMillis, 0);
	}

	public void setCurrentTimeInMillis(long currentTimeInMillis) {
		this.currentTimeInMillis = currentTimeInMillis;
	}

	public int getRefererType() {
		return refererType;
	}

	public void setRefererType(int refererType) {
		this.refererType = refererType;
	}

	@Override
	public String toString() {
		return this.line;
	}

	public String getPcxuv() {
		return pcxuv;
	}

	public void setPcxuv(String pcxuv) {
		this.pcxuv = pcxuv;
	}

	public String getLdjc() {
		return ldjc;
	}

	public void setLdjc(String ldjc) {
		this.ldjc = ldjc;
	}

}
