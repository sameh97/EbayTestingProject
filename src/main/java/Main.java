import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.FrameworkProperties;
import drivers.DriverSingleton;
import net.bytebuddy.asm.Advice.OffsetMapping.Target.AbstractReadOnlyAdapter;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.SignInPage;

public class Main {

	public static void main(String[] args) {
		FrameworkProperties frameworkProperties = new FrameworkProperties();

		DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
		WebDriver driver = DriverSingleton.getDriver();
		driver.get("https://www.ebay.com");

		SignInPage signInPage = new SignInPage();
		HomePage homePage = new HomePage();
		SearchResultsPage searchResultsPage = new SearchResultsPage();

		homePage.searchForProducts(frameworkProperties.getProperty("product_name"));
		searchResultsPage.clickOnfirstResult();

//		homePage.clickSignIn();

//		try {
//			Thread.sleep(15000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		DriverSingleton.closeObjectInstance();

	}

}
