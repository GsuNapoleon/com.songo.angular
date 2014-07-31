/**
 * 
 */
package com.songo.angular.utils;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;

/**
 * <p>decription:</p>
 * <p>date:2014年7月7日 上午11:28:48</p>
 * @author gsu·napoleon
 */
public final class Tools {
	
	public static String formatWithMillis(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss,SSS");
    }

	public static String format(Date date) {
		if ( date == null) {
			return null;
		}
		
		return format(date, "yyyy-MM-dd");
	}

	public static String format(Date date, String pattern) {
        if ( date == null || StringUtils.isEmpty(pattern)) {
            return null;
        }
        
        return FastDateFormat.getInstance(pattern).format(date);
    }
    
    public static Date parse(String date, String pattern) throws ParseException {
    	if (StringUtils.isEmpty(date) || StringUtils.isEmpty(pattern)) {
    		return null;
    	}
    	return FastDateFormat.getInstance(pattern).parse(date);
    }
    
}
