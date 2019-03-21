package cz.assist.ibmi.browser.gui.treetable;

/**
 * 
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.IFSFile;

import cz.assist.ibmi.browser.config.BrowserConfig;
import cz.assist.ibmi.browser.ibmi.ListFiles;

import javafx.scene.control.TreeItem;

/**
 * 
 * @author milos.tygl
 *
 */
public class MyTreeTableRealDataStructure {

	private static final Logger LOGGER = Logger.getLogger(MyTreeTableRealDataStructure.class);

	private long numberOfFiles;

	private int currentLevel;
	private final int treeMaxLevel;

	/**
	 * 
	 */
	MyTreeTableRealDataStructure() {

		LOGGER.debug("begin");

		treeMaxLevel = BrowserConfig.getTreeMaxLevel();

		LOGGER.debug("end");
	}

	/**
	 * 
	 * @return
	 */
	public TreeItem<MyTreeTableDataNode> generateFullDataStructure() {

		LOGGER.debug("begin");

		var fullDataStructure = generateRootDataStructure();

		LOGGER.debug("end");

		return fullDataStructure;
	}

	/**
	 * 
	 * @return
	 */
	private TreeItem<MyTreeTableDataNode> generateRootDataStructure() {

		LOGGER.debug("begin");

		numberOfFiles = 0L;
		currentLevel = 0;

		final boolean isRecursive = true;
		final String entryPoint = "/";

		var treeItemsNextLevel = generatePartialDataStructure(entryPoint, isRecursive);
		var root = getRootTreeItem();
		root.getChildren().addAll(treeItemsNextLevel);

		System.out.println("numberOfFiles: " + numberOfFiles);

		LOGGER.debug("end");

		return root;
	}

	/**
	 * 
	 * @return
	 */
	private TreeItem<MyTreeTableDataNode> getRootTreeItem() {

		LOGGER.debug("begin");

		final String xName = "[root]";
		final String xType = null;
		final String xAttr = null;
		final String xText = null;
		final String xPath = null;

		var rootTreeTableDataNode = new MyTreeTableDataNode(xName, xType, xAttr, xText, xPath);
		var rootTreeItem = new TreeItem<MyTreeTableDataNode>(rootTreeTableDataNode);

		LOGGER.debug("end");

		return rootTreeItem;
	}

	/**
	 * 
	 * @return
	 */
	private List<TreeItem<MyTreeTableDataNode>> getDummyTreeItems() {

		LOGGER.debug("begin");

		final String xName = "[dummy]";
		final String xType = null;
		final String xAttr = null;
		final String xText = null;
		final String xPath = null;

		var dummyTreeItems = new ArrayList<TreeItem<MyTreeTableDataNode>>();
		var dummyTreeTableDataNode = new MyTreeTableDataNode(xName, xType, xAttr, xText, xPath);
		dummyTreeItems.add(new TreeItem<MyTreeTableDataNode>(dummyTreeTableDataNode));

		LOGGER.debug("end");

		return dummyTreeItems;
	}

	/**
	 * 
	 * @return
	 */
	private List<TreeItem<MyTreeTableDataNode>> generateDummyDataStructure() {

		LOGGER.debug("begin");

		var dummyTreeItems = getDummyTreeItems();

		LOGGER.debug("end");

		return dummyTreeItems;
	}

	/**
	 * 
	 * @param entryPoint
	 * @param isRecursive
	 * @return
	 */
	private List<TreeItem<MyTreeTableDataNode>> generatePartialDataStructure(String entryPoint, boolean isRecursive) {

		LOGGER.debug("begin");

		LOGGER.debug("entryPoint: " + entryPoint);

		currentLevel++;

		final ListFiles listFiles = new ListFiles();
		final IFSFile[] ifsFiles = listFiles.listIfs(entryPoint);

		var treeItemCurrentLevel = new ArrayList<TreeItem<MyTreeTableDataNode>>();

		if (ifsFiles != null) {
			for (IFSFile ifsFile : ifsFiles) {

				final String xName = ifsFile.getName();
				final String xPath = ifsFile.getPath();

				boolean isQsysLib = false;
				if (xPath.startsWith("/QSYS.LIB")) {
					isQsysLib = true;
				}

				String xType = MyIBMiObjectType.Type.getName();
				String xAttr = MyIBMiObjectAttribute.Attribute.getName();
				String xText = "Text...";

				if (isQsysLib) {
					xType = "*" + xName.substring(xName.lastIndexOf(".") + 1);
				}

				boolean isDirectory = false;
				boolean isSymbolicLink = false;

				try {
					isDirectory = ifsFile.isDirectory();
					isSymbolicLink = ifsFile.isSymbolicLink();
					xAttr = ifsFile.getSubtype();
				} catch (IOException e) {
					LOGGER.error(xPath + ": I/O exception");
				} catch (AS400SecurityException e) {
					LOGGER.error(xPath + ": security");
				}

				if (!isSymbolicLink) {
					numberOfFiles++;

					var currentTreeTableDataNode = new MyTreeTableDataNode(xName, xType, xAttr, xText, xPath);
					var currentTreeItem = new TreeItem<MyTreeTableDataNode>(currentTreeTableDataNode);

					if (isDirectory) {
						if (currentLevel < 3) {
							System.out.println(xPath);
						}
						if (isRecursive) {
							List<TreeItem<MyTreeTableDataNode>> treeItemNextLevel = null;
							if (currentLevel < treeMaxLevel) {
								treeItemNextLevel = generatePartialDataStructure(xPath, true);
							} else {
								treeItemNextLevel = generateDummyDataStructure();
							}
							if (treeItemNextLevel != null) {
								currentTreeItem.getChildren().addAll(treeItemNextLevel);
							}
						}
					}
					treeItemCurrentLevel.add(currentTreeItem);
				}
			}
		}

		currentLevel--;

		LOGGER.debug("end");

		return treeItemCurrentLevel;
	}
}
