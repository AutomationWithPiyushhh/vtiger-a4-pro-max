package parallel_execution_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LeadTest {
	
	@Parameters("bro")
	@Test
	public void createLeadTest(String browser) throws InterruptedException {
		WebDriver driver = null;
		
//		String browser = "chrome";
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		Thread.sleep(3000);
		driver.quit();
	}
}
