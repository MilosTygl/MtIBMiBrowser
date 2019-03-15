package cz.assist.ibmi.browser.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import cz.assist.ibmi.browser.Main;

/**
 * 
 * @author milos.tygl
 *
 */
public class PropertyFileUtils {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	private static PropertyFileUtils INSTANCE;

	private final String PROPERTY_FILE = AppConfig.getPropertyfile();
	private final Properties properties;

	/**
	 * 
	 */
	private PropertyFileUtils() {

		LOGGER.debug("begin");

		properties = new Properties();

		try {
			FileInputStream fileInputStream = new FileInputStream(PROPERTY_FILE);
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException ex) {
			LOGGER.error(ex);
		}
	}

	/**
	 * 
	 * @return
	 */
	public static PropertyFileUtils getInstance() {

		LOGGER.debug("begin");

		if (INSTANCE == null) {
			LOGGER.debug("New instance");
			INSTANCE = new PropertyFileUtils();
		} else {
			LOGGER.debug("Old instance");
		}

		LOGGER.debug("end");

		return INSTANCE;
	}

	/**
	 * 
	 */
	public static void cancelInstance() {

		LOGGER.debug("begin");

		INSTANCE = null;

		LOGGER.debug("end");
	}

	/**
	 * 
	 * @param propertyName
	 * @return
	 * @throws PropertyFileException
	 */
	public String getProperty(String propertyName) throws PropertyFileException {

		LOGGER.debug("begin");

		String propertyValue = properties.getProperty(propertyName);

		LOGGER.debug("propertyName: " + propertyName);
		LOGGER.debug("propertyValue: " + propertyValue);

		if (propertyValue == null) {
			LOGGER.error("Property not found");
			PropertyFileException propertyFileException = new PropertyFileException("Property not found");
			propertyFileException.setPropertyName(propertyName);
			propertyFileException.setPropertyValue(propertyValue);
			throw propertyFileException;
		}

		LOGGER.debug("end");

		return propertyValue;
	}
}
