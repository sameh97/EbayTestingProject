import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import org.junit.runners.Parameterized;

import Utils.Constants;
import Utils.FrameworkProperties;
import drivers.DriverSingleton;
import pages.BuyItemPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.SignInPage;

@RunWith(Parameterized.class)
public class SearchTests {
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

	public SearchTests(String inputString, Boolean expectedResult) {
		this.inputString = inputString;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> searchOptions() {
		return Arrays.asList(
				new Object[][] { { "Shirt", true }, { "jeans", true }, { "dsadwevcewv", false }, { "iphone", true } });
	}

	@Test
	public void testingSearch() {
		driver.get(Constants.URL);
		assertEquals(expectedResult, homePage.searchElement(inputString));
	}

	@AfterClass
	public static void closeObjects() {
		driver.close();
	}

}
