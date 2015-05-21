/**
 * 
 */
package com.songo.angular.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songo.angular.entity.SearchResult;
import com.songo.angular.utils.Operations;

/**
 * <p>decription:</p>
 * <p>date:2014年9月5日 下午2:48:00</p>
 * @author gsu·napoleon
 */
@Controller
@Scope("prototype")
@RequestMapping("/search")
public class SearchController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/{keywords}/{btnK}/{operate}", method=RequestMethod.GET)
	@ResponseBody
	public SearchResult query(@PathVariable String keywords, @PathVariable String btnK, 
			@PathVariable String operate) {
		logger.debug("接收到的参数一次是：[keywords: {}, btnK: {}, operate: {}]", 
				new Object[]{keywords, btnK, operate});
		if (StringUtils.isNotBlank(operate) && 
				!StringUtils.equalsIgnoreCase(Operations.SEARCH.name(), operate)) {
			logger.warn("该操作{}不规范,不属于系统提供的范畴,请自重!", operate);
		}
		return new SearchResult();
	}
	
}
