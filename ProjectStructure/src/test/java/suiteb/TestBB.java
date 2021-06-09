package suiteb;

import org.testng.annotations.Test;

import dataprovider.TestDataProvider;
import testbase.TestBase;

public class TestBB extends TestBase {

		@Test(groups={"sanity","browsergroup2"},dataProviderClass = TestDataProvider.class,dataProvider = "datasuiteB")
		
		public void testBB(String username,String pwd) throws InterruptedException {
			
			System.out.println("Starting BB");
			Thread.sleep(2);
			System.out.println("Ending BB");
		}

	}

