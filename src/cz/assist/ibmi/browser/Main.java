package cz.assist.ibmi.browser;

/*
 * Based on JavaFX - TreeTableView
 */

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import cz.assist.ibmi.browser.config.LogConfig;
import cz.assist.ibmi.browser.gui.treetable.MyTreeTableViewTest;

/**
 * 
 * @author milos.tygl
 *
 */
public class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		PropertyConfigurator.configure(LogConfig.getLogPropertyFile());

		LOGGER.debug("*** BEGIN ***");

		MyTreeTableViewTest.showTree();

		LOGGER.debug("*** END ***");

	}
}
