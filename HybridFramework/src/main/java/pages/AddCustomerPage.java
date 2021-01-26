package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import lib.Global;
import lib.InitDriver;
import lib.TestData;
import lib.UserActions;
import lib.Utility;

public class AddCustomerPage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;

	@CacheLookup
	@FindBy(how = How.NAME, using = "addr")
	WebElement txtaddress;

	@CacheLookup
	@FindBy(how = How.NAME, using = "city")
	WebElement txtcity;

	@CacheLookup
	@FindBy(how = How.NAME, using = "state")
	WebElement txtstate;

	@CacheLookup
	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtpinno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txttelephoneno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;

	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	WebElement txtpassword;

	@CacheLookup
	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;
	
	@FindBy(name="uid")
	@CacheLookup
	public WebElement edt_L_UserID;
	
	@FindBy(name="password")
	@CacheLookup
	public WebElement edt_L_Password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	

	public AddCustomerPage(){		
		//InitDriver.getWebDriverInstance("Chrome");
		driver = Utility.returnDriver();
		PageFactory.initElements(driver, this);	
	}
	
	//Business components
	public void addcustomer() {
		Global.objMapData = TestData.readTestData(Global.id, Global.className, Global.methodname);
		
		UserActions.invokeApp(Global.appURL);
		UserActions.enterText(edt_L_UserID, "user Id", "UserLogin");
		UserActions.enterText(edt_L_Password, "password", "UserPassword");
		btnLogin.click();
		
		UserActions.wait(5);
		
		lnkAddNewCustomer.click();
		UserActions.enterText(txtCustomerName, "Customer Name", "Name");
		UserActions.enterText(rdGender, "Customer Gender", "Gender");
		UserActions.enterText(txtdob, "Customer Dob", "Dob");
		UserActions.enterText(txtaddress, "Customer Address", "Address");
		UserActions.enterText(txtcity, "Customer City", "City");
		UserActions.enterText(txtstate, "Customer State", "State");
		UserActions.enterText(txtpinno, "Customer Pinno", "Pinno");
		UserActions.enterText(txttelephoneno, "Customer Telephone", "Telephone");
		UserActions.enterText(txtemailid, "Customer Email", "Email");
		UserActions.enterText(txtpassword, "Customer Passsword", "Passsword");
		btnSubmit.click();
		
	}

}
