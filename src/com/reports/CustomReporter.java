package com.reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.excelOpertion.ExcelLibrary;
import com.generic.GenericWebDriverFunctions;
import com.memory.MemoryFile;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomReporter {

	static ExtentReports object;
	public static String category;
	public static String subCategory;
	
	public static Stack<String> childInfoDesc=null;
	
	public static Stack<String> childTitle =null;

	public static Stack<String> childLogStatus = null;
	public static Stack<String> childLogDesc = null;
	public static List<ExtentTest> allChild=null;
	
	public static String parentTitle;
	public static String parentDesc;
	
	public static String parentLogStatus;
	public static String parentLogDesc;
	
	static {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd h:mm a");
		String formattedDate = sdf.format(date);
	
	
		System.out.println(formattedDate);
		
		String str="Report_"+date.getDay()+"day"+date.getMonth()+"month"+date.getHours()+"hrs"+date.getMinutes()+"min";
		object = new ExtentReports(MemoryFile.getParentResultpath()+File.separator+str+".html", true);
		
	}
	public static ExtentTest parent;
	public static ExtentTest child;
	public static String currentTestCase=null;
	public static String userType=" Guest User ";
  
	public CustomReporter()
	{
//		childInfoDesc=new Stack<String>();
//		childTitle =new Stack<String>();
//		childLogStatus = new Stack<String>();
//		childLogDesc = new Stack<String>();
		
		allChild = new ArrayList<ExtentTest>();
	}
	 
	public static void startParent(String scenarioName,String description)
	{   
//		ExcelLibrary exe=new ExcelLibrary(System.getProperty("user.dir")+"\\Bealls_Execution_Excel.xlsx");
//		
	//nvnvnvnvn
	//String Environment=(String) exe.getCellData("TestData", 1, 1);
		//String Browser=(String) exe.getCellData("TestData", 11, 1);
		String Browser="Chrome";
	   // object.addSystemInfo("Environvent:",TestClass.URLMain );
	    object.addSystemInfo("Browser:",Browser );
	   
	    object.addSystemInfo("Host Name","10.200.9.80" );
	    
		parent = object.startTest(scenarioName, description);	
	}
	
	
	public static void startChild(String testName,String description)
	{
		child = object.startTest(testName, description);
	}
	
	public static void reportParent(String status,String description)
	{
	
		if(status.equalsIgnoreCase("PASS"))
		parent.log(LogStatus.PASS, description);
		else
		if(status.equalsIgnoreCase("FAIL"))
		parent.log(LogStatus.FAIL, description);
		else
		parent.log(LogStatus.SKIP,description);
		
	}
	
	
	
	public static void reportChild(String status,String description )
	{
		
		if(status.equalsIgnoreCase("PASS"))
		child.log(LogStatus.PASS, description);
		else
		if(status.equalsIgnoreCase("FAIL"))
		{
		child.log(LogStatus.FAIL, description);
		 
		}
		else
		child.log(LogStatus.SKIP,description);
		
	}
	
	public static void childCategory(String category)
	{
		child.assignCategory(category);
	}

	public static void endChildTest()
	{
		object.endTest(child);
		addChild(child);
		
	}
	public static  void endParentTest()
	{
		object.endTest(parent);
	}
	
	public static void end()
	{
		object.flush();
	}
	
	
	
	public static void addChildInfo(String description)
	{
		child.log(LogStatus.INFO,description);
	}
	
	public static void addParentInfo(String description)
	{
		parent.log(LogStatus.INFO,description);
	}
	
	
	public static void generateReport()
	{
		
		
		
		for(int childTitleCounter =0;childTitleCounter<CustomReporter.childTitle.size();childTitleCounter++)
		{
			
		startChild(childTitle.pop(),"");
		for(int info =0;info<childInfoDesc.size();info++)
		{
		addChildInfo(childInfoDesc.pop());
		}
		
		if(!childLogStatus.isEmpty())
		reportChild(childLogStatus.pop(),childLogDesc.pop());
		
	
		
		endChildTest();
	    //CustomReporter.addChild(child);
		}
		reportParent(parentLogStatus, parentLogDesc);
		endParentTest();
	    end();
	}
	
	
	public static void addChild(ExtentTest test)
	{
	allChild.add(test);	
	}
	
	public static void appendChild(ExtentTest parent)
	{
		for(int i=0;i<allChild.size();i++)
		{
			parent.appendChild(allChild.get(i));
		}
	}
	
	public static void addScreenShot(String path){
		child.log(LogStatus.INFO, "Snapshot below: " + child.addScreenCapture(path));
		
	}
	
	public static void addScreenShotCustom(String imgName) throws IOException{
		File scrFile = ((TakesScreenshot)GenericWebDriverFunctions.driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\utility\\ScreenShots\\"+imgName+".png"));
		child.log(LogStatus.INFO, "Snapshot below: " + child.addScreenCapture(System.getProperty("user.dir")+"\\utility\\ScreenShots\\"+imgName+".png"));
		
	}
}
