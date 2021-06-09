package suiteb;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import dataprovider.TestDataProvider;
import testbase.TestBase;

public class TestB extends TestBase {

	
	
	@Test(groups={"smoke","browsergroup2"},dataProviderClass = TestDataProvider.class,dataProvider = "datasuiteB")
		
		public void testB(String username,String pwd) throws InterruptedException {
			
			log(username +"-------"+pwd);
			Thread.sleep(2);
			log("Ending test case B");
		}

	
}
