/**
 * 
 */
package com.songo.angular.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.CollectionUtils;

/**
 * <p>decription:</p>
 * <p>date:2014年9月5日 下午3:15:30</p>
 * @author gsu·napoleon
 */
public class SearchResult {

	private String randomCode;	// 随机码
	private String url;			// 原始请求路径	
	private String referer;		// 路径来源,即referer
	private String keywords;	// 关键字
	private Timestamp timestamp;// 时间戳
	
	private List<Map<String, Object>> results;	// 查询结果
	
	public SearchResult() {
		this("", "", "", "", null);
	}
	
	public SearchResult(String randomCode, String url, String referer, 
			String keywords, List<Map<String, Object>> results) {
		this.randomCode = randomCode;
		this.url = url;
		this.referer = referer;
		this.keywords = keywords;
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.results = CollectionUtils.isEmpty(results) ? new ArrayList<Map<String,Object>>() : results;
	}

	/**
	 * @return the randomCode
	 */
	public String getRandomCode() {
		return randomCode;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the referer
	 */
	public String getReferer() {
		return referer;
	}

	/**
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * @return the results
	 */
	public List<Map<String, Object>> getResults() {
		return results;
	}
	
}
