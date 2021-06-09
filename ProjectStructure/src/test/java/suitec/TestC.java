package suitec;

import org.testng.annotations.Test;

import dataprovider.TestDataProvider;
import testbase.TestBase;

public class TestC extends TestBase {

	@Test(groups={"smoke","browsergroup1"},dataProviderClass = TestDataProvider.class,dataProvider = "datasuiteC")
	public void testC(String username,String pwd) throws InterruptedException {
		
		System.out.println("Starting C");
		Thread.sleep(2);
		System.out.println("Ending C");
	}
}
