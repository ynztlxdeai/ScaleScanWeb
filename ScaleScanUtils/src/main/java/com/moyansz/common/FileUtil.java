package com.moyansz.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * @Title: FileUtil.java
 * @Description：文件读取工具类
 * @author: wangpeng
 * @date： 2015-04-02 
 * @version 1.0
 */
public class FileUtil {
	private static Log LOG = LogFactory.getLog(FileUtil.class);
	/**
	 * @Description: 读取指定文件的内容
	 * @param filePath 文件目录
	 * @return String
	 * @throws
	 */
	public static String readFile(String filePath) {
		String fileContent = "";
		BufferedReader bufferedReader = null;
		try {
//			bufferedReader = new BufferedReader(new FileReader(filePath));
			bufferedReader = new BufferedReader(new InputStreamReader(FileUtil.class.getResourceAsStream(filePath)));
			String str;
			while((str = bufferedReader.readLine()) != null) {
				fileContent += str;
			}
			
		} catch (Exception e) {
			LOG.error("文件" + filePath + "读取失败:" + e.getMessage());
		} finally {
			if(bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					LOG.error("文件流" + filePath + "关闭失败:" + e.getMessage());
				}
			}
		}
		return fileContent;
	}
	
	 public static Iterator<?> findXMLForAll(String objName,String filePath){
		 Iterator<?> iterator = null;
         String realPath = FileUtil.class.getClassLoader().getResource("").getPath()+filePath;
         SAXReader reader = new SAXReader();
         File file = new File(realPath);
         try
	      {
			Document document = reader.read(file);
			Element root = document.getRootElement();// 得到根节点
		    iterator = root.elementIterator(objName);
		 }
		 catch (DocumentException e)
		 {
			 LOG.error(e);
		 }
         return iterator;
	 }

	public static String getPath(String uuidFileName , int level){
		int code = uuidFileName.hashCode();
		int dir = 0;
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < level; i++) {
			dir = code & 0xf;
			code = code >>> 4;
			if (i == level - 1){
				stringBuffer.append("/" + dir + "/");
			}else {
				stringBuffer.append("/" + dir);
			}
		}

		return stringBuffer.toString();
	}
}
