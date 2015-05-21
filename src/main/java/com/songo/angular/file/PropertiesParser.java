/**
 * 
 */
package com.songo.angular.file;

import java.io.IOException;
import java.util.Properties;

/**
 * <p>decription:</p>
 * <p>date:2014年9月11日 下午2:47:19</p>
 * @author gsu·napoleon
 */
public class PropertiesParser {

	private Properties properties = new Properties();
	
	public void load(String filename) throws IOException {
		properties.load(PropertiesParser.class.getClassLoader().getResourceAsStream(filename));
	}
	
	public void loads(String...filenames) throws IOException {
		if (filenames != null && filenames.length > 0) {
			for (String filename : filenames) {
				load(filename);
			}
		}
	}
	
	public String get(String key) {
		return properties.getProperty(key);
	}
	
}
