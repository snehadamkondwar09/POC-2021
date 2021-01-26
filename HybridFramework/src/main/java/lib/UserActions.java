package lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserActions {
	
	
	/**method : clickElement(WebElement ele , String label , String value) 
	 * return : void
	 * Params: nothing
	 */
	public static void clickElement(WebElement ele , String label , String value) {
		try {
			boolean flag = ele.isDisplayed();
			if(flag) {
				ele.click();
			}
			Reporting.writeHTMLLogs("PASS", "Sucessfully click on " + label );
		}
		catch(Exception e) {
			Reporting.writeHTMLLogs("FAIL", "Failed to click on " + label );
		}
	}
	
	
	/**method : enterText(WebElement ele , String label , String value)
	 * return : void
	 * Params: nothing
	 * @author Dharm
	 *
	 */
	public static void enterText(WebElement ele , String label , String colName) {
		String value ="";
		try {
		    value  = TestData.readtestdataValue(colName);
			boolean flag = ele.isDisplayed();
			if(flag) {
				ele.sendKeys(value);
			}
			Reporting.writeHTMLLogs("PASS", "Sucessfully enter " + value + " on " + label );
		}
		catch(Exception e) {
			Reporting.writeHTMLLogs("FAIL", "Failed to enter " + value + " on " + label );
		}
	}
	
	
	/**method : clickElementUsingActions(WebElement ele , String label , String value) 
	 * return : void
	 * Params: nothing
	 * @author Dharm
	 *
	 */
	public static void clickElementUsingActions(WebElement ele , String label , String value) {
		try {
			boolean flag = ele.isDisplayed();
			if(flag) {
				Actions act = new Actions(InitDriver.driver);
				act.click(ele).perform();
				
			}
			Reporting.writeHTMLLogs("PASS", "Sucessfully click on " + label );
		}
		catch(Exception e) {
			Reporting.writeHTMLLogs("FAIL", "Failed to click on " + label );
		}
	}
	
	
	/**method : invokeApp(String url)
	 * return : void
	 * Params: nothing
	 * @author Dharm
	 *
	 */
	public static void invokeApp(String url) {
		try {
		   WebDriver driver = Utility.returnDriver();
		   driver.get(url);
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   Reporting.writeHTMLLogs("PASS", "Sucessfully invoke URL  " + url );
		}
		catch(Exception e) {
			Reporting.writeHTMLLogs("FAIL", "Failed to launch the URL " + url);
		}
	}
	
	public static void wait(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
