package automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.drivers.DriverSingleton;

public class SearchResultsPage {
	private WebDriver driver;

	public SearchResultsPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#srp-river-results > ul > li:nth-child(1) > div > div.s-item__info.clearfix > a")
	private WebElement firstResult;

	public void clickOnfirstResult() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(firstResult));
		firstResult.click();
	}
}
