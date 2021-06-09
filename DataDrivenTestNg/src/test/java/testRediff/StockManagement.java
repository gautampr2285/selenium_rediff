package testRediff;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testBase.BaseTest;

public class StockManagement extends BaseTest {
	
	@Test
	
	public void AddStock(ITestContext context) throws InterruptedException {
		
		String Company_name = "Bharti Airtel Ltd";
		String Date_Of_Purchase = "24-04-2021";
		String Quantity_to_add="100";
		String Purchase_price="50";
		String name = "Bharti Airtel";
		
		int quantityBeforeAdding = apps.CurrentStockQuantity(name);
		System.out.println("Current quantiy of "+name+"is : "+quantityBeforeAdding);
		context.setAttribute("qunatityBeforeadding", quantityBeforeAdding);
		apps.log("quantity before adding is "+quantityBeforeAdding);
		apps.click("Add_Button_xpath");
		apps.type("Stock_Name_xpath", Company_name);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {

			e.printStackTrace();
		}
		apps.EnterPress("Stock_Name_xpath");
		Thread.sleep(2000);
		apps.click("calendar_click_xpath");
		apps.DateSelect("date_display_xpath", Date_Of_Purchase);
		//apps.type("Stock_purchase_xpath", Date_Of_Purchase);
		apps.type("addstockqty_xpath", Quantity_to_add);
		apps.type("addstockprice_xpath", Purchase_price);
		apps.click("addStockButton_xpath");
		apps.log("Stocks added successfully");
		//apps.WaitforElementToLoad();
		
	}
	
	
	@Test
		public void VerifyStockInList() {
		
		String company_name = "Bharti Airtel";
		int row = apps.getRowNumber("Add_stock_xpath", company_name);
		
		if(row==-1) {
			apps.log("stock not present");
				
		}
			
	}
	
	@Test
	
	public void ModifyStock() {
		
	}
	
	
	@Parameters("action")
	@Test
	
	public void verifyQuantity(ITestContext context,String action) {
		
		String Company_name = "Bharti Airtel";
		String Quantity_to_add="100";
		String Purchase_price="50";
		
		apps.log("Verifying stock");
		//quantity after adding stocks
		int quantityAfterAdding = apps.CurrentStockQuantity(Company_name);
		int ModifyQuantity = Integer.parseInt(Quantity_to_add);
		int ExpectedModifyQuantity =0;
		
		//quantity before adding
		
		int quantityBeforeAdding = (Integer) context.getAttribute("qunatityBeforeadding");
		
		if(action.equals("add_stock")) {
			ExpectedModifyQuantity = quantityAfterAdding-quantityBeforeAdding;
			
		}else if(action.equals("sell_stock")) {
			
			ExpectedModifyQuantity = quantityBeforeAdding-quantityAfterAdding;
		}
		apps.log("Old Stock quatity"+quantityBeforeAdding);
		apps.log("New Stock quatity"+quantityAfterAdding);
			
	
	
	if(!(ModifyQuantity==ExpectedModifyQuantity)) {
		apps.log("Test fail");
	}
}

	@Test
	
	public void TransactionHistory() {
		
			
	}

}
