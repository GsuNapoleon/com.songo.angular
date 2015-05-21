/**
 * 
 */
package com.songo.angular.search.crawler;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.songo.angular.BaseTest;
import com.songo.angular.model.CrawlerInitUrl;
import com.songo.angular.service.CrawlerInitUrlService;

/**
 * <p>decription:</p>
 * <p>date:2014年9月11日 下午2:01:37</p>
 * @author gsu·napoleon
 */
public class SearchControllerTest extends BaseTest {

	@Autowired
	private CrawlerInitUrlService crawlerInitUrlService;
	
	/**
	 * <p>decription:</p>
	 * <p>date:2014年9月11日 下午2:01:37</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		List<CrawlerInitUrl> inits = crawlerInitUrlService.inits(Boolean.FALSE);
		CrawlerInitUrl initUrl = ((inits != null && inits.size() > 0) ?inits.get(0) : new CrawlerInitUrl());
		try {
			SearchCrawler crawler = new SearchCrawler();
			crawler.crawlerWebContent(initUrl.getUrl(), initUrl.getDirectory());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
