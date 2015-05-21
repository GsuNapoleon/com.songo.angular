/**
 * 
 */
package com.songo.spss.model;

/**
 * <p>decription:</p>
 * <p>date:2014年11月27日 上午11:05:30</p>
 * @author gsu·napoleon
 */
public class Task {

	private String id;
	private java.sql.Date date;
	private int hour;
	private int minute;
	private int year;
	private int day;
	private int ym;
	private int ymd;
	private int ymdh;

	public Task(String id) {
		this.id = id;
		int length = id.length();
		date = java.sql.Date.valueOf(id.substring(0, 4)
				+ "-" + id.substring(4, 6) + "-" + id.substring(6, 8));
		year = Integer.parseInt(id.substring(0, 4));
		day = Integer.parseInt(id.substring(6, 8));
		ym = Integer.parseInt(id.substring(0, 6));
		ymd = Integer.parseInt(id.substring(0, 8));
		if (length >= 10) {
			hour = Integer.parseInt(id.substring(8, 10));
			ymdh = Integer.parseInt(id.substring(0, 10));
		}
		if (length >= 12) {
			minute = Integer.parseInt(id.substring(10, 12));
		}
	}

	public java.sql.Date getDate() {
		return date;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public String getId() {
		return id;
	}

	public int getYear() {
		return year;
	}

	public int getDay() {
		return day;
	}

	/**
	 * 得到年月
	 *
	 * @return
	 */
	public int getYm() {
		return ym;
	}

	/**
	 * 得到年月日
	 *
	 * @return
	 */
	public int getYmd() {
		return ymd;
	}

	/**
	 * 得到年月日
	 *
	 * @return
	 */
	public int getYmdh() {
		return ymdh;
	}

}
