package javascriptactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.TestBase;

public class AmericanGolf extends TestBase{
	
	@Test
	
	public void testAmerican() throws InterruptedException {
		
		launchbrowser("Chrome");
		driver.get("https://www.americangolf.co.uk/");
		WebElement golfClub = driver.findElement(By.xpath("//*[@id='header-navigation']/div[1]/ul/li[2]/a"));
		Actions act = new Actions(driver);
		act.moveToElement(golfClub).build().perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CLUBS_1']/ul/li[3]/ul/li/a/span")));
		driver.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[3]/ul/li/a/span")).click();
		waitForPageToLoad();
		WebElement e = driver.findElement(By.xpath("//*[@id='secondary']/div[1]/div[7]/div/div/div[1]/div"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		act.dragAndDropBy(e, 50, 0).build().perform();
		
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
