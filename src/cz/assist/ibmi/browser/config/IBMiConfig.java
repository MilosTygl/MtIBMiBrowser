package cz.assist.ibmi.browser.config;

import org.apache.log4j.Logger;

/**
 * 
 * @author milos.tygl
 *
 */
public class IBMiConfig {

	private static final Logger LOGGER = Logger.getLogger(IBMiConfig.class);

	/**
	 * 
	 * @return
	 */
	public static String getAS400Address() {

		LOGGER.debug("begin");

		PropertyFileUtils propertyFile = PropertyFileUtils.getInstance();
		String propertyName = "as400.address";
		String propertyValue = null;
		try {
			propertyValue = propertyFile.getProperty(propertyName);
		} catch (PropertyFileException e) {
			LOGGER.error(e);
		}
		LOGGER.debug("end");

		return propertyValue;
	}

	/**
	 * 
	 * @return
	 */
	public static String getAS400UserName() {

		LOGGER.debug("begin");

		PropertyFileUtils propertyFile = PropertyFileUtils.getInstance();
		String propertyName = "as400.user.name";
		String propertyValue = null;
		try {
			propertyValue = propertyFile.getProperty(propertyName);
		} catch (PropertyFileException e) {
			LOGGER.error(e);
		}
		LOGGER.debug("end");

		return propertyValue;
	}

	/**
	 * 
	 * @return
	 */
	public static String getAS400UserPassword() {

		LOGGER.debug("begin");

		PropertyFileUtils propertyFile = PropertyFileUtils.getInstance();
		String propertyName = "as400.user.password";
		String propertyValue = null;
		try {
			propertyValue = propertyFile.getProperty(propertyName);
		} catch (PropertyFileException e) {
			LOGGER.error(e);
		}
		LOGGER.debug("end");

		return propertyValue;
	}

}
