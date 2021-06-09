package suitec;

import org.testng.annotations.Test;

import dataprovider.TestDataProvider;
import testbase.TestBase;

public class TestCC extends TestBase {
	
	@Test(groups={"smoke","browsergroup2"},dataProviderClass = TestDataProvider.class,dataProvider = "datasuiteC")
	public void testCC(String username,String pwd) throws InterruptedException {
		
		System.out.println("Starting CC");
		Thread.sleep(2);
		System.out.println("Ending CC");
	}
}
