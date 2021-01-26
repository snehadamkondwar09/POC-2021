package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitDriver {
	
	public static WebDriver driver;
	
	public static WebDriver getWebDriverInstance(String strBrowser) {
		
		if(strBrowser.contentEquals(Global.strBrowserName)) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();
		}
		else if(strBrowser.contentEquals(Global.strBrowserName)) {
			// code for firefox
		}
		return driver;
	}

}
