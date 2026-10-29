package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
//	initialize
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(id = "")
	private WebElement element2;
	
	@FindBy(id = "")
	private WebElement element3;
	
	@FindBy(id = "")
	private WebElement element4;
	
	@FindBy(id = "")
	private WebElement element5;
	
	@FindBy(id = "")
	private WebElement element6;

	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getElement2() {
		return element2;
	}
	public WebElement getElement3() {
		return element3;
	}
	public WebElement getElement4() {
		return element4;
	}
	public WebElement getElement5() {
		return element5;
	}
	public WebElement getElement6() {
		return element6;
	}
}
