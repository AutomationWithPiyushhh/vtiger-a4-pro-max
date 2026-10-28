package learning_ad_rep;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners_utility.List_Imp.class)
public class ContactTest {
	@Test
	public void createContactTest() {
		Assert.assertTrue(true);
		System.out.println("contact created");
	}
	
	@Test
	public void modifyContactTest() {
		Assert.assertTrue(false);
		System.out.println("contact modified");
	}
	
	@Test(dependsOnMethods = "modifyContactTest")
	public void deleteContactTest() {
		Assert.assertTrue(true);
		System.out.println("contact deleted");
	}
}
