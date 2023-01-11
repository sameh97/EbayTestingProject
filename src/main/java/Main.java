import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Constants;
import Utils.FrameworkProperties;
import drivers.DriverSingleton;
import net.bytebuddy.asm.Advice.OffsetMapping.Target.AbstractReadOnlyAdapter;
import pages.BuyItemPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.SignInPage;

public class Main {

	public static void main(String[] args) {
		FrameworkProperties frameworkProperties = new FrameworkProperties();

		DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
		WebDriver driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);

		SignInPage signInPage = new SignInPage();
		HomePage homePage = new HomePage();
		SearchResultsPage searchResultsPage = new SearchResultsPage();
		BuyItemPage buyItemPage = new BuyItemPage();
		CheckoutPage checkoutPage = new CheckoutPage();

		homePage.searchElement(frameworkProperties.getProperty("product_name"));
		searchResultsPage.clickOnfirstResult();

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		buyItemPage.setQuantity("3");
		buyItemPage.clickBuyNow();
		buyItemPage.clickCheckoutAsGuest();

		checkoutPage.ProvideBillingDetails();

//		homePage.clickSignIn();

//		try {
//			Thread.sleep(15000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		DriverSingleton.closeObjectInstance();

	}

}