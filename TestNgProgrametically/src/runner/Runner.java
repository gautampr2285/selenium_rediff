package runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Runner {

	public static void main(String[] args) {
		
		TestNG testng = new TestNG();
		XmlSuite suite = new XmlSuite();
		suite.setName("My Suite"); // Set the suite Name
		List<XmlSuite> Allsuites = new ArrayList<XmlSuite>();//in the AllSuite list will add all the test suite
		Allsuites.add(suite);
		testng.setXmlSuites(Allsuites);//TestNg has all the XML suites.
		
		XmlTest test = new XmlTest(suite);
		test.setName("Login Test");//Set the test Name
		List<XmlClass> AllClasses = new ArrayList<XmlClass>();
		AllClasses.add(new XmlClass("testcase.Login"));
		test.setXmlClasses(AllClasses);
		
		testng.run();

		




	}

}
