package com.memory;

import org.openqa.selenium.WebDriver;

import com.reports.CustomReporter;

/**
 * @author hegde
 *
 */
public class MemoryFile {
	public static String curentPath;
	public static String executionStartTime;
	public static String parentResultpath;
	public static String excelPath;
	public static WebDriver driver;
	public static CustomReporter reporter;


	public static CustomReporter getReporter() {
		return reporter;
	}
	public static void setReporter(CustomReporter reporter) {
		MemoryFile.reporter = reporter;
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		MemoryFile.driver = driver;
	}
	public static String getCurentPath() {
		return curentPath;
	}
	public static void setCurentPath(String curentPath) {
		MemoryFile.curentPath = curentPath;
	}
	public static String getExecutionStartTime() {
		return executionStartTime;
	}
	public static void setExecutionStartTime(String executionStartTime) {
		MemoryFile.executionStartTime = executionStartTime;
	}
	public static String getParentResultpath() {
		return parentResultpath;
	}
	public static void setParentResultpath(String parentResultpath) {
		MemoryFile.parentResultpath = parentResultpath;
	}
	public static String getExcelPath() {
		return excelPath;
	}
	public static void setExcelPath(String excelPath) {
		MemoryFile.excelPath = excelPath;
	}

	

}
