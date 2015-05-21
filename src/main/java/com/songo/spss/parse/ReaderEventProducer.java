/**
 * 
 */
package com.songo.spss.parse;

import java.io.File;

import com.lmax.disruptor.RingBuffer;

/**
 * <p>decription:</p>
 * <p>date:2014年11月26日 上午10:48:23</p>
 * @author gsu·napoleon
 */
public class ReaderEventProducer {
	
	private RingBuffer<KillFileEvent> ringBuffer;
	
	public ReaderEventProducer() {}
	
	public ReaderEventProducer(RingBuffer<KillFileEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}
	
	public void producer(File srcFile) {
		long sequence = this.ringBuffer.next();
		
		try {
			KillFileEvent event = this.ringBuffer.get(sequence);
			event.setSrcFile(srcFile);
		} finally {
			this.ringBuffer.publish(sequence);
		}
	}

}
