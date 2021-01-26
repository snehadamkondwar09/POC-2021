package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.Global;
import lib.InitDriver;
import lib.TestData;
import lib.UserActions;
import lib.Utility;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(name="uid")
	@CacheLookup
	public WebElement edt_L_UserID;
	
	@FindBy(name="password")
	@CacheLookup
	public WebElement edt_L_Password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	

	public LoginPage(){		
		//InitDriver.getWebDriverInstance("Chrome");
		driver = Utility.returnDriver();
		PageFactory.initElements(driver, this);	
	}
	
	//Business components
	public void login() {
		Global.objMapData = TestData.readTestData(Global.id, Global.className, Global.methodname);
		UserActions.invokeApp(Global.appURL);
		UserActions.enterText(edt_L_UserID, "user Id", "L_UserID");
		UserActions.enterText(edt_L_Password, "password", "L_password");
		
		btnLogin.click();
		
		System.out.println("I am in login method");
		
	}
	
	
	
	
	
	
	
	
	

}
