package multipleObjectExtraction;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Flipkart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				System.setProperty("webdriver.chrome.driver","C:\\Softwares\\driver\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				
				ChromeOptions ops = new ChromeOptions();
				//ops.setPageLoadStrategy(PageLoadStrategy.EAGER);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get("https://www.flipkart.com/clothing-and-accessories/topwear/tshirt/men-tshirt/pr?sid=clo,ash,ank,edy&otracker=categorytree&otracker=nmenu_sub_Men_0_T-Shirts");
				
				List<WebElement> allTshirts = driver.findElements(By.xpath("//a[@class='IRpwTa']"));
				
				System.out.println("All Links"+allTshirts.size());
				WebElement fifth_link = allTshirts.get(5);
				
				System.out.println(fifth_link);
				//System.out.println(fifth_link.getText());
				//System.out.println(fifth_link.getAttribute("href"));
				
				//fifth_link.click();
				
				//to get all the webelement/link and text
				/*
				for(int i =0;i<allTshirts.size();i++) {
					
					WebElement link = allTshirts.get(i);
					System.out.println(link.getText()+"------"+link.isDisplayed());*/
				
				for(WebElement e:allTshirts ) {
					
					System.out.println(e.getText()+"-------"+e.isDisplayed());
				}
				
				
				List<WebElement> TshirtPrice = driver.findElements(By.xpath("//div[@class='_30jeq3']"));
				for(WebElement e1:TshirtPrice) {
					
					System.out.println(e1.getText()+"-------"+e1.isDisplayed());
			}
				
				for(int i=0;i<allTshirts.size();i++) {
					System.out.println(allTshirts.get(i).getText()+"---------"+TshirtPrice.get(i).getText());
				}
	
	
	}

}


