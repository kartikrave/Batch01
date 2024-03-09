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

import base.BaseClass;

public class ListenerClass extends BaseClass implements ISuiteListener, ITestListener
{
	@Override
	public void onFinish(ISuite suite)
	{
		Reporter.log(suite.getName()+" Has Finished", true);
	}
	@Override
	public void onStart(ISuite suite)
	{
		Reporter.log(suite.getName()+" Has Started", true);
	}
	@Override
	public void onTestStart(ITestResult result)
	{
		
		Reporter.log(result.getName()+" Has Started", true);
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log(result.getName()+" Executed Successfully", true);
	}
	@Override
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log(result.getName()+" Execution Skipped", true);
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		File path = new File("./FailedScreenShot/" +result.getName()+".png");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File ss=ts.getScreenshotAs(OutputType.FILE);
		try
		{
			FileHandler.copy(ss, path);
		}
		catch (IOException e)
		{
			e.getSuppressed();
			
		}
		Reporter.log(result.getName() + " is faile and successfuly captured the screenshot", true);
		
	}
}
