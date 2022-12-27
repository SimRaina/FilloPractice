package com.filloTests.FilloTests;

import com.codoid.products.client.By;
import com.codoid.products.client.Desktop;
import com.codoid.products.client.Server;
import com.codoid.products.client.Window;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Test {
	
	public static void main(String args[]) throws FilloException {
		
		
		Server server = new Server("localhost", 3000);  
		//To initialize the Server 
		 
		        server.openApplication("C:\\WINDOWS\\system32\\notepad.exe");
		// To launch the Windows application
		 
		        Desktop desktop = server.getDesktop();
		//By using this Server class object, we will take control of the Desktop first and then take control of all the running apps. 
		 
		        Window window = desktop.findWindow(By.name("Untitled - Notepad"));  
		//To find the window using the locator strategy and attach the window session in the window reference object.
		 
		        window.findElement(By.xpath("//MenuItem[@name='File']")).click();   
		// Using findElement keyword, to find the particular element and then 'click' action performed.
	}

}
