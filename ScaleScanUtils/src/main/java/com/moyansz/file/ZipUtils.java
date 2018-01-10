package com.moyansz.file;


import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipUtils {

	public static void unZip(String zipPath,String path) throws IOException {
		File zipFile = new File(zipPath);
		File file = new File(path);
		
		unZip(zipFile, file);
	}

	public static void unZip(File zipFile, File file) throws IOException {
		InputStream is = new FileInputStream(zipFile);
		OutputStream os = new FileOutputStream(file);
		unZip(is, os);
	}

	public static void unZip(InputStream is, OutputStream os) throws IOException {
		byte[] buffer = new byte[8192];
		int len = -1;
		System.out.println(is);
		GZIPInputStream gzis = new GZIPInputStream(is);
		try {
			while ((len = gzis.read(buffer)) != -1) {
				os.write(buffer, 0, len);
				os.flush();
			} 
		} finally {
			closeIO(gzis);
			closeIO(os);
		}
	}

	public static void zip(String path, String zipPath) throws IOException {
		File file = new File(path);
		System.out.println(path);
		File zipFile = new File(zipPath);
		System.out.println(zipPath);
		zip(file, zipFile);
	}

	public static void zip(File file, File zipFile) throws IOException {
		InputStream is = new FileInputStream(file);
		OutputStream os = new FileOutputStream(zipFile);
		zip(is, os);
	}

	public static void zip(InputStream is, OutputStream os) throws IOException {
		byte[] buffer = new byte[8192];
		int len = -1;
		GZIPOutputStream gzos = new GZIPOutputStream(os);
		try {
			while ((len = is.read(buffer)) != -1) {
				gzos.write(buffer, 0, len);
				gzos.flush();
			}
		} finally {
			closeIO(is);
			closeIO(gzos);
		}
	}

	public static void closeIO(Closeable io) throws IOException {
		if (io != null) {
			io.close();
		}
	}

	public static void unZip(InputStream inputStream, File jsonFile) throws IOException{
		OutputStream os = new FileOutputStream(jsonFile);
		unZip(inputStream, os);
	}

	/**
	 * 功能:压缩多个文件成一个zip文件
	 * @param srcfile：源文件列表
	 * @param zipfile：压缩后的文件
	 */
	public static void zipFiles(File[] srcfile, File zipfile) {
		byte[] buf = new byte[1024];
		ZipOutputStream out = null;
		FileInputStream in = null;
		try {
			//ZipOutputStream类：完成文件或文件夹的压缩
			out = new ZipOutputStream(new FileOutputStream(zipfile));
			for (int i = 0; i < srcfile.length; i++) {
				in = new FileInputStream(srcfile[i]);
				out.putNextEntry(new ZipEntry(srcfile[i].getName()));
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				out.closeEntry();
				in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeIO(out);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 功能:解压缩
	 * @param zipfile：需要解压缩的文件
	 * @param descDir：解压后的目标目录
	 */
	public static void unZipFiles(File zipfile, String descDir) {
		if (!zipfile.exists()){
			return;
		}
		InputStream in = null;
		OutputStream out =null;
		ZipFile zf = null;
		try {
			zf = new ZipFile(zipfile);
			for (Enumeration entries = zf.entries(); entries.hasMoreElements();) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				String zipEntryName = entry.getName();
				in = zf.getInputStream(entry);
				out = new FileOutputStream(new File(descDir , zipEntryName));
				byte[] buf1 = new byte[1024];
				int len;
				while ((len = in.read(buf1)) > 0) {
					out.write(buf1, 0, len);
				}
				out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (zf != null){
					zf.close();
				}
				closeIO(in);
				closeIO(out);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}




