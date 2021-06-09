package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import org.testng.asserts.Assertion;


public class Test_Base {
	
	
	public WebDriver driver = null;
	public Properties prop = null;
	public SoftAssert softAssert;
	
	//@BeforeMethod()
	public WebDriver LaunchBrowser(String BrowserName) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
	
		if(BrowserName.equals("Chrome")) {
			driver = new ChromeDriver();
			ChromeOptions ops = new ChromeOptions();
			ops.setPageLoadStrategy(PageLoadStrategy.EAGER);
							
		}else if(BrowserName.equals("Mozilla")){
			driver = new FirefoxDriver();
			
			FirefoxOptions fxo = new FirefoxOptions();
			fxo.setPageLoadStrategy(PageLoadStrategy.NONE);
			
		}else if(BrowserName.equals("Edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//proj.properties");
			prop.load(fs);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return driver;
					
	}
	//@AfterMethod
	
	public void failandStop(String msg) {
		
		softAssert = new SoftAssert();
		softAssert.fail(msg);
		softAssert.assertAll();
	}
	
	
	public void softAssert(String msg) {
		softAssert.fail(msg);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
