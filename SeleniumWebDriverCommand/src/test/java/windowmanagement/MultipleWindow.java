package windowmanagement;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.testng.annotations.Test;

import base.TestBase;

public class MultipleWindow extends TestBase{
	
	@Test
	
	public void multiple_window() {
		
		launchbrowser("Chrome");
		
		//driver.manage().window();
		//WebDriver driver =
		driver.get("https://www.naukri.com/");
		
		Set<String> s = driver.getWindowHandles();
		System.out.println(s.size());
		Iterator<String> it = s.iterator();
		/*
		while(it.hasNext()) {
			System.out.println(it.next());
		}*/
		
		String MainWindow = it.next();
		String popup1 = it.next();
		String popup2 = it.next();
		/*
		System.out.println(MainWindow);
		System.out.println(popup1);
		System.out.println(popup2);
		//System.out.println("All Window: "+MainWindow+","+popup1+" ,"+popup2);
		 */
		driver.switchTo().window(popup1);
		driver.close();
		driver.switchTo().window(popup2);
		driver.close();
	}

}
