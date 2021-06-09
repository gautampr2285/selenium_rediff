package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.testng.ITestContext;

public class CustomListner implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Failed Test Name : "+result.getName());
		//System.out.println(result.getThrowable().getMessage());	
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("test");
		test.log(Status.FAIL, result.getThrowable().getMessage());
				
	}
	
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("---Test Case Passed---"+result.getName());
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("test");
		//System.out.println(result.getThrowable().getMessage());
		test.log(Status.PASS, "Test Passed"+result.getName());
	}
	
   public void onTestSkipped(ITestResult result) {
		
		System.out.println("***Test Case skipped**"+result.getName());
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("test");
		//System.out.println(result.getThrowable().getMessage());
		test.log(Status.SKIP, "Test Passed"+result.getName());
	}
	
	

}
