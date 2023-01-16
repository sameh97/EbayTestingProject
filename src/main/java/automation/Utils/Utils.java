package automation.Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.util.FileCopyUtils;

import automation.drivers.DriverSingleton;

public class Utils {
	public static boolean hasValue(Object obj) {
		if (obj == null) {
			return false;
		}

		return true;
	}

	public static void switchDriverToTab(int tabNumber, WebDriver driver) {
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabNumber));
		} catch (Exception e) {
			// TODO: add a proper message
			e.printStackTrace();
		}
	}

	public static boolean takeScreenshot() {
		File file = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileCopyUtils.copy(file,
					new File(Constants.SCREENSHOTS_FOLDER + generateRandomString() + Constants.PNG_EXTENSION));
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	private static String generateRandomString() {
		RandomStringGenerator stringGenerator = new RandomStringGenerator.Builder().withinRange('A', 'Z').build();
		return stringGenerator.generate(Constants.SCREENSHOTS_NAME_LENGTH);
	}

}
