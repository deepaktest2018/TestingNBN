package com.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.memory.MemoryFile;
import com.videorecording.VideoRecord;

//import com.Pages.AllBealls.PopUpPage;
//import com.constants.string.StringConstants;
//import com.exceptions.custom.CustomException;

public class GenericWebDriverFunctions {	
	public static WebElement element = null;
	public static String getText=null;
	public static WebDriverWait wait= null;
	public static WebDriver driver = null;

	public static void BeforeNextTestCase(){
		driver=MemoryFile.getDriver();
	}
	
	/**
	 * loadDriver function loads a 
	 * specified driver before launching 
	 * the a browser.
	 * It takes 1 parameter driverName,
	 * and finds an appropriate match 
	 * from the properties and launches it. 
	 * 
	 * @param driverName
	 */
//	public static void loadDriver(String driverName) {
//		switch (driverName.toLowerCase()) {
//		case StringConstants.CHROME:
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
//			driver = new ChromeDriver();
//			
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//			break;
//		case StringConstants.IE:
//			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
//			driver = new InternetExplorerDriver();
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//			break;
//		case StringConstants.FIREFOX:
//			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//			break;
//		default:
//			try {
//				throw new CustomException("Invalid driver");
//			} catch (CustomException e) {
//				e.getErrorMessage();
//			}
//			break;
//		}
//	}
//
//	/**
//	 * startServer feeds the specified URL in the browser launched.
//	 * It takes 1 parameter environmentURL.
//	 * @param environmentURL
//	 */
//	public static void startServer(String environmentURL) {
//		driver.get(environmentURL);
//	}
//	
//	/**
//	 * performAction performs specified browser actions with/without data.
//	 * The actions include all generic WebDriver function viz mouseClick,
//	 * buttonClick,sendKeys etc. It takes 3 parameters actionName,
//	 * element and data.
//	 * @param actionName
//	 * @param element
//	 * @param data
//	 */
//	public static void performAction(String actionName, WebElement element,	String data) {
//		 
//		getText =null;
//		Select option= null;
//		wait = new WebDriverWait(driver, 12);
//		try
//		{
//		switch (actionName.toLowerCase()) {
//
//		case StringConstants.CLICK:
//			element=wait.until(ExpectedConditions.visibilityOf(element));
//			 element.click();
//			break;
//		case StringConstants.SENDKEYS:
//			element=wait.until(ExpectedConditions.visibilityOf(element));
//		 element.sendKeys(data);
//			break;
//		case StringConstants.SUBMIT:
//			element=wait.until(ExpectedConditions.visibilityOf(element));
//			 element.submit();
//			break;
//		case StringConstants.SELECTBYVT:
//			element=wait.until(ExpectedConditions.visibilityOf(element));
//			 option= new Select( element);
//			 option.selectByVisibleText(data);	 
//			break;
//		case StringConstants.SELECTVALUE:
//			element=wait.until(ExpectedConditions.visibilityOf(element));
//			 option= new Select(element);
//			 
//			 try
//			 {
//				 option.selectByValue(data);
//			 }
//			 catch(Exception e)
//			 {
//			 	 option.selectByIndex(1);
//			 }
//			break;
//		case StringConstants.SELECTINDEX:
//			element=wait.until(ExpectedConditions.visibilityOf(element));
//			option = new Select(element);
//			option.selectByIndex(Integer.parseInt(data));
//			break;
//		case StringConstants.MOUSEOVER:
//			Actions builder = new Actions(driver);
//			element=wait.until(ExpectedConditions.visibilityOf(element));
//			Action mouseOver = builder.moveToElement(element).build();
//			mouseOver.perform();
//			break;
//		case StringConstants.GETTEXT:
//			element=wait.until(ExpectedConditions.visibilityOf(element));
//			  getText=element.getText();
//			  break;
//		case StringConstants.CLEAR:
//			element = wait.until(ExpectedConditions.visibilityOf(element));
//			  element.clear();
//			  break;
//		case StringConstants.GETATTRIBS:
//			element = wait.until(ExpectedConditions.visibilityOf(element));
//			GenericWebDriverFunctions.getText=element.getAttribute(data);
//		break;
//		default:
//			try {
//				throw new CustomException("Invalid action name");
//			} catch (CustomException e) {
//				e.getErrorMessage();
//			}
//		}
//	}
//		catch(WebDriverException | NullPointerException exception)
//		{
//	 	 System.out.println(exception.getLocalizedMessage());
//			PopUpPage pup = new PopUpPage();
//			
//			if(PopUpPage.popUp!=null && GenericWebDriverFunctions.findPopUpBy(StringConstants.POPUP)>0)
//			{ 
//			 PopUpPage.closePopUp();
//			 GenericWebDriverFunctions.scrollToElement(element);
//			 GenericWebDriverFunctions.performAction(actionName, element, data);
//			}
//		}
//	}
	
	public static void ClickOnElement(By element){
		driver.findElement(element).click();
	}
	
