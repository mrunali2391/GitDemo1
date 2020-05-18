package pageObject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import resources.Base;
import resources.Locators;
import resources.Locators.loginPageInterface;
import resources.fetchData;

public class LoginPage implements loginPageInterface{
	public static Logger log = LogManager.getLogger(Base.class.getName());

	public WebDriver driver;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickLoginButton()
	{
		driver.findElement(landOnloginButton).click();
	}
	
	public void verifyLoginPageDisplayed() {
		
	}
	
	public void loginToexistingUser(String userEmail, String userPasswd) throws IOException
	{
		driver.findElement(userid).sendKeys(userEmail);
		driver.findElement(password).sendKeys(userPasswd);
		driver.findElement(loginButton).click();
	}
	
	
	
	
	
}
