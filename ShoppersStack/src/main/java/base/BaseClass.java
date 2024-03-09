package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import fileutility.ReadProperty;

public class BaseClass 
{
	public static WebDriver driver;
	 public static WebDriver sdriver;
	// @Parameters("browser")
	 @BeforeClass(alwaysRun = true)
	 public void openBrowser()
	 {
		driver =new ChromeDriver();
	 /*
		if(browser.eauals("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("Edge"))
			
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		*/
		sdriver=driver;
		driver.manage().window().maximize();
		ReadProperty properties =new ReadProperty();
		String url=properties.fetchProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.findElement(By.id("loginBtn")).click();
		Reporter.log("Browser opened Successfully ",true);
	 }
	
	@BeforeMethod(alwaysRun = true)
	public void login()
	{
		//WebDriverUtility webDriverUtility = new WebDriverUtility();
		ReadProperty properties =new ReadProperty();
		//LoginPage loginpage=new LoginPage(driver);
		
		String un =properties.fetchProperty("username");
		String pwd=properties.fetchProperty("password");
		driver.findElement(By.id("Email")).sendKeys(un);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Reporter.log("Successfully Logged-in", true);
		
		//loginpage.getEmailTextField().sendKeys("username");
		//loginpage.getPasswordTextField().sendKeys("password");
		//loginpage.getLoginButton().click();
		
	}
	@AfterMethod(alwaysRun = true)
	public void logout()
	{
		    driver.findElement(By.xpath("//*[name()='svg' and @data-testid='SettingsIcon']")).click();
			driver.findElement(By.xpath("(//li[@role='menuitem'])[7]")).click();
			Reporter.log("Logged out Successfully" , true);
	}
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("Browser has been Closed Successfully",true);
	}
}
	
	
