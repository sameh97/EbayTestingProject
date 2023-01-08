import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import Utils.Constants;
import Utils.FrameworkProperties;
import Utils.Utils;
import drivers.DriverSingleton;
import pages.BuyItemPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.SignInPage;

public class Tests {
	static FrameworkProperties frameworkProperties;
	static WebDriver driver;
	static SignInPage signInPage;
	static HomePage homePage;
	static SearchResultsPage searchResultsPage;
	static BuyItemPage buyItemPage;
	static CheckoutPage checkoutPage;

	@BeforeClass
	public static void initializeObjects() {
		frameworkProperties = new FrameworkProperties();
		DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
		driver = DriverSingleton.getDriver();
		homePage = new HomePage();
		searchResultsPage = new SearchResultsPage();
		buyItemPage = new BuyItemPage();
		checkoutPage = new CheckoutPage();
	}

	@Test
	public void testingAddingProductToCartAsGuest() {
		driver.get(Constants.URL);
		homePage.searchForProducts(frameworkProperties.getProperty("product_name"));
		searchResultsPage.clickOnfirstResult();

		Utils.switchDriverToTab(1, driver);

		buyItemPage.setQuantity(frameworkProperties.getProperty("number_of_items"));
		buyItemPage.clickBuyNow();
		buyItemPage.clickCheckoutAsGuest();
		checkoutPage.ProvideBillingDetails();

		assertEquals(checkoutPage.getSummaryProductsString(), frameworkProperties.getProperty("number_of_items"));
	}

	@AfterClass
	public static void closeObjects() {
		DriverSingleton.closeObjectInstance();
	}
}
