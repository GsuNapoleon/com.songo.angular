/**
 * 
 */
package com.songo.spss.request;


/**
 * <p>decription:</p>
 * <p>date:2014年11月26日 上午11:17:55</p>
 * @author gsu·napoleon
 */
public class Record extends Request implements Cloneable {


	private SrcType srcType;
	
	//记录来源，如广告，搜索，站外，直接
	private int sourceType;
	private int dayOfMonth;

	public int getSourceType() {
		return sourceType;
	}

	public void setSourceType(int sourceType) {
		this.sourceType = sourceType;
	}

	public int getMinute() {
		return (int) (currentTimeYmdhms / 100 % 100);
	}

	public int getHour() {
		return (int) (currentTimeYmdhms / 10000 % 100);
	}

	public int getDayOfMonth() {
		if (dayOfMonth == 0) {
			dayOfMonth = getDayOfMonthForCurrentTime();
		}
		return this.dayOfMonth;
	}

	public int getDayOfMonthForCurrentTime() {
		return (int) (currentTimeYmdhms / 1000000 % 100);
	}

	public void setDayOfMonth(int dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	public long getIpFindTime() {
		return lastAccessTime;
	}

	public long getIpPutTime() {
		return currentTimeInMillis;
	}

	/**
	 * 如果不存在cookie，返回null
	 * @return
	 */
	public String getCookie() {
		return "0".equals(getSuv()) ? null : getSuv();
	}

	public String getVisitPutKey() {
		if ("0".equals(getSuv())) {
			return ipAddress;
		}
		return getSuv();
	}

	public int getContainerNo() {
		return getMinute() % 30;
	}

	public int getPreviousContainerNo() {
		int num = getMinute() % 30 - 1;
		if (num == -1) {
			num = 29;
		}
		return num;
	}

	public String getDumpFileName() {
		return currentTimeYmdhms / 10000 + "-" + (getMinute() / 15);
	}

	public SrcType getSrcType() {
		return srcType;
	}

	public void setSrcType(SrcType srcType) {
		this.srcType = srcType;
	}

	public long getYmd() {
		return currentTimeYmdhms / 1000000;
	}

	public static boolean isPcxuv(String key) {
		if (key == null) {
			return false;
		}
		return key.length() == 32 && key.indexOf(".") == -1;
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
