/**
 * 
 */
package com.songo.angular.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.songo.angular.utils.Constant;

/**
 * <p>decription:</p>
 * <p>date:2014年9月11日 下午2:31:38</p>
 * @author gsu·napoleon
 */
public class FileWriter {
	
	private static final Logger logger = LoggerFactory.getLogger(FileWriter.class);
	
	public static void write(String filePath, String directory, String data) {
		write(filePath, directory, data, Constant.ENCODING_UTF8.getKey(), false);
	}
	
	public static void write(String filePath, String directory, String data, boolean append) {
		write(filePath, directory, data, Constant.ENCODING_UTF8.getKey(), append);
	}
	
	public static void write(String filePath, String directory, String data, String encoding) {
		write(filePath, directory, data, encoding, false);
	}
	
	public static void write(String filePath, String directory, String data, String encoding, boolean append) {
		try {
			File file = new File(filePath + File.separator + directory); 
			if (!file.exists() || !file.isDirectory()) {
				file.mkdir();
			}
			String pathname = file.getPath() + File.separator + UUID.randomUUID() + Constant.CRAWLER_FILE_SUFFIX.getKey();
			logger.info("爬虫保存的文件路径及名称：{}", pathname);
			FileUtils.write(new File(pathname), data, encoding, append);
		} catch (IOException e) {
			logger.warn("写入文件失败, {}", e);
		}
	}

	public static void selfWrite(String filePath, String fileName, byte [] contentBytes) {
		
		File file = new File(filePath + File.separator + fileName);
		
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "rw");
			FileChannel channel = raf.getChannel();
			ByteBuffer srcBuffer = ByteBuffer.allocate(1024);
			srcBuffer.put(contentBytes);
			srcBuffer.flip();
			
			channel.write(srcBuffer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (raf != null) {
					raf.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
