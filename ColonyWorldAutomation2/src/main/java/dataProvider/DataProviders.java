package dataProvider;

import org.testng.annotations.DataProvider;

import utility.NewExcelLibrary;

public class DataProviders {
	NewExcelLibrary  obj = new NewExcelLibrary ();
	@DataProvider(name="credentils")
	public Object[][]getCredentials(){ 
		//Total Rows Count 
		int rows= obj.getRowCount("credentials");
		//Total Columns 
		int column= obj.getColumnCount("credentials");
		int actRows=rows-1;
		
		Object[][]data= new Object[actRows][column];
		for (int i=0;i<actRows;i++) {
			for (int j=0;j<column;j++) {
				data[i][j]=obj.getCellData("credentials",j,i+2  );
		}
	}
return data;
	}
}
