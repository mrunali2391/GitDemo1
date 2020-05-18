package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	public String url;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	public Base() throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
	}

	public WebDriver intializeDriver() throws IOException {

		String browser_name = System.getProperty("browser");

		// String browser_name = prop.getProperty("browser");
		url = prop.getProperty("url");

		if (browser_name.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\selenium-jar & drivers\\chromedriver_win32\\chromedriver.exe");

			ChromeOptions option = new ChromeOptions();
			if (browser_name.contains("headless"))
				option.addArguments("headless");
			driver = new ChromeDriver(option);

		} 
		else if (browser_name.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\selenium-jar & drivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//driver.findElement(by)
		return driver;
	}

	public void getScreenshotPath(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\reports\\" + testcaseName + ".png";
		FileUtils.copyFile(src, new File("C:\\Users\\mingle\\Screenshots\\takescreen.png"));
	}

}
