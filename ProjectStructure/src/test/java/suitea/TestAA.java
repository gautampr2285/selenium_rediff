package suitea;

import org.testng.annotations.Test;

import dataprovider.TestDataProvider;
import testbase.TestBase;

public class TestAA extends TestBase {
	
	@Test(groups={"sanity","browsergroup1"},dataProviderClass = TestDataProvider.class,dataProvider = "datasuiteA")
	
	public void testAA(String username,String pwd) throws InterruptedException {
		
		log("Starting test case AA");
		log(username+"--"+pwd);
		Thread.sleep(2);
		log("Ending test case AA");
	}

}
