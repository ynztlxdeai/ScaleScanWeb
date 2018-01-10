/**  
 * Project Name:filmbComm  
 * File Name:FileVO.java  
 * Package Name:com.filmb.comm.file.vo  
 * Date:2014年10月30日下午2:38:50  
 * Copyright (c) 2014  
 *  
*/
/**   
 * @projectName:filmbComm  
 * @packageName:com.filmb.comm.file.vo  
 * @className:FileVO.java  
 *   
 * @createTime:2014年10月30日-下午2:38:50  
 *  
 *    
 */

package com.moyansz.vo;

import java.io.File;

/**
 * @description:文件vo类
 * @fileName:FileVO.java
 * @createTime:2014年10月30日 下午2:38:50
 * @author:肖震
 * @version 1.0.0
 * 
 */
public class FileVO implements java.io.Serializable {
	private static final long serialVersionUID = -9140752601086601631L;
	// 操作是否成功，true表示成功，false表示失败
	private boolean isOK;
	// 组名
	private String groupName;
	// 文件原始名称
	private String olderFileName;
	// 上传后服务器上名称
	private String newFileName;
	// 文件大小
	private long fileSize;
	// 上传所用时间(ms)
	private long uploadTime;
	// 文件格式
	private String fileFormat;
	// 文件对象
	private File file;

	// 上传者id
	private Long uploadUserId;
	// 项目id
	private Integer ownerId;

	public FileVO() {

		super();

	}

	public FileVO(boolean isOK, String groupName, String olderFileName, String newFileName, long fileSize,
			long uploadTime, String fileFormat) {
		super();
		this.isOK = isOK;
		this.groupName = groupName;
		this.olderFileName = olderFileName;
		this.newFileName = newFileName;
		this.fileSize = fileSize;
		this.uploadTime = uploadTime;
		this.fileFormat = fileFormat;
	}

	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getOlderFileName() {
		return olderFileName;
	}

	public void setOlderFileName(String olderFileName) {
		this.olderFileName = olderFileName;
	}

	public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public long getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(long uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Long getUploadUserId() {
		return uploadUserId;
	}

	public void setUploadUserId(Long uploadUserId) {
		this.uploadUserId = uploadUserId;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

}
