/**
 * 
 */
package com.songo.spss.request;

import java.util.ArrayList;
import java.util.List;

import com.songo.spss.model.Advertisement;

/**
 * <p>decription:</p>
 * <p>date:2014年11月27日 上午9:27:52</p>
 * @author gsu·napoleon
 */
public class AdvertisementManager {

	static List<Advertisement> inSiteAdNeedMatchList = new ArrayList<Advertisement>();
	static List<Advertisement> outSiteAdNeedMatchList = new ArrayList<Advertisement>();
	
	public static void addSiteMatch(String urlPattern, String startWith, int adId) {
		String url = (urlPattern == null || "".equals(urlPattern)) ? startWith : urlPattern;
		if ((url == null || "".equals(url) )|| adId <= 0)
			return;
		Advertisement ad = new Advertisement(urlPattern, startWith, adId);
		if (ApplicationManager.matchSite(url))
			addInSiteMatch(ad);
		else 
			addOutSiteMatch(ad);
	}
	
	/**
	 * 增加需要转换的内站广告
	 * @param ad
	 */
	public static void addInSiteMatch(Advertisement ad) {
		inSiteAdNeedMatchList.add(ad);
	}
	
	/**
	 * 增加需要转换的外站广告
	 * @param ad
	 */
	public static void addOutSiteMatch(Advertisement ad) {
		outSiteAdNeedMatchList.add(ad);
	}
	
	public static int matchSite(String refer) {
		if (ApplicationManager.matchSite(refer))
			return matchInSite(refer);
		else return matchOutSite(refer);
	}
	
	/**
	 * 匹配外站广告
	 * @param refer
	 * @return
	 */
	public static int matchOutSite(String refer) {
		return matchSite(refer, outSiteAdNeedMatchList);
	}
	
	/**
	 * 匹配内站广告
	 * @param refer
	 * @return
	 */
	public static int matchInSite(String refer) {
		return matchSite(refer, inSiteAdNeedMatchList);
	}
	
	/**
	 * 根据列表匹配广告
	 * @param refer
	 * @param list
	 * @return
	 */
	private static int matchSite(String refer, List<Advertisement> list) {
		for (Advertisement ad : list) {
			int adId = ad.match(refer) ;
			if (adId != Advertisement.NOT_AD)
				return adId;
		}
		return Advertisement.NOT_AD;
	}
	
}
