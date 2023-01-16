package automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.drivers.DriverSingleton;

public class SignInPage {
	private WebDriver driver;

	public SignInPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userid")
	private WebElement signInEmail;

	@FindBy(id = "signin-continue-btn")
	private WebElement signInContinueBtn;

	@FindBy(id = "pass")
	private WebElement signInPasswordField;

	@FindBy(id = "sgnBt")
	private WebElement signInSubmitButton;



	public void login(String email, String password) {

		signInEmail.sendKeys(email);

		WebDriverWait waitForContinueButton = new WebDriverWait(driver, Duration.ofSeconds(15));
		waitForContinueButton.until(ExpectedConditions.elementToBeClickable(signInContinueBtn));
		signInContinueBtn.click();

		signInPasswordField.sendKeys(password);

		WebDriverWait waitForSubmitButton = new WebDriverWait(driver, Duration.ofSeconds(15));
		waitForSubmitButton.until(ExpectedConditions.elementToBeClickable(signInSubmitButton));
		signInSubmitButton.click();

	}

}
