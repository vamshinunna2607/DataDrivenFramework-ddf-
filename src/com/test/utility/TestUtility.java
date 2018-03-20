package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtility {

	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		reader = new Xls_Reader("C:\\Users\\vamsh\\eclipse-workspace\\DataDrivenFramework\\src\\com\\testdata\\testData.xlsx");
	
		for(int rownum =2; rownum<= reader.getRowCount("sheet1");rownum++)
		{
			String firstname = reader.getCellData("sheet1", "firstname", rownum);
			String lastname = reader.getCellData("sheet1", "lastname", rownum);
			String emailaddress = reader.getCellData("sheet1", "emailaddress", rownum);
			Object ob[] = {firstname,lastname,emailaddress};
			
			myData.add(ob);
		}
		return myData;
	}
	
}
