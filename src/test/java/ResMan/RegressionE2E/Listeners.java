package ResMan.RegressionE2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.BrowserInvocation;
import resources.ExtendReporterNG;

public class Listeners extends BrowserInvocation implements ITestListener {
	ExtentReports extent =ExtendReporterNG.getReportObject(); 
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test = extent.createTest("TestforReport");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log (Status.PASS,"Test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//test.fail(result.getThrowable());
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String testname = result.getMethod().getMethodName();
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		
		//Screenshots
 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			getScreenshotPath(testname,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
