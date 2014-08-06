/**
 * 
 */
package com.songo.angular.dao;

import java.util.List;

import com.songo.angular.entity.Pagination;
import com.songo.angular.model.ConsumerPlan;

/**
 * <p>decription:</p>
 * <p>date:2014年7月9日 下午4:32:49</p>
 * @author gsu·napoleon
 */
public interface ConsumerPlanDao {

	void insert(ConsumerPlan obj) throws Exception;
	void update(ConsumerPlan obj) throws Exception;
	void delete(Integer id) throws Exception;
	ConsumerPlan queryById(Integer id) throws Exception;
	List<ConsumerPlan> selectList(ConsumerPlan obj) throws Exception;
	int queryTotalRecords(ConsumerPlan obj) throws Exception;
	List<ConsumerPlan> queryPagination(Pagination<ConsumerPlan> obj) throws Exception;
}
