package suitea;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import dataprovider.TestDataProvider;
import listner.CustomListner;
import reports.ReportManager;
import testbase.TestBase;



public class TestA extends TestBase {
	
	
	
	@Test(groups={"smoke","browsergroup1"},dataProviderClass = TestDataProvider.class,dataProvider = "datasuiteA")
	
	public void testA(String BrowserName,String username,String pwd) throws InterruptedException{
		
		log("Starting test case A");
		
		if(!"Title1".equals("Title")) {
			softAssert("Title do not match");
		}
		
		if(!"Text1".equals("Text2")) {
			softAssert("Text do not match");
		}
		
		//if(!"a".equals("b")) {
		//	FailandStop("Hard assert");
		//}
		log(BrowserName +"--"+username+"--"+pwd);
		Thread.sleep(2000);
		log("Ending test case A");
		//softAssert.assertAll();
	}

	
}
