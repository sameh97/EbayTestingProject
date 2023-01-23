package automation.drivers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import automation.drivers.strategies.DriverStrategy;
import automation.drivers.strategies.DriverStrategyImplementer;

import static java.time.temporal.ChronoUnit.SECONDS;

public class DriverSingleton {
	private static DriverSingleton instance;
	private static WebDriver driver;

	public DriverSingleton(String strategy) {
		instantiate(strategy);
	}

	public WebDriver instantiate(String strategy) {
		DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);

		driver = driverStrategy.setStrategy();
		driver.manage().timeouts().implicitlyWait(Duration.of(5, SECONDS));
		driver.manage().window().maximize();

		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static DriverSingleton getInstance(String strategy) {
		if (instance == null)
			return new DriverSingleton(strategy);
		return instance;
	}

	public static void closeObjectInstance() {
		instance = null;
		driver.quit();
	}

}
