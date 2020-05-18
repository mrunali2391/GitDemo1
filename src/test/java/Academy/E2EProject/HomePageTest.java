package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;
import resources.fetchData;

public class HomePageTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());

	fetchData fetch = new fetchData();

	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(dataProvider = "getData")
	public void loginOnWebsite(String user, String pass) throws IOException {
		driver.get(url);
		log.info("url is launched");
		LoginPage lp = new LoginPage(driver);
		lp.clickLoginButton();
		lp.loginToexistingUser(user, pass);
	}

	@Test(enabled=false)
	public void verificationOfContactTabDisplayed() throws IOException, InterruptedException {
		driver.get(url);
		log.info("url is launched...");
		LandingPage land = new LandingPage(driver);
		Assert.assertTrue(land.verifyContactTabDisplayed());
		log.info("contact tab is displayed successfully");

	}

	@AfterTest
	public void teardown() {
		driver.close();

	}

	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = intializeDriver();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = fetch.getuserid1();
		data[0][1] = fetch.getPassword();
		data[1][0] = fetch.getuserid2();
		data[1][1] = fetch.getPassword2();
		return data;
	}

}
