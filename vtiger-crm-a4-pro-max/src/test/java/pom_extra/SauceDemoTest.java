package pom_extra;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import saucedemo_object_repository.CartPage;
import saucedemo_object_repository.Checkout1Page;
import saucedemo_object_repository.Checkout2Page;
import saucedemo_object_repository.CheckoutCompletePage;
import saucedemo_object_repository.InventoryPage;
import saucedemo_object_repository.LoginPage;

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

		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		loginButton.click();

		Thread.sleep(2000);

		// Add product to cart
		InventoryPage ip = new InventoryPage(driver);

		WebElement addToCartButton = ip.getAddToCartButton();
		addToCartButton.click();

		// Open shopping cart
		WebElement shoppingCart = ip.getShoppingCart();
		shoppingCart.click();

		Thread.sleep(2000);

		// Click Checkout
		CartPage cp = new CartPage(driver);

		WebElement checkoutButton = cp.getCheckoutButton();
		checkoutButton.click();

		Thread.sleep(2000);

		// Enter checkout information
		Checkout1Page c1p = new Checkout1Page(driver);

		WebElement firstName = c1p.getFirstName();
		WebElement lastName = c1p.getLastName();
		WebElement postalCode = c1p.getPostalCode();

		firstName.sendKeys("Piyush");
		lastName.sendKeys("Baldaniya");
		postalCode.sendKeys("380001");

		// Continue to order overview
		WebElement continueButton = c1p.getContinueButton();
		continueButton.click();

		Thread.sleep(2000);

		// Finish checkout
		Checkout2Page c2p = new Checkout2Page(driver);

		WebElement finishButton = c2p.getFinishButton();
		finishButton.click();

		Thread.sleep(2000);

		// Back to home
		CheckoutCompletePage ccp = new CheckoutCompletePage(driver);

		WebElement backHomeButton = ccp.getBackHomeButton();
		backHomeButton.click();

		Thread.sleep(2000);

		// Close browser
		driver.quit();
	}
}