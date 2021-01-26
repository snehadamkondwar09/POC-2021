package runManager;

import java.lang.reflect.Method;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import lib.Global;
import lib.Reporting;
import lib.TestData;
import lib.Utility;

public class RunManager {

	public static void main(String[] args) throws Exception{
		
		Reporting.createHTMlReport();
		String StrQuery = "select * from Groups where Run = 'Y' ";
		List <String>lGroups = TestData.readGroups(Global.strGroupControlFilepath, StrQuery);
		
		for(String module : lGroups) {
			String strTestcaseQuery = "select * from " + module  + " where Run = 'Y'"  ;
			Recordset  rsTestCase = TestData.readTestCase(Global.strGroupControlFilepath, strTestcaseQuery);
			
			while(rsTestCase.next()) {
				 Global.id=rsTestCase.getField("ID");
				 Global.AutomationId=rsTestCase.getField("AutomationID");
				 Global.Description=rsTestCase.getField("Description");
				 String strComponents =  rsTestCase.getField("Keywords");
				 
				 String[] arrComponents = strComponents.split("_");
				 
				 new Utility(Global.strBrowserName);
				 
				 for(int i =0 ; i<arrComponents.length;i++) {
					 
					String strClassName =   arrComponents[i].split("\\.")[0];
					Global.className=strClassName;
					String strMethodName =   arrComponents[i].split("\\.")[1];
					Global.methodname = strMethodName;
					
					//Reflection
					Class cls = Class.forName("pages."+strClassName);
					Object obj = cls.newInstance();
					Method M = cls.getMethod(strMethodName);
					M.invoke(obj);
					
					
					 
				 }
				 
				
			}
			
			
		}
		
		Global.report.flush();
		
	

	}

}
