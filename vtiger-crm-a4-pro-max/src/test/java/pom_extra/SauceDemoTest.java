package pom_extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import object_repository_saucedemo.LoginPage;

public class SauceDemoTest {

	public static void main(String[] args) throws InterruptedException {

		// Launch browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Open SauceDemo
		driver.get("https://www.saucedemo.com/");

		// Login

		LoginPage lp = new LoginPage(driver);
		WebElement username = lp.getUsername();
		WebElement password = lp.getPassword();
		WebElement loginButton = lp.getLoginButton();

		driver.navigate().refresh();

		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		loginButton.click();

		Thread.sleep(2000);

		// Add product to cart
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		addToCartButton.click();

		// Open shopping cart
		WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
		shoppingCart.click();

		Thread.sleep(2000);

		// Click Checkout
		WebElement checkoutButton = driver.findElement(By.id("checkout"));
		checkoutButton.click();

		Thread.sleep(2000);

		// Enter checkout information
		WebElement firstName = driver.findElement(By.id("first-name"));
		WebElement lastName = driver.findElement(By.id("last-name"));
		WebElement postalCode = driver.findElement(By.id("postal-code"));

		firstName.sendKeys("Piyush");
		lastName.sendKeys("Baldaniya");
		postalCode.sendKeys("380001");

		// Continue to order overview
		WebElement continueButton = driver.findElement(By.id("continue"));
		continueButton.click();

		Thread.sleep(2000);

		// Finish checkout
		WebElement finishButton = driver.findElement(By.id("finish"));
		finishButton.click();

		Thread.sleep(2000);

		// Back to home
		WebElement backHomeButton = driver.findElement(By.id("back-to-products"));
		backHomeButton.click();

		Thread.sleep(2000);

		// Close browser
		driver.quit();
	}
}