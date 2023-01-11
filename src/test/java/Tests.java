import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
	static FrameworkProperties frameworkProperties;
	static WebDriver driver;
	static SignInPage signInPage;
	static HomePage homePage;
	static SearchResultsPage searchResultsPage;
	static BuyItemPage buyItemPage;
	static CheckoutPage checkoutPage;
	static String inputString;
	static Boolean expectedResult;

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
	public void test01TestingAddingProductToCartAsGuest() {
		driver.get(Constants.URL);
		homePage.searchElement(frameworkProperties.getProperty("product_name"));
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
		driver.close();
	}
}
