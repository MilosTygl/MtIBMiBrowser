package cz.assist.ibmi.browser.gui.treetable;

import org.apache.log4j.Logger;

import javafx.scene.control.TreeItem;

/**
 * 
 * @author milos.tygl
 *
 */
public class MyTreeTableFakeDataStructure {

	private static final Logger LOGGER = Logger.getLogger(MyTreeTableFakeDataStructure.class);

	final TreeItem<MyTreeTableDataNode> root;

	/**
	 * 
	 */
	MyTreeTableFakeDataStructure() {

		LOGGER.debug("begin");

		root = createNextLevelItem("[root]", null, null, null, null);

		LOGGER.debug("end");

	}

	/**
	 * 
	 * @param xName
	 * @param xType
	 * @param xAttr
	 * @param xText
	 * @param xPath
	 * @return
	 */
	public TreeItem<MyTreeTableDataNode> createNextLevelItem(String xName, String xType, String xAttr, String xText, String xPath) {

		LOGGER.debug("begin");

		var ttdn = new MyTreeTableDataNode(xName, xType, xAttr, xText, xPath);
		var child = new TreeItem<MyTreeTableDataNode>(ttdn);

		LOGGER.debug("end");

		return child;
	}

	/**
	 * 
	 * @return
	 */
	public TreeItem<MyTreeTableDataNode> generateFullDataStructure() {

		LOGGER.debug("begin");

		var item1 = createNextLevelItem("QSYS.LIB", "*LIB", "PROD", "System Library", "/QSYS.LIB");
		root.getChildren().add(item1);

		var item1sub1 = createNextLevelItem("USER1LIB.LIB", "*LIB", "PROD", "USER1 Current Library", "/QSYS.LIB/USER1LIB.LIB");
		item1.getChildren().add(item1sub1);

		var item1sub1sub1 = createNextLevelItem("QCLSRC.FILE", "*FILE", "PF", "CL Sources", "/QSYS.LIB/USER1LIB.LIB/QCLSRC.FILE");
		item1sub1.getChildren().add(item1sub1sub1);

		var item1sub1sub1sub1 = createNextLevelItem("TEST1.MBR", "*MBR", "CLP", "CL Program Example 1", "/QSYS.LIB/USER1LIB.LIB/QCLSRC.FILE/TEST1.MBR");
		item1sub1sub1.getChildren().add(item1sub1sub1sub1);

		var item1sub1sub1sub2 = createNextLevelItem("TEST2.MBR", "*MBR", "CLP", "CL Program Example 2", "/QSYS.LIB/USER1LIB.LIB/QCLSRC.FILE/TEST2.MBR");
		item1sub1sub1.getChildren().add(item1sub1sub1sub2);

		var item1sub1sub2 = createNextLevelItem("TEST1.PGM", "*PGM", "CLP", "CL Program Example 1", "/QSYS.LIB/USER1LIB.LIB/TEST1.PGM");
		item1sub1.getChildren().add(item1sub1sub2);

		var item1sub1sub3 = createNextLevelItem("TEST2.PGM", "*PGM", "CLP", "CL Program Example 2", "/QSYS.LIB/USER1LIB.LIB/TEST2.PGM");
		item1sub1.getChildren().add(item1sub1sub3);

		var item1sub2 = createNextLevelItem("USER2LIB.LIB", "*LIB", "PROD", "USER2 Current Library", "/QSYS.LIB/USER2LIB.LIB");
		item1.getChildren().add(item1sub2);

		var item1sub3 = createNextLevelItem("USER3LIB.LIB", "*LIB", "PROD", "USER3 Current Library", "/QSYS.LIB/USER3LIB.LIB");
		item1.getChildren().add(item1sub3);

		var item1sub4 = createNextLevelItem("USER4LIB.LIB", "*LIB", "PROD", "USER4 Current Library", "/QSYS.LIB/USER4LIB.LIB");
		item1.getChildren().add(item1sub4);

		var item1sub5 = createNextLevelItem("USER5LIB.LIB", "*LIB", "PROD", "USER5 Current Library", "/QSYS.LIB/USER5LIB.LIB");
		item1.getChildren().add(item1sub5);

		var item1sub6 = createNextLevelItem("USER6LIB.LIB", "*LIB", "PROD", "USER6 Current Library", "/QSYS.LIB/USER6LIB.LIB");
		item1.getChildren().add(item1sub6);

		var item2 = createNextLevelItem("QOpenSys", null, null, null, "/QOpenSys");
		root.getChildren().add(item2);

		var item2sub1 = createNextLevelItem("home", null, null, null, "/QOpenSys/home");
		item2.getChildren().add(item2sub1);

		var item2sub1sub1 = createNextLevelItem("user1", null, null, null, "/QOpenSys/home/user1");
		item2sub1.getChildren().add(item2sub1sub1);

		var item2sub1sub2 = createNextLevelItem("user2", null, null, null, "/QOpenSys/home/user2");
		item2sub1.getChildren().add(item2sub1sub2);

		var item2sub1sub3 = createNextLevelItem("user3", null, null, null, "/QOpenSys/home/user3");
		item2sub1.getChildren().add(item2sub1sub3);

		var item2sub1sub4 = createNextLevelItem("user4", null, null, null, "/QOpenSys/home/user4");
		item2sub1.getChildren().add(item2sub1sub4);

		var item2sub1sub5 = createNextLevelItem("user5", null, null, null, "/QOpenSys/home/user5");
		item2sub1.getChildren().add(item2sub1sub5);

		var item2sub1sub6 = createNextLevelItem("user6", null, null, null, "/QOpenSys/home/user6");
		item2sub1.getChildren().add(item2sub1sub6);

		var item2sub2 = createNextLevelItem("opt", null, null, null, "/QOpenSys/opt");
		item2.getChildren().add(item2sub2);

		var item3 = createNextLevelItem("QIBM", null, null, null, "/QIBM");
		root.getChildren().add(item3);

		var item4 = createNextLevelItem("QOPT", null, null, null, "/QOPT");
		root.getChildren().add(item4);

		LOGGER.debug("end");

		return root;
	}

}
