package com.filloTests.FilloTests;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;

public class DataTest {
	
	ExcelReader excel;
	ArrayList<String> login_cred = new ArrayList<String>();
	ArrayList<String> info = new ArrayList<String>();
	String filepath=System.getProperty("user.dir") + "\\Resource\\";
	String sheetName = "login";
	String fileName =  "data.xlsx";

	@Test(enabled=false)
	public void getTest() throws FilloException {
		excel = new ExcelReader();
	
		// calling getData method
		login_cred = excel.getData(filepath, fileName, sheetName, 1);
	    System.out.println(login_cred.get(0)+ ", " + login_cred.get(1) + ", " + login_cred.get(2));
	    //System.out.println(login_cred.get(4)+ ", " + login_cred.get(5) + ", " + login_cred.get(6));
	}
	
	@Test(enabled=false)
	public void updateTest() throws FilloException{
		excel = new ExcelReader();
		
		// calling updateData method
		excel.updateData(filepath, fileName, sheetName, "Pass", 1);
				
		login_cred = excel.getData(filepath, fileName, sheetName, 1);
		System.out.println(login_cred.get(0)+ ", " + login_cred.get(1) + ", " + login_cred.get(2) + ", " + login_cred.get(3));
	}
	
	@Test(enabled=true)
	public void insertTest() throws FilloException{
		excel = new ExcelReader();
		
		// excel.insertData(filepath, fileName, "info");
		
		info = excel.getData2(filepath, fileName, "info", 2, "Sam");
		System.out.println(info.get(0)+ ", " + info.get(1) + ", " + info.get(2));	
	}

}
