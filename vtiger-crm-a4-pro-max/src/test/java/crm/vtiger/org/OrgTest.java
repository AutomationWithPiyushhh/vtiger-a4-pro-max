package crm.vtiger.org;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.JavaUtility;

@Listeners(listeners_utility.List_Imp.class)
public class OrgTest extends BaseClass{

	@Test
	public void createOrgTest() throws EncryptedDocumentException, IOException, ParseException, InterruptedException {

//		get the data from excel file
		String orgName = FileUtility.getDataFromExcelFile("org", 1, 0) + JavaUtility.generateRandomNumber();

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

		Assert.assertEquals(orgName, actOrgName);
	}
}