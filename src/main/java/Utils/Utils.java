package Utils;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

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
}
