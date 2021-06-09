package dataproviders;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class Data_providers {
	
@DataProvider 
	
	public Object[][] getData(Method m){
		 //Method m will get the method which is calling getData

		System.out.println("Method"+ " "+m.getName());
	
		Object[][] data = new Object[2][3];
		
		
		data[0][0] = "Chrome";
		data[0][1] = "Admin";
		data[0][2] = 1234;
		
		data[1][0] = "Mozilla";
		data[1][1] = "Non Admin";
		data[1][2] = 3456;
				
		return data;

  }
}