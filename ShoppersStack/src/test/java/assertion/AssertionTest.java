package assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import base.BaseClass;

public class AssertionTest extends BaseClass
{
	public void assertTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://shoppersstack.com/");
		driver.findElement(By.partialLinkText("Login")).click();
		WebElement log= driver.findElement(By.id("vertical-tab-2"));
		Assert.assertEquals(driver.getTitle().contains("Login"), true);
		Assert.assertEquals(log.isDisplayed(), true);
		Reporter.log("Login Page is Displayed", true);
		driver.quit();
	}
	
}
