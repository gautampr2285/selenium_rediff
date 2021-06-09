package browsera;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumBasics {
	
	@Test
	
	public void testApp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		//driver.manage().window().maximize();
		//System.setProperty("webdriver.geco.driver", "C:\\Softwares\\driver\\geckodriver.exe");
		//FirefoxDriver fd = new FirefoxDriver();
		
		//System.getProperty("webdriver.edge.driver","C:\\Softwares\\driver\\msedgedriver.exe");
		//EdgeDriver ed = new EdgeDriver();
		//ed.get("https://www.google.com");
		
	}

}
