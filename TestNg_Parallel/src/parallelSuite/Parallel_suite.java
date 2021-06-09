package parallelSuite;

import java.util.Arrays;

import org.testng.TestNG;

public class Parallel_suite {

	public static void main(String[] args) {
	
		TestNG testing = new TestNG();
		
		testing.setTestSuites(Arrays.asList(new String[] {System.getProperty("user.dir")+"//suite.xml"}));
		testing.setSuiteThreadPoolSize(2);
		
		testing.run();
		
		
	}

}
