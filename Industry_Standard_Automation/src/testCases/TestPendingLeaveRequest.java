package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.DashboardPageObjects;
import pageObjects.LoginPageObjects;

public class TestPendingLeaveRequest extends CommonFunctions{
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestPendingLeaveRequest.class);
	public static void login(){
		PropertyConfigurator.configure("log4j.properties");
		PageFactory.initElements(driver, LoginPageObjects.class);
		logger.info("entering username");
		LoginPageObjects.username.sendKeys(properties.getProperty("username"));
		logger.info("entering password");
		LoginPageObjects.password.sendKeys(properties.getProperty("password"));
		logger.info("clicking login");
		LoginPageObjects.btnLogin.click();

	}
	public static void dashboard(){
		PageFactory.initElements(driver, DashboardPageObjects.class);
		logger.info("clicking dashboard");
		DashboardPageObjects.dashboard.click();
		logger.info("Getting pending leave request");
		String text = DashboardPageObjects.pendingleaverequest.getText();
		logger.info("verifying pending leave request data has expected or not");
		Assert.assertEquals(text, "No Records are Available");
	}
	@Test
	public void VerifyPendingLeaveRequest() throws InterruptedException{
		login();
		dashboard();

	}

}
