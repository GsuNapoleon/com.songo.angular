/**
 * 
 */
package com.songo.angular.service;

import java.util.List;

import com.songo.angular.model.CrawlerInitUrl;

/**
 * <p>decription:</p>
 * <p>date:2014年9月11日 下午12:21:30</p>
 * @author gsu·napoleon
 */
public interface CrawlerInitUrlService {

	List<CrawlerInitUrl> inits(Boolean visit);
	
}
