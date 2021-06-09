package keywords;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

public class ApplicationKeyword extends ValidationKeywords {
	
	public ApplicationKeyword() {
		
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\env.properties";
		System.out.println(path);
		prop = new Properties();
		Envprop = new Properties();
		try {
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);
			String env=prop.getProperty("env")+".properties";
			path = System.getProperty("user.dir")+"\\src\\test\\resources\\"+env;
			fs = new FileInputStream(path);
			Envprop.load(fs);
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		softAssert = new SoftAssert();
		
	}
	
	public void Defaultlogin() {
		
		navigate("url");
		type("user_name_xpath",Envprop.getProperty("user_name"));
		type("password_id",Envprop.getProperty("password"));
		click("login_button_xpath");
		WaitforElementToLoad();
		
		
	}

	public void selectDate() {
		
	}
	
	public void verifyStockadded() {
		
	}
	
	public void SetReports(ExtentTest test) {
		this.test=test;
		
	}	
	
	public void dropdown(Select select) {
		this.select=select;
		
	}
	
	 public int CurrentStockQuantity(String name) {
		 
		 log("Findng the current stock of: "+name);
		int row = getRowNumber("Add_stock_xpath", name);
		
		 if(row==-1) {
			 log("Current stock is 0 as stock is not present");
			 return 0;
		 }
		 
		String quantity=driver.findElement(By.xpath("//table[@id='stock']/tbody/tr["+row+"]/td[4]")).getText();
		log("Stock Quantity is :"+quantity);
		return Integer.parseInt(quantity);
		 
		}
	 
		
		

		
		 
 }

	 
	 



