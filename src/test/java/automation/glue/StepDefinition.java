package automation.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import automation.Utils.ConfigurationProperties;
import automation.Utils.Constants;
import automation.Utils.TestCases;
import automation.Utils.Utils;
import automation.config.AutomationFrameworkConfiguration;
import automation.drivers.DriverSingleton;
import automation.pages.BuyItemPage;
import automation.pages.CheckoutPage;
import automation.pages.HomePage;
import automation.pages.SearchResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {
	private WebDriver driver;
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;
	private BuyItemPage buyItemPage;
	private CheckoutPage checkoutPage;
	ExtentTest test;
	static ExtentReports report = new ExtentReports("report/TestReport.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());

		homePage = new HomePage();
		searchResultsPage = new SearchResultsPage();
		buyItemPage = new BuyItemPage();
		checkoutPage = new CheckoutPage();
		TestCases[] tests = TestCases.values();
		test = report.startTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
	}

	@Given("^I go to ebays website")
	public void i_go_to_ebays_website() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		test.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("^I search for product")
	public void i_search_for_product() {
		homePage.searchElement(configurationProperties.getProductName());
		test.log(LogStatus.PASS, "Searching for item");
	}

	@And("^I click on the first result")
	public void i_click_on_the_first_result() {
		searchResultsPage.clickOnfirstResult();
		test.log(LogStatus.PASS, "clicked on the first result");
	}

	@And("^I set the item quantity and click buy now")
	public void i_set_the_item_quantity_and_click_buy_now() {
		Utils.switchDriverToTab(1, driver);

		buyItemPage.setQuantity(configurationProperties.getNumberOfItems());
		buyItemPage.clickBuyNow();
		test.log(LogStatus.PASS, "Item quantity has been set and clicked on buy now button");
	}

	@And("^I click checkout as guest and provide billing details")
	public void i_click_checkout_as_guest_and_provide_billing_details() {
		buyItemPage.clickCheckoutAsGuest();
		checkoutPage.ProvideBillingDetails();
		test.log(LogStatus.PASS, "clicked checkout as guest and provided billing details");
	}

	@Then("^I validate that items was added to cart and shop was succesfull")
	public void i_validate_that_items_was_added_to_cart_and_shop_was_succesfull() {
		if (checkoutPage.getSummaryProductsString().equals(configurationProperties.getNumberOfItems())) {
			test.log(LogStatus.PASS, "shop was successfull");
		} else {
			test.log(LogStatus.FAIL, "shop was not successfull");
		}
		assertEquals(checkoutPage.getSummaryProductsString(), configurationProperties.getNumberOfItems());
	}

	@After
	public void closeObjects() {
		report.endTest(test);
		report.flush();
		DriverSingleton.closeObjectInstance();
	}

}
