package lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class TestData {
	
	
	/**method : Recordset getrecordUsingFillo(String strFilepath , String StrQuery)
	 * return : Recordset
	 * Params: strFilepath ,  StrQuery
	 */
	public static Recordset getrecordUsingFillo(String strFilepath , String StrQuery) {
		Fillo f=null;
		Connection con =null;
		Recordset  rs = null;
		try {
			 f = new Fillo();
			 con = f.getConnection(strFilepath);
			 rs = con.executeQuery(StrQuery);
		}
		catch(Exception e) {
			con.close();
		}
		con.close();	
		return rs;	
	}
	
	
	/**method : readGroups(String strFilepath , String StrQuery)
	 * return : List
	 * Params: strFilepath ,  StrQuery
	 * @author Dharm
	 *
	 */
	public static List readGroups(String strFilepath , String StrQuery) {
		ArrayList lGrps = new ArrayList();
		Recordset rs  = null;
		try {
			rs = TestData.getrecordUsingFillo(strFilepath, StrQuery);
			while(rs.next()) {
				String strModuleName =  rs.getField("Groups");
				lGrps.add(strModuleName);
			}
		}
		catch(Exception e) {
			System.out.println("Exception in readGroups method. Hence not able to read the groups");
		}	
		return lGrps;	
	}
	
	
	/**method : readTestData(String id , String strTestDataFileName , String strSheetName )
	 * return : Map
	 * Params: id , strTestDataFileName ,  strSheetName
	 * @author Dharm
	 *
	 */
	public static Map readTestData(String id , String strTestDataFileName , String strSheetName ) {
	
		Recordset rs = null;
		HashMap<String , String> m = new HashMap<String , String>();
		String strAbsFilepath = Global.testArtifacts+strTestDataFileName+"_TestData.xlsx";
		String StrQuery = "select * from " + strSheetName + " where ID = '"+ id + "'";
		
		try {
			 rs =  TestData.getrecordUsingFillo(strAbsFilepath, StrQuery);
			 while(rs.next()) {
				 
				 for(int i=0 ; i<rs.getFieldNames().size();i++) {
					 String strColName = rs.getField(i).name();
					 String strColValue = rs.getField(i).value();
					 m.put(strColName, strColValue);
				 }			 
			 }
		}
		catch(Exception e) {
			System.out.println("error while reading data from  file " + strTestDataFileName );
		}
		return m;
		
	}
	
	
	/**method : readtestdataValue(String strColKey) 
	 * return : String
	 * Params: strColKey
	 * @author Dharm
	 *
	 */
	public static String readtestdataValue(String strColKey) {
		String strvalue="";
		try {
			strvalue=  (String) Global.objMapData.get(strColKey.toUpperCase());
		}
		catch(Exception e) {
			System.out.println("error while reading test data value based on the key -->  " + strColKey );
		}
	
		return strvalue;
		
	}
	
	
	
	/**method : readTestCase(String strFilepath , String StrQuery)
	 * return : List
	 * Params: strFilepath ,  StrQuery
	 * @author Dharm
	 *
	 */
	public static  Recordset readTestCase(String strFilepath , String StrQuery) {
		
		Recordset rs  = null;
		try {
			rs = TestData.getrecordUsingFillo(strFilepath, StrQuery);
			
		}
		catch(Exception e) {
			System.out.println("Exception in readTestCase method. Hence not able to read the testcase");
		}	
		return rs;	
	}
	
	

}
