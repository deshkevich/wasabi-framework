package com.autotesting.framework.utils;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngSeleniumEventsListener implements ITestListener, IInvokedMethodListener {

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		handleFailure(result);
		
	}

	private void handleFailure(ITestResult result) {
		if (WebDriverRunner.getDriver() !=null) {
			String casName = getCaseName(result);
			//будут методы в сосднем классе
			Photographer.doScreenshot(caseName);
			Photographer.saveSourceToFile(caseName);
		}
		
	}

	private String getCaseName(ITestResult result) {
		return result.getTestClass().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


}
