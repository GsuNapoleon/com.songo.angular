/**
 * 
 */
package com.songo.spss.model;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Pattern;

/**
 * <p>decription:</p>
 * <p>date:2014年11月27日 上午11:44:44</p>
 * @author gsu·napoleon
 */
public class SearchEngine {

    public final static String[] EMPTY = new String[0];

    private int id;
    private String urlPattern;
    private String searchKey;
    private String encoding;
    private Pattern pattern;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
        pattern = Pattern.compile("^" + urlPattern);
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    //[0]：se的ID；[1]：keyword
    public String[] match(String url) {
        if (!pattern.matcher(url).find())
            return EMPTY;

        String[] result = new String[2];
        result[0] = String.valueOf(id);

        String[] items = url.split(searchKey, 2);

        String key = null;
        
        boolean isCheck = false; //用于判断是否能检查到默认编码 
        
        if (items.length < 2) {
            key = "unknown";
        } else {
            int stop = items[1].indexOf('&');
            if (stop != -1) {
                key = items[1].substring(0, stop);
            } else {
                key = items[1];
            }
            if(key.length() > 255){
                key = "unknown";
            }
        }
        //System.out.println("###########" + searchKey);
        String enc = encoding;
        /* 2011-02-14
         * 114search是ec=gb2312, youdao是ue=gbk
         * 
         * google: ie=gb2312/ie=utf-8
         * 
         * baidu: m.baidu.com; wap.baidu.com 为utf8, 其他为gbk
         */
        if (url.toUpperCase().indexOf("IE=GB") > 0 || 
        		//url.toUpperCase().indexOf("HL=ZH-CN") > 0 || 
        		url.toUpperCase().indexOf("EC=GB") > 0 || 
        		url.toUpperCase().indexOf("UE=GB") > 0 ||
        		url.toUpperCase().indexOf("EI=GB") > 0 ||
        		url.toUpperCase().indexOf("IE=GBK") > 0) {
        	enc = "gbk";
        	isCheck = true;
        }
        if (url.toUpperCase().indexOf("IE=UTF") > 0 || 
        		url.toUpperCase().indexOf("EC=UTF") > 0 || 
        		url.toUpperCase().indexOf("UE=UTF") > 0 ||
        		url.toUpperCase().indexOf("EI=UTF") > 0 ||
        		url.toUpperCase().indexOf("IE=UTF-8") >0) { 
        	enc = "utf-8";
        	isCheck = true;
        }
        if (url.toUpperCase().indexOf("IE=GB2312") > 0) {
        	enc = "gb2312";
        	isCheck = true;
        }
        
        try {
	        if(!isCheck) { //如果没有匹配，只能一个个编码试，gbk的url编码很可能重复，故最后才测试
	        	if(key.equals(URLEncoder.encode(URLDecoder.decode(key, "utf-8").toLowerCase().trim(), "utf-8"))){
	        		enc = "utf-8";
				} else if(key.equals(URLEncoder.encode(URLDecoder.decode(key, "gb2312").toLowerCase().trim(), "gb2312"))){
					enc = "gb2312";
				} else if(key.equals(URLEncoder.encode(URLDecoder.decode(key, "gbk").toLowerCase().trim(), "gbk"))) {
					enc = "gbk";
				}
	        } 
	        result[1] = URLDecoder.decode(key, enc).toLowerCase().trim();
        }catch (Exception e) {
            result[1] = "unknown";
        }
        return result;
    }

    public String[] matchQuick(String url) {
        if (!pattern.matcher(url).find())
            return EMPTY;

        String[] result = new String[2];
        result[0] = String.valueOf(id);

        return result;
    }

}
