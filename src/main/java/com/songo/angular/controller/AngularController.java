/**
 * 
 */
package com.songo.angular.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>decription:</p>
 * <p>date:2014年7月3日 上午10:01:43</p>
 * @author gsu·napoleon
 */
@Controller
@Scope("prototype")
public class AngularController {

	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/main")
	public ModelAndView main() {
		return new ModelAndView("main");
	}
	
	@RequestMapping("/top")
	public ModelAndView top() {
		return new ModelAndView("top");
	}
	
	@RequestMapping("/menu/consumer/plan")
	public ModelAndView menuConsumerPlan() {
		return new ModelAndView("consume/consumer_plan");
	}
	
}
