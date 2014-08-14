/**
 * 
 */
package com.songo.angular;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Collections2;

/**
 * <p>decription:</p>
 * <p>date:2014年7月1日 上午9:44:24</p>
 * @author gsu·napoleon
 */
public class LogBackTest {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * <p>decription:</p>
	 * <p>date:2014年7月1日 上午9:44:24</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		logger.trace("Test Logback 1..................");
	}

}
