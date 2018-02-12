package com.identity.e2e.utils;

public class FileDetails {
	
	String fileName;
	String fileMimeType;
	long fileSize;
	String fileExtension;

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileMimeType() {
		return fileMimeType;
	}
	public void setFileMimeType(String fileMimeType) {
		this.fileMimeType = fileMimeType;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long l) {
		this.fileSize = l;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	@Override
	public String toString() {
		return "FilesInfo[fileName=" + fileName + ", fileMimeType=" + fileMimeType+", fileSize=" + fileSize+",fileExtension=" + fileExtension+"]";
	}
}
