package com.db.service;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Parameters;

import com.db.pages.DBPageElements;
import com.db.utils.ConfigReader;

public class BrowserInitImpl{
	private static String browserType;
	ConfigReader cr;	
	
	private static WebDriver driver;
	public static void setBrowserType(String browser) {
		browserType=browser;	
	}

	public void init() {
		if(cr==null) {
			try {
				cr= ConfigReader.init();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Configreader failed to initialize properties file");
			}
		}
		String s;
		if(browserType!=null) {
			s=browserType;
		}else {
			s= cr.getBrowserType();
		}
		if(driver!=null) {
			return;
		}
		if(s.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
	        driver = new ChromeDriver(options);
		}else if (s.equalsIgnoreCase("Edge")) {
			EdgeOptions options1 = new EdgeOptions();
			options1.addArguments("--remote-allow-origins=*");
	        driver = new EdgeDriver(options1);
		}
		DBPageElements.setWebDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
	}
	
	 public WebDriver getDriver() {
		 if(driver==null) {
			 init();
		 }
			return driver;
		}
	 
	 public static void setDriver(WebDriver dv) {
			driver=dv;
		}
	 
	 public void openURL(String url) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.manage().window().maximize();
		    driver.get(url);
	 }
	 

}
