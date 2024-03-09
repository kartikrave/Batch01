package demopackage;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;

public class ExtentReports1 extends BaseClass
{
	@Test
	public void loginTest()
	{
		ExtentReports report = new ExtentReports("./AdvancedReport/loginTest.html");
		ExtentTest test = report.startTest("LoginTest");
		test.log(LogStatus.INFO, "Navigated to welcomePage");
		test.log(LogStatus.INFO, "Clicked on login Button");
		test.log(LogStatus.INFO, "Entered valid credentials and clicked on Login");
		test.log(LogStatus.PASS, "Logged in Successfully");
		test.log(LogStatus.FAIL, "Login Page is not displayed hence test script is Failed");
		report.endTest(test);
		report.flush();
	}
	
}
