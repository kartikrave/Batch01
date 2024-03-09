package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage

{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id ="Email")
	private WebElement emailTextField;
	
	@FindBy(id ="password")
	private WebElement passwordTextField;
	
	@FindBy(xpath ="(//span[@class='MuiButton-label'])[1]")
	private WebElement loginButton;

	public WebElement getEmailTextField() 
	{
		return emailTextField;
	}

	public WebElement getPasswordTextField() 
	{
		return passwordTextField;
	}

	public WebElement getLoginButton() 
	{
		return loginButton;
	}
	
}
