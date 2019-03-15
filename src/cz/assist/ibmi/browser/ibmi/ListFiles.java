package cz.assist.ibmi.browser.ibmi;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.IFSFile;

/**
 * 
 * @author milos
 *
 */
public class ListFiles {

	private static final Logger LOGGER = Logger.getLogger(ListFiles.class);

	/**
	 * 
	 * @param ifsPath0
	 * @return
	 */
	public IFSFile[] listIfs(String ifsPath) {

		// LOGGER.debug("begin");

		LOGGER.debug(ifsPath);

		AS400 IBMi = IBMiConnection.getInstance().getIBMi();

		IFSFile ifsFile = new IFSFile(IBMi, ifsPath);

		IFSFile[] ifsFiles = null;

		try {
			ifsFiles = ifsFile.listFiles();
		} catch (IOException e) {
			LOGGER.error("I/O exception");
		}

		// LOGGER.debug("end");

		return ifsFiles;
	}

}
