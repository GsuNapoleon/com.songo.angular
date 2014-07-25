/**
 * 
 */
package com.songo.angular.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.songo.angular.model.ConsumerPlan;
import com.songo.angular.service.ConsumerPlanService;

/**
 * <p>decription:</p>
 * <p>date:2014年7月3日 下午4:44:25</p>
 * @author gsu·napoleon
 */
@Controller
@Scope("prototype")
@RequestMapping("/consumer")
public class ConsumerController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

	@Autowired
	private ConsumerPlanService consumerPlanService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView postAdd(HttpServletRequest req, HttpServletResponse resp,
			@Valid ConsumerPlan obj, BindingResult result) {
		logger.info("开始新增对象");
//		consumerPlanService.add(obj);
		logger.info("新增对象成功,操作结束");
		return new ModelAndView("test");
	}
	
}
