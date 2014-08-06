/**
 * 
 */
package com.songo.angular.service;

import java.util.List;

import com.songo.angular.entity.Pagination;
import com.songo.angular.model.ConsumerPlan;

/**
 * <p>decription:</p>
 * <p>date:2014年7月9日 下午4:41:50</p>
 * @author gsu·napoleon
 */
public interface ConsumerPlanService {
	
	void add(ConsumerPlan obj) throws Exception;
	void update(ConsumerPlan obj) throws Exception;
	void delete(Integer id) throws Exception;
	ConsumerPlan getById(Integer id) throws Exception;
	List<ConsumerPlan> getList(ConsumerPlan obj) throws Exception;
	Pagination<ConsumerPlan> getPagination(Pagination<ConsumerPlan> obj) throws Exception;
	
}
