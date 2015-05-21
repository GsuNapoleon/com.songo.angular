/**
 * 
 */
package com.songo.angular.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.songo.angular.BaseTest;
import com.songo.angular.model.CrawlerInitUrl;

/**
 * <p>decription:</p>
 * <p>date:2014年9月11日 下午12:24:03</p>
 * @author gsu·napoleon
 */
public class CrawlerInitUrlServiceTest extends BaseTest {

	@Autowired
	private CrawlerInitUrlService crawlerInitUrlService;
	
	/**
	 * <p>decription:</p>
	 * <p>date:2014年9月11日 下午12:24:03</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		List<CrawlerInitUrl> inits = crawlerInitUrlService.inits(true);
		System.out.println(inits.size());
	}

}
