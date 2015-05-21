/**
 * 
 */
package com.songo.spss.model;

import java.util.regex.Pattern;

/**
 * <p>decription:</p>
 * <p>date:2014年11月27日 上午9:28:59</p>
 * @author gsu·napoleon
 */
public class Advertisement {
	public final static int NOT_AD = 0;
	private int id;
	private String urlPattern;
	private String startWith;
	private Pattern pattern;
	
	public Advertisement() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Advertisement(String urlPattern, String startWith, int id) {
		this.startWith = startWith;
		setUrlPattern(urlPattern);
		this.id = id;
	}
	
	public void setUrlPattern(String urlPattern) {
		if (urlPattern == null || "".equals(urlPattern))
			return;
        this.urlPattern = urlPattern;
        pattern = Pattern.compile("^" + urlPattern);
    }
	
	public String getUrlPattern() {
		return urlPattern;
	}
	
	public String getStartWith() {
		return startWith;
	}

	public void setStartWith(String startWith) {
		this.startWith = startWith;
	}

	public int match(String url) {
		if (startWith != null && !"".equals(startWith)) {
			if (url.startsWith(startWith))
				return id;
			else return NOT_AD;
		}
        if (pattern != null && !pattern.matcher(url).find())
            return NOT_AD;
        return id;
    }
}
