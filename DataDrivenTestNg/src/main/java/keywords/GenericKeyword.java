package keywords;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ReportManager;

public class GenericKeyword {
	
	public WebDriver driver;
	public Properties prop;
	public Properties Envprop;
	public ExtentTest test;
	public SoftAssert softAssert;
	public Select select;
	public Alert alert;
	
	public void openbrowser(String browser) {
		
		if(browser.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Softwares\\driver\\chromedriver.exe");
			log("�pening Browser: "+browser);
			driver = new ChromeDriver();
		}else if(browser.equals("Mozilla")) {
			
			System.setProperty("webdriver.geco.driver", "C:\\Softwares\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browser.equals("Edge")) {
			
			System.getProperty("webdriver.edge.driver","C:\\Softwares\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	public void navigate(String urlkey) {
		log("Opening URL "+Envprop.getProperty(urlkey));
		//driver.get(urlkey);
		driver.get(Envprop.getProperty(urlkey));	
		driver.manage().window().maximize();	
	}
	
	public void click(String locatorkey) {
		
		log("Clicking on  "+locatorkey);
		getElement(locatorkey).click();
	}
	
	public void type(String locatorkey,String data) {
		
		getElement(locatorkey).sendKeys(data);
	}
	
	public void clear(String locatorkey) {
		
		getElement(locatorkey).clear();
	}
	
	public void select() {	
	}
	
	public void getText() {
		
	}
	
	public void selectfromdropdown(String locatorkey,String portfolio_name) {
		//WebElement select_element = getElement(locatorkey);
		//select = new Select(select_element);
		//select.selectByVisibleText(portfolio_name);
		Select s = new Select(getElement(locatorkey));
		s.selectByVisibleText(portfolio_name);
	}
	
	public void ValidateDropDown(String locatorkey,String portfolio_name) {
		
		//WebElement element = getElement(locatorkey);
		//select = new Select(element);
		Select s = new Select(getElement(locatorkey));
		String text = s.getFirstSelectedOption().getText();
		
		if(!text.equals(portfolio_name)) {
			System.out.println("Element not present");
		}
		
	}
	
	public void ValidateNoDropDown(String locatorkey,String portfolio_name) {
		
		//WebElement element = getElement(locatorkey);
		//select = new Select(element);
		Select s = new Select(getElement(locatorkey));
		String text = s.getFirstSelectedOption().getText();
		
		if(text.equals(portfolio_name)) {
			System.out.println("Element not present");
		}
		
	}
	
	public void WaitforElementToLoad() {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i=0;
		// page to load 100% -- wait for max 20 secs
		while(i!=20){
			String state = (String)js.executeScript("return document.readyState;");
			System.out.println(state);// complete, loading, interactive
	
			if(state.equals("complete"))
				break;
			else
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			i++;
		}
	
	}
	
	//Central function to extract elements
	public WebElement getElement(String locatorkey) {
		//  check the presence of element.
		// check the visibility of element.
		
		if(!isElementPresent(locatorkey)) {
			
			System.out.println("Element not present");
		}
		
		if(!isElementvisible(locatorkey)) {
			
			System.out.println("Element not visible");
		}	
		WebElement e = driver.findElement(getLocator(locatorkey));
		return e;		
	}
	
	public void acceptAlert() {
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void EnterPress(String locatorkey) {
		
		getElement(locatorkey).sendKeys(Keys.ENTER);
	}
	
	
	public boolean isElementPresent(String locatorkey) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try {
		//wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorkey)));
			Thread.sleep(5000);
		} catch(Exception e) {
			
			return false;
		}
		return true;			
	}
	
	public boolean isElementvisible(String locatorkey) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		try {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorkey)));
			//wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorkey)));
			Thread.sleep(5000);
		}catch(Exception e) {
			return false;
		}
			
		return true;
	}
	
	
	public By getLocator(String locatorkey) {
		
		By by = null;
		
		if(locatorkey.endsWith("_id")) 
			by = By.id(prop.getProperty(locatorkey));
		else if(locatorkey.endsWith("_xpath")) 
			by = By.xpath(prop.getProperty(locatorkey));
		else if(locatorkey.endsWith("_css")) 
			by = By.cssSelector(prop.getProperty(locatorkey));
		else if(locatorkey.endsWith("_name")) 
			by = By.name(prop.getProperty(locatorkey));
		
		return by;
	}
	
	public void DateSelect(String locatorkey, String DateProvide) {
		
		String DateDisplayed = getElement(locatorkey).getText();
		System.out.println(DateDisplayed);
		SimpleDateFormat sd = new SimpleDateFormat("d-MM-yyyy");
		
		try {
			Date DateToBeSelected = sd.parse(DateProvide);
			String day = new SimpleDateFormat("d").format(DateToBeSelected);
			String month = new SimpleDateFormat("MMMM").format(DateToBeSelected);
			String year = new SimpleDateFormat("yyyy").format(DateToBeSelected);
			
			String MonthYeartobeselected = month+" "+year;
			
			System.out.println("MonthYeartobeselected is : "+MonthYeartobeselected);
			while(!MonthYeartobeselected.equals(DateDisplayed)) {
				
					driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[2]/button")).click();
					DateDisplayed = getElement(locatorkey).getText();	
				}
			driver.findElement(By.xpath("//td[text()='"+day+"']")).click();
		
	}
			
		
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void log(String msg) {
		test.log(Status.INFO, msg);
	}
	
	public void reportFailure(String FailureMsg,boolean StopOnFailure) {
		//System.out.println(FailureMsg);
		test.log(Status.FAIL,FailureMsg);
		softAssert.fail(FailureMsg);
		
		if(StopOnFailure)
			assertAll();
	}
	
	public void assertAll() {
		Reporter.getCurrentTestResult().getTestContext().setAttribute("CriticalFailure", "Y");
		softAssert.assertAll();
	}
	
	public int getRowNumber(String locatorkey,String Data) {
		
		WebElement table = getElement(locatorkey);
		List<WebElement> rows = table.findElements(By.xpath("//table[@id='stock']/tbody/tr"));
		
		for(int rNum=0;rNum<rows.size();rNum++) {
			WebElement row_data = rows.get(rNum);
			List<WebElement> cells = row_data.findElements(By.tagName("td"));
			for(int cNum = 0;cNum<cells.size();cNum++) {
				//log(cells.get(cNum).getText());
				
				if(Data.equals(cells.get(cNum).getText())) {
					return(rNum+1);
				}
			}
		
		 
		}return -1;
	}
	/*
	public void takeScreenShot(String filePath){
		// take screenshot- java object
		// save screenshot in path
		Date d = new Date();
		String screenshotfile = d.toString().replace(":", "_").replace("", "_")+".png";
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		// get the dynamic folder name
		FileUtils.copyFile(srcFile, new File(ReportManager.screenshotFolderPath));
		test.addScreenCaptureFromPath(ReportManager.screenshotFolderPath+screenshotfile);

		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	*/
	
	
}

