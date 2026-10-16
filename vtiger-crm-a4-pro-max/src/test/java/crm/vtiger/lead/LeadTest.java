package crm.vtiger.lead;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.JavaUtility;

public class LeadTest {
	public static void main(String[] args)
			throws InterruptedException, EncryptedDocumentException, IOException, ParseException {
//		get the data from json file
		FileReader fr = new FileReader("./src/test/resources/cd.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		JSONObject jObj = (JSONObject) obj;
		String browser = jObj.get("bro").toString();
		String url = jObj.get("url").toString();
		String un = jObj.get("un").toString();
		String pwd = jObj.get("pwd").toString();

//		get the data from excel file
		FileInputStream fis = new FileInputStream("./src/test/resources/tsd.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("contact");

		Row row = sh.getRow(10);
		Cell cell = row.getCell(0);
		String lastName = cell.getStringCellValue();

		Row row1 = sh.getRow(1);
		Cell cell1 = row1.getCell(1);
		String company = cell1.getStringCellValue();

		// open the browser
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

		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.cssSelector("[alt='Create Lead...']")).click();

//		String lastName = "kumar";

		WebElement lastNameField = driver.findElement(By.name("lastname"));

		lastNameField.sendKeys(lastName);

		System.out.println("[PASS] Last Name entered successfully.");

//		String company = "ceat";

		WebElement companyField = driver.findElement(By.name("company"));
		companyField.sendKeys(company);

		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

//		verification
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		String actCompany = driver.findElement(By.id("dtlview_Company")).getText();

		if (actLastName.equals(lastName) && actCompany.equals(company)) {
			System.out.println("[PASS] Lead Created Successfully.");
			System.out.println("[PASS] Last Name verification passed.");
			System.out.println("[PASS] Company verification passed.");
		} else {
			System.out.println("[FAIL] Failed to create Lead.");
			System.out.println("[FAIL] Lead details verification failed.");
		}

		// logout
		WebElement profileIcon = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profileIcon).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();

		// close the browser
		Thread.sleep(10000);
		driver.quit();
	}
}