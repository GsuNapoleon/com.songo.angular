/**
 * 
 */
package com.songo.angular.dao;

import java.util.List;

import com.songo.angular.model.ConsumerPlan;

/**
 * <p>decription:</p>
 * <p>date:2014年7月9日 下午4:32:49</p>
 * @author gsu·napoleon
 */
public interface ConsumerPlanDao {

	void insert(ConsumerPlan obj);
	void update(ConsumerPlan obj);
	void delete(int id);
	List<ConsumerPlan> select(ConsumerPlan obj);
}
