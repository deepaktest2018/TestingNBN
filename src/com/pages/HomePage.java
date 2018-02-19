package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.generic.GenericWebDriverFunctions;
import com.memory.MemoryFile;
import com.readPropertiesFiles.ReadAndWritePropertyFile;

public class HomePage extends GenericWebDriverFunctions{
	static WebDriver driver = MemoryFile.getDriver();
	
	public static void VerifyThePageLandedOnTheHomePage() throws IOException{
		try{
			WebElement element= driver.findElement(By.xpath(ReadAndWritePropertyFile.readPropertyFile("HomePage", "HomePageBox")));
			isDisplayed(element);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void ClickOnTheAdminName() throws IOException{
		String AdminMouseOver=ReadAndWritePropertyFile.readPropertyFile("HomePage", "HomeWelComeAdmin");		
		ClickOnElement(By.id(AdminMouseOver));
	}
	
	public static void ClickOnTheLogOutButton() throws IOException{
		String AdminMouseOver=ReadAndWritePropertyFile.readPropertyFile("HomePage", "HomeWelComeAdmin");		
		ClickOnElement(By.id(AdminMouseOver));
	}
	
	
}
