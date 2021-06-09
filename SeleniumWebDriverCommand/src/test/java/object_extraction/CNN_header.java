package object_extraction;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class CNN_header extends TestBase{
	
	
	@Test
	
	public void CNN_Object() {
		
		SoftAssert softAssert = new SoftAssert();
		WebDriver driver = launchbrowser("Chrome");
		//driver.get("https://edition.cnn.com/");
		driver.navigate().to("https://edition.cnn.com/");
		
		List<WebElement> toplinks =driver.findElements(By.xpath("//*[@id=\"header-nav-container\"]/div/div[1]/div/div[2]/nav/ul/li/a"));
		
		System.out.println(toplinks.size());
		
		for(WebElement i : toplinks) {
			
			System.out.println(i.getText());
			String url = i.getAttribute("href");
			System.out.println(url);
			boolean result = ValidateResponse(url);
			//Assert.assertTrue(result,"Invalid response");
			softAssert.assertTrue(result, "Invalid response");
			i.click();//click on the link
			System.out.println(driver.getTitle());//get the next wondow title
			driver.navigate().back();//back to main page
			toplinks =driver.findElements(By.xpath("//*[@id=\"header-nav-container\"]/div/div[1]/div/div[2]/nav/ul/li/a"));
			System.out.println("-------");
	}

  } 
	
	public boolean ValidateResponse(String url) {
		
		int Resp_code = 0;
		
		try {
			Resp_code = Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
			System.out.println("Response of URL " + url + " is " +Resp_code );//it will the response code.
			if(Resp_code==200) {
				return true;
			}
					
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}
	
}
