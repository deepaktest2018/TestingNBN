package com.pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

import com.exception.CustomException;
import com.generic.GenericWebDriverFunctions;
import com.memory.MemoryFile;
import com.readPropertiesFiles.ReadAndWritePropertyFile;
import com.reports.CustomReporter;

public class LoginPage extends GenericWebDriverFunctions {
	static WebDriver driver = MemoryFile.getDriver();
	static CustomReporter report=MemoryFile.getReporter();

	public static void enterValueToTextBox(String textBoxName) throws IOException {
		try {
			
			switch (textBoxName.toLowerCase()) {
			case "username":
				String userNameId = ReadAndWritePropertyFile.readPropertyFile("login", "UsernameId");
				EnterValueToTextBox(By.id(userNameId), "admin");
				break;
			case "password":
				String passwordId = ReadAndWritePropertyFile.readPropertyFile("Login", "PasswordId");
				EnterValueToTextBox(By.id(passwordId), "admin");
				break;
			default:
				break;
			}

		} catch (Exception e) {
			// TODO: handle exception
			new CustomException(e.toString());
		}
		report.reportParent("Pass", "User entered in"+textBoxName);
	}

	public static void clickOnButton() throws IOException {
		try {
			String loginbuttonId = ReadAndWritePropertyFile.readPropertyFile("Login", "LoginButtonId");
			ClickOnElement(By.id(loginbuttonId));
		} catch (Exception e) {
			// TODO: handle exception
			Exception e1;
		}

	}

	public static void verifyThePageTitel() {
		try {
			assertEquals(GenericWebDriverFunctions.GetPageTitele(),
					ReadAndWritePropertyFile.readPropertyFile("Login", "LoginPageTitle"));
		} catch (Exception e) {
			// TODO: handle exception
			Exception e1;
		}
	}
}
