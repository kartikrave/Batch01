package testScriptsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import base.BaseClass;

public class AddAddressTest extends BaseClass
{

		@Test(groups = "smoke")
		public void addAddressTest()
		{
			driver.findElement(By.xpath("//*[name()='svg' and @data-testid='SettingsIcon']")).click();
			driver.findElement(By.xpath("//ul[@role='menu']/li[1]")).click();
			
			driver.findElement(By.xpath("//div[@class='MuiGrid-root profileDashactive css-rfnosa']")).click();
			driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium  css-1hw9j7s']")).click();
			driver.findElement(By.id("Name")).sendKeys("Tyrian");
			driver.findElement(By.id("House/Office Info")).sendKeys("North Sea");
			driver.findElement(By.id("Street Info")).sendKeys("Govindaa Street");
			driver.findElement(By.id("Landmark")).sendKeys("Near StarBucks");
			
			Select country= new Select(driver.findElement(By.id("Country")));
			country.selectByVisibleText("India");
			Select stat = new Select(driver.findElement(By.id("State")));
			stat.selectByVisibleText("Tamil Nadu");
			Select city= new Select(driver.findElement(By.id("city")));
			city.selectByVisibleText("Chennai");
			driver.findElement(By.id("pincode")).sendKeys("600048");
			driver.findElement(By.id("Phone Number")).sendKeys("9000060000");
			driver.findElement(By.id("addAddress")).click();
			
			
		}
	
	
}
