package lib;

import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Global {
	
	
	public static String htmlFile = System.getProperty("user.dir")+"\\TestResultLogs\\resultLogs\\Selenium.html";
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	public static String strBrowserName= "CHROME";
	public static String appURL= "http://demo.guru99.com/v4/index.php";
	public static String strEnv = "UAT";
	
	public static String testArtifacts =  System.getProperty("user.dir")+"\\TestArtifacts\\";
	public static String strGroupControlFilepath =  System.getProperty("user.dir")+"\\TestArtifacts\\GroupControlFile.xlsx";
	
	
	
	public static Map objMapData ;
	
	public static String id;
	public static String AutomationId;
	public static String Description;
	public static String className;
	public static String methodname;
	
}
