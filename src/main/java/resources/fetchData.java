package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class fetchData {
	public Properties prop;
	public FileInputStream fis;

	public fetchData() throws IOException {
		fis = new FileInputStream(
				"C:\\mrunali\\mrunali\\study\\DEMO_SELENIUM_PROJECT\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
	}

	public String getuserid1()
	{
		
		return prop.getProperty("userid1");
	}
	
	public String getPassword()
	{
		return prop.getProperty("password1");
	}
	public String getuserid2()
	{
		
		return prop.getProperty("userid2");
	}
	
	public String getPassword2()
	{
		return prop.getProperty("password2");
	}
	
	
}
