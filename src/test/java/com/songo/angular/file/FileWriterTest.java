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
 * <p>date:2014年9月11日 下午5:00:59</p>
 * @author gsu·napoleon
 */
public class FileWriterTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年9月11日 下午5:00:59</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			PropertiesParser pp = new PropertiesParser();
			pp.load(Constant.CRAWLER_CONFIG.getKey());
			FileWriter.write(pp.get(Constant.CRAWLER_ORIGIN_DIRECTORY.getKey()), "sohu", "11111111111222222222");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
