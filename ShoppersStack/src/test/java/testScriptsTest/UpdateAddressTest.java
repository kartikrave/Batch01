package testScriptsTest;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;


public class UpdateAddressTest extends BaseClass
{
	@Test(groups ="smoke")
	public void updateAddressTest() 
	{
		driver.findElement(By.xpath("//*[name()='svg' and @data-testid='SettingsIcon']")).click();
		driver.findElement(By.xpath("//ul[@role='menu']/li[1]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Addresses')]")).click();
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textSuccess MuiButton-sizeSmall MuiButton-textSizeSmall  css-n3v15g']")).click();
		driver.findElement(By.id("Name")).sendKeys("Jadeja");
		driver.findElement(By.id("House/Office Info")).sendKeys("1386");
		driver.findElement(By.id("Street Info")).sendKeys("Bacardi Street");
		driver.findElement(By.id("Landmark")).sendKeys("Near OldMonk Tank");
		
		Select country= new Select(driver.findElement(By.id("Country")));
		country.selectByVisibleText("India");
				
		Select state= new Select(driver.findElement(By.id("State")));
		state.selectByVisibleText("Karnataka");

		Select city = new Select(driver.findElement(By.id("City")));
		city.selectByVisibleText("Bengaluru");

		driver.findElement(By.id("Pincode")).sendKeys("600091");
		driver.findElement(By.id("Phone Number")).sendKeys("9500655700");
		driver.findElement(By.id("Update Address")).click();
	
		
	}
	
}
