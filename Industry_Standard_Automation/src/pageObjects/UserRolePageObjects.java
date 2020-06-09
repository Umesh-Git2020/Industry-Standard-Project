package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRolePageObjects {
	@FindBy(xpath="//a[@id='menu_admin_viewAdminModule']")
	public static WebElement admin;
	@FindBy(xpath="//a[@id='menu_admin_UserManagement']")
	public static WebElement usermanagement;
	@FindBy(xpath="//a[@id='menu_admin_viewSystemUsers']")  //li[@class='selected']//following::a
	public static WebElement users;
	@FindBy(xpath="//input[@type='hidden']//preceding::select")
	public static WebElement userrole;
	@FindBy(xpath="//input[@type='hidden']//following::select[2]")
	public static WebElement userstatus;
	@FindBy(xpath="//input[starts-with(@class,'searchbutton')]")
	public static WebElement search;
	@FindBy(xpath="//tr/td[3]")
	public static WebElement usertext;
	@FindBy(xpath="//tr/td[5]")
	public static WebElement status;
	

}
