package cz.assist.ibmi.browser.ibmi;

import org.apache.log4j.Logger;

import com.ibm.as400.access.AS400;

import cz.assist.ibmi.browser.config.IBMiConfig;

/**
 * 
 * @author milos
 *
 */
public class IBMiConnection {

	private static final Logger LOGGER = Logger.getLogger(IBMiConnection.class);

	private static IBMiConnection INSTANCE;

	private AS400 IBMi;

	/**
	 * 
	 */
	private IBMiConnection() {

		LOGGER.debug("begin");

		final String IBMiHost = IBMiConfig.getAS400Address();
		final String IBMiUser = IBMiConfig.getAS400UserName();
		final String IBMiPassword = IBMiConfig.getAS400UserPassword();

		IBMi = new AS400(IBMiHost, IBMiUser, IBMiPassword);

		// LOGGER.debug("end");
	}

	/**
	 * 
	 * @return
	 */
	public static IBMiConnection getInstance() {

		LOGGER.debug("begin");

		if (INSTANCE == null) {
			INSTANCE = new IBMiConnection();
		}

		// LOGGER.debug("end");

		return INSTANCE;
	}

	/**
	 * 
	 */
	public static void cancelInstance() {

		LOGGER.debug("begin");

		INSTANCE = null;

		// LOGGER.debug("end");
	}

	/**
	 * 
	 * @return
	 */
	public AS400 getIBMi() {

		LOGGER.debug("begin");

		return IBMi;
	}

}
