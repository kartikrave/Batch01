package genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility 
{

	public void clickOnElement (WebElement element)
	{
		element.click();
	}
	public void sendText(WebElement element, String text)
	{
		element.sendKeys(text);
	}
	public String fetchTitle (WebDriver driver)
	{
		return driver.getTitle();
	}
	public void acceptAlert (WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlet (WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void sendTextToTitle (WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	public String fetchAlertText(WebDriver driver)
	{
		String alertText=driver.switchTo().alert().getText();
		return alertText;
	}
	public void SelectOptionByvalueAttribute(WebElement element, String value)
	{
		Select sele=new Select(element);
		sele.selectByValue(value);
	}
	public void SelectOptionByVisibleText(WebElement element, String visibleText)
	{
		Select sele=new Select(element);
		sele.selectByVisibleText(visibleText);
	}
 }
