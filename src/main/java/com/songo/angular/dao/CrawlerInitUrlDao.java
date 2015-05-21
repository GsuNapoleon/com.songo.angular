/**
 * 
 */
package com.songo.angular.dao;

import java.util.List;

import com.songo.angular.model.CrawlerInitUrl;

/**
 * <p>decription:</p>
 * <p>date:2014年9月11日 下午12:14:40</p>
 * @author gsu·napoleon
 */
public interface CrawlerInitUrlDao {

	List<CrawlerInitUrl> selects(Boolean visit);
	
}
