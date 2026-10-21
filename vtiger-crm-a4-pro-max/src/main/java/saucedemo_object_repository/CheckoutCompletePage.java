package saucedemo_object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {


	@FindBy(className = "title")
	private WebElement confirmationTitle;

	@FindBy(className = "complete-header")
	private WebElement confirmationMessage;

	@FindBy(className = "complete-text")
	private WebElement confirmationDescription;

	@FindBy(id = "back-to-products")
	private WebElement backHomeButton;

	public CheckoutCompletePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getConfirmationTitle() {
		return confirmationTitle;
	}

	public WebElement getConfirmationMessage() {
		return confirmationMessage;
	}

	public WebElement getConfirmationDescription() {
		return confirmationDescription;
	}

	public WebElement getBackHomeButton() {
		return backHomeButton;
	}
}