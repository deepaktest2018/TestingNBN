package com.Testcases;

import java.io.IOException;
import org.testng.annotations.Test;

import com.generic.GenericWebDriverFunctions;
import com.memory.MemoryFile;
import com.pages.LoginPage;
import com.pages.HomePage;
import com.readPropertiesFiles.ReadAndWritePropertyFile;



public class TestPage extends Hook{	
	
	@Test
	public void Login() throws IOException{	
		reporter.startParent("Login with Valid User and Log out", "Checks the basic fuctionity of login and log out");
		MemoryFile.getDriver().navigate().to(ReadAndWritePropertyFile.readConFigPropertyFile("URL"));
		LoginPage.verifyThePageTitel();
		GenericWebDriverFunctions.BrowserMaximize();
		LoginPage.enterValueToTextBox("username");
		LoginPage.enterValueToTextBox("password");
		LoginPage.clickOnButton();
		HomePage.VerifyThePageLandedOnTheHomePage();	
		HomePage.ClickOnTheAdminName();
		HomePage.ClickOnTheLogOutButton();
		LoginPage.verifyThePageTitel();
		GenericWebDriverFunctions.stopServer();
	}
	
	@Test
	public void Test2() throws IOException{	
		reporter.startParent("Login with Valid User and Log out", "Checks the basic fuctionity of login and log out");
		MemoryFile.getDriver().navigate().to(ReadAndWritePropertyFile.readConFigPropertyFile("URL"));
		LoginPage.verifyThePageTitel();
		GenericWebDriverFunctions.BrowserMaximize();
		LoginPage.enterValueToTextBox("username");
		LoginPage.enterValueToTextBox("password");
		LoginPage.clickOnButton();
		GenericWebDriverFunctions.stopServer();
	}
	
	

}
