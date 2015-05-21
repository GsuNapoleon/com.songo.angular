/**
 * 
 */
package com.songo.angular.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songo.angular.entity.Pagination;
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
	
	@RequestMapping(value="/{currentPage}/{searchContent}/{operate}", method=RequestMethod.GET)
	@ResponseBody
	public Pagination<ConsumerPlan> pagination(@PathVariable int currentPage,
			@PathVariable("searchContent") String category, @PathVariable String operate) {
		Pagination<ConsumerPlan> parameterPagination = new Pagination<ConsumerPlan>();
		try {
			logger.debug("接收到的查询参数为：currentPage={}, category={}, operate={}.", 
					new Object[]{currentPage, category, operate});
			ConsumerPlan parameter = new ConsumerPlan();
			parameter.setCategory(filterSearchContent(category));
			parameterPagination.setParameter(parameter);
			parameterPagination.setCurrentPage(currentPage);
			return consumerPlanService.getPagination(parameterPagination);
		} catch (Exception e) {
			logger.warn("查询消费计划列表时,发生异常：{}", e);
			return parameterPagination;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<ConsumerPlan> list() {
		try {
			return consumerPlanService.getList(new ConsumerPlan());
		} catch (Exception e) {
			logger.warn("查询消费计划列表时,发生异常：{}", e);
			return new ArrayList<ConsumerPlan>();
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseMessage postAdd(@RequestBody ConsumerPlan consumerPlan) {
		
		try {
			logger.debug("开始新增数据");
			consumerPlanService.add(consumerPlan);
			logger.debug("新增数据成功,操作结束");
			return new ResponseMessage(true, "添加成功");
		} catch (Exception e) {
			logger.warn("新增数据失败,具体异常是：{}", e);
			return new ResponseMessage(false, "添加失败");
		}
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseMessage postUpdate(@PathVariable int id, @RequestBody ConsumerPlan consumerPlan) {
		
		try {
			logger.debug("开始根据ID={}更新数据", id);
			consumerPlanService.update(consumerPlan);
			logger.debug("更新数据成功,操作结束");
			return new ResponseMessage(true, "更新成功");
		} catch (Exception e) {
			logger.warn("更新数据失败,具体异常是：{}", e);
			return new ResponseMessage(false, "更新失败");
		}
		
	}
	
	@RequestMapping(value = "/{id}/{operate}", method = RequestMethod.GET)
	@ResponseBody
	public ConsumerPlan postFindById(@PathVariable Integer id, @PathVariable String operate) {
		
		try {
			logger.debug("Operate={},开始根据ID={}获取消费计划的实例", operate, id);
			return consumerPlanService.getById(id);
		} catch (Exception e) {
			logger.warn("根据ID={}获取消费计划的实例时,发生异常：{}", id, e);
			return new ConsumerPlan();
		}
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseMessage postRemove(@PathVariable int id) {
		try {
			logger.debug("开始根据ID={}删除数据", id);
			consumerPlanService.delete(id);
			logger.debug("删除数据成功,操作结束");
			return new ResponseMessage(true, "删除成功");
		} catch (Exception e) {
			logger.warn("删除数据失败,具体异常是：{}", e);
			return new ResponseMessage(false, "删除失败");
		}
	}
}
