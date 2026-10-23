package testng_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrgInvocationTest {
	@Test(invocationCount = 7)
	public void createOrgTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		System.out.println("org created");
		driver.quit();
	}

	@Test(invocationCount = 0)
	public void modifyOrgTest() {
		Assert.assertTrue(false);
		System.out.println("org modified to LatestOrg");
	}

	@Test(invocationCount = 2 , enabled = false)
	public void deleteOrgTest() {	
		System.out.println("LatestOrg deleted");
	}
	
//	data provider
//	to execute the same test script multiple times
//	with diff set of data => 2D Object array (3 Programs) with new keyword
	
	/* Tests ? fail ? skip ?
	 * Run ? pass ? fail ? skip ?
	 *
	*/	
}
