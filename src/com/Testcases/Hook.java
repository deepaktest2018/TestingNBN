package com.Testcases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.excelOpertion.ExcelLibrary;
import com.generic.GenericWebDriverFunctions;
import com.memory.MemoryFile;
import com.pages.LoginPage;
import com.reports.CustomReporter;
import com.videorecording.VideoRecord;

public class Hook{
	public static WebDriver driver =null;
	public static VideoRecord recorder= null;
	CustomReporter reporter = null;
	
	public Hook() {
		// TODO Auto-generated constructor stub		
		MemoryFile.setCurentPath(System.getProperty("user.dir"));
		MemoryFile.setExecutionStartTime(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
		MemoryFile.setParentResultpath(MemoryFile.getCurentPath()+"\\Result\\"+MemoryFile.getExecutionStartTime());
		new File(MemoryFile.getParentResultpath()).mkdirs();	
		
	}
	
	@BeforeTest
	public void init()
	{
	reporter = new CustomReporter();
	MemoryFile.setReporter(reporter);
	}
	@AfterTest
	public void AfterTest()
	{
		reporter.end();
	
	}
	@BeforeMethod
	public static void beforeTest() throws Exception{
		System.out.println("Before test");
		recorder=new VideoRecord();
		recorder.startRecording();		
		System.setProperty("webdriver.chrome.driver", MemoryFile.getCurentPath()+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		MemoryFile.setDriver(driver);
		GenericWebDriverFunctions.BeforeNextTestCase();	
		}
	
	@AfterTest
	public static void afterTest() throws Exception{	
		System.out.println("AFTER test");
		recorder.stopRecording();
		//GenericWebDriverFunctions.stopServer();
	}
	
	

	
	

}
