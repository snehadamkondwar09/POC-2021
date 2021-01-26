package lib;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Reporting {
	
	
	/**method : createHTMlReport()
	 * return : void
	 * Params: nothing
	 */
	public static void createHTMlReport() {		
		try {
			Global.htmlReporter =  new ExtentHtmlReporter(Global.htmlFile);
			Global.report = new ExtentReports();		
			Global.report.attachReporter(Global.htmlReporter );
		}
		catch(Exception e) {
			System.out.println("error in createHTMlReport method " + e.getMessage());
		}		
	}
	
	
	/**method : writeHTMLLogs(String strPassFail , String strDescription) 
	 * return : void
	 * Params: nothing
	 * @author Dharm
	 *
	 */
	public static void writeHTMLLogs(String strPassFail , String strDescription) {
		if(strPassFail.contentEquals("PASS")) {
			Global.logger.log(Status.PASS, strDescription);
		}
		else if(strPassFail.contentEquals("FAIL")) {
			Global.logger.log(Status.FAIL, strDescription);
		}
		else {
			Global.logger.log(Status.INFO, strDescription);
		}
		
		
		
	}
	
	
	
	

}
