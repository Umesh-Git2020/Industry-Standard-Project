package testCases;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonFunctions.CommonFunctions;
import pageObjects.UserRolePageObjects;

public class TestUserRole extends CommonFunctions {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestUserRole.class);
	public static void MoveToUsers(){
		PropertyConfigurator.configure("log4j.properties");
		PageFactory.initElements(driver, UserRolePageObjects.class);
		logger.info("starting mouse hover");
		Actions action = new Actions(driver);
		logger.info("performing mouse hover on admin");
		action.moveToElement(UserRolePageObjects.admin);
		logger.info("performing mouse hover on usermanagement");
		action.moveToElement(UserRolePageObjects.usermanagement);
		logger.info("performing mouse hover on users and clicking users");
		action.moveToElement(UserRolePageObjects.users).click();
		action.build().perform();
	}
	public void SelectUserRoleAndStatus(){
		Select dropdown = new Select(UserRolePageObjects.userrole);
		logger.info("selecting index of 1");
		dropdown.selectByIndex(1);
		Select dropdown2 = new Select(UserRolePageObjects.userstatus);
		logger.info("selecting index of 1");
		dropdown2.selectByIndex(1);
		logger.info("clicking on search");
		UserRolePageObjects.search.click();

	}
	public void GetRoleAndStatus(){
		logger.info("getting text of user");
		String role = UserRolePageObjects.usertext.getText();
		logger.info("getting status of user");
		String status = UserRolePageObjects.status.getText();
		logger.info("verifying user role");
		Assert.assertEquals(role, "Admin");
		logger.info("verifying status");
		Assert.assertEquals(status, "Enabled");
	}
	@Test
	public void checkuserrole(){
		MoveToUsers();
		SelectUserRoleAndStatus();
		GetRoleAndStatus();
	}

}
