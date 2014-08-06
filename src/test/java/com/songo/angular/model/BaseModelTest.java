/**
 * 
 */
package com.songo.angular.model;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年8月4日 上午9:39:28</p>
 * @author gsu·napoleon
 */
public class BaseModelTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年8月4日 上午9:39:28</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ConsumerPlan plan = new ConsumerPlan();
		plan.setId(1);
		plan.setCategory("1");
		plan.setConsumerId(1);
		plan.setPurchaseDate(new Date());
		System.out.println(plan.toString());
	}

}
