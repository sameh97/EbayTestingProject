package automation.drivers.strategies;

import automation.Utils.Constants;
import automation.Utils.Utils;

public class DriverStrategyImplementer {
	public static DriverStrategy chooseStrategy(String strategy) {
		if (!Utils.hasValue(strategy)) {
			return null;
		}

		switch (strategy) {
		case Constants.CHROME:
			return new Chrome();
		default:
			return null;
		}
	}
}
