package com.db.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName());
		System.out.println("Execution for - " +context.getName() +" has Started");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getInstance().toString());
		System.out.println("Test execution Started");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite execution finished");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==result.FAILURE) {
			HelperMethods.getScreenshot();
		}
	}
	
	

}
