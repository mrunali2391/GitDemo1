package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import resources.Base;
import resources.Locators.landingPage;

public class LandingPage implements landingPage {
	public static Logger log = LogManager.getLogger(Base.class.getName());

	public WebDriver driver;
	

	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public boolean verifyContactTabDisplayed() throws InterruptedException {
		/*
		 * String contactTabName=(driver.findElement(contactTab)).getText();
		 * System.out.println(contactTabName); Boolean
		 * status=contactTabName.equalsIgnoreCase("contact");
		 */
		Thread.sleep(5000);
		boolean status=(driver.findElement(contactTab)).isDisplayed();
       return status;
	}

}
