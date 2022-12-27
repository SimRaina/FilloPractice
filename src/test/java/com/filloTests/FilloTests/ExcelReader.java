package com.filloTests.FilloTests;

import java.util.ArrayList;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelReader {
	
	ArrayList<String> row= new ArrayList<String>();
	ArrayList<String> loginValues=new ArrayList<String>();
	public String filepath;
	
	
	public ArrayList<String> getData(String filepath,String excelName,String sheetName, int rowNumber, String name) throws FilloException {
		this.filepath=filepath;
		Fillo fillo=new Fillo();
		String filepath1 = filepath+excelName;
	
		Connection connection=fillo.getConnection(filepath1);  // Setting connection with the Excel File
		
		//String strQuery="Select * from" +" "+sheetName+" "+ "where TC='"+rowNumber+"' "; // Writing SQL Query
		String strQuery1 = ("Select * from "+ sheetName);
		String strQuery = "Select * from " + sheetName+" where TC='"+rowNumber+"' and name='"+name+"'";
		String strQuery2="Select * from "+ sheetName+ " where name like '%am'";
		//Recordset recordset=connection.executeQuery(strQuery1).where("TC='"+rowNumber+"'"); // Execute Query and store result in Recordset
         Recordset recordset = connection.executeQuery(strQuery2);
		while(recordset.next()){  // Condition till recordset has values
        
			row=recordset.getFieldNames(); // get column names
			System.out.println(row);
          
			for (int i=0;i<row.size();i++) {  // run for loop for desired column values
                loginValues.add(recordset.getField(row.get(i)));  // add row values to ArrayList
            }
        } 
		recordset.close();
		connection.close();
		return loginValues;
    }
	
	public void updateData(String filepath,String excelName,String sheetName, String result, int rowNumber) throws FilloException {
		this.filepath=filepath;
		Fillo fillo=new Fillo();
		String filepath1 = filepath+excelName;
	
		Connection connection=fillo.getConnection(filepath1);  // Setting connection with the Excel File
		
		String strQuery="UPDATE" +" "+sheetName+" "+ "SET Result='"+result+"' " + "where TC='"+rowNumber+"' "; // Writing SQL Query
		connection.executeUpdate(strQuery);
		connection.close();
    }
	
	public void insertData(String filepath,String excelName,String sheetName) throws FilloException {
		this.filepath=filepath;
		Fillo fillo=new Fillo();
		String filepath1 = filepath+excelName;
	
		Connection connection=fillo.getConnection(filepath1);  // Setting connection with the Excel File
		
		String strQuery1="INSERT INTO "+ sheetName + "(TC,Name,Country) VALUES('1','Piotr','PL')";
		connection.executeUpdate(strQuery1);
		connection.close();
    }
}


