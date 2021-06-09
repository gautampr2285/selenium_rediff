package testBase;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import keywords.ApplicationKeyword;
import reports.ReportManager;

public class BaseTest {
	
	public ApplicationKeyword apps;
	public ExtentReports reports;
	public ExtentTest test;
	public Properties prop;
	
	
	//public int i;
	
	@BeforeTest(alwaysRun = true)
	
	//used to inintialize
	public void beforeTest(ITestContext context) {
		
		System.out.println("=====================Before Test=====================");
		apps = new ApplicationKeyword();
		
		//In before test initialize the application keywords
		context.setAttribute("applicationKW", apps);
		
		//Initialize the reports for the tets case:
		reports = ReportManager.getReports();
		test = reports.createTest(context.getCurrentXmlTest().getName());//get the test name from the xml
		test.log(Status.INFO, "Starting test"+context.getCurrentXmlTest().getName());
		apps.SetReports(test);
		context.setAttribute("report", reports);
		context.setAttribute("test", test);
		apps.openbrowser("Chrome");
		apps.Defaultlogin();
		
		
	}
	
	@BeforeMethod(alwaysRun = true )
	
	public void beforeMethdd(ITestContext con) {
		
		System.out.println("*******Before Method*******");
		
		String Critical = (String) con.getAttribute("CriticalFailure");
		
		if(Critical!=null && Critical.equals("Y") ) {
			
			test.log(Status.SKIP, "Critical failure in previous test"); //skip the test in Extent Reports
			throw new SkipException("Critical failure in previous test");//skip the test in TestNG
		}
		
		//extracted from the context 
		 apps = (ApplicationKeyword) con.getAttribute("applicationKW");
		 reports = (ExtentReports) con.getAttribute("report");
		 test = (ExtentTest) con.getAttribute("test");
	}
	
	@AfterTest
	
	public void quit() {
		
		if(reports!=null) {
			
			reports.flush();
		}
		
	}
	


}
