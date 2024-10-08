package screenshotsAndReports;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//Execution starts from here
public class Listeners extends ScreenShotAndReports implements ITestListener {
	ExtentReports extent = ExtentReport2.config();
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		test.fail(result.getThrowable());
		//screenshot code 
		
		
//		String filepath = null;
//		try {
//			filepath = getScrennshot(result.getMethod().getMethodName());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		//it's asking to give file path and result what you will get
//		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
//	}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}


}
