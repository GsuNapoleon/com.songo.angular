/**
 * 
 */
package com.songo.spss.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2014年11月27日 上午11:18:41
 * </p>
 * 
 * @author gsu·napoleon
 */
public class FilterUrlManager {

	public static List<Pattern> regularList = new ArrayList<Pattern>();
	public static List<String> notRegularList = new ArrayList<String>();
	public static Map<Object, List<Object>> refererMap = new HashMap<Object, List<Object>>();

	public List<Pattern> getRegularList() {
		return regularList;
	}

	public List<String> getNotRegularList() {
		return notRegularList;
	}

	// 加入url
	public static void addRegularUrl(String regex) {
		Pattern p = Pattern.compile("^" + regex);
		regularList.add(p);
	}

	public static void addNotRegularUrl(String url) {
		notRegularList.add(url);
	}

	public static void addRefererUrl(String referer, boolean referIsRegex,
			String url, boolean urlIsRegex) {
		if (StringUtils.isEmpty(referer))
			return;
		boolean newReferer = true;
		for (Map.Entry<Object, List<Object>> entry : refererMap.entrySet()) {
			if (referer.equals(entry.getKey().toString())) {
				newReferer = false;
				if (StringUtils.isNotEmpty(url)) {
					entry.getValue().add(
							urlIsRegex ? Pattern.compile("^" + url) : url);
				}
			}
		}
		if (newReferer) {
			List<Object> urlList = new ArrayList<Object>();
			if (StringUtils.isNotEmpty(url))
				urlList.add(urlIsRegex ? Pattern.compile("^" + url) : url);
			refererMap.put(referIsRegex ? Pattern.compile("^" + referer)
					: referer, urlList);
		}
	}

	public static void printReferer() {
		for (Map.Entry<Object, List<Object>> entry : refererMap.entrySet()) {
			Object key = entry.getKey();
			System.out.print(key.toString());
			if (key instanceof Pattern)
				System.out.print(" pattern");
			System.out.println();
			List<Object> values = entry.getValue();
			if (values != null) {
				for (Object value : values) {
					System.out.print("\t" + value.toString());
					if (value instanceof Pattern)
						System.out.print(" pattern");
					System.out.println();
				}
			}

		}
	}

	// 完全匹配
	public static boolean isFullMatch(String url) {
		if (notRegularList != null && notRegularList.size() > 0) {
			for (String ma : notRegularList) {
				if (ma.equals(url)) {
					return true;
				}
			}
		}
		return false;
	}

	// 正则匹配
	public static boolean isRegularMatch(String url) {
		if (regularList != null && regularList.size() > 0) {
			for (Pattern p : regularList) {
				if (p.matcher(url).find()) {
					return true;
				}
			}
		}
		return false;
	}

	// 是否两者匹配
	public static boolean isMatch(String url) {
		if (isFullMatch(url)) {
			return true;
		}
		return isRegularMatch(url);
	}

	// 是否匹配到referer表达式
	public static boolean isRefererMatch(String referer, String url) {
		if (StringUtils.isEmpty(referer))
			return false;
		if (refererMap != null && refererMap.size() > 0) {
			for (Map.Entry<Object, List<Object>> entry : refererMap.entrySet()) {
				if (checkRefererRegex(referer, entry.getKey())) {
					if (entry.getValue().size() == 0)
						return true;
					if (StringUtils.isEmpty(url))
						return false;
					for (Object value : entry.getValue()) {
						if (checkRefererRegex(url, value))
							return true;
					}
					return false;
				}
			}
		}
		return false;
	}

	// 检查是不是匹配了上指定的表达式，URL或是正则
	private static boolean checkRefererRegex(String url, Object pattern) {
		if (StringUtils.isEmpty(url) || pattern == null)
			return false;
		if (pattern instanceof Pattern) {
			Pattern _pattern = (Pattern) pattern;
			if (_pattern.matcher(url).find()) {
				return true;
			}
		} else if (pattern instanceof String) {
			if (url.equals(pattern))
				return true;
		}
		return false;
	}

}