	public static void EnterValueToTextBox(By element, String value){
		driver.findElement(element).sendKeys(value);
	}
	public static void BrowserMaximize(){
		driver.manage().window().maximize();
	}
	
	public static String GetPageTitele(){
		return driver.getTitle();
	}	
	
	public static void MouserOverononElement(By locator){
		element=driver.findElement(locator);
		Actions action = new Actions(driver);
		 
	    action.moveToElement(element).build().perform();
	}

	/**
	 * stopServer quits the WebBroser.
	 */
	public static void stopServer() {
		driver.quit();
	}
	
	/**
	 * isDisplayed checks whether a specified element is displayed 
	 * or not. It takes element as parameter and returns a boolean status.
	 * @param element
	 * @return
	 */
	public static boolean isDisplayed(WebElement element)
	{
		wait = new WebDriverWait(driver, 25);
		element=wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
		
	}
	/**
	 * getElementByLinkText returns a web element with specified link text.
	 * It takes 1 parameter linText and returns the identified element. 
	 * @param linkText
	 * @return
	 */
	public static WebElement getElementByLinkText(String linkText)
	{
		WebElement element=null;
		try
		{
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(linkText))));
		element=driver.findElement(By.linkText(linkText));
		}
		catch(WebDriverException e)
		{
			e.printStackTrace();
		}
		return element;
	}
	
	
	/**
	 * scrollToElement will perform a scroll to the element specified.
	 * It takes 1 parameter element and scrolls to its position.
	 * @param element
	 */
	public static void scrollToElement(WebElement element)
	{
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	/**
	 * findElementsBy finds the element by locator and returns that element. 
	 * It takes 1 parameter locatorString finds the element and returns it.
	 * @param locatorString
	 * @return
	 */
	public static WebElement findElementsBy(String locatorString)
	{
		if(driver.findElements(By.xpath(locatorString)).size()>0)
		{
			return driver.findElements(By.xpath(locatorString)).get(0);
		}
			else
			{
				return null;
			}
	}
	
	/**
	 * findElementByLinkText returns the element by finding the link text.
	 * It takes 1 parameter linkText and returns the element found.
	 * @param linkText
	 * @return
	 */
	public static WebElement findElementByLinkText(String linkText)
	{
		wait = new WebDriverWait(driver, 8);
		return wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.linkText(linkText))));
	}
	/**
	 * findPopUpBy checks whether pop up is displayed or not.
	 * It takes 1 parameter locatorString and returns the count.
	 * @param locatorString
	 * @return
	 */
	public static int findPopUpBy(String locatorString)
	{
		return driver.findElements(By.className(locatorString)).size();
	}
	/**
	 * findElementsByXpath checks whether there are elements available by provided
	 * locator. It takes 1 parameter locator and returns count.
	 * @param locator
	 * @return
	 */
	public static int findElementsByXpath(String locator)
	{
		return driver.findElements(By.xpath(locator)).size();
	}
	
	/**
	 * isClickable check whether the element is click able or not.
	 * It takes 1 parameter and returns boolean status.
	 * @param element
	 * @return
	 */
	public static boolean isClickable(WebElement element){
	  	       try {
	       	      	 WebDriverWait wait = new WebDriverWait(driver, 19);
		       	      wait.until(ExpectedConditions.elementToBeClickable(element));
	          return true;
	        } catch(Exception e){
	          return false;
	       }
	}
	
	public static void clearInputFiled() throws InterruptedException, AWTException
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(600);
		r.keyPress(KeyEvent.VK_A);
		Thread.sleep(3200);
		r.keyPress(KeyEvent.VK_DELETE);
		Thread.sleep(200);
		r.keyRelease(KeyEvent.VK_DELETE);
		r.keyRelease(KeyEvent.VK_CONTROL);
