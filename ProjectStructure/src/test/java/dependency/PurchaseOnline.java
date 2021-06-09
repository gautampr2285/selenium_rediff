package dependency;

import org.testng.annotations.Test;

public class PurchaseOnline {
	
	@Test
	
	public void searchproduct() {
		
	}
	
	@Test(dependsOnMethods = {"searchproduct"})
	public void select() {
		
	}
	
	@Test(dependsOnMethods = {"searchproduct"})
	
	public void buyproduct() {
		
	}
	
	@Test(dependsOnMethods = {"buyproduct"})
	
	public void confirmemail() {
		
		
	}
}
