package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverSingleton;

public class SignInPage {
	private WebDriver driver;

	public SignInPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, null);
	}

	@FindBy(css = "#gh-ug > a")
	private WebElement signInBtn;

	@FindBy(id = "userid")
	private WebElement signInEmail;

	@FindBy(id = "pass")
	private WebElement signInPasswordField;

	@FindBy(id = "sgnBt")
	private WebElement signInSubmitButton;

	public void login(String email, String password) {
		
	}
}