//		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_A);
//		Thread.sleep(3000);
	}
		
	public static List<WebElement> getElementByXpath(String xpath)
	{	
		 List<WebElement> elements=null;
		return elements =driver.findElements(By.xpath(xpath));
	}

	public static void deleteAllCookies()
	{
		driver.manage().deleteAllCookies();
	}
	
	public static void beforeCapture()
	{
//		PopUpPage pup = new PopUpPage();
//		
//		if(PopUpPage.popUp!=null && GenericWebDriverFunctions.findPopUpBy(StringConstants.POPUP)>0)
//		{ 
//		 PopUpPage.closePopUp();
//	 	}
	}
	
	public static String capture(WebElement element,String path,String fileName)
	{
     	beforeCapture();
		String filePath=null;
		//Get entire page screenshot
		try
		{
			File screenshot = ((TakesScreenshot)GenericWebDriverFunctions.driver).getScreenshotAs(OutputType.FILE);
			BufferedImage  fullImg = ImageIO.read(screenshot);
		//Get the location of element on the page
		Point point = element.getLocation();
		//Get width and height of the element
		int eleWidth = element.getSize().getWidth();
		int eleHeight = element.getSize().getHeight();
		//Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);
		//Copy the element screenshot to disk
		File screenshotLocation = new File(path+"\\"+fileName);
		FileUtils.copyFile(screenshot, screenshotLocation);
		filePath = screenshotLocation.getAbsolutePath();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filePath;
	}
	
	/**
	 *Shippingflag=0  //Initialization 
	 *		      =1  //Proper shipping Charge
	 *			  =2  //Improper Shipping Charge
	 */
	public static int Shippingflag=0;
	public static String parentReportName;
	public static String parentReportDescription;
	public static boolean parentReportsettingFlag=true;   //you can set the flag
	
	
	
	/**
	 *EstimatedTotalflag=0  //Initialization 
	 *		      =1  //Proper Estimated Total
	 *			  =2  //Improper Estimated Total
	 */
	public static int EstimatedTotalflag=0;
	
	
	public static boolean ElementVisibility(List <WebElement> element){
		boolean status=false;
		//if element is visible
		if(element.size() != 0){
			status=true;
    		}
		
		return status;
	}
	
	public static double StringToDoubleConvertor(String PriceInDollar){
		String str=" "+PriceInDollar;
	    String OfferPrice1[]=str.split("\\$");
	    double subtotal=Double.parseDouble(OfferPrice1[1]);
	    
		return subtotal;
		
	}
		
		public static boolean NumberComparer(Double a,Double b){
			
			boolean status=false;
			double roundOffA = Math.round(a*100)/100;
			double roundOffB = Math.round(b*100)/100;
			System.out.println("roundOffA:"+roundOffA+"    "+"roundOffB:"+roundOffB);
			if(roundOffA==roundOffB){
				System.out.println("No. are equal");
				status=true;
			}else{
				System.out.println("No. are not equal");
			}
			return status;
			
		}
		
		public static boolean NumberComparerModified(double a,double b){
			
			boolean status=false;
			//double CalculatedTotalpriceOther = (int)Math.round(CalculatedTotalprice * 100)/(double)100;
			double roundOffA = (int)Math.round(a * 100)/(double)100;            
			double roundOffB = (int)Math.round(b * 100)/(double)100; 
			System.out.println("roundOffA:"+roundOffA+"    "+"roundOffB:"+roundOffB);
			if(roundOffA==roundOffB){
				System.out.println("No. are equal");
				status=true;
			}else{
				System.out.println("No. are not equal");
			}
			return status;
			
		}
		
		
		
		public static String[] Split(String str) {

			String[] tokens = str.split("[\\s']");
			return tokens;
		}
		
		
		public static StringBuffer Concatenation(StringBuffer s,String str){
			  
		      s = s.append(str);
		      //System.out.println(s);
			return s;

		}	
		
	   public static Double ExtractdoublefromString(String stringToStrip){
		   
		 //  String stringToStrip="radius: -0.118211 zone";
		   String stripedValue = (stringToStrip.replaceAll("[\\s+a-zA-Z :]",""));
		   double dbl = Double.parseDouble(stripedValue);
		   System.out.println(dbl);
		return null;
		   
	   }
	   
		public static List<Double> PriceRangeStringTodouble(String str){
			String strr[]=str.split("\\$");
			List<Double> li=new ArrayList<Double>();
			for (int i = 0; i < strr.length; i++) {
				//System.out.println("Range:"+i+")"+strr[i].replace("-", ""));
				try {
					Double dou=Double.valueOf(strr[i].replace("-", ""));
					//System.out.println("Double:"+dou);
					li.add(dou);
				} catch (Exception e) {
					// TODO: handle exception
				}
				//System.out.println("---------------------------------");
			}
			
			return li;
			
		}
		
		public static List quantityPriceValidator(String eachItemPrice,String qty,String totalprice){
			boolean status=false;
			List li=new ArrayList();
			double EachItemPrice=StringToDoubleConvertor(eachItemPrice);
			System.out.println("-->"+EachItemPrice);
			double Qty=Double.parseDouble(qty);
			double CalculatedTotalprice=EachItemPrice*Qty;
			System.out.println("Calculated Total Price:"+CalculatedTotalprice);
			
			double ObtainedTotalPrice=StringToDoubleConvertor(totalprice);
			System.out.println("Obtained Total Price:"+ObtainedTotalPrice);
			/*if(GenericFunctionsExtra.NumberComparer(CalculatedTotalprice, ObtainedTotalPrice)){
				status=true;
			}*/
			//double CalculatedTotalpriceOther=Math.round(CalculatedTotalprice*100)/100;
			 double CalculatedTotalpriceOther = (int)Math.round(CalculatedTotalprice * 100)/(double)100;
			if(CalculatedTotalpriceOther==ObtainedTotalPrice){
				status=true;	
			}
			li.add(status);
			li.add(CalculatedTotalpriceOther);
			return li;	
		}
		
		public static void imgCapture(String imgName) throws IOException{
			File scrFile = ((TakesScreenshot)GenericWebDriverFunctions.driver).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\utility\\ScreenShots\\"+imgName+".png"));
		}


}
