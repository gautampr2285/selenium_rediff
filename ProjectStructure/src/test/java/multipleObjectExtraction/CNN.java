package multipleObjectExtraction;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CNN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Softwares\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		ChromeOptions ops = new ChromeOptions();
		//ops.setPageLoadStrategy(PageLoadStrategy.EAGER);
		driver.get("https://edition.cnn.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("All Links"+allLinks.size());
		//WebElement fifth_link = allLinks.get(5);
		//System.out.println(fifth_link.getText());
		//System.out.println(fifth_link.getAttribute("href"));
		
		//fifth_link.click();
		
		//to get all the webelement/link and text
		
		for(int i =0;i<allLinks.size();i++) {
			
			WebElement link = allLinks.get(i);
			System.out.println(link.getText()+"------"+link.isDisplayed());
		}
	}

}
