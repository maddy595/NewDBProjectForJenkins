package com.db.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.db.service.BrowserInitImpl;
import com.db.stepdefinitions.DBCareerDefinitions;

import io.cucumber.java.Scenario;

public class HelperMethods {
	 static BrowserInitImpl browserInitImpl = new BrowserInitImpl();
	public static WebDriver driver= browserInitImpl.getDriver();

	public static int extractintFromString(WebElement el) {
		
		String str = el.getText();
		str = str.replaceAll("[^0-9]", "");
		int number = Integer.parseInt(str);
		return number;
	}
	
	public static void getScreenshot() {
		driver= browserInitImpl.getDriver();
		TakesScreenshot tks = (TakesScreenshot)driver;
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//Call getScreenshotAs method to create image file
		File SrcFile=tks.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		String destination = System.getProperty("user.dir") + "\\screenshots\\"+nameofCurrMethod+dateName+".png";
		File DestFile=new File(destination);
		try {
			FileHandler.copy(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void movetoElement(WebElement element) {
		driver= browserInitImpl.getDriver();
		Actions ac = new Actions(driver);
	    ac.moveToElement(element).build().perform();
	}
	
	public static void clickElementUsingActionsClass(WebElement element) {
		driver= browserInitImpl.getDriver();
		Actions ac = new Actions(driver);
	    ac.moveToElement(element).click().build().perform();
	}
	
	public static void validateText(String expected, String actual) {
		Assertions.assertThat(actual).isEqualTo(expected);
	}
	
}
