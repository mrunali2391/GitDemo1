package resources;

import org.openqa.selenium.By;

public interface Locators {

	public interface loginPageInterface {
		By landOnloginButton = By.xpath("//a[@href='http://qaclickacademy.usefedora.com/sign_in']");
		By userid = By.xpath("//input[@id='user_email']");
		By loginButton=By.xpath("//input[@name='commit']");

	}
	
	public interface landingPage{
		By contactTab=By.xpath("//a[@class='fedora-navbar-link navbar-link'][contains(text(),'Contact')]");
		
	}

}
