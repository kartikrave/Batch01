package testScriptsTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.BaseClass;

public class DeleteAddressTest extends BaseClass
{
		@Test(groups="Regression")
		public void updateAddressTest()
		{
			
			driver.findElement(By.xpath("//*[name()='svg' and @data-testid='SettingsIcon']")).click();
			driver.findElement(By.xpath("//ul[@role='menu']/li[1]")).click();
			driver.findElement(By.xpath("//div[contains(text(),'Addresses')]")).click();
			driver.findElement(By.xpath("//*[name()='svg'and@data-testid='DeleteIcon']")).click();
			driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
			
			
		}
		
}
	

