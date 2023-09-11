package com.db.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.db.service.BrowserInitImpl;
import com.db.stepdefinitions.DBCareerDefinitions;

public class DBHelperMethods {
	 static BrowserInitImpl browserInitImpl = new BrowserInitImpl();
	public static WebDriver driver;

	public static void selectValueFromDropdown(WebElement dropdownbox , By listboxxpath , String valueToBeSelected) {
		driver = browserInitImpl.getDriver();
		   Actions ac = new Actions(driver);
		   WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		   w.until(ExpectedConditions.elementToBeClickable(dropdownbox));
		   ac.moveToElement(dropdownbox).click().build().perform();
		    List<WebElement> listbox = driver.findElements(listboxxpath);
		   // System.out.println(listbox.size());
		    for(WebElement el1 : listbox) {
		    	//System.out.println(el1.getText());
		    	if(el1.getText().contains(valueToBeSelected)) {
		    		//w.until(ExpectedConditions.elementToBeClickable(el1));
		    		ac.moveToElement(el1).click().build().perform();
		    		break;
		    	}
		    }
			try {
				Thread.sleep(3000);
			}catch(Exception e) {
				System.out.println(e);
			}
	}
}
