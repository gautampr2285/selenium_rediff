package runner;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestNgRunner testNg = new TestNgRunner(1);
		//we will create constructor for TestNgRunner which takes int value. It defines the number of test suites run parallely
		
		testNg.createSuiteName("Portfolio_Suite", false);
		testNg.addListner("listener.CustomListner");
		testNg.addTest("Add_new_stock");
		testNg.addTestParam("action", "addstock");
		List<String> includedMethods = new ArrayList<String>();
		testNg.addTestClass("testRediff.PortFolioManagement", includedMethods);
		includedMethods = new ArrayList<String>();
		includedMethods.add("selectPortfolio");
		testNg.addTestClass("testRediff.StockManagement", includedMethods);
		includedMethods.add("AddStock");
		includedMethods.add("VerifyStockInList");
		testNg.run();

	}

}
