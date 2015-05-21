/**
 * 
 */
package com.songo.angular.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.songo.angular.dao.CrawlerInitUrlDao;
import com.songo.angular.model.CrawlerInitUrl;
import com.songo.angular.service.CrawlerInitUrlService;

/**
 * <p>decription:</p>
 * <p>date:2014年9月11日 下午12:22:21</p>
 * @author gsu·napoleon
 */
@Service
@Transactional
public class CrawlerInitUrlServiceImpl implements CrawlerInitUrlService {
	
	@Autowired
	private CrawlerInitUrlDao crawlerInitUrlDao;

	/* (non-Javadoc)
	 * @see com.songo.angular.service.CrawlerInitUrlService#inits(Integer)
	 */
	@Override
	public List<CrawlerInitUrl> inits(Boolean visit) {
		return crawlerInitUrlDao.selects(visit);
	}

}
