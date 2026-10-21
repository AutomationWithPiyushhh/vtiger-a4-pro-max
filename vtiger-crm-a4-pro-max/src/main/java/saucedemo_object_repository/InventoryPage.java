package saucedemo_object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {


	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement addToCartButton;

	@FindBy(className = "shopping_cart_link")
	private WebElement shoppingCart;

	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public WebElement getShoppingCart() {
		return shoppingCart;
	}
}