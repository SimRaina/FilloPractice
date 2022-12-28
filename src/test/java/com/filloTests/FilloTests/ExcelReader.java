package com.filloTests.FilloTests;

import java.util.ArrayList;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelReader {
	
	ArrayList<String> column= new ArrayList<String>();
	ArrayList<String> loginValues=new ArrayList<String>();
	ArrayList<String> infoValues=new ArrayList<String>();
	public String filepath;
	
	
	public ArrayList<String> getData(String filepath,String excelName,String sheetName, int rowNumber) throws FilloException {
		this.filepath=filepath;
		Fillo fillo=new Fillo();
		String filepath1 = filepath+excelName;
	
	    Connection connection=fillo.getConnection(filepath1);  // Setting connection with the Excel File
		
		// Select query with Where condition
		String strQuery  ="Select * from "+sheetName+" where TC="+rowNumber+" "; // Writing SQL Query
		
		// Select query with Where Method
		  String strQuery1 = ("Select * from "+ sheetName);
		  
		// Recordset recordset=connection.executeQuery(strQuery1).where("TC="+rowNumber); // Execute Query and store result in Recordset
     
		 Recordset recordset = connection.executeQuery(strQuery);
		 
		 while(recordset.next()){  // Condition till recordset has rows
        
			column=recordset.getFieldNames(); // get column names
          
			for (int i=0;i<column.size();i++) {  // run for loop for desired column values
                loginValues.add(recordset.getField(column.get(i)));  // add row values to ArrayList
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
		
		String strQuery="UPDATE "+sheetName+ " SET Result='"+result+"' " + "where TC="+rowNumber+" "; 
		connection.executeUpdate(strQuery);
		connection.close();
    }
	
	public void insertData(String filepath,String excelName,String sheetName) throws FilloException {
		this.filepath=filepath;
		Fillo fillo=new Fillo();
		String filepath1 = filepath+excelName;
	
		Connection connection=fillo.getConnection(filepath1);  // Setting connection with the Excel File
		
		String strQuery1="INSERT INTO "+ sheetName + "(TC,Name,Country) VALUES(2,'Sam','US')";
		connection.executeUpdate(strQuery1);
		connection.close();
    }
	
	public ArrayList<String> getData2(String filepath, String excelName, String sheetName, int rowNumber, String name) throws FilloException{
		
		this.filepath=filepath;
		Fillo fillo=new Fillo();
		String filepath1 = filepath+excelName;
	
		Connection connection=fillo.getConnection(filepath1);  
		
		// Multiple Where conditions
		String strQuery2 = "Select * from " + sheetName+" where TC="+rowNumber+" and Name='"+name+"'";
		
		// Like Operator
		String strQuery3 ="Select * from "+ sheetName+ " where name like 'P%'";
		Recordset recordset = connection.executeQuery(strQuery3);
		
		while(recordset.next()){                                                 
        
			column=recordset.getFieldNames(); 
          
			for (int i=0;i<column.size();i++) {  
                infoValues.add(recordset.getField(column.get(i))); 
            }
        } 
		recordset.close();
		connection.close();
		return infoValues;		
	}
}


