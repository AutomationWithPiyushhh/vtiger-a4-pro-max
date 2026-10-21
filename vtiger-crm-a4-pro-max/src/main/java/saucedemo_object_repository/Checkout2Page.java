package saucedemo_object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout2Page {


	@FindBy(xpath = "(//div[@class='summary_value_label'])[1]")
	private WebElement paymentInformation;

	@FindBy(xpath = "(//div[@class='summary_value_label'])[2]")
	private WebElement shippingInformation;

	@FindBy(className = "inventory_item_price")
	private WebElement itemPrice;

	@FindBy(className = "summary_subtotal_label")
	private WebElement itemTotal;

	@FindBy(className = "summary_tax_label")
	private WebElement tax;

	@FindBy(className = "summary_total_label")
	private WebElement total;

	@FindBy(id = "finish")
	private WebElement finishButton;

	public Checkout2Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPaymentInformation() {
		return paymentInformation;
	}

	public WebElement getShippingInformation() {
		return shippingInformation;
	}

	public WebElement getItemPrice() {
		return itemPrice;
	}

	public WebElement getItemTotal() {
		return itemTotal;
	}

	public WebElement getTax() {
		return tax;
	}

	public WebElement getTotal() {
		return total;
	}

	public WebElement getFinishButton() {
		return finishButton;
	}
}