import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import org.openqa.selenium.WebDriver;

import automation.Utils.Constants;
import automation.Utils.FrameworkProperties;
import automation.drivers.DriverSingleton;
import automation.pages.BuyItemPage;
import automation.pages.CheckoutPage;
import automation.pages.HomePage;
import automation.pages.SearchResultsPage;
import automation.pages.SignInPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTests {
	static FrameworkProperties frameworkProperties;
	static WebDriver driver;
	static SignInPage signInPage;
	static HomePage homePage;
	static SearchResultsPage searchResultsPage;
	static BuyItemPage buyItemPage;
	static CheckoutPage checkoutPage;

	@BeforeAll
	public static void initializeObjects() {
		frameworkProperties = new FrameworkProperties();
		DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
		driver = DriverSingleton.getDriver();
		homePage = new HomePage();
		searchResultsPage = new SearchResultsPage();
		buyItemPage = new BuyItemPage();
		checkoutPage = new CheckoutPage();
	}

	public static Collection<Object[]> searchOptions() {
		return Arrays.asList(
				new Object[][] { { "Shirt", true }, { "jeans", true }, { "dsadwevcewv", false }, { "iphone", true } });
	}

	@ParameterizedTest
        @MethodSource("searchOptions")
	public void testingSearch(String inputString, boolean expectedResult) {
		driver.get(Constants.URL);
		assertEquals(expectedResult, homePage.searchElement(inputString));
	}

	@AfterAll
	public static void closeObjects() {
		driver.close();
	}

}
