/**
 * 
 */
package com.songo.spss;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.songo.spss.parse.ReaderZipFile;

/**
 * <p>decription:</p>
 * <p>date:2014年11月26日 上午9:25:33</p>
 * @author gsu·napoleon
 */
public class ReaderZipFileTest {
	
	private ReaderZipFile reader;
	private static final String DIRECTORY = "D:\\DevelopmentEnvironment\\spss\\lady\\";
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * <p>decription:</p>
	 * <p>date:2014年11月26日 上午9:25:33</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		reader = new ReaderZipFile(DIRECTORY, "20141115");
	}

	/**
	 * Test method for {@link com.songo.spss.parse.ReaderZipFile#getFiles(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetFiles() {
		File [] files = reader.getFiles();
		
		testParseZipFile(files);
		
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2014年11月27日 上午9:59:09</p>
	 * @author gsu·napoleon
	 * @param files
	 */
	private void testParseZipFile(File[] files) {
		ZipFile zf = null;
		InputStream is = null;
		ZipInputStream zis = null;
		try {
			File file = files[0];
			zf = new ZipFile(file);
			is = new BufferedInputStream(new FileInputStream(file));
			zis = new ZipInputStream(is);
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
						logger.info(line);
					}
				}finally {
					br.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	}

}
