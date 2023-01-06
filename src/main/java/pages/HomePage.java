package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverSingleton;

public class HomePage {
	private WebDriver driver;

	public HomePage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#gh-ug > a")
	private WebElement signInBtn;

	@FindBy(css = "#mainContent > div.hl-cat-nav > ul > li:nth-child(7) > a")
	private WebElement sportsButton;

	@FindBy(id = "gh-ug")
	private WebElement username;

	@FindBy(xpath = "//*[@id=\"gh-ac\"]")
	private WebElement searchInput;

	@FindBy(id = "gh-btn")
	private WebElement searchButton;

	public void searchForProducts(String productName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(searchInput));
		searchInput.sendKeys(productName);

		WebDriverWait waitForSearchButton = new WebDriverWait(driver, Duration.ofSeconds(15));
		waitForSearchButton.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
	}

	public void clickSignIn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
		signInBtn.click();
	}

	public void clickSportsButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(sportsButton));
		sportsButton.click();
	}

	public String getUserName() {
		// TODO: check what string it returns
		return username.getText();
	}

}
