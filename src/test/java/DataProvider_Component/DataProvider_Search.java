package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class DataProvider_Search {
	
	
		@DataProvider(name="dp_InvalidSearch")
		public static Iterator<Object[]> getInvalidSearchdata() throws IOException
		{
			
			List<Object[]> Obj = flagrowCount("InvalidSearch");
			return Obj.iterator();
			
		}
		
		@DataProvider(name="dp_ValidSearch")
		public static Iterator<Object[]> getValidSearchdata() throws IOException
		{
			
			List<Object[]> Obj = flagrowCount("ValidSearch");
			return Obj.iterator();
			
		}
		
		
		public static List<Object[]> flagrowCount(String Scriptname) throws IOException
		{
			ExcelReadWrite xl= new ExcelReadWrite("D:\\BB_Project\\TestData\\TestData.xls");
			HSSFSheet Scenario_Search = xl.Setsheet("Scenario_Search");
			
			int Rowcount = xl.getrowcount(Scenario_Search);
			int Colcount = xl.getcolcount(Scenario_Search, 0);
			
			List<Object[]> list_Search= new ArrayList<Object[]>();
			
			for(int irow=1;irow<=Rowcount;irow++)
			{
				String Execute_Flag = xl.Readvalue(Scenario_Search, irow, "Execute_Flag");
				String Script_name = xl.Readvalue(Scenario_Search, irow, "Script_name");
				
				if((Execute_Flag.equals("Y")) && (Script_name.equals(Scriptname)))
				{
					Map<String,String> dsMap=new HashMap<String,String>();
					
					for(int jcol=0;jcol<=Colcount;jcol++)
					{
						
						String Key = xl.Readvalue(Scenario_Search, 0, jcol);
						String Value = xl.Readvalue(Scenario_Search, irow, jcol);
						
						dsMap.put(Key, Value);
						
						
					}
					
					Object[] x= new Object[1];
					x[0]=dsMap;
					
					list_Search.add(x);
				}//end of if
				
				
			}//end of for
			
			return list_Search;
			
			
		}
		

}
