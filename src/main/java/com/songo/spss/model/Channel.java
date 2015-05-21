/**
 * 
 */
package com.songo.spss.model;


/**
 * <p>decription:</p>
 * <p>date:2014年11月27日 上午10:28:57</p>
 * @author gsu·napoleon
 */
public class Channel {

	private Channel parent;
	protected long channelId;
	private int level;

	public Channel(long channelId) {
		this.channelId = channelId;
	}

	public Channel getParent() {
		return parent;
	}

	public void setParent(Channel parent) {
		this.parent = parent;
	}

	public long getChannelId() {
		return channelId;
	}

	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (false == (obj instanceof Channel)) {
			return false;
		}
		Channel ch = (Channel) obj;
		return channelId == ch.getChannelId();
	}

	@Override
	public int hashCode() {
		return (String.valueOf(channelId) + getClass().getName()).hashCode();
	}

	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append(channelId).append(",");
		if (parent == null) {
			buf.append("parnet=null,");
		} else {
			buf.append("parent=").append(parent.getChannelId()).append(",");
		}

		return buf.toString();
	}
}
