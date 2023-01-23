package automation.drivers.strategies;

import automation.Utils.Constants;
import automation.Utils.Utils;
import automation.drivers.strategies.Chrome;
import automation.drivers.strategies.DriverStrategy;

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
