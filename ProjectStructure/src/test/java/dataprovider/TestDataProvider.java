package dataprovider;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider
	
	public static Object[][] datasuiteA(ITestContext con,Method m) {
		String browsers[] =con.getCurrentXmlTest().getParameter("browsers").split(",");
		System.out.println(browsers[0]);
		System.out.println(browsers[1]);
		//System.out.println(m.getName());
		Object[][] data = null;
		if(m.getName().equals("testA")){
			
			data = new Object[2][3];
			
			data[0][0] =browsers[0];
			data[0][1] ="User 1" ;
			data[0][2] ="pwd 1" ;
			
			data[1][0] =browsers[1] ;
			data[1][1] ="User 2" ;
			data[1][2] ="pwd 2" ;
						
		}else if (m.getName().equals("testAA")){
			
			data = new Object[2][3];
			data[0][0] =browsers[0];
			data[0][1] ="USer 1" ;
			data[0][2] ="pwd1" ;
			
			data[1][0] =browsers[1];
			data[1][1] ="User 2" ;
			data[1][2] ="pwd 2" ;
	}
		return data;
		
}
		  		
	@DataProvider
	
	public static Object[][] datasuiteB(Method m) {
		
		System.out.println(m.getName());
		Object[][] data = null;
		if(m.getName().equals("testB")){
			
			data = new Object[2][2];
			
			data[0][0] ="USer 1" ;
			data[0][1] ="USer 2" ;
			
			data[1][0] ="pwd 1" ;
			data[1][1] ="pwd 2" ;
			
					
		}else if (m.getName().equals("testBB")){
			
			data = new Object[2][2];
			
			data[0][0] ="USer 1" ;
			data[0][1] ="USer 2" ;
			
			data[1][0] ="pwd 1" ;
			data[1][1] ="pwd 2" ;
	}
		return data;
		
		
	}
	
	@DataProvider
	
	public static Object[][] datasuiteC(Method m) {
		
		System.out.println(m.getName());
		Object[][] data = null;
		if(m.getName().equals("testC")){
			
			data = new Object[2][2];
			
			data[0][0] ="USer 1" ;
			data[0][1] ="USer 2" ;
			
			data[1][0] ="pwd 1" ;
			data[1][1] ="pwd 2" ;
			
					
		}else if (m.getName().equals("testCC")){
			
			data = new Object[2][2];
			
			data[0][0] ="USer 1" ;
			data[0][1] ="USer 2" ;
			
			data[1][0] ="pwd 1" ;
			data[1][1] ="pwd 2" ;
	}
		return data;
		
}
	
	

}
