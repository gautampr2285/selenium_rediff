package runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

public class CustomTestNgRunner {
	TestNG mytestng;
	
	List<XmlSuite> mysuites; //All test suites to run
	XmlSuite suite; //single test suite
	List<XmlTest> suiteTestCases; //All test cases in a suite
	XmlTest test;  //single test case
	Map<String,String> testparam;  // parameters
	List<XmlClass> testclasses;  // All test class in a test
	
	public CustomTestNgRunner(Integer threadpoolsize) {
		
		mysuites = new ArrayList<XmlSuite>();  //initialize all suites
		mytestng = new TestNG();
		mytestng.setSuiteThreadPoolSize(threadpoolsize);//how many suites can run paralleley
		mytestng.setXmlSuites(mysuites);
	}
	
	//create a suite from list of suites
	public void createSuite(String suiteName, boolean parallelTests) {
		suite = new XmlSuite();
		suite.setName(suiteName);
		
		if(parallelTests) 
			
			suite.setParallel(ParallelMode.TESTS); //enable parallel execution\
		
			mysuites.add(suite);
			suiteTestCases = new ArrayList<XmlTest>();//adding all test in a suite

		//adding test case inside a test suite
	}
	
	public void AddTest(String name) {
		
		test = new XmlTest(suite);//create a test in a suite
		test.setName(name);//name of the test
		testparam = new HashMap<String,String>();
		test.setParameters(testparam);
		testclasses = new ArrayList<XmlClass>();//represents class in a test
		test.setXmlClasses(testclasses);
		
		suiteTestCases.add(test);
		
	}
	public void AddTestParam(String key,String value) {
		testparam.put(key, value);
	}
	
	public void AddTestClass(String fullClassName,List<String>inlcudeMethodsnames ) {
		
		XmlClass testClass = new XmlClass(fullClassName);
		List<XmlInclude> inlcudeMethods = new ArrayList<XmlInclude>(); //add all methods in a class
		
		int order=1;
		for(String name :inlcudeMethodsnames) {
			
			inlcudeMethods.add(new XmlInclude(name,order));
			order++;
		}
		
		testClass.setIncludedMethods(inlcudeMethods);//add class to list of classes
		testclasses.add(testClass); //add class to test class
	
		
	}
	
	public void run() {
		mytestng.run();
	}
	
	
	
	

}
