package object_extraction;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;

public class CNNHeaderLink2 extends TestBase{
	
	
	@Test
	
	public void CNNheader() {
		
		SoftAssert softAssert = new SoftAssert();
		WebDriver driver = launchbrowser("Chrome");
		driver.get("https://edition.cnn.com/");
		
		String str1 =" //*[@id='header-nav-container']/div/div[1]/div/div[2]/nav/ul/li[";
		String str2="]/a";
		WebElement Box = driver.findElement(By.xpath("//*[@id='header-nav-container']/div/div[1]/div/div[2]/nav/ul"));
		List<WebElement> links = Box.findElements(By.tagName("a"));
		int size = links.size();
		
		System.out.println(size);
				
		for(int i =1;i<=size;i++) {
			boolean present = IsElementPresent(str1+i+str2);
			softAssert.assertTrue(present, "Not Present");
			String text = driver.findElement(By.xpath(str1+i+str2)).getText();
			System.out.println(text);
			String url = driver.findElement(By.xpath(str1+i+str2)).getAttribute("href");
			System.out.println(url);
			boolean result = ValidateResponse(url);
			softAssert.assertTrue(result, "Invalid response");
			driver.findElement(By.xpath(str1+i+str2)).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
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
	
	public boolean IsElementPresent(String xpath) {
		
		int s =driver.findElements(By.xpath(xpath)).size();
		
		if(s==0)
			return false;
		
		if(driver.findElement(By.xpath(xpath)).isDisplayed() && driver.findElement(By.xpath(xpath)).isEnabled())
			return true;
		else
		
			return false;				

	}
}
