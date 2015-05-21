/**
 * 
 */
package com.songo.spss.parse;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.apache.commons.lang3.StringUtils;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

/**
 * <p>decription:</p>
 * <p>date:2014年11月26日 上午9:12:51</p>
 * @author gsu·napoleon
 */
public class ReaderZipFile {
	
	private String directory;
	private String prefix;
	
	public ReaderZipFile() {}
	
	public ReaderZipFile(String directory, String prefix) {
		this.directory = directory;
		this.prefix = prefix;
	}
	
	@SuppressWarnings("unchecked")
	public void run() {
		
		Disruptor<KillFileEvent> disruptor = new Disruptor<KillFileEvent>(
				new ReaderEventFactory(), 8, Executors.newCachedThreadPool());
		
		EventHandler<KillFileEvent> fileReaderEventHandler = new ReaderEventHandler();
		
		disruptor.handleEventsWith(fileReaderEventHandler);
		disruptor.start();
		
		RingBuffer<KillFileEvent> ringBuffer = disruptor.getRingBuffer();
		ReaderEventProducer producer = new ReaderEventProducer(ringBuffer);
		
		File [] srcFiles = getFiles();
		try {
			for (File srcFile : srcFiles) {
				producer.producer(srcFile);
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void reader(File srcFile) {
		ZipFile zf = null;
		InputStream is = null;
		ZipInputStream zis = null;
		try {
			zf = new ZipFile(srcFile);
			is = new BufferedInputStream(new FileInputStream(srcFile));
			zis = new ZipInputStream(is);
			killConcrete(zf, zis);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeKill(zf, is, zis);
		}
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2014年11月27日 下午5:10:52</p>
	 * @author gsu·napoleon
	 * @param zf
	 * @param zis
	 * @throws IOException
	 */
	private void killConcrete(ZipFile zf, ZipInputStream zis)
			throws IOException {
		ZipEntry ze = null;
		while ((ze = zis.getNextEntry()) != null) {
			if (ze.isDirectory()) {
				continue;
			}
			if (ze.getSize() <= 0) {
				continue;
			}
			String line;
			BufferedReader br = new BufferedReader(new InputStreamReader(zf.getInputStream(ze)));
			try {
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			}finally {
				br.close();
			}
		}
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2014年11月27日 下午5:09:54</p>
	 * @author gsu·napoleon
	 * @param zf
	 * @param is
	 * @param zis
	 */
	private void closeKill(ZipFile zf, InputStream is, ZipInputStream zis) {
		try {
			if (zf != null) {
				zf.close();
			}
			if (is != null) {
				is.close();
			}
			if (zis != null) {
				zis.close();
			}
		} catch(Exception e) {
			
		}
	}

	public File [] getFiles() {
		File file = getDirectory();
		File [] files = file.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return isFilenameStartsWithPrefix(name);
			}

		});
		return files;
	}
	
	public String [] getFilenames() {
		File file = getDirectory();
		String [] fileNames = file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return isFilenameStartsWithPrefix(name);
			}
		});
		return fileNames;
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2014年11月26日 上午11:01:40</p>
	 * @author gsu·napoleon
	 * @return
	 */
	private File getDirectory() {
		if (StringUtils.isBlank(directory) || StringUtils.isBlank(prefix)) {
			return null;
		}
		File file = new File(directory + prefix);
		if (!file.isDirectory()) {
			return null;
		}
		return file;
	}
	
	/**
	 * <p>decription:</p>
	 * <p>date:2014年11月26日 上午11:10:45</p>
	 * @author gsu·napoleon
	 * @param name
	 * @return
	 */
	private boolean isFilenameStartsWithPrefix(String name) {
		return name.startsWith(prefix);
	}
	
}
