package generic_utility;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class WebDriverUtility {
	
	WebDriver driver = null;
	
	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	public void hover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public void takeScreenshotOfWebPage(String name) throws IOException {
		TakesScreenshot tks = (TakesScreenshot) driver;
		File source = tks.getScreenshotAs(OutputType.FILE);
		File destination = new File("./errorShots/"+ name + ".png");
		FileHandler.copy(source, destination);
	}
	
	public void takeScreenshotOfWebElement(WebElement element, String name) throws IOException {
		File source = element.getScreenshotAs(OutputType.FILE);
		File destination = new File("./errorShots/"+ name + ".png");
		FileHandler.copy(source, destination);
	}
	
	public void switchToWindowByTitle(String title) {
		Set<String> CIDs = driver.getWindowHandles();
		for (String i : CIDs) {
			driver.switchTo().window(i);
			if (driver.getTitle().contains(title)) {
				break;
			}
		}
	}
	
	public void switchToWindowByURL(String URL) {
		Set<String> CIDs = driver.getWindowHandles();
		for (String i : CIDs) {
			driver.switchTo().window(i);
			if (driver.getCurrentUrl().contains(URL)) {
				break;
			}
		}
	}
	
}
