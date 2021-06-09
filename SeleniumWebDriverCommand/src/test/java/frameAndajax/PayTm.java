package frameAndajax;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.TestBase;

public class PayTm extends TestBase{
	
	@Test
	
	public void paytm() throws InterruptedException {
		
		launchbrowser("Chrome");
		driver.get("https://paytm.com/");
		//Thread.sleep(10000);
		waitForPageToLoad();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div[3]/div/div/div")));
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div[3]/div/div/div")).click();
	}
	
	public void waitForPageToLoad() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i=0;
		// page to load 100% -- wait for max 20 secs
		while(i!=10){
			String state = (String)js.executeScript("return document.readyState;");
			System.out.println(state);// complete, loading, interactive
	
			if(state.equals("complete"))
				break;
			else
				Thread.sleep(2000);
	
			i++;
		}

	}
}
