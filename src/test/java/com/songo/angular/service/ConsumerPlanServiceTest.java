/**
 * 
 */
package com.songo.angular.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.songo.angular.BaseTest;
import com.songo.angular.entity.Pagination;
import com.songo.angular.model.ConsumerPlan;

/**
 * <p>decription:</p>
 * <p>date:2014年8月5日 上午10:52:11</p>
 * @author gsu·napoleon
 */
public class ConsumerPlanServiceTest extends BaseTest {

	@Autowired
	private ConsumerPlanService consumerPlanService;
	
	/**
	 * <p>decription:</p>
	 * <p>date:2014年8月5日 上午10:52:11</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Pagination<ConsumerPlan> obj = new Pagination<ConsumerPlan>();
		try {
			obj.setPageSize(5);
			obj.setCurrentPage(2);
			consumerPlanService.getPagination(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
