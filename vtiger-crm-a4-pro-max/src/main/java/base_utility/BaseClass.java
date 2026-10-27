package base_utility;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.LoginPage;

public class BaseClass {
	public WebDriver driver = null;

	@BeforeClass
	public void setUp() throws IOException, ParseException {
// 		open the browser
		String browser = FileUtility.getDataFromJsonFile("bro");

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

		driver.get("http://localhost:8888/");
	}

	@BeforeMethod
	public void login() throws IOException, ParseException {

		String un = FileUtility.getDataFromJsonFile("un");
		String pwd = FileUtility.getDataFromJsonFile("pwd");

		LoginPage lp = new LoginPage(driver);
		lp.login(un, pwd);
	}

	@AfterMethod
	public void logout() {
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		new WebDriverUtility(driver).hover(profile);
		driver.findElement(By.linkText("Sign Out")).click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
