package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataProviders 
{
	//DataProvider 1
	@DataProvider (name="LoginData")
	public String[][] getData() throws IOException
	{
	    String path = "../OpencartV121/testData/OpenCart_LoginData.xlsx"; //taking xl file from testData
	    
	    excelUtility xlutil = new excelUtility(path);                     //creating an object for XLUtility
	    
	    int totalrows = xlutil.getRowCount("Sheet1");
	    int totalcols = xlutil.getCellCount("Sheet1", 1);
	    
	    String logindata[][] = new String[totalrows][totalcols];          //created for two dimension array which can store
	    
	    for (int i = 1; i <totalrows; i++)                               //1 -> start from 1 for row
	    {                             
	        for (int j = 0; j < totalcols; j++)                           //0 -> start from 0 for column
	        {                         
	            logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);     //i, j
	        }
	    }
	    return logindata; //returning two dimension array
	}	
}
