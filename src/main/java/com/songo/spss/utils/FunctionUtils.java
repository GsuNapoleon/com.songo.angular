/**
 * 
 */
package com.songo.spss.utils;

import com.songo.spss.model.SourceDetail;
import com.songo.spss.model.Task;

/**
 * <p>decription:</p>
 * <p>date:2014年11月27日 上午11:48:52</p>
 * @author gsu·napoleon
 */
public class FunctionUtils {


	public static String getCompletedFile(String folder, Task task) {
		return SourceDetail.getSourceFolder(folder, task) + task.getId() + ".out";
	}

	public static String getDomain(String url) {
		if (url == null || contains(url, "(", ")", "<", ">")) {
			return "N/A";
		}
		url = url.replaceAll("http://", "");
		int index = url.indexOf("/");
		if (index == -1) {
			index = url.indexOf("?");
		}
		if (index > 0) {
			url = url.substring(0, index);
		}
		return url.trim().toLowerCase();
	}

	private static boolean contains(String src, String... args) {
		boolean result = false;
		for (String arg : args) {
			if (src.indexOf(arg) > 0) {
				result = true;
				break;
			}
		}
		return result;
	}

}
