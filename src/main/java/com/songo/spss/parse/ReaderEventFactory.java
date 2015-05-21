/**
 * 
 */
package com.songo.spss.parse;

import com.lmax.disruptor.EventFactory;

/**
 * <p>decription:</p>
 * <p>date:2014年11月26日 上午10:12:51</p>
 * @author gsu·napoleon
 */
public class ReaderEventFactory implements EventFactory<KillFileEvent> {

	/* (non-Javadoc)
	 * @see com.lmax.disruptor.EventFactory#newInstance()
	 */
	@Override
	public KillFileEvent newInstance() {
		return new KillFileEvent();
	}

}
