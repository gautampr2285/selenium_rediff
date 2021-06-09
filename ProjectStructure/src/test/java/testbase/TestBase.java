/*1) *Data provider for one test suite
2) Implement listners
3)run from Mavne
4) Run Parallely*/



package testbase;


import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ReportManager;

public class TestBase {
	
	public ExtentReports rep; //extent test objects are declared so that they are visible all over. 
	public ExtentTest test;
	public SoftAssert softAssert;
	public String browser;
	@BeforeMethod(alwaysRun = true)
	
	public void init(ITestContext con,ITestResult result) {
		String name = result.getMethod().getMethodName().toUpperCase();
		rep = ReportManager.getReports();
		test = rep.createTest(name);
		softAssert = new SoftAssert();
		/*browser = con.getCurrentXmlTest().getParameter("browser");//code when all test cases needs to rum from ne browser
		System.out.println(browser);*/
		
		//Find group name from test method parameteres
		//System.out.println("Total Method "+con.getAllTestMethods().length);
		// code to run test cases in differet broswer 
		String groupName[] = con.getAllTestMethods()[0].getGroups(); //get all groups in an array
		String browserGroup ="";
		for(String g:groupName) {
			if(g.startsWith("browsergroup")) {
				browserGroup = g;
				break;
			}
		}
		//System.out.println("Broswer: "+browserGroup);
		//System.out.println("browser group"+con.getCurrentXmlTest().getParameter(browserGroup));
		browser = con.getCurrentXmlTest().getParameter(browserGroup);
		System.out.println("Browser is "+browser);
	}
	
	@AfterMethod
	
	public void quit() {
		
		rep.flush();
	}
	
	public void log(String msg) {
		System.out.println(msg);
		test.log(Status.INFO,msg);
	}
	
	public void logFailure(String msg) {//fail in exent report
		System.out.println(msg);
		test.log(Status.FAIL, msg);
	}
	
	public void FailandStop(String msg) { //Fail in testNg and extent report and stop the flow
		logFailure(msg);//extent
		softAssert.fail(msg);//TestNG
		softAssert.assertAll();//Stop
		
		
	}
	//initialize the soft assert class
	public void softAssert(String msg) {//Fail in testNg and extent report but continue the flow
		logFailure(msg);//fails in extent report
		softAssert.fail(msg);
	}
	
	
	
	
	
	
	

}
