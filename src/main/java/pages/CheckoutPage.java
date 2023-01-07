package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverSingleton;

public class CheckoutPage {
	private WebDriver driver;

	public CheckoutPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#page-form > div > button")
	private WebElement confirmAndPaybutton;

	@FindBy(id = "firstName")
	private WebElement firstNameInput;

	@FindBy(id = "lastName")
	private WebElement lastNameInput;

	@FindBy(id = "addressLine1")
	private WebElement addressInput;

	@FindBy(id = "city")
	private WebElement cityInput;

	@FindBy(id = "stateOrProvince")
	private WebElement stateOrProvinceInput;

	@FindBy(id = "postalCode")
	private WebElement postalCodeInput;

	@FindBy(id = "email")
	private WebElement emailInput;

	@FindBy(id = "emailConfirm")
	private WebElement emailConfirmInput;

	@FindBy(id = "phoneNumber")
	private WebElement phoneNumberInput;

	public void clickConfirmAndPay() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(confirmAndPaybutton));
		confirmAndPaybutton.click();
	}

	public void ProvideBillingDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(firstNameInput));
		firstNameInput.sendKeys("sameh");
	}
}
