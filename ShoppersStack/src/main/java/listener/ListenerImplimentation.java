package listener;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;

public class ListenerImplimentation implements ITestListener, ISuiteListener
{

	public static ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		String imgpath = "./FailedScreenshots/" + result.getName() + ".png";
		Reporter.log(result.getName() +"has failed", true);
		TakesScreenshot ts= (TakesScreenshot)BaseClass.sdriver;
		System.out.println(ts);
		File Screenshot = ts.getScreenshotAs(OutputType.FILE);
		File path = new File(imgpath);
		try
		{
			FileHandler.copy(Screenshot, path);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, test.addScreenCapture("." + imgpath));
		test.log(LogStatus.FAIL, result.getName()+ "has Failed");
	}
	@Override
	public void onTestStart(ITestResult result)
	{
		
		Reporter.log(result.getName()+" Has Started", true);
		
		test=report.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName()+ "has Started");
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log(result.getName() + "has successfully Executed", true);
		test.log(LogStatus.PASS, result.getName()+ "has passed");
	}
	@Override
	public void onStart(ISuite suite)
	{
		
		Reporter.log(suite.getName()+" Has Started", true);
		report = new ExtentReports("./AdvancedReports/" + suite.getName() + ".html");
	}
	@Override
	public void onTestSkipped(ITestResult result)
	{
		
		Reporter.log(result.getName()+" has Skipped", true);
		test.log(LogStatus.SKIP, result.getName() + " Has Skipped");
	}
	@Override
	public void onFinish(ISuite suite)
	{
		Reporter.log(suite.getName()+" Has Finished", true);
		//test.log(LogStatus.INFO, suite.getName()+ "has finished");
		report.endTest(test);
		report.flush();
	}
	
}
