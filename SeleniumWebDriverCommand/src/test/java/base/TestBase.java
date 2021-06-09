package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver launchbrowser(String BrowserName) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Softwares\\driver\\chromedriver.exe");
		System.setProperty("webdriver.geco.driver", "C:\\Softwares\\driver\\geckodriver.exe");
		System.getProperty("webdriver.edge.driver","C:\\Softwares\\driver\\msedgedriver.exe");
		
		if(BrowserName.equals("Chrome")) {
			driver = new ChromeDriver();
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			ops.setPageLoadStrategy(PageLoadStrategy.EAGER);
							
		}else if(BrowserName.equals("Mozilla")){
			driver = new FirefoxDriver();
			
			FirefoxOptions fxo = new FirefoxOptions();
			fxo.setPageLoadStrategy(PageLoadStrategy.NONE);
			
		}else if(BrowserName.equals("Edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		return driver;
		
	}

}
