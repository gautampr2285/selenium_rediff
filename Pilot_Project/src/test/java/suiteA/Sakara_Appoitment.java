package suiteA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import testbase.Test_Base;

public class Sakara_Appoitment extends Test_Base {
	
	@Test
	
	public void appoint_test() throws InterruptedException {
		
		 //prop = null;
		//Reading from Properties file
		
		LaunchBrowser("Chrome");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		waitForPageToLoad();
		driver.findElement(By.linkText(prop.getProperty("doctor_name"))).click();
		Thread.sleep(5000);
		if(!IsElementPresent(prop.getProperty("Name_field")))
			failandStop("Element not present");
			
		
		//driver.findElement(By.xpath(prop.getProperty("doctor_1"))).click();;
		driver.findElement(By.id(prop.getProperty("Name_field"))).sendKeys(prop.getProperty("First_Name"));
		driver.findElement(By.xpath(prop.getProperty("Email_field"))).sendKeys(prop.getProperty("Email"));
		driver.findElement(By.xpath(prop.getProperty("phone"))).sendKeys(prop.getProperty("mobile_num"));
		WebElement droplist = driver.findElement(By.xpath(prop.getProperty("gender")));
		
		Select s = new Select(droplist);
		//List<WebElement> l = s.getOptions();
		//for(WebElement i:l)
			///System.out.println(i.getText());
		//s.selectByValue(prop.getProperty("value"));
		//System.out.println(prop.get("value_Drop"));
		s.selectByVisibleText("Male");
		
		driver.findElement(By.xpath(prop.getProperty("dob"))).click();
		//String DateofBirth = prop.getProperty("dob_value");	
		selectDate(prop.getProperty("dob_value"));
		if(driver.findElement(By.xpath(prop.getProperty("uuid_name"))).isDisplayed()){
			failandStop("UUID is displayed");		
		}
		driver.findElement(By.xpath(prop.getProperty("Radio_Yes"))).click();
		
		if(!driver.findElement(By.xpath(prop.getProperty("uuid_name"))).isDisplayed()){
			failandStop("UUID is not displayed");		
		}
				
		
	} 
		
		public boolean IsElementPresent(String locator) {
			WebElement e = null;
			try {
			e= driver.findElement(By.id(locator));
			}	catch(Exception ex) {
				
				return false;
			}
			if(!e.isDisplayed())
				return false;
			return true;
		}
		
	
	public void waitForPageToLoad(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i=0;
		
		while(i!=15){
		String state = (String)js.executeScript("return document.readyState;");
		System.out.println(state);

		if(state.equals("complete"))
			break;
		else
			wait(2);

		i++;
		}
		// check for jquery status
		i=0;
		while(i!=15){
	
			Long d= (Long) js.executeScript("return jQuery.active;");
			System.out.println(d);
			if(d.longValue() == 0 )
			 	break;
			else
				 wait(2);
			 i++;
				
			}
		
		}
		public void wait(int time) {
			try {
			Thread.sleep(time*1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	
		
	public void selectDate(String ProvideDate) {
		
		String DateDisplayed = driver.findElement(By.xpath(prop.getProperty("datedisplayed"))).getText();
		System.out.println(DateDisplayed);
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
				Date DateToBeSelected = sd.parse(ProvideDate);
				Date currentDate = new Date();
				//System.out.println(currentDate);
				//System.out.println(DateToBeSelected);
				
				String day = new SimpleDateFormat("dd").format(DateToBeSelected);
				//System.out.println(day);
				String month = new SimpleDateFormat("MMMM").format(DateToBeSelected);
				//System.out.println(month);
				String year = new SimpleDateFormat("yyyy").format(DateToBeSelected);
				//System.out.println(year);
				String MonthYeartobeselected = month+" "+year;
				//System.out.println(MonthYeartobeselected);
				
				while(!MonthYeartobeselected.equals(DateDisplayed)){
					
					if(DateToBeSelected.compareTo(currentDate)==1) {
						driver.findElement(By.xpath(prop.getProperty("next"))).click();
						DateDisplayed = driver.findElement(By.xpath(prop.getProperty("datedisplayed"))).getText();
						
					}else if(DateToBeSelected.compareTo(currentDate)==-1) {
						driver.findElement(By.xpath(prop.getProperty("next"))).click();
						DateDisplayed = driver.findElement(By.xpath(prop.getProperty("datedisplayed"))).getText();
				  }
					
					
				}
				
				driver.findElement(By.xpath("//a[text()='"+day+"']"));//select the date in the properties file.
				
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
}
