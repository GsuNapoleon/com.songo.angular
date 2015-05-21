/**
 * 
 */
package com.songo.spss.utils;

import com.songo.spss.request.ApplicationManager;
import com.songo.spss.request.Request;
import com.songo.spss.request.SearchEngineManager;

/**
 * <p>decription:</p>
 * <p>date:2014年11月27日 上午11:43:21</p>
 * @author gsu·napoleon
 */
public class SourceTypeUtils {

	/**
	 * 来源个数<br>
	 * 0代表全部<br>
	 * 1-4是以下的int _TYPE的类型
	 */
	public final static int TYPE_SIZE = 5;
	
	/**
	 * 直接来源
	 */
	public final static int DIRCET_ACCESS_TYPE = 1;
	/**
	 * 站外来源
	 */
	public final static int OUTSITE_ACCESS_TYPE = 2;
	/**
	 * 搜索来源
	 */
	public final static int SEARCH_ENGINE_ACCESS_TYPE = 3;
	/**
	 * 广告来源
	 */
	public final static int AD_ACCESS_TYPE = 4;
	
	/**
	 * 判断来源类型<br>
	 * 返回类型:<pre>
	 * <code>1 是直接来源</code>
	 * <code>2 是站外来源</code>
	 * <code>3 是搜索来源</code>
	 * <code>4 是广告来源</code></pre>
	 * @param req
	 * @return
	 */
	public static int referType(Request req) {
    	if (isAd(req)) return AD_ACCESS_TYPE;
    	//如果是站外，则再判断是是否是搜索
    	if (req.getRefererType() == Request.REFERER_OUTSITE) {
	    	if (isSearchEngine(req)) return SEARCH_ENGINE_ACCESS_TYPE;
	    	return OUTSITE_ACCESS_TYPE;
    	}
    	return DIRCET_ACCESS_TYPE;
	}
	
	/**
     * 判断是否为广告。
     * <pre>
     * 广告Ad必须是 <i>1 - 99999999</i> 范围内的
     * </pre>
     * @param req
     * @return
     */
    public static boolean isAd(Request req) {
    	return isAd(req.getAdId());
    }
    
    public static boolean isAd(int adId) {
    	return !(adId > 99999999 || adId <= 0);
    }
    
    /**
     * 判断是否为搜索引擎
     * @param req
     * @return
     */
    public static boolean isSearchEngine(Request req) {
    	String[] result = SearchEngineManager.matchQuick(req.getReferer());
        if (result.length == 0) return false;
        return true;
    }
    
    /**
     * 判断是否为站外
     * <pre>
     * 	除了本网站的域名地址，其它都是站外
     * </pre>
     * @param req
     * @return
     */
    public static boolean isOutSite(Request req) {
    	String refer = req.getReferer();
    	if (refer == null || "".equals(refer.trim()))
    		return false;
    	return ApplicationManager.matchSite(req.getReferer()) ? false : true;
    }
    
    /**
     * 判断是否为直接来源
     * <pre>
     * 没有refer，且是网站内各网站之间的跳转
     * </pre>
     * @param channel
     * @param req
     * @return
     */
    public static boolean isDirectAccess(Request req) {
		return !isOutSite(req);
	}

}
