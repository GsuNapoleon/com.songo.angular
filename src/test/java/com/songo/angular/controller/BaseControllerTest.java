/**
 * 
 */
package com.songo.angular.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletException;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.CookieResultMatchers;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.songo.angular.BaseTest;

/**
 * <p>decription:</p>
 * <p>date:2014年7月3日 下午4:01:22</p>
 * @author gsu·napoleon
 */
public class BaseControllerTest extends BaseTest {

	@Autowired
	protected WebApplicationContext webApplicationContext;
	
	protected MockMvc mockMvc;
	
	/**
	 * <p>decription:</p>
	 * <p>date:2014年7月3日 下午3:29:37</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	/**
	 * <p>decription:</p>
	 * <p>date:2014年7月3日 下午4:15:24</p>
	 * @author gsu·napoleon
	 * @param string
	 * @return
	 * @throws URISyntaxException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected MockHttpServletRequestBuilder get(String string) throws URISyntaxException {
		URI uri = new URI(string);
		return MockMvcRequestBuilders.get(uri);
	}
	
	protected MockHttpServletRequestBuilder post(String string) throws URISyntaxException {
		URI uri = new URI(string);
		return MockMvcRequestBuilders.post(uri);
	}
	
	protected StatusResultMatchers status() {
		return MockMvcResultMatchers.status();
	}
	
	protected ResultMatcher forward(String expectedUrl) {
		return MockMvcResultMatchers.forwardedUrl(expectedUrl);
	}
	
	protected ResultMatcher redirect(String expectedUrl) {
		return MockMvcResultMatchers.redirectedUrl(expectedUrl);
	}
	
	protected Object jsonPathArgs(String expression, Matcher<Object> args) {
		return MockMvcResultMatchers.jsonPath(expression, args);
	}
	
	protected JsonPathResultMatchers jsonPathArgs(String expression, Object...args) {
		return MockMvcResultMatchers.jsonPath(expression, args);
	}
	
	protected ContentResultMatchers content() {
		return MockMvcResultMatchers.content();
	}
	
	protected CookieResultMatchers cookie() {
		return MockMvcResultMatchers.cookie();
	}
	
}
