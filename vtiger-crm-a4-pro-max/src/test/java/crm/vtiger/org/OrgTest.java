package crm.vtiger.org;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;

public class OrgTest {
	

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
//		get the data from json file
		String browser = FileUtility.getDataFromJsonFile("bro");
		String url = FileUtility.getDataFromJsonFile("url");
		String un = FileUtility.getDataFromJsonFile("un");
		String pwd = FileUtility.getDataFromJsonFile("pwd");

//		get the data from excel file
		String orgName = FileUtility.getDataFromExcelFile("org", 1, 0) + JavaUtility.generateRandomNumber();

// 		open the browser
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Login
		driver.get(url);
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		username.sendKeys(un);
		password.sendKeys(pwd + Keys.ENTER);

		// Create organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

		// Filling Form
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);

		// Save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		// Verification
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.equals(orgName)) {
			System.out.println("Organization Succesfully created !!!");
		} else {
			System.out.println("Failed.....");
		}

		// logout
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		driver.findElement(By.linkText("Sign Out")).click();

		// close the browser
		Thread.sleep(10000);
		driver.quit();
	}
}