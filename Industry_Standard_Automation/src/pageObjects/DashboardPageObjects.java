package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageObjects {
	@FindBy(xpath="//a[@id='menu_dashboard_index']")
	public static WebElement dashboard;
	@FindBy(xpath="//tr[@class='odd']")
	public static WebElement pendingleaverequest;

}
