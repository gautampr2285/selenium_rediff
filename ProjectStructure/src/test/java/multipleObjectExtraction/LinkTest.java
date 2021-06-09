package multipleObjectExtraction;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testbase.TestBase;

public class LinkTest extends TestBase{
	
	@Test
	
	/*
	public void CNN_Object() {
	
	//WebDriver driver = LaunchBrowser("Chrome");
	driver.get("https://edition.cnn.com/");
	
	List<WebElement> toplinks =driver.findElements(By.xpath("//*[@id=\"header-nav-container\"]/div/div[1]/div/div[2]/nav/ul/li/a"));
	
	System.out.println(toplinks.size());
	
	for(WebElement i : toplinks) {
		
		System.out.println(i.getText());
		String url = i.getAttribute("href");
		System.out.println(url);
		
		System.out.println("-------");

 }
	
}*/



	public boolean Response_Code(String url) {
		// TODO Auto-generated method stub
		
		
		String URL = "https://edition.cnn.com/world";
		
		int Resp_code = 0;
		
		try {
			Resp_code = Request.Get(URL).execute().returnResponse().getStatusLine().getStatusCode();
			System.out.println("Response of URL " + URL + " is " +Resp_code );
			
			if(Resp_code==200) {
				
				return true;
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Response of URL " + URL + " is " +Resp_code );
		
		return false;
	}

}
