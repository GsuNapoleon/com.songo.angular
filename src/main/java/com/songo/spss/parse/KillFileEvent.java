/**
 * 
 */
package com.songo.spss.parse;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.songo.spss.request.Request;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2014年11月26日 上午10:09:19
 * </p>
 * 
 * @author gsu·napoleon
 */
public class KillFileEvent {

	private File srcFile;

	private Request request;
	
	public void kill() {
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
	 * <p>date:2014年11月27日 下午4:10:43</p>
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

	/**
	 * <p>decription:</p>
	 * <p>date:2014年11月27日 上午10:00:34</p>
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
					Request req = Request.getInstance(line);
					
				}
			}finally {
				br.close();
			}
		}
	}
	
	/**
	 * @param srcFile
	 *            the srcFile to set
	 */
	public void setSrcFile(File srcFile) {
		this.srcFile = srcFile;
	}

	/**
	 * @return the request
	 */
	public Request getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(Request request) {
		this.request = request;
	}

}
