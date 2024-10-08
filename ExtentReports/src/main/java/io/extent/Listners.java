package io.extent;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class Listners implements ITestListener {
	ExtentReports extent = ExtentReport2.config();
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());	
		}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	System.out.println("I successfully executed Listeners Pass code");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot code 
		//response if API is failed
		
		System.out.println("I failed executed Listeners Pass code" +result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		 extent.flush();		
	}



}
