package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import reports.ReportManager;

public class LoginTest {
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeMethod
	
	public void init() {
		
		reports = ReportManager.getReports();
		test = reports.createTest("Login Test");
			
	}
	
	@AfterMethod
	
	public void quit() {
		reports.flush();//generate reports
	}
	
	@Test
	public void login() {
		//test = reports.createTest("Login Test");
		test.log(Status.INFO,"Starting test case");
		test.log(Status.INFO,"Opening browser");
		test.log(Status.INFO,"Logging In");
		test.log(Status.PASS, "Test Case Passed");	
	}
	

}
