/**
 * 
 */
package com.songo.angular.utils;

/**
 * <p>decription:</p>
 * <p>date:2014年9月11日 下午3:01:51</p>
 * @author gsu·napoleon
 */
public enum Constant {

	CRAWLER_ORIGIN_DIRECTORY("crawler.origin.directory", "爬虫的原始文件保存目录"),
	CRAWLER_CONFIG("crawler.properties", "爬虫的配置文件"),
	CRAWLER_FILE_SUFFIX(".html", "文件名后缀"),
	ENCODING_UTF8("UTF-8", "Unicode编码");
	
	private String key;
	private String value;
	
	private Constant(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
}
