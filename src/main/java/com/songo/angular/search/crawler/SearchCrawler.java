/**
 * 
 */
package com.songo.angular.search.crawler;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.songo.angular.file.FileWriter;
import com.songo.angular.file.PropertiesParser;
import com.songo.angular.utils.Constant;

/**
 * <p>decription:</p>
 * <p>date:2014年9月5日 下午4:06:43</p>
 * @author gsu·napoleon
 */
public class SearchCrawler {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public String crawlerWebContent(String url, String fileName) throws Exception {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		HttpClient httpClient = httpClientBuilder.build();
		HttpUriRequest httpReq = new HttpGet(url);
		HttpResponse httpResp = null;
		HttpEntity httpEntity = null;
		try {
			httpResp = httpClient.execute(httpReq);
			httpEntity = httpResp.getEntity();
			if (httpEntity != null) {
				InputStream is = httpEntity.getContent();
				StringWriter writer = new StringWriter();
				IOUtils.copy(is, writer, "UTF-8");
				writer.close();
				is.close();
				String result = writer.toString();
				logger.info("{}", result);
				PropertiesParser pp = new PropertiesParser();
				pp.load(Constant.CRAWLER_CONFIG.getKey());
				FileWriter.write(pp.get(Constant.CRAWLER_ORIGIN_DIRECTORY.getKey()), fileName, result);
				getAllHref(url, result);
				return result;
			}
		} catch (IOException e) {
			logger.error("获取网页内容时,发生异常,具体为：{}", e);
			return StringUtils.EMPTY;
		} finally {
			httpReq.abort();
			try {
				EntityUtils.consume(httpEntity);
			} catch (Exception e2) {
				
			}
		}
		return StringUtils.EMPTY;
	}
	
	public void getAllHref(String rootUrl, String data) {
		if (data == null) {
			return ;
		}
		Set<String> downloadHrefSets = new LinkedHashSet<String>();
		try {
			Document document = Jsoup.parse(data);
			Elements links = document.select("a[href]");
			addURLs(downloadHrefSets, links, rootUrl);
		} catch (Exception e) {
			
		}
	}
	
	private void addURLs(Set<String> sets, Elements eles, String rootUrl) {
		if (eles == null) {
			return;
		}
		
		if (sets == null) {
			sets = new LinkedHashSet<String>();
		}
		
		for (Element e : eles) {
			String title = e.attr("title");
			String text = e.childNode(0).attr("text");
			String name = StringUtils.isNotBlank(text) ? text : (StringUtils.isNotBlank(title) ? title : "未知");
			String href = e.attr("href");
			if (StringUtils.isNotBlank(href) && !href.startsWith("http://")) {
				href = rootUrl + href;
			}
			sets.add(href);
		}
	}
	
}
