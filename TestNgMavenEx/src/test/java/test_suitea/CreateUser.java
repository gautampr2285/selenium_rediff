package test_suitea;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataproviders.Data_providers;

public class CreateUser {
	
	//@Test(dataProvider = "getData")
	
	@Test(dataProviderClass = Data_providers.class,dataProvider = "getData")
	public void createusers(String browser,String name, int Phone ) {
		
		System.out.println("Create: Browser is" + " " + browser + " " + "User Name"+" "+name+" "+"Phone number is"+Phone);
	}
	
	/*@DataProvider 
	
	public Object[][] getData(){
		
		Object[][] data = new Object[2][3];
		
		
		data[0][0] = "Chrome";
		data[0][1] = "Admin";
		data[0][2] = 1234;
		
		data[1][0] = "Mozilla";
		data[1][1] = "Non Admin";
		data[1][2] = 3456;
				
		return data;
			
	}*/
	@Test(dataProviderClass  = Data_providers.class,dataProvider  = "getData")
	public void deleteuser(String browser,String name, int Phone) {
		System.out.println("Delete: Browser is" + " " + browser + " " + "User Name"+" "+name+" "+"Phone number is"+Phone);
		
		
	}
	
}
