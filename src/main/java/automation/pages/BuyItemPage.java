package automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.drivers.DriverSingleton;

public class BuyItemPage {
	private WebDriver driver;

	public BuyItemPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "binBtn_btn_1")
	private WebElement buyNowButton;

	@FindBy(id = "qtyTextBox")
	private WebElement quantityInput;

	@FindBy(css = "#mainContent > form > div.vim-buybox-wrapper > div > div.x-buybox__section > div.x-buybox__cta-section > ul > li:nth-child(1) > div > div > div > div.lightbox-dialog__window.lightbox-dialog__window--fade.keyboard-trap--active > div.lightbox-dialog__main > div > div > div.ux-bin-nudge__buttons > div.ux-bin-nudge__guestCheckOut > a")
	private WebElement CheckoutAsGuestButton;

	public void setQuantity(String qty) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(quantityInput));
		quantityInput.clear();
		quantityInput.sendKeys(qty);
	}

	public void clickBuyNow() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(buyNowButton));
		buyNowButton.click();
	}

	public void clickCheckoutAsGuest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(CheckoutAsGuestButton));
		CheckoutAsGuestButton.click();
	}
}
