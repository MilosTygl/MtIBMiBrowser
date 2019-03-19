package cz.assist.ibmi.browser.config;

import org.apache.log4j.Logger;

/**
 * 
 * @author milos.tygl
 *
 */
public class BrowserConfig {

	private static final Logger LOGGER = Logger.getLogger(BrowserConfig.class);

	/**
	 * 
	 * @return
	 */
	public static boolean getRealData() {

		LOGGER.debug("begin");

		PropertyFileUtils propertyFile = PropertyFileUtils.getInstance();
		String propertyName = "browser.real.data";
		String propertyValue = null;
		try {
			propertyValue = propertyFile.getProperty(propertyName);
		} catch (PropertyFileException e) {
			LOGGER.error(e);
		}

		boolean realData = false;
		if (propertyValue.equalsIgnoreCase("yes")) {
			realData = true;
		}

		LOGGER.debug("end");

		return realData;
	}

	/**
	 * 
	 * @return
	 */
	public static int getTreeMaxLevel() {

		LOGGER.debug("begin");

		PropertyFileUtils propertyFile = PropertyFileUtils.getInstance();
		String propertyName = "browser.tree.max.level";
		String propertyValue = null;
		try {
			propertyValue = propertyFile.getProperty(propertyName);
		} catch (PropertyFileException e) {
			LOGGER.error(e);
		}

		int treeMaxLevel = 0;
		treeMaxLevel = Integer.valueOf(propertyValue);

		LOGGER.debug("end");

		return treeMaxLevel;
	}
}
