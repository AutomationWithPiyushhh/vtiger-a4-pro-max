package generic_utility_extra;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.WebDriverUtility;

public class FB_SS {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		
		wdUtil.takeScreenshotOfWebPage("fbPage");
		
		Thread.sleep(3000);
		driver.quit();
	}
}
