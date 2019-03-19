package cz.assist.ibmi.browser.config;

/**
 * 
 * @author milos.tygl
 *
 */
public class AppConfig {

	private static final String APP_NAME = "MT IBM i Browser";
	private static final String APP_VERSION = "beta 2019-03-15";
	private static final String PROPERTY_FILE = "C:/mt-dev/_test/MtIBMiBrowser/conf/conf.properties";

	public static String getAppName() {
		return APP_NAME;
	}

	public static String getAppVersion() {
		return APP_VERSION;
	}

	public static String getAppFullName() {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(APP_NAME);
		stringBuilder.append(" ");
		stringBuilder.append(APP_VERSION);

		return stringBuilder.toString();
	}

	public static String getPropertyfile() {
		return PROPERTY_FILE;
	}

}
