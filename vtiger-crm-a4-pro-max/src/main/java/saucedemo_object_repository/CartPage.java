package saucedemo_object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {


	@FindBy(id = "checkout")
	private WebElement checkoutButton;

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCheckoutButton() {
		return checkoutButton;
	}
}