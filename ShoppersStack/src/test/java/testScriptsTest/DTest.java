package testScriptsTest;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseClass;

public class DTest extends BaseClass
{
	
	@Test
	public void enter()
	{
		Reporter.log("Hello World", true);
	}
}
