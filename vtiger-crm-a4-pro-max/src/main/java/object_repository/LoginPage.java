package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//		WebElement username = driver.findElement(By.name("user_name"));
//		WebElement password = driver.findElement(By.name("user_password"));

	
	@FindBy(name = "user_name")
	private WebElement username;
	
	@FindBy(name = "user_password")
	private WebElement password;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}
}
