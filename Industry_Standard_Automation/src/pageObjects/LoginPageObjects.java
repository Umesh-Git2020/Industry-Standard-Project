package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {
	@FindBy(xpath="//span[@class='form-hint']//preceding-sibling::input")
	public static WebElement username;
	@FindBy(xpath="//input[contains(@name,'txtPassword')]")
	public static WebElement password;
//	@FindBy(xpath="//input[@id='btnLogin']")
//	public static WebElement login;
	public static WebElement btnLogin;
	

}
