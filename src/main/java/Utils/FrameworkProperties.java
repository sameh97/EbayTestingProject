package Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {
	private String result;
	private InputStream inputStream;

	public String getProperty(String key) {
		try {
			Properties properties = new Properties();
			String propFileName = Constants.PROP_FILE_NAME;

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (!Utils.hasValue(inputStream)) {
				throw new FileNotFoundException(Constants.FILE_NOT_FOUND_EXCEPTION_MESSAGE);
			}

			properties.load(inputStream);
			String propertyValue = properties.getProperty(key);
			this.result = propertyValue;

		} catch (FileNotFoundException e) {
			// TODO: add logs
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: add logs
			e.printStackTrace();
		}
		return this.result;
	}
}
