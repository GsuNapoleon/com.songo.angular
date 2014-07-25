/**
 * 
 */
package com.songo.angular.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.songo.angular.dao.ConsumerPlanDao;
import com.songo.angular.model.ConsumerPlan;
import com.songo.angular.service.ConsumerPlanService;

/**
 * <p>decription:</p>
 * <p>date:2014年7月9日 下午4:42:22</p>
 * @author gsu·napoleon
 */
@Transactional
@Service("consumerPlanService")
public class ConsumerPlanServiceImpl implements ConsumerPlanService {

	@Autowired
	private ConsumerPlanDao consumerPlanDao;
	
	/* (non-Javadoc)
	 * @see com.songo.angular.service.ConsumerPlanService#add(com.songo.angular.model.ConsumerPlan)
	 */
	@Override
	public void add(ConsumerPlan obj) {
		consumerPlanDao.insert(obj);
	}
	
}
