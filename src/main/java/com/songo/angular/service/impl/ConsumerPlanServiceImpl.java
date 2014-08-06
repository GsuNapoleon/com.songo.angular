/**
 * 
 */
package com.songo.angular.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.songo.angular.dao.ConsumerPlanDao;
import com.songo.angular.entity.Pagination;
import com.songo.angular.model.ConsumerPlan;
import com.songo.angular.service.ConsumerPlanService;

/**
 * <p>decription:</p>
 * <p>date:2014年7月9日 下午4:42:22</p>
 * @author gsu·napoleon
 */
@Transactional
@Service
public class ConsumerPlanServiceImpl implements ConsumerPlanService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ConsumerPlanDao consumerPlanDao;
	
	/* (non-Javadoc)
	 * @see com.songo.angular.service.ConsumerPlanService#add(com.songo.angular.model.ConsumerPlan)
	 */
	@Override
	public void add(ConsumerPlan obj) throws Exception {
		logger.debug("接收到的新增对象实例是:{}", obj);
		consumerPlanDao.insert(obj);
	}

	/* (non-Javadoc)
	 * @see com.songo.angular.service.ConsumerPlanService#update(com.songo.angular.model.ConsumerPlan)
	 */
	@Override
	public void update(ConsumerPlan obj) throws Exception {
		logger.debug("接收到的修改对象实例是:{}", obj);
		consumerPlanDao.update(obj);
	}

	/* (non-Javadoc)
	 * @see com.songo.angular.service.ConsumerPlanService#delete(int)
	 */
	@Override
	public void delete(Integer id) throws Exception {
		logger.debug("接收到的删除id是:{}", id);
		consumerPlanDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.songo.angular.service.ConsumerPlanService#getList(com.songo.angular.model.ConsumerPlan)
	 */
	@Override
	public List<ConsumerPlan> getList(ConsumerPlan obj) throws Exception {
		return consumerPlanDao.selectList(obj);
	}

	/* (non-Javadoc)
	 * @see com.songo.angular.service.ConsumerPlanService#getPagination(com.songo.angular.entity.Pagination)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Pagination<ConsumerPlan> getPagination(Pagination<ConsumerPlan> obj) throws Exception {
		Pagination<ConsumerPlan> result = Pagination.transform(obj);
		result.setTotalRecords(getTotalRecords(obj.getParameter()));
		result.setResults(getPaginations(obj));
		return result;
	}

	public int getTotalRecords(ConsumerPlan obj) throws Exception {
		return consumerPlanDao.queryTotalRecords(obj);
	}

	public List<ConsumerPlan> getPaginations(Pagination<ConsumerPlan> obj)
			throws Exception {
		return consumerPlanDao.queryPagination(obj);
	}

	/* (non-Javadoc)
	 * @see com.songo.angular.service.ConsumerPlanService#getById(int)
	 */
	@Override
	public ConsumerPlan getById(Integer id) throws Exception {
		return consumerPlanDao.queryById(id);
	}
	
}
