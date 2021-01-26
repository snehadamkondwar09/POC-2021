package lib;

import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static WebDriver driver;
	
	public Utility(String strBrowser){
		driver =  InitDriver.getWebDriverInstance(strBrowser);
		Global.logger = Global.report.createTest(Global.AutomationId, Global.Description);
	}
	
	
	
	public static WebDriver returnDriver() {
		return driver;
		
	}
	

}
