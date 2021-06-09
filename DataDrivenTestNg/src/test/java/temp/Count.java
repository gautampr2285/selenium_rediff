package temp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Count {

	public static void main(String[] args) throws InterruptedException {
		
		//test("Apollo Hospitals");
		int RowNumber = test("Apollo Hospitals");
		System.out.println("Row number is "+RowNumber);
		WebElement Price = driver.findElement(By.xpath("//table[@id='stock']/tbody/tr["+RowNumber+"]/td[4]"));
		System.out.println(Price.getText());
		
	}
	
		
		public static WebDriver driver;
		
		public static int test(String data) throws InterruptedException {
			
		driver=	new ChromeDriver();
		
		System.setProperty("webdriver.chrome.driver","C:\\Softwares\\driver\\chromedriver.exe");
		driver.get("https://portfolio.rediff.com/portfolio-login");
		driver.findElement(By.xpath("//input[@id='useremail']")).sendKeys("ashishthakur1983");
		driver.findElement(By.id("userpass")).sendKeys("pass@1234");
		driver.findElement(By.xpath("//input[@id='loginsubmit']")).click();
		//WebElement Price = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+rnum+"]/td[4]"));
		
		Thread.sleep(5000);
		
		WebElement table = driver.findElement(By.xpath("//table[@id='stock']"));
		List<WebElement> rows = table.findElements(By.xpath("//table[@id='stock']/tbody/tr"));
		
		for(int rnum=0;rnum<rows.size();rnum++) {
			
			//System.out.println("Row "+(rnum)+1);
			//System.out.println(rows.get(rnum).getText());
			WebElement row_date = rows.get(rnum);
			List<WebElement> col_data = row_date.findElements(By.tagName("td"));
			
			for(int cnum =0;cnum<col_data.size();cnum++) {
				
				//System.out.println("Col data "+col_data.get(cnum).getText());
				 if(data.equals(col_data.get(cnum).getText()))
					return( rnum+1);
			}
			
		}
		return -1;
		

	}

}
