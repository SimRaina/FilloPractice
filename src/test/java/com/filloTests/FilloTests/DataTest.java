package com.filloTests.FilloTests;

import java.util.ArrayList;

import com.codoid.products.exception.FilloException;

public class DataTest {
	
	ExcelReader excel;
	ArrayList<String> login_cred = new ArrayList<String>();
	ArrayList<String> info = new ArrayList<String>();
	String filepath=System.getProperty("user.dir") + "\\Resource\\";
	String sheetName = "login";
	String fileName =  "data.xlsx";

	public static void main(String args[]) throws FilloException {
		
		DataTest dt = new DataTest();
		dt.test();
		
	}
	
	public void test() throws FilloException {
		excel = new ExcelReader();
		/* login_cred = excel.getData(filepath, fileName, sheetName, 1);
		System.out.println(login_cred.get(0));
		System.out.println(login_cred.get(1));
		
		excel.updateData(filepath, fileName, sheetName, "Pass", 1);
		login_cred = excel.getData(filepath, fileName, sheetName, 1);
		System.out.println(login_cred.get(2));
		
		//excel.insertData(filepath, fileName, "info"); */
		info = excel.getData(filepath, fileName, "info", 1, "Piotr");
	    System.out.println(info.get(0));
		System.out.println(info.get(1));
		System.out.println(info.get(2));
	}

}
