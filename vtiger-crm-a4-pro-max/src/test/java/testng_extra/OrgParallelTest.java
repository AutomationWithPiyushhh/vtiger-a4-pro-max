package testng_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrgParallelTest {

	/*
	 * priority 
	 * dependsOnMethods 
	 * enabled 
	 * alwaysRun 
	 * invocationCount 
	 * threadPoolSize
	 */

	@Test(invocationCount = 5, threadPoolSize = 2)
	public void createOrgTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		System.out.println("org created");
		driver.quit();
	}
		
}
