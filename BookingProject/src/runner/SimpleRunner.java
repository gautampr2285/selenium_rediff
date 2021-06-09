package runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class SimpleRunner {

	public static void main(String[] args) {
		
		TestNG testng = new TestNG();
		XmlSuite suite = new XmlSuite();
		suite.setName("Booking Suite");
		List<XmlSuite> Allsuites = new ArrayList<XmlSuite>();
		Allsuites.add(suite);
		testng.setXmlSuites(Allsuites);
		
		//First test case 
		
		XmlTest BookingTest = new XmlTest(suite);
		BookingTest.setName("Create Booking-Without discount");//Set the test Name
		//Adding Parameters:
		
		Map<String,String> parameters = new HashMap<String,String>();
		parameters.put("action","Without-discount");
		BookingTest.setParameters(parameters);
		List<XmlClass> AllClasses = new ArrayList<XmlClass>();
		
		//Ceating testclass and adding include methods
		XmlClass testClass = new XmlClass("testcases.BookingHotel");
		List<XmlInclude> methods = new ArrayList<XmlInclude>();
		methods.add(new XmlInclude("SearchHotel",1));
		methods.add(new XmlInclude("SelectHotel",2));
		methods.add(new XmlInclude("EnterGuestInfo",3));
		
		testClass.setIncludedMethods(methods);
		AllClasses.add(testClass);
		
		testClass = new XmlClass("testcases.PaymentManager");
		methods = new ArrayList<XmlInclude>();
		methods.add(new XmlInclude("Payment",1));
		
		testClass.setIncludedMethods(methods);
		AllClasses.add(testClass);
		
		testClass.setIncludedMethods(methods);
		AllClasses.add(testClass);
		
		testClass = new XmlClass("testcases.CustomerCommunication");
		methods = new ArrayList<XmlInclude>();
		methods.add(new XmlInclude("checkMail",1));
		
		testClass.setIncludedMethods(methods);
		AllClasses.add(testClass);
		
		BookingTest.setXmlClasses(AllClasses);
		
		//2nd test
		
		XmlTest BookingTestWD = new XmlTest(suite);
		BookingTestWD.setName("Create Booking: With discount");//Set the test Name
		//Adding Parameters:
		
		Map<String,String> parametersWD = new HashMap<String,String>();
		parametersWD.put("action","With discount");
		BookingTestWD.setParameters(parametersWD);
		List<XmlClass> AllClassesWD = new ArrayList<XmlClass>();
		
		//Ceating testclass and adding include methods
		XmlClass testClassWD = new XmlClass("testcases.BookingHotel");
		List<XmlInclude> methodsWD = new ArrayList<XmlInclude>();
		methodsWD.add(new XmlInclude("SearchHotel",1));
		methodsWD.add(new XmlInclude("SelectHotel",2));
		methodsWD.add(new XmlInclude("EnterGuestInfo",3));
		
		testClassWD.setIncludedMethods(methods);
		AllClassesWD.add(testClassWD);
		
		testClassWD = new XmlClass("testcases.PaymentManager");
		methodsWD = new ArrayList<XmlInclude>();
		methodsWD.add(new XmlInclude("Discount",1));
		methodsWD.add(new XmlInclude("Payment",2));
		
		testClassWD.setIncludedMethods(methodsWD);
		AllClassesWD.add(testClassWD);
		
		testClassWD.setIncludedMethods(methodsWD);
		AllClassesWD.add(testClassWD);
		
		testClassWD = new XmlClass("testcases.CustomerCommunication");
		methodsWD = new ArrayList<XmlInclude>();
		methodsWD.add(new XmlInclude("checkMail",1));
		
		testClassWD.setIncludedMethods(methodsWD);
		AllClassesWD.add(testClassWD);
		
		BookingTestWD.setXmlClasses(AllClassesWD);
		
		testng.run();

	}

}
