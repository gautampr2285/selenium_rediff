package depedency;

import org.testng.Assert;
import org.testng.annotations.Test;

	public class Dependency {
	
		@Test(groups= {"searchproduct"})
	
		public void searchproduct() {
			System.out.println("searchproduct");
		}
	
		@Test(groups= {"select"})
		
		public void select() {
			System.out.println("select");
			Assert.fail("fail");
	}
	
		@Test(groups= {"buyproduct"})
	
		public void buyproduct() {
			
			System.out.println("buyproduct");
		
	}
	
		@Test(groups= {"confirmemail"})
	
		public void confirmemail() {
			
			System.out.println("confirmemail");
		
	}
		
}
