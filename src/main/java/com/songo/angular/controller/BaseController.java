/**
 * 
 */
package com.songo.angular.controller;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>decription:</p>
 * <p>date:2014年7月3日 下午4:44:36</p>
 * @author gsu·napoleon
 */
public abstract class BaseController {

	protected String filterSearchContent(String searchContent) {
		return StringUtils.equalsIgnoreCase("default", searchContent) ? "" : searchContent;
	}
	
}
