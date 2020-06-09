package commonFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import testCases.TestUserRole;

public class CommonFunctions {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CommonFunctions.class);
	public static WebDriver driver;
	public static Properties properties;
	public static Properties Readpropertyfile() throws IOException{
		logger.info("reading property file");
		FileInputStream file = new FileInputStream("config.properties");
		properties = new Properties();
		properties.load(file);
		return properties;
	}
	@BeforeSuite
	public static void startingbrowser() throws IOException{
		PropertyConfigurator.configure("log4j.properties");
		Readpropertyfile();
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String Location = properties.getProperty("DriverLocation");
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", Location);
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", Location);
			driver = new FirefoxDriver();

		}
		logger.info("maximizing browser");
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

	}
	@AfterSuite
	public void closebrowser(){
		driver.quit();
	}
}
