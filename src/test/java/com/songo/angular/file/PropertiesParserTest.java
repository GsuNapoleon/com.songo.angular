/**
 * 
 */
package com.songo.angular.file;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.songo.angular.utils.Constant;

/**
 * <p>decription:</p>
 * <p>date:2014年9月11日 下午2:58:24</p>
 * @author gsu·napoleon
 */
public class PropertiesParserTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年9月11日 下午2:58:24</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		PropertiesParser pp = new PropertiesParser();
		try {
			pp.load(Constant.CRAWLER_CONFIG.getKey());
		} catch (IOException e) {
			System.out.println("文件载入异常");
		}
		System.out.println(pp.get(Constant.CRAWLER_ORIGIN_DIRECTORY.getKey()));
	}

}
