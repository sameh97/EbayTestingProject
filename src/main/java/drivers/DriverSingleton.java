package drivers;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import drivers.strategies.DriverStrategy;
import drivers.strategies.DriverStrategyImplementer;

public class DriverSingleton {
	public static DriverSingleton instance;
	public static WebDriver driver;

	public DriverSingleton(String strategy) {
		instantiate(strategy);
	}

	public WebDriver instantiate(String strategy) {
		DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);

		driver = driverStrategy.setStrategy();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
