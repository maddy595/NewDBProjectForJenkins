package com.db.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/** This is a Singleton class. Multiple instance of this class cannot be created
 * Purpose of this class is to read the property kept in location config.properties
 * If <b>BrowserType</b> parameter  is provided through testNGXML BrowserType parameter would be set from there
 * @author 
 *
 */
public class ConfigReader {
	
	public Properties prop;
	private static String configPath="C:\\Users\\HP\\eclipse-workspace\\DBCareers_Project\\src\\test\\java\\com\\db\\utils\\config.properties";
	private static ConfigReader instance;
	
	private ConfigReader() throws IOException {
		initializePropertyFile();
	}

	/**
	 * If application is unable to read properties file it will throw IO exception
	 * @return
	 * @throws IOException
	 */
	public static ConfigReader init() throws IOException {
		if(instance==null) {
			instance= new ConfigReader();
		}
		return instance;
	}
	
	public void initializePropertyFile() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(configPath);
		prop.load(fis);
	}
	
	public String getBrowserType() {
		return prop.getProperty("BrowserType");
	}
	
	public String getUrl() {
		return prop.getProperty("url");
	}
	

}
