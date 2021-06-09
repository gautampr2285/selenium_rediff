package listner;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class CustomListner implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		
		System.out.println("***********Test Fail******"+result.getName());
	
	}
	
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("***********Test Fail******"+result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("*********Test Skipped*****"+result.getName());
		
	}

}
