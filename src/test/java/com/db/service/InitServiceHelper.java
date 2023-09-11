package com.db.service;
/**
 * This is a initialization class where initializations for browser webdriver, DB connection 
 * @author HP
 *
 */
public class InitServiceHelper {
	private BrowserInitImpl browserInitImpl;
	
	private void initBrowser(String browserType) {
		BrowserInitImpl.setBrowserType(browserType);
		browserInitImpl.init();
	}
	
	/**
	 * This method helps in initializing browser, DB etc.
	 */
    public void setUp(String browser) {
		browserInitImpl = new BrowserInitImpl();
		initBrowser(browser);
    }
	
    public void tearDown() {
		if(null!=browserInitImpl.getDriver()) {
			browserInitImpl.getDriver().quit();
			BrowserInitImpl.setDriver(null);
		}
    }
}
