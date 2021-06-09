package options_and_profiling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChromeProfilingAndOptions {
	
	@Test
	
	public void chrome() {
		
		WebDriver driver = null;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\driver\\chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("--start--maximized");
		ops.addArguments("ignore certificate error");
		
		driver = new ChromeDriver(ops);
		driver.get("http://pushengage.com/demo");
		
		
	}

}
