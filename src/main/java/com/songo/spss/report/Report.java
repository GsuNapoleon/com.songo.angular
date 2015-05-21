/**
 * 
 */
package com.songo.spss.report;

import java.util.Map;

import com.songo.spss.model.Channel;
import com.songo.spss.request.Request;

/**
 * <p>decription:</p>
 * <p>date:2014年11月27日 上午10:28:30</p>
 * @author gsu·napoleon
 */
public interface Report<T extends Channel> {

	void init() throws Exception;
	
    void setChannels(Map<Long, T> channels);     
    
    void count(Request request);
    
    void shutdown() throws Exception;

    Map<Long, T> getChannels();
	
}
