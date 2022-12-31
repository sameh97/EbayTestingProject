import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class DriverSingleton {
	public static DriverSingleton instance;
	public static WebDriver driver;

	public DriverSingleton() {
		instantiate("Chrome");
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

	public static DriverSingleton getInstance() {
		if (instance == null)
			return new DriverSingleton();
		return instance;
	}

	public static void closeObjectInstance() {
		instance = null;
		driver.quit();
	}

}
