/**
 * 
 */
package com.songo.angular.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.songo.angular.entity.ResponseMessage;
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
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<ConsumerPlan> list() {
		return consumerPlanService.getList(new ConsumerPlan());
	}
	
	@RequestMapping("/pre/add/consumer/plan")
	public ModelAndView preAdd(HttpServletRequest req, HttpServletResponse resp) {
		return new ModelAndView("consume/add_consumer_plan");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseMessage postAdd(@RequestBody ConsumerPlan consumerPlan) {
		logger.info("开始新增对象");
//		consumerPlanService.add(obj);
		logger.info("新增对象成功,操作结束");
		
		return new ResponseMessage(true, "添加成功");
	}
	
}
