/**
 * 
 */
package com.songo.angular.controller;

import java.net.URISyntaxException;

import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年7月3日 下午3:29:37</p>
 * @author gsu·napoleon
 */
public class ConsumerControllerTest extends BaseControllerTest {
	
	@Test
	public void testAdd() {
		
		try {
			mockMvc.perform(post("/consumer/add").param("consumerId1", "1")
					.param("category", "1").param("details", "牙膏")
					.param("expense", "20.5").param("purchaseDate", "2014-07-09")
					.param("isvisible", "true").param("isstatus", "true")
					.param("creator", "狄仁杰"))
					;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuery() {
		try {
			mockMvc.perform(get("/consumer/query"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
