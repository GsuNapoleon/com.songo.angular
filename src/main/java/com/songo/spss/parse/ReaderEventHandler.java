/**
 * 
 */
package com.songo.spss.parse;

import com.lmax.disruptor.EventHandler;

/**
 * <p>decription:</p>
 * <p>date:2014年11月26日 上午10:17:57</p>
 * @author gsu·napoleon
 */
public class ReaderEventHandler implements EventHandler<KillFileEvent> {

	/* (non-Javadoc)
	 * @see com.lmax.disruptor.EventHandler#onEvent(java.lang.Object, long, boolean)
	 */
	@Override
	public void onEvent(KillFileEvent event, long sequence, boolean endOfBatch)
			throws Exception {
		event.kill();
	}

}
