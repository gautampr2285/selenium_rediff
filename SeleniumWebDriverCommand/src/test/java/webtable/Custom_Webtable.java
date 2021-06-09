package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;

public class Custom_Webtable extends TestBase{
	
	@Test
	
	public void Webtable_Example() {
		
		launchbrowser("Chrome");
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		String Company = "BEML Ltd.";
		testTable(Company);
		int RowNumber = testTable(Company);
		System.out.println("Row number is "+RowNumber);
		WebElement Price = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+RowNumber+"]/td[4]"));
		System.out.println("Price of "+Company+ "is :" +Price.getText());
		
		
	}
		
	
	public int testTable(String Data) {
		
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		
		for(int rNum=0;rNum<rows.size();rNum++) {
			//System.out.println(rows.get(rNum).getText());	
			WebElement RowData = rows.get(rNum);
			List<WebElement> cell = RowData.findElements(By.tagName("td"));
			for(int cNum=0;cNum<cell.size();cNum++) {
				
				//System.out.println(cell.get(cNum).getText());
				if(Data.equals(cell.get(cNum).getText())){
					return(rNum+1);
				}
			}
			//System.out.println("-----------");
		}
		return -1;
			
		
	}
	
	

}
